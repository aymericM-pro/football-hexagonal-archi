package com.app.footballapispring.football.domain.player.usescases;


import com.app.footballapispring.core.mediator.CommandHandler;
import com.app.footballapispring.football.domain.player.Player;
import com.app.footballapispring.football.domain.player.PlayerRepository;
import com.app.footballapispring.football.domain.player.command.CreatePlayerCommand;

public class CreatePlayerUseCase implements CommandHandler<CreatePlayerCommand, Player> {

    private final PlayerRepository repo;

    public CreatePlayerUseCase(PlayerRepository repo) {
        this.repo = repo;
    }

    @Override
    public Player handle(CreatePlayerCommand c) {
        Player p = new Player(
                c.name(),
                c.age(),
                c.position(),
                c.nationality(),
                c.photo()
        );
        return repo.save(p);
    }
}
