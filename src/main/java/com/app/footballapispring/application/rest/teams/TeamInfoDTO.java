package com.app.footballapispring.application.rest.teams;

import com.app.footballapispring.application.rest.player.PlayerDTO;

import java.util.List;

public record TeamInfoDTO(
        String id,
        String name,
        String country,
        List<PlayerDTO> players
) {}
