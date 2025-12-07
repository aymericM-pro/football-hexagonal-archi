package com.app.footballapispring.football.domain.player.command;


import com.app.footballapispring.core.mediator.Command;
import com.app.footballapispring.football.domain.player.Player;

public record CreatePlayerCommand(
        String name,
        int age,
        String position,
        String nationality,
        String photo
) implements Command<Player> {}
