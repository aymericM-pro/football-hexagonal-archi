package com.app.footballapispring.http.countries.rest;

import com.app.footballapispring.http.countries.domain.CountryDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.List;

public interface ICountriesControllerSwagger {

    @Operation(
            summary = "Récupère la liste des pays",
            description = "Retourne tous les pays disponibles dans l’API Football.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Liste des pays récupérée",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CountryDTO.class)
                            )
                    ),
                    @ApiResponse(responseCode = "500", description = "Erreur interne")
            }
    )
    List<CountryDTO> getCountries();
}