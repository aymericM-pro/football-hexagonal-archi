package com.app.footballapispring.http.countries.rest;

import com.app.footballapispring.http.countries.domain.Country;
import com.app.footballapispring.http.countries.domain.CountryDTO;

public class CountryMapper {

    public static CountryDTO toDto(Country country) {
        return new CountryDTO(
                country.name(),
                country.code(),
                country.flag()
        );
    }
}