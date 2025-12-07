package com.app.footballapispring.footballApi.rest.teams;

import com.app.footballapispring.domain.teams.TeamDetail;

public class TeamDetailMapper {

    public static TeamDetailDTO toDto(TeamDetail t) {
        return new TeamDetailDTO(
                t.id(),
                t.name(),
                t.country(),
                t.founded(),
                t.logo(),
                t.stadiumName(),
                t.stadiumCity(),
                t.stadiumCapacity(),
                t.stadiumImage(),
                t.coachName(),
                t.coachNationality(),
                t.coachPhoto()
        );
    }
}
