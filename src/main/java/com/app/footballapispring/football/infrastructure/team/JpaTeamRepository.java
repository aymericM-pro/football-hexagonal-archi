package com.app.footballapispring.football.infrastructure.team;

import com.app.footballapispring.core.errors.BusinessException;
import com.app.footballapispring.core.errors.exceptions.ChampionshipsError;
import com.app.footballapispring.core.errors.exceptions.TeamError;
import com.app.footballapispring.football.domain.player.Player;
import com.app.footballapispring.football.domain.teams.Team;
import com.app.footballapispring.football.domain.teams.TeamRepository;
import com.app.footballapispring.football.infrastructure.championship.ChampionshipEntity;
import com.app.footballapispring.football.infrastructure.championship.SpringDataChampionshipRepository;
import com.app.footballapispring.football.infrastructure.player.PlayerEntity;
import com.app.footballapispring.football.infrastructure.player.PlayerInfraMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class JpaTeamRepository implements TeamRepository {
    private final SpringDataTeamRepository repo;
    private final SpringDataChampionshipRepository championshipJpaRepository;


    @Override
    public Team save(Team t) {
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
                .orElseThrow(() -> new BusinessException(TeamError.TEAM_NOT_FOUND));

        PlayerEntity pe = PlayerInfraMapper.toEntity(domainPlayer);

        entity.addPlayer(pe);

        TeamEntity saved = repo.save(entity);
        return TeamInfraMapper.toDomainWithPlayer(saved);
    }

    @Override
    @Transactional
    public void addTeamToChampionship(String teamId, String championshipId) {

        TeamEntity team = repo
                .findById(UUID.fromString(teamId))
                .orElseThrow(() -> new BusinessException(TeamError.TEAM_NOT_FOUND));

        ChampionshipEntity championship = championshipJpaRepository
                .findById(UUID.fromString(championshipId))
                .orElseThrow(() -> new BusinessException(ChampionshipsError.CHAMPIONSHIP_NOT_FOUND));

        if (!team.getChampionships().contains(championship)) {
            team.getChampionships().add(championship);
        }

        repo.save(team);
    }
}

