package com.app.footballapispring.football.domain.user.commands;

import com.app.footballapispring.core.mediator.Query;
import com.app.footballapispring.football.application.rest.users.dtos.UserResponse;

import java.util.List;

public record GetAllUsersQuery() implements Query<List<UserResponse>> { }
