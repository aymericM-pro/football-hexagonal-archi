package com.app.footballapispring.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI footballStatsApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Football Stats API")
                        .description("API pour Classements, Matchs, Équipes et Statistiques du Football")
                        .version("1.0.0")
                );
    }
}
