package org.example.ch1_4.calculator;

import org.example.ch1_4.QueryStrings;
import org.example.ch1_4.calculator.domain.Calculator;
import org.example.ch1_4.calculator.domain.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


public class ClientRequestHandler implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(ClientRequestHandler.class);

    private final Socket clientSocket;

    public ClientRequestHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {

        /**
         * Step2 - 클라이언트가 요청할때마다 별도의 스레드를 만들어서 처리하도록 한다.
         */
        logger.info("[ClientRequestHandler] new client {} started.", Thread.currentThread().getName());
        try (InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
            DataOutputStream dataOutputStream = new DataOutputStream(out);

            HttpRequest httpRequest = new HttpRequest(bufferedReader);

            if (httpRequest.isGetRequest() && httpRequest.matchPath("/calculate")) {
                QueryStrings queryStrings = httpRequest.getQueryStrings();

                int operand1 = Integer.parseInt(queryStrings.getValue("operand1"));
                String operator = queryStrings.getValue("operator");
                int operand2 = Integer.parseInt(queryStrings.getValue("operand2"));

                int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));
                byte[] body = String.valueOf(result).getBytes();
                HttpResponse httpResponse = new HttpResponse(dataOutputStream);
                httpResponse.response200Header("application/json", body.length);
                httpResponse.responseBody(body);
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

    }
}
