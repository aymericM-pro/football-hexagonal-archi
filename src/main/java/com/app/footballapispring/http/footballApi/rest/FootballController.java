package com.app.footballapispring.http.footballApi.rest;

import com.app.footballapispring.http.footballApi.rest.fixture.FixtureDTO;
import com.app.footballapispring.http.footballApi.rest.fixture.FixtureMapper;
import com.app.footballapispring.football.application.rest.player.PlayerDTO;
import com.app.footballapispring.football.application.rest.player.PlayerMapper;
import com.app.footballapispring.http.footballApi.rest.standing.StandingDTO;
import com.app.footballapispring.http.footballApi.rest.standing.StandingMapper;
import com.app.footballapispring.http.footballApi.rest.teams.TeamDetailDTO;
import com.app.footballapispring.http.footballApi.rest.teams.TeamDetailMapper;

import com.app.footballapispring.core.mediator.Mediator;
import com.app.footballapispring.http.footballApi.domain.fixtures.GetFixturesQuery;
import com.app.footballapispring.football.domain.player.GetPlayersQuery;
import com.app.footballapispring.http.footballApi.domain.standings.GetStandingsQuery;
import com.app.footballapispring.football.domain.teams.GetTeamDetailsQuery;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/football")
public class FootballController implements IFootballControllerSwagger {

    private final Mediator mediator;

    public FootballController(Mediator mediator) {
        this.mediator = mediator;
    }

    // ------------------------
    // 1) STANDINGS
    // ------------------------
    @Override
    @GetMapping("/standings")
    public List<StandingDTO> getStandings(
            @RequestParam(defaultValue = "61") int league,
            @RequestParam(defaultValue = "2023") int season
    ) {
        return mediator.send(new GetStandingsQuery(league, season))
                .stream()
                .map(StandingMapper::toDto)
                .toList();
    }

    // ------------------------
    // 2) MATCHES (Fixtures)
    // ------------------------
    @Override
    @GetMapping("/matches")
    public List<FixtureDTO> getMatches(
            @RequestParam(defaultValue = "61") int league,
            @RequestParam(defaultValue = "2024") int season,
            @RequestParam(defaultValue = "1") int day
    ) {
        return mediator.send(new GetFixturesQuery(league, season, day))
                .stream()
                .map(FixtureMapper::toDto)
                .toList();
    }

    // ------------------------
    // 3) PLAYERS
    // ------------------------
    @Override
    @GetMapping("/players")
    public List<PlayerDTO> getPlayers(
            @RequestParam int team,
            @RequestParam(defaultValue = "2024") int season,
            @RequestParam(defaultValue = "1") int page
    ) {
        return mediator.send(new GetPlayersQuery(team, season, page))
                .stream()
                .map(PlayerMapper::toDto)
                .toList();
    }

    // ------------------------
    // 4) TEAM DETAILS
    // ------------------------
    @Override
    @GetMapping("/team")
    public TeamDetailDTO getTeamDetails(@RequestParam int id) {
        return TeamDetailMapper.toDto(
                mediator.send(new GetTeamDetailsQuery(id))
        );
    }
}
