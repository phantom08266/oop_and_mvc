package org.example.ch1_4.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


public class CustomWebApplicationServer {

    private final int port;
    private final static Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);

    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("[CustomWebApplicationServer] started {} port.", port);
            Socket clientSocket;
            logger.info("[CustomWebApplicationServer] waiting for client.");

            while ((clientSocket = serverSocket.accept()) != null) {
                logger.info("[CustomWebApplicationServer] client connected");

                /**
                 * Step1 - 사용자 요청을 메인 Thread가 처리하도록 한다.
                 */

                try (InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                    DataOutputStream dataOutputStream = new DataOutputStream(out);

                    String line;
                    while((line = bufferedReader.readLine())!= "") {
                        System.out.println(line);
                    }
                }
            }
        }
    }
}
