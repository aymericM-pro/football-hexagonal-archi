package com.app.footballapispring.football.application.rest.users;


import com.app.footballapispring.core.mediator.Mediator;
import com.app.footballapispring.football.application.rest.users.dtos.UserResponse;
import com.app.footballapispring.football.domain.user.commands.GetAllUsersQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController implements IUsersControllerSwagger {

    private final Mediator mediator;

    public UsersController(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAll() {
        List<UserResponse> users = mediator.send(new GetAllUsersQuery());
        return ResponseEntity.ok(users);
    }
}