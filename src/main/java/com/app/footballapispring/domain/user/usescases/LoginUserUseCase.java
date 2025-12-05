package com.app.footballapispring.domain.user.usescases;

import com.app.footballapispring.core.auth.JwtTokenProvider;
import com.app.footballapispring.core.mediator.CommandHandler;
import com.app.footballapispring.domain.user.UserRepository;
import com.app.footballapispring.domain.user.commands.LoginResult;
import com.app.footballapispring.domain.user.commands.LoginUserCommand;
import org.springframework.security.crypto.password.PasswordEncoder;

public class LoginUserUseCase implements CommandHandler<LoginUserCommand, LoginResult> {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public LoginUserUseCase(UserRepository userRepository,
                            PasswordEncoder passwordEncoder,
                            JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public LoginResult handle(LoginUserCommand cmd) {
        var user = userRepository.findByEmail(cmd.email())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(cmd.password(), user.getPasswordHash())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtTokenProvider.generateToken(user.getEmail(), user.getRole().name());
        return new LoginResult(token);
    }
}
