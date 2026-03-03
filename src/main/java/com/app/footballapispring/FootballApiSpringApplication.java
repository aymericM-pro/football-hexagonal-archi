package com.app.footballapispring;

import com.app.footballapispring.config.FootballApiProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableCaching
@EnableConfigurationProperties(FootballApiProperties.class)
public class FootballApiSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(FootballApiSpringApplication.class, args);
    }
}
