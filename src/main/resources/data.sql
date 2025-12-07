-- ============================================
-- INSERT TEAMS
-- ============================================

INSERT INTO teams (name, country) VALUES
                                      ('Paris Saint-Germain', 'France'),
                                      ('Olympique Lyonnais', 'France');

-- ============================================
-- INSERT PLAYERS PSG
-- ============================================

INSERT INTO players (team_id, name, age, position, nationality, photo)
SELECT id, 'Kylian Mbappé', 25, 'FW', 'France', 'photo1.jpg'
FROM teams WHERE name = 'Paris Saint-Germain';

INSERT INTO players (team_id, name, age, position, nationality, photo)
SELECT id, 'Ousmane Dembélé', 27, 'FW', 'France', 'photo2.jpg'
FROM teams WHERE name = 'Paris Saint-Germain';

INSERT INTO players (team_id, name, age, position, nationality, photo)
SELECT id, 'Marquinhos', 29, 'DF', 'Brazil', 'photo3.jpg'
FROM teams WHERE name = 'Paris Saint-Germain';

INSERT INTO players (team_id, name, age, position, nationality, photo)
SELECT id, 'Gianluigi Donnarumma', 25, 'GK', 'Italy', 'photo4.jpg'
FROM teams WHERE name = 'Paris Saint-Germain';

INSERT INTO players (team_id, name, age, position, nationality, photo)
SELECT id, 'Vitinha', 24, 'MF', 'Portugal', 'photo5.jpg'
FROM teams WHERE name = 'Paris Saint-Germain';

-- ============================================
-- INSERT PLAYERS LYON
-- ============================================

INSERT INTO players (team_id, name, age, position, nationality, photo)
SELECT id, 'Alexandre Lacazette', 33, 'FW', 'France', 'photo6.jpg'
FROM teams WHERE name = 'Olympique Lyonnais';

INSERT INTO players (team_id, name, age, position, nationality, photo)
SELECT id, 'Rayan Cherki', 21, 'MF', 'France', 'photo7.jpg'
FROM teams WHERE name = 'Olympique Lyonnais';

INSERT INTO players (team_id, name, age, position, nationality, photo)
SELECT id, 'Maxence Caqueret', 24, 'MF', 'France', 'photo8.jpg'
FROM teams WHERE name = 'Olympique Lyonnais';

INSERT INTO players (team_id, name, age, position, nationality, photo)
SELECT id, 'Anthony Lopes', 33, 'GK', 'Portugal', 'photo9.jpg'
FROM teams WHERE name = 'Olympique Lyonnais';

INSERT INTO players (team_id, name, age, position, nationality, photo)
SELECT id, 'Dejan Lovren', 34, 'DF', 'Croatia', 'photo10.jpg'
FROM teams WHERE name = 'Olympique Lyonnais';

-- ============================================
-- INSERT FIXTURES
-- ============================================

INSERT INTO fixtures (home_team_id, away_team_id, home_score, away_score, date)
SELECT
    (SELECT id::text FROM teams WHERE name = 'Paris Saint-Germain'),
    (SELECT id::text FROM teams WHERE name = 'Olympique Lyonnais'),
    3, 1, NOW() - INTERVAL '7 days';

INSERT INTO fixtures (home_team_id, away_team_id, home_score, away_score, date)
SELECT
    (SELECT id::text FROM teams WHERE name = 'Olympique Lyonnais'),
    (SELECT id::text FROM teams WHERE name = 'Paris Saint-Germain'),
    2, 2, NOW() - INTERVAL '3 days';

INSERT INTO fixtures (home_team_id, away_team_id, home_score, away_score, date)
SELECT
    (SELECT id::text FROM teams WHERE name = 'Paris Saint-Germain'),
    (SELECT id::text FROM teams WHERE name = 'Olympique Lyonnais'),
    1, 0, NOW();
