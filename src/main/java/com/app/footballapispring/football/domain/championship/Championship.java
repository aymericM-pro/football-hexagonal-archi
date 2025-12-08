package com.app.footballapispring.football.domain.championship;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Championship {

    private final String id;
    private String name;
    private String code;
    private String country;
    private String season;
    private String division;
    private ChampionshipType type;
    private String logoUrl;

    public Championship(String id, String name, String code, String country,
                        String season, String division, ChampionshipType type,
                        String logoUrl) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.country = country;
        this.season = season;
        this.division = division;
        this.type = type;
        this.logoUrl = logoUrl;
    }

}
