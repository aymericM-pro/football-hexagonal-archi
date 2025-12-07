package com.app.footballapispring.football.domain.player.models;

public enum Position {
    GK,
    DEF,
    MID,
    ATT;

    public static Position fromApiValue(String value) {
        if (value == null) return null;

        return switch (value.toUpperCase()) {
            case "GOALKEEPER" -> GK;
            case "DEFENDER" -> DEF;
            case "MIDFIELDER" -> MID;
            case "ATTACKER"-> ATT;
            default -> null;
        };
    }
}
