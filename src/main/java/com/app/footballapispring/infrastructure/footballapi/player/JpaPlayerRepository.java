package com.app.footballapispring.infrastructure.footballapi.player;

import com.app.footballapispring.domain.player.Player;
import com.app.footballapispring.domain.player.PlayerRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class JpaPlayerRepository implements PlayerRepository {

    private final SpringDataPlayerRepository repo;

    public JpaPlayerRepository(SpringDataPlayerRepository repo) {
        this.repo = repo;
    }

    @Override
    public Player save(Player p) {
        PlayerEntity entity = PlayerInfraMapper.toEntity(p);
        PlayerEntity saved = repo.save(entity);
        return PlayerInfraMapper.toDomain(saved);
    }

    @Override
    public Optional<Player> findById(String id) {
        return repo.findById(UUID.fromString(id))
                .map(PlayerInfraMapper::toDomain);
    }

    @Override
    public List<Player> findAll() {
        return repo.findAll()
                .stream()
                .map(PlayerInfraMapper::toDomain)
                .toList();
    }

    @Override
    public void delete(String id) {
        repo.deleteById(UUID.fromString(id));
    }
}
