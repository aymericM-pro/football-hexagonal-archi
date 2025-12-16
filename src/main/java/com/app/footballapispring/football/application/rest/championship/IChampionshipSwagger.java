// java
package com.app.footballapispring.football.application.rest.championship;

import com.app.footballapispring.football.application.rest.championship.requests.ChampionshipResponse;
import com.app.footballapispring.football.application.rest.championship.requests.CreateChampionshipRequest;
import com.app.footballapispring.football.domain.championship.models.ChampionshipCalendarResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
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
@Tag(name = "Championship", description = "Endpoints de gestion des championnats")
public interface IChampionshipSwagger {

    @Operation(
            summary = "Créer un nouveau championnat",
            description = "Enregistre un championnat dans la base. Le nom, le code et la saison sont obligatoires.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    description = "Données du championnat à créer",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CreateChampionshipRequest.class),
                            examples = {
                                    @ExampleObject(
                                            name = "Création - Ligue 1",
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
                            description = "Championnat créé avec succès",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ChampionshipResponse.class),
                                    examples = @ExampleObject(
                                            value = """
                                                    {
                                                      "id": "c5f4417f-7b93-49b9-a687-ff07c070b4cd",
                                                      "name": "Ligue 1",
                                                      "code": "L1",
                                                      "country": "FRANCE",
                                                      "season": "2024-2025",
                                                      "division": "1",
                                                      "type": "LEAGUE",
                                                      "photo": "https://example.com/ligue1.png",
                                                      "teamsCount": 20
                                                    }
                                                    """
                                    )
                            )
                    ),
                    @ApiResponse(responseCode = "400", description = "Requête invalide : champ manquant ou format incorrect"),
                    @ApiResponse(responseCode = "401", description = "Non authentifié"),
                    @ApiResponse(responseCode = "403", description = "Accès refusé"),
                    @ApiResponse(responseCode = "409", description = "Conflit : championnat déjà existant"),
                    @ApiResponse(responseCode = "500", description = "Erreur serveur")
            }
    )
    ResponseEntity<ChampionshipResponse> createChampionship(
            @Parameter(hidden = true)
            @RequestBody CreateChampionshipRequest dto
    );


    @Operation(
            summary = "Ajouter une équipe à un championnat",
            description = "Associe une équipe existante à un championnat. Les IDs doivent être des UUID valides.",
            parameters = {
                    @Parameter(in = ParameterIn.PATH, name = "championshipId", description = "ID du championnat", required = true, example = "123e4567-e89b-12d3-a456-426614174000"),
                    @Parameter(in = ParameterIn.PATH, name = "teamId", description = "ID de l'équipe", required = true, example = "550e8400-e29b-41d4-a716-446655440000")
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Équipe ajoutée au championnat",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ChampionshipResponse.class)
                            )
                    ),
                    @ApiResponse(responseCode = "400", description = "Requête invalide"),
                    @ApiResponse(responseCode = "401", description = "Non authentifié"),
                    @ApiResponse(responseCode = "403", description = "Accès refusé"),
                    @ApiResponse(responseCode = "404", description = "Championnat ou équipe introuvable"),
                    @ApiResponse(responseCode = "409", description = "Équipe déjà présente dans le championnat"),
                    @ApiResponse(responseCode = "500", description = "Erreur serveur")
            }
    )
    ResponseEntity<ChampionshipResponse> addTeamToChampionship(
            @Parameter(in = ParameterIn.PATH, name = "championshipId", description = "ID du championnat", required = true, example = "123e4567-e89b-12d3-a456-426614174000")
            String championshipId,
            @Parameter(in = ParameterIn.PATH, name = "teamId", description = "ID de l'équipe", required = true, example = "550e8400-e29b-41d4-a716-446655440000")
            String teamId
    );


    @Operation(
            summary = "Lister tous les championnats",
            description = "Retourne l'intégralité des championnats enregistrés. Supporte pagination et filtres (à implémenter côté contrôleur).",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Liste des championnats",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ChampionshipResponse.class),
                                    examples = @ExampleObject(
                                            value = """
                                                    [
                                                      {
                                                        "id": "c5f4417f-7b93-49b9-a687-ff07c070b4cd",
                                                        "name": "Ligue 1",
                                                        "code": "L1",
                                                        "season": "2024-2025"
                                                      },
                                                      {
                                                        "id": "a1b2c3d4-1111-2222-3333-444455556666",
                                                        "name": "Premier League",
                                                        "code": "PL",
                                                        "season": "2024-2025"
                                                      }
                                                    ]
                                                    """
                                    )
                            )
                    ),
                    @ApiResponse(responseCode = "401", description = "Non authentifié"),
                    @ApiResponse(responseCode = "500", description = "Erreur serveur")
            }
    )
    ResponseEntity<List<ChampionshipResponse>> getAllChampionships();


    @Operation(
            summary = "Récupérer le calendrier du championnat",
            description = "Retourne le calendrier structuré par journée. Chaque journée contient la liste de ses matchs.",
            parameters = @Parameter(in = ParameterIn.PATH,
                    name = "id",
                    description = "ID du championnat (UUID)",
                    required = true,
                    example = "c5f4417f-7b93-49b9-a687-ff07c070b4cd"
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Calendrier du championnat",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ChampionshipCalendarResult.class),
                                    examples = @ExampleObject(
                                            value = """
                                                    {
                                                      "championshipId": "c5f4417f-7b93-49b9-a687-ff07c070b4cd",
                                                      "roundDays": {
                                                        "1": [
                                                          {
                                                            "homeTeamId": "8676fb88-83d2-4731-92f6-0523832ab26d",
                                                            "awayTeamId": "9d6b89e7-60d3-40ad-8077-7bbea1a638d6",
                                                            "date": "2025-02-01T20:00:00Z"
                                                          }
                                                        ]
                                                      }
                                                    }
                                                    """
                                    )
                            )
                    ),
                    @ApiResponse(responseCode = "400", description = "ID invalide"),
                    @ApiResponse(responseCode = "401", description = "Non authentifié"),
                    @ApiResponse(responseCode = "404", description = "Championnat introuvable"),
                    @ApiResponse(responseCode = "500", description = "Erreur serveur")
            }
    )
    ResponseEntity<ChampionshipCalendarResult> getCalendar(
            @Parameter(in = ParameterIn.PATH, name = "id", description = "ID du championnat", required = true, example = "c5f4417f-7b93-49b9-a687-ff07c070b4cd")
            String id);

}