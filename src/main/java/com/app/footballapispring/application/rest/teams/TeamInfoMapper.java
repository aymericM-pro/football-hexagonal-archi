package com.app.footballapispring.application.rest.teams;

import com.app.footballapispring.application.rest.player.PlayerMapper;
import com.app.footballapispring.domain.teams.Team;

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
