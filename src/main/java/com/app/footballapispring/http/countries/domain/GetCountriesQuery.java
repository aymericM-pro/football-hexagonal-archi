package com.app.footballapispring.http.countries.domain;

import com.app.footballapispring.core.mediator.Query;
import java.util.List;

public record GetCountriesQuery() implements Query<List<Country>> {}