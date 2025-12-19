package com.app.footballapispring.football.domain.player.command;

import com.app.footballapispring.core.mediator.Query;
import com.app.footballapispring.football.domain.player.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public record GetAllPlayersQuery(Pageable pageable)
        implements Query<Page<Player>> {}
