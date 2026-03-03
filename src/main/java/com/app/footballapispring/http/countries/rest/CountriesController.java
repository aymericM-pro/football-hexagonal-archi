package com.app.footballapispring.http.countries.rest;


import com.app.footballapispring.core.mediator.Mediator;
import com.app.footballapispring.http.countries.domain.CountryDTO;
import com.app.footballapispring.http.countries.domain.GetCountriesQuery;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountriesController implements ICountriesControllerSwagger {

    private final Mediator mediator;

    public CountriesController(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    @GetMapping
    public List<CountryDTO> getCountries() {
        return mediator.send(new GetCountriesQuery())
                .stream()
                .map(CountryMapper::toDto)
                .toList();
    }
}
