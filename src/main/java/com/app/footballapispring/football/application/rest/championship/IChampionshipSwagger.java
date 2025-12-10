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
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@SecurityRequirement(name = "BearerAuth")
public interface IChampionshipSwagger {

    @Operation(
            summary = "Créer un nouveau championnat",
            description = "Enregistre un championnat dans la base.",
            parameters = {
                    @Parameter(name = "name", description = "Nom du championnat", example = "Premier League"),
                    @Parameter(name = "code", description = "Code court", example = "EPL"),
                    @Parameter(name = "country", description = "Pays", example = "GB"),
                    @Parameter(name = "season", description = "Saison", example = "2024/2025"),
                    @Parameter(name = "division", description = "Division", example = "D1"),
                    @Parameter(name = "type", description = "Type du championnat", example = "LEAGUE"),
                    @Parameter(name = "photo", description = "URL du logo", example = "https://example.com/epl.png")
            },
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Championat créé",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ChampionshipResponse.class)
                            )
                    ),
                    @ApiResponse(responseCode = "400", description = "Requête invalide")
            }
    )
    ResponseEntity<ChampionshipResponse> createChampionship(
            @Parameter(hidden = true)
            @RequestBody CreateChampionshipRequest dto
    );


    @Operation(
            summary = "Ajouter une équipe à un championnat",
            description = "Associe une équipe existante à un championnat.",
            parameters = {
                    @Parameter(name = "championshipId", description = "ID du championnat", example = "123e4567-e89b-12d3-a456-426614174000"),
                    @Parameter(name = "teamId", description = "ID de l'équipe", example = "550e8400-e29b-41d4-a716-446655440000")
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Équipe ajoutée"),
                    @ApiResponse(responseCode = "404", description = "Championnat ou équipe introuvable")
            }
    )
    ResponseEntity<ChampionshipResponse> addTeamToChampionship(
            String championshipId,
            String teamId
    );


    @Operation(
            summary = "Lister tous les championnats",
            description = "Retourne l'intégralité des championnats enregistrés.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Liste récupérée",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ChampionshipResponse.class)
                            )
                    )
            }
    )
    ResponseEntity<List<ChampionshipResponse>> getAllChampionships();
}
