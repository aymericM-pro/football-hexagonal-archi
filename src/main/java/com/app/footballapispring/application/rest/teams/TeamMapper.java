package com.app.footballapispring.application.rest.teams;

import com.app.footballapispring.domain.teams.Team;

public final class TeamMapper {

    private TeamMapper() {}

    public static TeamDTO toDto(Team t) {
        return new TeamDTO(
                t.getId(),
                t.getName(),
                t.getCountry()
        );
    }
}