package com.example.tech_sns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

// 스프링이 자동으로 DB연결하는 것을 제거하는 설정을 하게되면 JPA가 맘대로 연결하려는 것을 막을 수 있다.
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class TechSnsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechSnsApplication.class, args);
    }

}
