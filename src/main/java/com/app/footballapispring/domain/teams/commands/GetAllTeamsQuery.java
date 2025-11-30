package com.app.footballapispring.domain.teams.commands;

import com.app.footballapispring.core.mediator.Query;
import com.app.footballapispring.domain.teams.Team;

import java.util.List;

public class GetAllTeamsQuery implements Query<List<Team>> {}
