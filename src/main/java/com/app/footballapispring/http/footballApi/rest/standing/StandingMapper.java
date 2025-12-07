package com.app.footballapispring.http.footballApi.rest.standing;

import com.app.footballapispring.http.footballApi.domain.standings.Standing;

public class StandingMapper {

    public static StandingDTO toDto(Standing s) {
        return new StandingDTO(
                s.rank(),
                s.teamId(),
                s.teamName(),
                s.points(),
                s.played(),
                s.win(),
                s.draw(),
                s.lose(),
                s.goalsFor(),
                s.goalsAgainst(),
                s.goalsDiff()
        );
    }
}
