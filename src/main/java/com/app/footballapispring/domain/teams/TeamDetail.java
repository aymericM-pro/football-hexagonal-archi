package com.app.footballapispring.domain.teams;

public record TeamDetail(
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
