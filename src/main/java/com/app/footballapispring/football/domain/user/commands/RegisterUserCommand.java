package com.app.footballapispring.football.domain.user.commands;

import com.app.footballapispring.core.mediator.Command;

public record RegisterUserCommand(
        String email,
        String password
) implements Command<AuthResult> {}