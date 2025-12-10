CREATE EXTENSION IF NOT EXISTS pgcrypto;

DROP TABLE IF EXISTS players CASCADE;
DROP TABLE IF EXISTS teams CASCADE;
DROP TABLE IF EXISTS fixtures CASCADE;

CREATE TABLE teams (
                       team_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                       name VARCHAR(100) NOT NULL,
                       country VARCHAR(100) NOT NULL
);

CREATE TABLE players (
                         player_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                         team_id UUID REFERENCES teams(id),
                         name VARCHAR(100) NOT NULL,
                         age INT,
                         position VARCHAR(20),
                         nationality VARCHAR(50),
                         photo VARCHAR(255)
);

CREATE TABLE fixtures (
                          fixture_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                          home_team_id TEXT NOT NULL,
                          away_team_id TEXT NOT NULL,
                          home_score INT,
                          away_score INT,
                          date TIMESTAMP
);
