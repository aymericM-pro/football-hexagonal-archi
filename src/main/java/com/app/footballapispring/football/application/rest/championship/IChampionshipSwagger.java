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
