package com.app.footballapispring.application.rest;

import com.app.footballapispring.application.rest.player.PlayerDTO;
import com.app.footballapispring.application.rest.player.PlayerMapper;
import com.app.footballapispring.core.mediator.Mediator;
import com.app.footballapispring.domain.player.Player;
import com.app.footballapispring.domain.player.command.CreatePlayerCommand;
import com.app.footballapispring.domain.player.command.DeletePlayerCommand;
import com.app.footballapispring.domain.player.command.GetAllPlayersQuery;
import com.app.footballapispring.domain.player.command.GetPlayerByIdQuery;
import com.app.footballapispring.domain.player.command.UpdatePlayerCommand;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private final Mediator mediator;

    public PlayerController(Mediator mediator) {
        this.mediator = mediator;
    }

    // ------------------------
    // 1) GET ALL
    // ------------------------
    @GetMapping
    public List<PlayerDTO> getAllPlayers() {
        return mediator.send(new GetAllPlayersQuery())
                .stream()
                .map(PlayerMapper::toDto)
                .toList();
    }

    // ------------------------
    // 2) GET BY ID
    // ------------------------
    @GetMapping("/{id}")
    public PlayerDTO getPlayerById(@PathVariable String id) {
        Player p = mediator.send(new GetPlayerByIdQuery(id));
        return PlayerMapper.toDto(p);
    }

    // ------------------------
    // 3) CREATE
    // ------------------------
    @PostMapping
    public PlayerDTO createPlayer(@RequestBody PlayerDTO dto) {
        Player p = mediator.send(new CreatePlayerCommand(
                dto.name(),
                dto.age(),
                dto.position(),
                dto.nationality(),
                dto.photo()
        ));
        return PlayerMapper.toDto(p);
    }

    // ------------------------
    // 4) UPDATE
    // ------------------------
    @PutMapping("/{id}")
    public PlayerDTO updatePlayer(
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
        return PlayerMapper.toDto(p);
    }

    // ------------------------
    // 5) DELETE
    // ------------------------
    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable String id) {
        mediator.send(new DeletePlayerCommand(id));
    }
}
