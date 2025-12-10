package com.app.footballapispring.football.application.rest.teams;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@SecurityRequirement(name = "BearerAuth")
public interface ITeamControllerSwagger {

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

    @Operation(
            summary = "Créer une équipe",
            description = "Ajoute une nouvelle équipe à la base de données.",
            parameters = {
                    @Parameter(
                            name = "name",
                            description = "Nom de l'équipe",
                            example = "Paris Saint-Germain"
                    ),
                    @Parameter(
                            name = "country",
                            description = "Pays de l'équipe",
                            example = "France"
                    )
            },
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
            @RequestBody CreateTeamDTO dto
    );

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
