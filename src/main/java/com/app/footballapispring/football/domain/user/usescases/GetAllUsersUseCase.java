package com.app.footballapispring.football.domain.user.usescases;

import com.app.footballapispring.core.mediator.QueryHandler;
import com.app.footballapispring.football.application.rest.users.dtos.UserResponse;
import com.app.footballapispring.football.domain.user.UserRepository;
import com.app.footballapispring.football.domain.user.commands.GetAllUsersQuery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GetAllUsersUseCase implements QueryHandler<GetAllUsersQuery, List<UserResponse>> {

    private final UserRepository userRepository;

    @Override
    public List<UserResponse> handle(GetAllUsersQuery query) {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserResponse(
                        user.getId(),
                        user.getEmail(),
                        user.getRole().name()
                ))
                .toList();
    }
}
