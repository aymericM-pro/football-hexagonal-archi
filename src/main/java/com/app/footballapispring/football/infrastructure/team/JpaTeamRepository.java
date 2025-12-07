package com.app.footballapispring.football.infrastructure.team;

import com.app.footballapispring.football.domain.player.Player;
import com.app.footballapispring.football.domain.teams.Team;
import com.app.footballapispring.football.domain.teams.TeamRepository;
import com.app.footballapispring.football.infrastructure.player.PlayerEntity;
import com.app.footballapispring.football.infrastructure.player.PlayerInfraMapper;
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

    @Override
    public Team save(Team t) {
        // Création pure → jamais de findById ici !
        TeamEntity entity = new TeamEntity();

        TeamInfraMapper.mapToEntity(t, entity);

        TeamEntity saved = repo.save(entity);

        return TeamInfraMapper.toDomainWithPlayer(saved);
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
    public Team addPlayer(Team domainTeam, Player domainPlayer) {
        UUID id = UUID.fromString(domainTeam.getId());
        TeamEntity entity = repo.findByIdWithPlayers(id)
                .orElseThrow(() -> new RuntimeException("Team not found"));
        PlayerEntity pe = PlayerInfraMapper.toEntity(domainPlayer);
        entity.addPlayer(pe);
        TeamEntity saved = repo.save(entity);
        return TeamInfraMapper.toDomainWithPlayer(saved);
    }
}

