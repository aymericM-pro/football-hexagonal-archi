package com.app.footballapispring.application.rest;

import com.app.footballapispring.application.rest.fixture.FixtureDTO;
import com.app.footballapispring.application.rest.player.PlayerDTO;
import com.app.footballapispring.application.rest.standing.StandingDTO;
import com.app.footballapispring.application.rest.teams.TeamDetailDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.List;

public interface IFootballControllerSwagger {

    @Operation(
            summary = "Récupère le classement d’un championnat",
            description = "Permet de récupérer le classement d’une saison pour un championnat.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Classement récupéré avec succès",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = StandingDTO.class)
                            )
                    )
            }
    )
    List<StandingDTO> getStandings(
            @Parameter(description = "ID du championnat", example = "61") int league,
            @Parameter(description = "Saison", example = "2023") int season
    );

    @Operation(
            summary = "Récupère les joueurs d’une équipe",
            description = "Retourne la liste complète des joueurs d'un club pour une saison donnée.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Liste des joueurs récupérée",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = PlayerDTO.class)
                            )
                    ),
                    @ApiResponse(responseCode = "400", description = "Paramètres invalides"),
                    @ApiResponse(responseCode = "500", description = "Erreur interne")
            }
    )
    List<PlayerDTO> getPlayers(
            @Parameter(description = "ID de l'équipe", example = "85")
            int team,

            @Parameter(description = "Saison (année de début)", example = "2024")
            int season,

            @Parameter(description = "Numéro de la page pour la pagination API", example = "1")
            int page
    );


    @Operation(
            summary = "Récupère les matchs d’une journée",
            description = "Retourne les matchs d'une journée pour un championnat.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = FixtureDTO.class)
                            )
                    )
            }
    )
    List<FixtureDTO> getMatches(
            @Parameter(example = "61") int league,
            @Parameter(example = "2024") int season,
            @Parameter(example = "1") int day
    );

    @Operation(
            summary = "Infos détaillées d'une équipe",
            description = "Infos club : pays, logo, coach, stade…",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = TeamDetailDTO.class)
                            )
                    )
            }
    )
    TeamDetailDTO getTeamDetails(
            @Parameter(example = "85") int id
    );
}
