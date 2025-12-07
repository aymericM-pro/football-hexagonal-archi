package com.app.footballapispring.football.domain.teams.commands;

import com.app.footballapispring.core.mediator.Query;
import com.app.footballapispring.football.domain.teams.Team;

import java.util.List;

public class GetAllTeamsQuery implements Query<List<Team>> {}
