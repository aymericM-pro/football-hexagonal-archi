package com.app.footballapispring.application.rest.users;

import com.app.footballapispring.application.rest.users.dtos.AuthResponseDTO;
import com.app.footballapispring.application.rest.users.dtos.LoginRequestDTO;
import com.app.footballapispring.application.rest.users.dtos.RegisterRequestDTO;
import com.app.footballapispring.core.mediator.Mediator;
import com.app.footballapispring.domain.user.commands.AuthResult;
import com.app.footballapispring.domain.user.commands.LoginUserCommand;
import com.app.footballapispring.domain.user.commands.RegisterUserCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController implements IAuthControllerSwagger {

    private final Mediator mediator;

    public AuthController(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(@RequestBody RegisterRequestDTO dto) {
        AuthResult result = mediator.send(
                new RegisterUserCommand(dto.email(), dto.password())
        );
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new AuthResponseDTO(result.token()));
    }

    @Override
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginRequestDTO dto) {
        AuthResult result = mediator.send(
                new LoginUserCommand(dto.email(), dto.password())
        );
        return ResponseEntity.ok(new AuthResponseDTO(result.token()));
    }
}
