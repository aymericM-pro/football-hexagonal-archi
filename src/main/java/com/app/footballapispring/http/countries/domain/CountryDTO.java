package com.app.footballapispring.http.countries.domain;

public record CountryDTO(
        String name,
        String code,
        String flag
) {}