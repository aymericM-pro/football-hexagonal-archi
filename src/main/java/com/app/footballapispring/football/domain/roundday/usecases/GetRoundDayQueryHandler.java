package com.app.footballapispring.football.domain.roundday.usecases;


import com.app.footballapispring.core.mediator.QueryHandler;
import com.app.footballapispring.football.domain.roundday.RoundDay;
import com.app.footballapispring.football.domain.roundday.RoundDayRepository;
import com.app.footballapispring.football.domain.roundday.commands.GetRoundDayQuery;
import com.app.footballapispring.football.domain.roundday.models.RoundDayResult;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetRoundDayQueryHandler implements QueryHandler<GetRoundDayQuery, RoundDayResult> {

    private final RoundDayRepository repository;

    @Override
    public RoundDayResult handle(GetRoundDayQuery query) {
        RoundDay rd = repository.findById(query.id())
                .orElseThrow(() -> new IllegalArgumentException("RoundDay not found: " + query.id()));

        return new RoundDayResult(rd.getId(), rd.getNumber());
    }
}
