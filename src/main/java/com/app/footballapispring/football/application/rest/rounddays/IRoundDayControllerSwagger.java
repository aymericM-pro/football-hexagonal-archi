package com.app.footballapispring.football.application.rest.rounddays;

import com.app.footballapispring.football.application.rest.rounddays.request.AddFixtureRequest;
import com.app.footballapispring.football.application.rest.rounddays.request.CreateRoundDayRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "RoundDays", description = "Gestion des journées d’un championnat (matchdays)")
@SecurityRequirement(name = "BearerAuth")
public interface IRoundDayControllerSwagger {

    // ------------------------------------------------------------------
    // CREATE ROUND DAY
    // ------------------------------------------------------------------

    @Operation(
            summary = "Créer une journée (RoundDay)",
            description = "Crée une nouvelle journée de championnat pour un championnat donné.",
            requestBody = @RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CreateRoundDayRequest.class)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Journée créée",
                            content = @Content(
                                    schema = @Schema(implementation = RoundDayResponse.class)
                            )
                    ),
                    @ApiResponse(responseCode = "400", description = "Requête invalide"),
                    @ApiResponse(responseCode = "404", description = "Championnat introuvable")
            }
    )
    ResponseEntity<RoundDayResponse> create(CreateRoundDayRequest request);

    // ------------------------------------------------------------------
    // GET ROUND DAY
    // ------------------------------------------------------------------

    @Operation(
            summary = "Récupérer une journée",
            description = "Retourne une journée de championnat ainsi que la liste de ses matchs.",
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "Identifiant de la journée",
                            required = true
                    )
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Journée trouvée",
                            content = @Content(
                                    schema = @Schema(implementation = RoundDayResponse.class)
                            )
                    ),
                    @ApiResponse(responseCode = "404", description = "Journée introuvable")
            }
    )
    ResponseEntity<RoundDayResponse> getById(String id);

    // ------------------------------------------------------------------
    // ADD FIXTURE
    // ------------------------------------------------------------------

    @Operation(
            summary = "Ajouter un match à une journée",
            description = """
                    Ajoute un match (fixture) à une journée existante.
                    Le championnat est fourni dans le corps de la requête.
                    """,
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "Identifiant de la journée",
                            required = true
                    )
            },
            requestBody = @RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = AddFixtureRequest.class)
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "204", description = "Match ajouté"),
                    @ApiResponse(responseCode = "404", description = "Journée ou championnat introuvable")
            }
    )
    ResponseEntity<Void> addFixture(String id, AddFixtureRequest request);

    // ------------------------------------------------------------------
    // REMOVE FIXTURE
    // ------------------------------------------------------------------

    @Operation(
            summary = "Supprimer un match d’une journée",
            description = "Retire un match (fixture) d’une journée spécifique d’un championnat.",
            parameters = {
                    @Parameter(
                            name = "championshipId",
                            description = "Identifiant du championnat",
                            required = true
                    ),
                    @Parameter(
                            name = "dayId",
                            description = "Identifiant de la journée",
                            required = true
                    ),
                    @Parameter(
                            name = "fixtureId",
                            description = "Identifiant du match",
                            required = true
                    )
            },
            responses = {
                    @ApiResponse(responseCode = "204", description = "Match supprimé"),
                    @ApiResponse(responseCode = "404", description = "Journée ou match introuvable")
            }
    )
    ResponseEntity<Void> removeFixture(
            String championshipId,
            String dayId,
            String fixtureId
    );
}
