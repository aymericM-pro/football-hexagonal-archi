package com.app.footballapispring.football.domain.player.usescases;

import com.app.footballapispring.core.mediator.CommandHandler;
import com.app.footballapispring.football.domain.player.Player;
import com.app.footballapispring.football.domain.player.PlayerRepository;
import com.app.footballapispring.football.domain.player.command.UpdatePlayerCommand;

public class UpdatePlayerUseCase implements CommandHandler<UpdatePlayerCommand, Player> {

    private final PlayerRepository repo;

    public UpdatePlayerUseCase(PlayerRepository repo) {
        this.repo = repo;
    }

    @Override
    public Player handle(UpdatePlayerCommand c) {
        Player existing = repo.findById(c.id())
                .orElseThrow(() -> new RuntimeException("Player not found"));

        Player updated = new Player(
                existing.getId(),
                c.name(),
                c.age(),
                c.position(),
                c.nationality(),
                c.photo()
        );

        return repo.save(updated);
    }
}
