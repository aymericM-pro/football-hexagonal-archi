package com.app.footballapispring.football.domain.user.commands;

import com.app.footballapispring.core.mediator.Command;

public record LoginUserCommand(
        String email,
        String password
) implements Command<AuthResult> {

}