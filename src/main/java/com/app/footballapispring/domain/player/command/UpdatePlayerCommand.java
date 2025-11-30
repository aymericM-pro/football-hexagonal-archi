package com.app.footballapispring.domain.player.command;

import com.app.footballapispring.core.mediator.Command;
import com.app.footballapispring.domain.player.Player;

public record UpdatePlayerCommand(
        String id,
        String name,
        int age,
        String position,
        String nationality,
        String photo
) implements Command<Player> {}
