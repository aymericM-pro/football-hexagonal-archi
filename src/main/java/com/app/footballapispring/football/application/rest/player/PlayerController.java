package com.app.footballapispring.football.application.rest.player;

import com.app.footballapispring.core.base.BaseResponse;
import com.app.footballapispring.core.mediator.Mediator;
import com.app.footballapispring.football.domain.player.Player;
import com.app.footballapispring.football.domain.player.command.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.footballapispring.core.base.PageResponse;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private final Mediator mediator;

    public PlayerController(Mediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping
    public ResponseEntity<PageResponse<PlayerDTO>> getAllPlayers(
            @PageableDefault(size = 20, sort = "name")
            Pageable pageable
    ) {
        Page<Player> page =
                mediator.send(new GetAllPlayersQuery(pageable));

        return ResponseEntity.ok(
                PageResponse.from(page.map(PlayerMapper::toDto))
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDTO> getPlayerById(
            @PathVariable String id
    ) {
        Player player = mediator.send(new GetPlayerByIdQuery(id));
        return ResponseEntity.ok(PlayerMapper.toDto(player));
    }

    @PostMapping
    public ResponseEntity<PlayerDTO> createPlayer(
            @RequestBody CreatePlayerDTO dto
    ) {
        Player created = mediator.send(
                new CreatePlayerCommand(
                        dto.name(),
                        dto.age(),
                        dto.position(),
                        dto.nationality(),
                        dto.photo()
                )
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(PlayerMapper.toDto(created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerDTO> updatePlayer(
            @PathVariable String id,
            @RequestBody PlayerDTO dto
    ) {
        Player updated = mediator.send(
                new UpdatePlayerCommand(
                        id,
                        dto.name(),
                        dto.age(),
                        dto.position(),
                        dto.nationality(),
                        dto.photo()
                )
        );

        return ResponseEntity.ok(PlayerMapper.toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(
            @PathVariable String id
    ) {
        mediator.send(new DeletePlayerCommand(id));
        return ResponseEntity.noContent().build();
    }
}
