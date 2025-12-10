------------------------------------------------------------
-- INSERT TEAMS
------------------------------------------------------------
INSERT INTO teams (name, country) VALUES
                                      ('Paris Saint-Germain', 'France'),
                                      ('Olympique Lyonnais', 'France');

------------------------------------------------------------
-- INSERT PLAYERS PSG
------------------------------------------------------------
INSERT INTO players (team_id, name, age, position, nationality, photo)
SELECT team_id, 'Kylian Mbappé', 25, 'ATT', 'France', 'photo1.jpg'
FROM teams WHERE name = 'Paris Saint-Germain';

INSERT INTO players (team_id, name, age, position, nationality, photo)
SELECT team_id, 'Ousmane Dembélé', 27, 'ATT', 'France', 'photo2.jpg'
FROM teams WHERE name = 'Paris Saint-Germain';

INSERT INTO players (team_id, name, age, position, nationality, photo)
SELECT team_id, 'Marquinhos', 29, 'DEF', 'Brazil', 'photo3.jpg'
FROM teams WHERE name = 'Paris Saint-Germain';

INSERT INTO players (team_id, name, age, position, nationality, photo)
SELECT team_id, 'Gianluigi Donnarumma', 25, 'GK', 'Italy', 'photo4.jpg'
FROM teams WHERE name = 'Paris Saint-Germain';

INSERT INTO players (team_id, name, age, position, nationality, photo)
SELECT team_id, 'Vitinha', 24, 'MID', 'Portugal', 'photo5.jpg'
FROM teams WHERE name = 'Paris Saint-Germain';

------------------------------------------------------------
-- INSERT PLAYERS LYON
------------------------------------------------------------
INSERT INTO players (team_id, name, age, position, nationality, photo)
SELECT team_id, 'Alexandre Lacazette', 33, 'ATT', 'France', 'photo6.jpg'
FROM teams WHERE name = 'Olympique Lyonnais';

INSERT INTO players (team_id, name, age, position, nationality, photo)
SELECT team_id, 'Rayan Cherki', 21, 'MID', 'France', 'photo7.jpg'
FROM teams WHERE name = 'Olympique Lyonnais';

INSERT INTO players (team_id, name, age, position, nationality, photo)
SELECT team_id, 'Maxence Caqueret', 24, 'MID', 'France', 'photo8.jpg'
FROM teams WHERE name = 'Olympique Lyonnais';

INSERT INTO players (team_id, name, age, position, nationality, photo)
SELECT team_id, 'Anthony Lopes', 33, 'GK', 'Portugal', 'photo9.jpg'
FROM teams WHERE name = 'Olympique Lyonnais';

INSERT INTO players (team_id, name, age, position, nationality, photo)
SELECT team_id, 'Dejan Lovren', 34, 'DEF', 'Croatia', 'photo10.jpg'
FROM teams WHERE name = 'Olympique Lyonnais';
