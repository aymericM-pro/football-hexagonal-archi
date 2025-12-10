package com.app.footballapispring.football.application.rest.championship;

import com.app.footballapispring.football.application.rest.championship.requests.ChampionshipResponse;
import com.app.footballapispring.football.application.rest.championship.requests.CreateChampionshipRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;

@SecurityRequirement(name = "BearerAuth")
public interface IChampionshipSwagger {

    @Operation(
            summary = "Crée un nouveau championnat",
            description = "Enregistre un championnat dans la base",
            parameters = {
                    @Parameter(name = "name", description = "Nom du championnat", example = "Premier League"),
                    @Parameter(name = "code", description = "Code court du championnat", example = "EPL"),
                    @Parameter(name = "country", description = "Pays du championnat", example = "GB"),
                    @Parameter(name = "season", description = "Saison concernée", example = "2024/2025"),
                    @Parameter(name = "division", description = "Division du championnat", example = "D1"),
                    @Parameter(name = "type", description = "Type du championnat", example = "LEAGUE"),
                    @Parameter(name = "photo", description = "URL du logo", example = "https://example.com/epl.png")
            },
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Championat crée",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CreateChampionshipRequest.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Requête invalides"
                    )
            }
    )
    ResponseEntity<ChampionshipResponse> createChampionship(
            @Parameter(description = "Payload de création du championnat")
            CreateChampionshipRequest dto
    );


    @Operation(
            summary = "Ajout une équipe à un championnat",
            description = "Ajout d'une équipe dans un championnat",
            parameters = {
                    @Parameter(name = "championshipId", description = "ID du championnat", example = "123e4567-e89b-12d3-a456-426614174000"),
                    @Parameter(name = "teamId", description = "ID de l'équipe à ajouter", example = "550e8400-e29b-41d4-a716-446655440000")
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Equipe ajoutée"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Championnat ou équipe introuvable"
                    )
            }
    )
    ResponseEntity<ChampionshipResponse> addTeamToChampionship(
            @Parameter(description = "Identifiant du championnat")
            String championshipId,

            @Parameter(description = "Id de l'équipe à ajouter")
            String teamId
    );
}
