package com.app.footballapispring.football.application.rest.teams;

import com.app.footballapispring.football.application.rest.player.PlayerMapper;
import com.app.footballapispring.football.domain.teams.Team;

public final class TeamInfoMapper {

    private TeamInfoMapper() {}

    public static TeamInfoDTO toDto(Team t) {
        return new TeamInfoDTO(
                t.getId(),
                t.getName(),
                t.getCountry(),
                t.getPlayers().stream()
                        .map(PlayerMapper::toDto)
                        .toList()
        );
    }
}
