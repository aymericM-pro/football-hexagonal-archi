package com.app.footballapispring.domain.user.usescases;

import com.app.footballapispring.core.mediator.CommandHandler;
import com.app.footballapispring.core.service.JwtService;
import com.app.footballapispring.core.service.PasswordHasher;
import com.app.footballapispring.domain.user.Role;
import com.app.footballapispring.domain.user.User;
import com.app.footballapispring.domain.user.UserRepository;
import com.app.footballapispring.domain.user.commands.AuthResult;
import com.app.footballapispring.domain.user.commands.RegisterUserCommand;
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

        // Hash password
        String hash = passwordHasher.hash(cmd.password());

        // Create user
        User user = new User(cmd.email(), hash, Role.USER);
        User saved = userRepository.save(user);

        // 🔥 Generate token for immediate login
        String token = jwtService.generateToken(
                saved.getEmail(),
                saved.getRole().name()
        );

        // 🔥 Return AuthResult instead of null
        return new AuthResult(token);
    }
}
