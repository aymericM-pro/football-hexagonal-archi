package com.app.footballapispring.http.footballApi.rest.teams;

public record TeamDetailDTO(
        int id,
        String name,
        String country,
        int founded,
        String logo,
        String stadiumName,
        String stadiumCity,
        int stadiumCapacity,
        String stadiumImage,
        String coachName,
        String coachNationality,
        String coachPhoto
) {}
