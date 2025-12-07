package com.app.footballapispring.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "BearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {

    @Bean
    public OpenAPI footballStatsApi() {

        Server localServer = new Server()
                .url("http://localhost:8080/api/v1")
                .description("Serveur local");

        return new OpenAPI()
                .info(new Info()
                        .title("Football Stats API")
                        .description("API pour Classements, Matchs, Équipes, Joueurs et Authentification JWT")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Aymeric Maillot")
                                .email("contact@example.com")
                        )
                        .license(new License()
                                .name("MIT Licence")
                                .url("https://opensource.org/licenses/MIT")
                        )
                )
                .addServersItem(localServer);
    }
}
