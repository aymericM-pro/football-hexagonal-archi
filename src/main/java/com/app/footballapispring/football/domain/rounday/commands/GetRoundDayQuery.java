package com.app.footballapispring.football.domain.rounday.commands;

import com.app.footballapispring.core.mediator.Query;
import com.app.footballapispring.football.domain.rounday.models.RoundDayResult;

public record GetRoundDayQuery(String id) implements Query<RoundDayResult> {}
