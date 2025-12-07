package com.app.footballapispring.football.domain.user.usescases;

import com.app.footballapispring.core.error.exceptions.UserError;
import com.app.footballapispring.core.error.BusinessException;
import com.app.footballapispring.core.mediator.CommandHandler;
import com.app.footballapispring.core.service.JwtService;
import com.app.footballapispring.core.service.PasswordHasher;
import com.app.footballapispring.football.domain.user.UserRepository;
import com.app.footballapispring.football.domain.user.commands.AuthResult;
import com.app.footballapispring.football.domain.user.commands.LoginUserCommand;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginUserUseCase implements CommandHandler<LoginUserCommand, AuthResult> {

    private final UserRepository userRepository;
    private final PasswordHasher passwordHasher;
    private final JwtService jwtService;

    @Override
    public AuthResult handle(LoginUserCommand cmd) {

        var user = userRepository.findByEmail(cmd.email())
                .orElseThrow(() -> new BusinessException(UserError.USER_NOT_FOUND));

        if (!passwordHasher.match(cmd.password(), user.getPasswordHash())) {
            throw new BusinessException(UserError.INVALID_CREDENTIALS);
        }

        String token = jwtService.generateToken(
                user.getEmail(),
                user.getRole().name()
        );

        return new AuthResult(token);
    }
}
