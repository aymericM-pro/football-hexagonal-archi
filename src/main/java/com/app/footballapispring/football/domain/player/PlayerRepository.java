package com.app.footballapispring.football.domain.player;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface PlayerRepository {

    Player save(Player p);

    Optional<Player> findById(String id);

    List<Player> findAll();

    Page<Player> findAll(Pageable pageable);

    void delete(String id);
}
