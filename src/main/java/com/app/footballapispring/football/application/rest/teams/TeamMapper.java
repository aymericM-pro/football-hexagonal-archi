package com.app.footballapispring.football.application.rest.teams;

import com.app.footballapispring.football.domain.teams.Team;

public final class TeamMapper {

    private TeamMapper() {}

    public static TeamDTO toDto(Team t) {
        return new TeamDTO(
                t.getId(),
                t.getName(),
                t.getCountry()
        );
    }

    public static TeamResponse toResponse(Team team) {
        return new TeamResponse(
                team.getId(),
                team.getName(),
                team.getCountry()
        );
    }

}