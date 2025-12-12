package com.app.footballapispring.football.domain.roundday.commands;

import com.app.footballapispring.core.mediator.Command;
import com.app.footballapispring.football.domain.roundday.models.RoundDayResult;

public record CreateRoundDayCommand(int number) implements Command<RoundDayResult> {}
