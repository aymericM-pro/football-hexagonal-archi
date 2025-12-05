package com.app.footballapispring.application.rest.player;

import com.app.footballapispring.core.mediator.Mediator;
import com.app.footballapispring.domain.player.Player;
import com.app.footballapispring.domain.player.command.CreatePlayerCommand;
import com.app.footballapispring.domain.player.command.DeletePlayerCommand;
import com.app.footballapispring.domain.player.command.GetAllPlayersQuery;
import com.app.footballapispring.domain.player.command.GetPlayerByIdQuery;
import com.app.footballapispring.domain.player.command.UpdatePlayerCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController implements IPlayerControllerSwagger {

    private final Mediator mediator;

    public PlayerController(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<PlayerDTO>> getAllPlayers() {
        List<PlayerDTO> result = mediator.send(new GetAllPlayersQuery())
                .stream()
                .map(PlayerMapper::toDto)
                .toList();

        return ResponseEntity.ok(result);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<PlayerDTO> getPlayerById(@PathVariable String id) {

        Player p = mediator.send(new GetPlayerByIdQuery(id));
        return ResponseEntity.ok(PlayerMapper.toDto(p));
    }

    @Override
    @PostMapping
    public ResponseEntity<PlayerDTO> createPlayer(@RequestBody CreatePlayerDTO dto) {

        Player p = mediator.send(new CreatePlayerCommand(
                dto.name(),
                dto.age(),
                dto.position(),
                dto.nationality(),
                dto.photo()
        ));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(PlayerMapper.toDto(p));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<PlayerDTO> updatePlayer(
            @PathVariable String id,
            @RequestBody PlayerDTO dto
    ) {
        Player p = mediator.send(new UpdatePlayerCommand(
                id,
                dto.name(),
                dto.age(),
                dto.position(),
                dto.nationality(),
                dto.photo()
        ));
        return ResponseEntity.ok(PlayerMapper.toDto(p));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable String id) {
        mediator.send(new DeletePlayerCommand(id));
        return ResponseEntity.noContent().build();
    }
}
