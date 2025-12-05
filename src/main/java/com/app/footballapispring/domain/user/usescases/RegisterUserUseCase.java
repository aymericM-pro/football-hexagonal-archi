package com.app.footballapispring.domain.user.usescases;

import com.app.footballapispring.core.mediator.CommandHandler;
import com.app.footballapispring.domain.user.Role;
import com.app.footballapispring.domain.user.User;
import com.app.footballapispring.domain.user.UserRepository;
import com.app.footballapispring.domain.user.commands.RegisterUserCommand;
import org.springframework.security.crypto.password.PasswordEncoder;

public class RegisterUserUseCase implements CommandHandler<RegisterUserCommand, User> {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterUserUseCase(UserRepository userRepository,
                               PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User handle(RegisterUserCommand cmd) {
        String hash = passwordEncoder.encode(cmd.password());
        User user = new User(cmd.email(), hash, Role.USER);
        return userRepository.save(user);
    }
}
