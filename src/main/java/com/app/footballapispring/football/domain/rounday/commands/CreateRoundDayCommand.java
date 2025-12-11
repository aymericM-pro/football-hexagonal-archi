package com.app.footballapispring.football.domain.rounday.commands;

import com.app.footballapispring.core.mediator.Command;
import com.app.footballapispring.football.domain.rounday.models.RoundDayResult;

public record CreateRoundDayCommand(int number) implements Command<RoundDayResult> {}
