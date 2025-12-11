package com.app.footballapispring.football.application.rest.fixture.request;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SecurityRequirement(name = "BearerAuth")
@Tag(name = "Fixture", description = "Endpoints de gestion des fixtures")
public interface IFixtureControllerSwagger {

    @Operation(
            summary = "Récupère tous les matchs (fixtures)",
            description = "Retourne la liste complète des matchs stockés.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Liste récupérée",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = FixtureResponse.class)
                            )
                    )
            }
    )
    ResponseEntity<List<FixtureResponse>> getAllFixtures();

    @Operation(
            summary = "Récupère un match par son ID",
            description = "Retourne toutes les informations d’un match.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Match trouvé"),
                    @ApiResponse(responseCode = "404", description = "Match introuvable")
            }
    )
    ResponseEntity<FixtureResponse> getFixtureById(
            @Parameter(description = "ID du match", example = "3f2a9510-4c07-42f3-9ed0-1a469e12cf11")
            String id
    );

    @Operation(
            summary = "Crée un nouveau match (fixture)",
            description = "Insère un match complet dans la base.",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Match créé",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = FixtureResponse.class)
                            )
                    ),
                    @ApiResponse(responseCode = "400", description = "Requête invalide")
            }
    )
    ResponseEntity<FixtureResponse> createFixture(
            @Parameter(description = "Payload de création du match")
            CreateFixtureRequest request
    );

    @Operation(
            summary = "Met à jour un match",
            description = "Modifie les scores et/ou la date du match existant.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Match mis à jour"),
                    @ApiResponse(responseCode = "404", description = "Match introuvable")
            }
    )
    ResponseEntity<FixtureResponse> updateFixture(
            @Parameter(description = "ID du match", example = "3f2a9510-4c07-42f3-9ed0-1a469e12cf11")
            String id,

            @Parameter(description = "Données à mettre à jour")
            UpdateFixtureRequest request
    );


    @Operation(
            summary = "Supprime un match",
            description = "Supprime un match existant.",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Suppression réussie"),
                    @ApiResponse(responseCode = "404", description = "Match introuvable")
            }
    )
    ResponseEntity<Void> deleteFixture(
            @Parameter(description = "ID du match", example = "3f2a9510-4c07-42f3-9ed0-1a469e12cf11")
            String id
    );
}
