package com.app.footballapispring.football.domain.user.usescases;

import com.app.footballapispring.core.mediator.CommandHandler;
import com.app.footballapispring.core.service.JwtService;
import com.app.footballapispring.core.service.PasswordHasher;
import com.app.footballapispring.football.domain.user.Role;
import com.app.footballapispring.football.domain.user.User;
import com.app.footballapispring.football.domain.user.UserRepository;
import com.app.footballapispring.football.domain.user.commands.AuthResult;
import com.app.footballapispring.football.domain.user.commands.RegisterUserCommand;
import lombok.AllArgsConstructor;

import com.app.footballapispring.core.error.BusinessException;
import com.app.footballapispring.core.error.exceptions.UserError;

@AllArgsConstructor
public class RegisterUserUseCase implements CommandHandler<RegisterUserCommand, AuthResult> {

    private final UserRepository userRepository;
    private final PasswordHasher passwordHasher;
    private final JwtService jwtService;

    @Override
    public AuthResult handle(RegisterUserCommand cmd) {

        if (cmd.email() == null || cmd.email().isBlank()) {
            throw new BusinessException(UserError.EMAIL_REQUIRED);
        }

        if (cmd.password() == null || cmd.password().isBlank()) {
            throw new BusinessException(UserError.PASSWORD_REQUIRED);
        }

        if (userRepository.findByEmail(cmd.email()).isPresent()) {
            throw new BusinessException(UserError.EMAIL_ALREADY_EXISTS);
        }

        String hash = passwordHasher.hash(cmd.password());

        User user = new User(cmd.email(), hash, Role.USER);
        User saved = userRepository.save(user);

        String token = jwtService.generateToken(
                saved.getEmail(),
                saved.getRole().name()
        );

        return new AuthResult(token);
    }
}
