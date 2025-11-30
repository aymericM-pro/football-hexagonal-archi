package com.app.footballapispring.application.rest.teams;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.List;

public interface ITeamControllerSwagger {

    // ----------------------------------------
    // 1) GET ALL TEAMS
    // ----------------------------------------
    @Operation(
            summary = "Liste des équipes",
            description = "Récupère la liste de toutes les équipes enregistrées.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = TeamDTO.class)
                            )
                    )
            }
    )
    List<TeamDTO> getAllTeams();

    // ----------------------------------------
    // 2) CREATE TEAM
    // ----------------------------------------
    @Operation(
            summary = "Créer une équipe",
            description = "Ajoute une nouvelle équipe à la base de données.",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Équipe créée",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = TeamDTO.class)
                            )
                    ),
                    @ApiResponse(responseCode = "400", description = "Données invalides")
            }
    )
    TeamDTO createTeam(
            @Parameter(description = "Nom et pays de l'équipe")
            CreateTeamDTO dto
    );

    // ----------------------------------------
    // 3) ADD PLAYER TO TEAM
    // ----------------------------------------
    @Operation(
            summary = "Ajouter un joueur à une équipe",
            description = "Associe un joueur existant dans la base de données à une équipe.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Joueur ajouté",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = TeamDTO.class)
                            )
                    ),
                    @ApiResponse(responseCode = "404", description = "Équipe ou joueur introuvable")
            }
    )
    TeamDTO addPlayerToTeam(
            @Parameter(description = "ID de l'équipe", example = "c6aebd9b-d78a-410b-8e50-17e45f2da1a1")
            String teamId,

            @Parameter(description = "ID du joueur", example = "161ee823-0ae2-40f6-8c32-79d8a47d7541")
            String playerId
    );

    // ----------------------------------------
    // 4) GET TEAM BY ID
    // ----------------------------------------
    @Operation(
            summary = "Récupérer une équipe par ID",
            description = "Renvoie les informations détaillées d’une équipe, incluant ses joueurs.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Équipe trouvée",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = TeamInfoDTO.class)
                            )
                    ),
                    @ApiResponse(responseCode = "404", description = "Équipe introuvable")
            }
    )
    TeamInfoDTO getTeamById(
            @Parameter(description = "ID de l’équipe", example = "c6aebd9b-d78a-410b-8e50-17e45f2da1a1")
            String teamId
    );
}
