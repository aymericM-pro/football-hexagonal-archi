package com.app.footballapispring.infrastructure.footballapi.team;

import com.app.footballapispring.domain.player.Player;
import com.app.footballapispring.domain.teams.Team;
import com.app.footballapispring.domain.teams.TeamRepository;
import com.app.footballapispring.infrastructure.footballapi.player.PlayerEntity;
import com.app.footballapispring.infrastructure.footballapi.player.PlayerInfraMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class JpaTeamRepository implements TeamRepository {
    private final SpringDataTeamRepository repo;

    public JpaTeamRepository(SpringDataTeamRepository repo) {
        this.repo = repo;
    }

    public Team save(Team t) {
        TeamEntity entity = new TeamEntity();
        TeamInfraMapper.mapToEntity(t, entity);
        TeamEntity saved = repo.save(entity);
        return TeamInfraMapper.toDomain(saved);
    }

    @Override
    public Optional<Team> findById(String id) {
        return repo.findByIdWithPlayers(UUID.fromString(id))
                .map(TeamInfraMapper::toDomainWithPlayer);
    }

    @Override
    public List<Team> findAll() {
        return repo.findAll().stream()
                .map(TeamInfraMapper::toDomain)
                .toList();
    }

    @Override
    public Team addPlayer(String teamId, Player p) {

        TeamEntity entity = repo.findByIdWithPlayers(UUID.fromString(teamId))
                .orElseThrow(() -> new RuntimeException("Team not found"));

        PlayerEntity pe = PlayerInfraMapper.toEntity(p);
        entity.addPlayer(pe);
        return TeamInfraMapper.toDomainWithPlayer(repo.save(entity));
    }
}

