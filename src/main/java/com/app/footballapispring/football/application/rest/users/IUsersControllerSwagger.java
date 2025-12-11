package com.app.footballapispring.football.application.rest.users;


import com.app.footballapispring.football.application.rest.users.dtos.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Users", description = "Endpoints de gestion des utilisateurs")
@SecurityRequirement(name = "BearerAuth")
public interface IUsersControllerSwagger {

    @Operation(
            summary = "Lister tous les utilisateurs",
            description = "Retourne la liste de tous les utilisateurs enregistrés.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Liste des utilisateurs",
                            content = @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = UserResponse.class)
                                    )
                            )
                    )
            }
    )
    ResponseEntity<List<UserResponse>> getAll();
}
