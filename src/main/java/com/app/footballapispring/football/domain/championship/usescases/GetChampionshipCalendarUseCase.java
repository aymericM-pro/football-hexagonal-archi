package com.app.footballapispring.football.domain.championship.usescases;

import com.app.footballapispring.core.mediator.QueryHandler;
import com.app.footballapispring.football.domain.championship.Championship;
import com.app.footballapispring.football.domain.championship.ChampionshipRepository;
import com.app.footballapispring.football.domain.championship.command.GetChampionshipCalendarQuery;
import com.app.footballapispring.football.domain.championship.models.ChampionshipCalendarResult;
import com.app.footballapispring.football.domain.fixture.models.FixtureResult;
import com.app.footballapispring.football.domain.roundday.RoundDay;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class GetChampionshipCalendarUseCase
        implements QueryHandler<GetChampionshipCalendarQuery, ChampionshipCalendarResult> {

    private final ChampionshipRepository championshipRepository;

    public GetChampionshipCalendarUseCase(
            ChampionshipRepository championshipRepository
    ) {
        this.championshipRepository = championshipRepository;
    }

    @Override
    public ChampionshipCalendarResult handle(GetChampionshipCalendarQuery query) {

        Championship championship = championshipRepository
                .findByIdWithRoundDays(query.championshipId())
                .orElseThrow();

        Map<Integer, List<FixtureResult>> calendar =
                championship.getRoundDays()
                        .stream()
                        .collect(Collectors.toMap(
                                RoundDay::getNumber,
                                rd -> rd.getFixtures()
                                        .stream()
                                        .map(f -> new FixtureResult(
                                                f.getId(),
                                                f.getHomeTeamId(),
                                                f.getAwayTeamId(),
                                                f.getHomeScore(),
                                                f.getAwayScore()
                                        ))
                                        .toList(),
                                (a, b) -> a,
                                TreeMap::new // journées ordonnées
                        ));

        return new ChampionshipCalendarResult(calendar);
    }
}
