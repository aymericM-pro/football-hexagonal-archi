package com.app.footballapispring.football.application.rest.rounddays;

import com.app.footballapispring.football.application.rest.rounddays.request.AddFixtureRequest;
import com.app.footballapispring.football.application.rest.rounddays.request.CreateRoundDayRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "RoundDays", description = "Gestion des journées d’un championnat (matchdays)")
@SecurityRequirement(name = "BearerAuth")
public interface IRoundDayControllerSwagger {

    @Operation(
            summary = "Créer une journée (RoundDay)",
            description = "Crée une nouvelle journée de championnat en indiquant son numéro.",
            requestBody = @RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CreateRoundDayRequest.class)
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "201", description = "Journée créée",
                            content = @Content(schema = @Schema(implementation = RoundDayResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Requête invalide")
            }
    )
    ResponseEntity<RoundDayResponse> create(CreateRoundDayRequest request);



    @Operation(
            summary = "Récupérer une journée",
            description = "Retourne une journée de championnat ainsi que la liste de ses matchs.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Journée trouvée",
                            content = @Content(schema = @Schema(implementation = RoundDayResponse.class))),
                    @ApiResponse(responseCode = "404", description = "Journée introuvable")
            }
    )
    ResponseEntity<RoundDayResponse> getById(String id);



    @Operation(
            summary = "Ajouter un match à une journée",
            description = "Ajoute un match à une journée existante.",
            requestBody = @RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = AddFixtureRequest.class)
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "204", description = "Match ajouté"),
                    @ApiResponse(responseCode = "404", description = "Journée introuvable")
            }
    )
    ResponseEntity<Void> addFixture(String id, AddFixtureRequest request);



    @Operation(
            summary = "Supprimer un match d’une journée",
            description = "Retire un match (fixture) d’une journée spécifique.",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Match supprimé"),
                    @ApiResponse(responseCode = "404", description = "Journée ou match introuvable")
            }
    )
    ResponseEntity<Void> removeFixture(String dayId, String fixtureId);
}
