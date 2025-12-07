package com.app.footballapispring.football.domain.player.command;


import com.app.footballapispring.core.mediator.Command;
import com.app.footballapispring.football.domain.player.Player;
import com.app.footballapispring.football.domain.player.models.Position;

public record CreatePlayerCommand(
        String name,
        int age,
        Position position,
        String nationality,
        String photo
) implements Command<Player> {}
