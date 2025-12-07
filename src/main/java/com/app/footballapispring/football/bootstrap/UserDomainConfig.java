package com.app.footballapispring.football.bootstrap;


import com.app.footballapispring.core.auth.BcryptPasswordHasher;
import com.app.footballapispring.core.service.JwtService;
import com.app.footballapispring.core.service.PasswordHasher;
import com.app.footballapispring.football.domain.user.UserRepository;
import com.app.footballapispring.football.domain.user.usescases.RegisterUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserDomainConfig {

    @Bean
    public PasswordHasher passwordHasher() {
        return new BcryptPasswordHasher();
    }

    @Bean
    public RegisterUserUseCase registerUserUseCase(
            UserRepository userRepository,
            PasswordHasher passwordHasher,
            JwtService jwtService
    ) {
        return new RegisterUserUseCase(userRepository, passwordHasher, jwtService);
    }
}
