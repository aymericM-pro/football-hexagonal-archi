package com.app.footballapispring.football.domain.roundday.commands;

import com.app.footballapispring.core.mediator.Query;
import com.app.footballapispring.football.domain.roundday.models.RoundDayResult;

public record GetRoundDayQuery(String id) implements Query<RoundDayResult> {}
