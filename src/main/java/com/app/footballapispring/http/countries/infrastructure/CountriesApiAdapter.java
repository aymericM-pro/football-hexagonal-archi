package com.app.footballapispring.http.countries.infrastructure;

import com.app.footballapispring.http.countries.domain.CountriesFetcher;
import com.app.footballapispring.http.countries.domain.Country;
import com.app.footballapispring.http.footballApi.rest.FootballApiClient;
import com.fasterxml.jackson.databind.JsonNode;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class CountriesApiAdapter implements CountriesFetcher {

    private final FootballApiClient footballApiClient;

    public CountriesApiAdapter(FootballApiClient footballApiClient) {
        this.footballApiClient = footballApiClient;
    }

    @Override
    public List<Country> getAllCountries() {

        JsonNode response = footballApiClient.get(
                "/countries",
                Collections.emptyMap()
        );

        List<Country> countries = new ArrayList<>();

        for (JsonNode node : response) {

            countries.add(
                    new Country(
                            node.path("name").asText(),
                            node.path("code").asText(),
                            node.path("flag").asText()
                    )
            );
        }

        return countries;
    }
}