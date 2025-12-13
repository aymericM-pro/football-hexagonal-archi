package com.app.footballapispring.football.domain.championship;

import com.app.footballapispring.core.error.BusinessException;
import com.app.footballapispring.core.error.exceptions.ChampionshipsError;
import com.app.footballapispring.core.models.Country;
import com.app.footballapispring.football.domain.fixture.Fixture;
import com.app.footballapispring.football.domain.roundday.RoundDay;
import com.app.footballapispring.football.domain.teams.Team;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Championship {

    private String id;
    private String name;
    private String code;
    private Country country;
    private String season;
    private String division;
    private ChampionshipType type;
    private String logoUrl;
    private List<Team> teams = new ArrayList<>();
    private final List<RoundDay> roundDays = new ArrayList<>();
    public static final int MAX_TEAMS = 20;

    public Championship(String id, String name, String code, Country country,
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

    public Championship(String name, String code, Country country, String season, String division, ChampionshipType type, String logoUrl) {
        this.name = name;
        this.code = code;
        this.country = country;
        this.season = season;
        this.division = division;
        this.type = type;
        this.logoUrl = logoUrl;
    }

    public void addTeam(Team team) {
        boolean exists = this.teams.stream()
                .anyMatch(t -> t.getId().equals(team.getId()));

        if (teams.size() >= MAX_TEAMS) {
            throw new IllegalStateException(
                    "Championship already has maximum number of teams: " + MAX_TEAMS
            );
        }


        if (exists) {
            throw new IllegalStateException("Team already registered in championship: " + team.getName());
        }

        int sizeAfterAdd = teams.size() + 1;

/*
        if (sizeAfterAdd % 2 != 0) {
            throw new IllegalStateException(
                    "Number of teams in a championship must be even"
            );
        }
*/

        this.teams.add(team);
    }

    public void removeTeam(String teamId) {
        this.teams.removeIf(t -> t.getId().equals(teamId));
    }

    public void createRounddaysChampionship() {
        int teamCount = teams.size();

        if (teamCount < 2 || teamCount % 2 != 0) {
            throw new BusinessException(
                    ChampionshipsError.TEAMS_NUMBER_MUST_BE_EVEN
            );
        }

        int roundsPerLeg = teamCount - 1;
        int matchesPerRound = teamCount / 2;

        List<Team> rotation = new ArrayList<>(teams);
        int roundNumber = 1;

        // =========================
        // ======== ALLER ==========
        // =========================
        for (int r = 0; r < roundsPerLeg; r++) {

            RoundDay roundDay = new RoundDay(roundNumber++);

            for (int i = 0; i < matchesPerRound; i++) {
                Team home = rotation.get(i);
                Team away = rotation.get(teamCount - 1 - i);

                roundDay.addFixture(new Fixture(
                        home.getId(),
                        away.getId(),
                        null,
                        null,
                        null
                ));
            }

            roundDays.add(roundDay);
            rotate(rotation);
        }

        // =========================
        // ======== RETOUR =========
        // =========================
        rotation = new ArrayList<>(teams); // reset rotation

        for (int r = 0; r < roundsPerLeg; r++) {

            RoundDay roundDay = new RoundDay(roundNumber++);

            for (int i = 0; i < matchesPerRound; i++) {
                Team home = rotation.get(i);
                Team away = rotation.get(teamCount - 1 - i);

                // INVERSION domicile / extérieur
                roundDay.addFixture(new Fixture(
                        away.getId(),
                        home.getId(),
                        null,
                        null,
                        null
                ));
            }

            roundDays.add(roundDay);
            rotate(rotation);
        }
    }

    private void rotate(List<Team> teams) {
        Team last = teams.remove(teams.size() - 1);
        teams.add(1, last);
    }
}
