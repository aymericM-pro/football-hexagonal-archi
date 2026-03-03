package com.app.footballapispring.http.countries.domain;


import com.app.footballapispring.core.mediator.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetCountriesUseCase implements QueryHandler<GetCountriesQuery, List<Country>> {

    private final CountriesFetcher fetcher;

    public GetCountriesUseCase(CountriesFetcher fetcher) {
        this.fetcher = fetcher;
    }

    @Override
    public List<Country> handle(GetCountriesQuery query) {
        return fetcher.getAllCountries();
    }
}