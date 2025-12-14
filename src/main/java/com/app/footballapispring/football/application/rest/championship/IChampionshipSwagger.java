package com.app.footballapispring.football.application.rest.championship;

import com.app.footballapispring.football.application.rest.championship.requests.ChampionshipResponse;
import com.app.footballapispring.football.application.rest.championship.requests.CreateChampionshipRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@SecurityRequirement(name = "BearerAuth")
@Tag(name = "Championship", description = "Endpoints de gestion des championships")
public interface IChampionshipSwagger {

    @Operation(
            summary = "Créer un nouveau championnat",
            description = "Enregistre un championnat dans la base.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    description = "Données du championnat à créer",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CreateChampionshipRequest.class),
                            examples = {
                                    @ExampleObject(
                                            name = "Exemple de création",
                                            value = """
                                                    {
                                                      "name": "Ligue 1",
                                                      "code": "L1",
                                                      "country": "FRANCE",
                                                      "season": "2024-2025",
                                                      "division": "1",
                                                      "type": "LEAGUE",
                                                      "photo": "https://example.com/ligue1.png"
                                                    }
                                                    """
                                    )
                            }
                    )
            ),
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
