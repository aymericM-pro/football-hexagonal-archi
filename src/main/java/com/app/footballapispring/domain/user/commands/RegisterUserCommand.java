package com.app.footballapispring.domain.user.commands;

import com.app.footballapispring.core.mediator.Command;
import com.app.footballapispring.domain.user.User;

public record RegisterUserCommand(
        String email,
        String password
) implements Command<User> {}