package com.app.footballapispring.football.infrastructure.team;

import com.app.footballapispring.football.domain.teams.Team;
import com.app.footballapispring.football.infrastructure.player.PlayerInfraMapper;

public final class TeamInfraMapper {

    private TeamInfraMapper() {}

    public static void mapToEntity(Team domain, TeamEntity entity) {
        entity.setName(domain.getName());
        entity.setCountry(domain.getCountry());
    }

    public static Team toDomain(TeamEntity entity) {
        return new Team(
                entity.getTeamId().toString(),
                entity.getName(),
                entity.getCountry()
        );
    }

    public static Team toDomainWithPlayer(TeamEntity entity) {
        return new Team(
                entity.getTeamId().toString(),
                entity.getName(),
                entity.getCountry(),
                entity.getPlayers().stream()
                        .map(PlayerInfraMapper::toDomain)
                        .toList()
        );
    }
}
