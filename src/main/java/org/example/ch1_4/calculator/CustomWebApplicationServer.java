package org.example.ch1_4.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CustomWebApplicationServer {

    private final int port;
    private final static Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);

    public CustomWebApplicationServer(int port) {
        this.port = port;
    }
}
