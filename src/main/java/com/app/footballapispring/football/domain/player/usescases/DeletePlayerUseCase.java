package com.app.footballapispring.football.domain.player.usescases;

import com.app.footballapispring.core.mediator.CommandHandler;
import com.app.footballapispring.football.domain.player.PlayerRepository;
import com.app.footballapispring.football.domain.player.command.DeletePlayerCommand;

public class DeletePlayerUseCase implements CommandHandler<DeletePlayerCommand, Void> {

    private final PlayerRepository repo;

    public DeletePlayerUseCase(PlayerRepository repo) {
        this.repo = repo;
    }

    @Override
    public Void handle(DeletePlayerCommand c) {
        repo.delete(c.id());
        return null;
    }
}