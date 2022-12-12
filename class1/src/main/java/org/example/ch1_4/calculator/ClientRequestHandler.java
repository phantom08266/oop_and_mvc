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
         *
         * 이렇게 하면 스레드는 새로 생성될때마다 독립적인 스택메모리를 할당받는다.
         * 이렇게되면 상당히 비싼 작업이며, 사용자의 요청에 따라 만들게된다면 성능이 떨어지게 된다.
         * 또한 동시접속자가 많아질 경우 다수의 스레드가 생성될 것이며 스레드가 많아진다는 것은 CPU의 컨텍스트 스위칭이 많아진다는 것이다.
         * 이 컨텍스트 스위칭 비용도 상당하고, CPU, 메모리 사용량이 증가하게 됨에 따라 서버의 리소스가 부족하게 될 수 있다.
         * 이렇게 되면 서버가 다운 될 수 있기 때문에 성능고려를 해야한다.
         *
         * 이러한 이유로 ThreadPool을 사용하여 안정적인 사용을 할 수 있다.
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
