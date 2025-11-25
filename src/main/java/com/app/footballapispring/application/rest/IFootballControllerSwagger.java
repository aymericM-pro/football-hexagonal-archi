package com.app.footballapispring;

import com.app.footballapispring.dtos.MatchInfo;
import com.app.footballapispring.dtos.TeamDetail;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.List;

public interface IFootballControllerSwagger {

/*    @Operation(
            summary = "Récupère le classement d’un championnat",
            description = "Permet de récupérer le classement d’une saison pour un championnat (ex : Ligue 1 2023).",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Classement récupéré avec succès",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = TeamStanding.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Paramètres invalides"),
                    @ApiResponse(responseCode = "500", description = "Erreur interne")
            }
    )
    List<TeamStanding> getStandings(
            @Parameter(description = "Championship ID (ex: 61 pour Ligue 1)", example = "61")
            int league,

            @Parameter(description = "Saison (année de début)", example = "2023")
            int season
    );*/

/*
    @Operation(
            summary = "Récupère les matchs d’une journée",
            description = "Récupère les matchs pour une journée donnée d’un championnat et d’une saison. Ex : Ligue 1 — Saison 2024 — Journée 1.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Liste des matchs récupérée",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = MatchInfo.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Paramètres invalides"),
                    @ApiResponse(responseCode = "500", description = "Erreur interne")
            }
    )
    List<MatchInfo> getMatches(
            @Parameter(description = "Championship ID (ex: 61 pour Ligue 1)", example = "61")
            int league,

            @Parameter(description = "Saison (année de début)", example = "2024")
            int season,

            @Parameter(description = "Numéro de journée (1-38)", example = "1")
            int day
    );
*/

    @Operation(
            summary = "Informations détaillées d'une équipe",
            description = "Retourne toutes les informations d’un club : nom, pays, année de fondation, stade, ville, capacité, logo…",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Informations d'équipe récupérées",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = TeamDetail.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Paramètres invalides"),
                    @ApiResponse(responseCode = "500", description = "Erreur interne")
            }
    )
    TeamDetail getTeamDetails(
            @Parameter(description = "ID de l'équipe", example = "85")
            int id
    );
}
