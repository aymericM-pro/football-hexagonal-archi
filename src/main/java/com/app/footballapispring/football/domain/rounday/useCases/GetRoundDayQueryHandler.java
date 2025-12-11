package com.app.footballapispring.football.domain.rounday.useCases;


import com.app.footballapispring.core.mediator.QueryHandler;
import com.app.footballapispring.football.domain.rounday.RoundDay;
import com.app.footballapispring.football.domain.rounday.RoundDayRepository;
import com.app.footballapispring.football.domain.rounday.commands.GetRoundDayQuery;
import com.app.footballapispring.football.domain.rounday.models.RoundDayResult;
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
