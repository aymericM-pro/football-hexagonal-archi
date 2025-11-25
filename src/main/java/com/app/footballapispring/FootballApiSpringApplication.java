package com.app.footballapispring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class FootballApiSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(FootballApiSpringApplication.class, args);
    }

}
