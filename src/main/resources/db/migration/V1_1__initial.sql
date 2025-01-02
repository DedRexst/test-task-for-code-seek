CREATE TABLE teams
(
    id         UUID NOT NULL,
    title      VARCHAR(50) NOT NULL,
    commission DOUBLE PRECISION NOT NULL,
    funds      DOUBLE PRECISION,
    CONSTRAINT pk_teams PRIMARY KEY (id)
);

INSERT INTO teams (id, title, commission, funds) VALUES
    ('a4f3c1e1-9a5f-4ad6-8e62-89b59d5c3e6e', 'Team Alpha', 5.15, 0),
    ('b3e5d2f2-7c8e-4bc3-8d0b-1f36c7fddf8e', 'Team Beta', 7.20, 1000000),
    ('c2d6e3f3-5b7c-4ca2-9e1b-2f47c8dee9e7', 'Team Gamma', 9.18, 1000000);

CREATE TABLE players
(
    id         UUID NOT NULL,
    first_name VARCHAR(50),
    last_name  VARCHAR(50),
    experience INTEGER NOT NULL,
    team_id    UUID REFERENCES teams(id) ON DELETE SET NULL,
    birthdate TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT pk_players PRIMARY KEY (id)
);

-- CREATE UNIQUE INDEX teams_title_idx ON teams (title);

INSERT INTO players (id, first_name, last_name, experience, team_id, birthdate)
VALUES
    ('a123e456-789b-12d3-a456-426614174000', 'John', 'Doe', 5, 'a4f3c1e1-9a5f-4ad6-8e62-89b59d5c3e6e', '1995-03-15'),
    ('b223e456-789b-12d3-a456-426614174000', 'Alice', 'Smith', 2, 'a4f3c1e1-9a5f-4ad6-8e62-89b59d5c3e6e', '2000-07-22'),
    ('c323e456-789b-12d3-a456-426614174000', 'Bob', 'Johnson', 8, 'b3e5d2f2-7c8e-4bc3-8d0b-1f36c7fddf8e', '1990-12-05'),
    ('d423e456-789b-12d3-a456-426614174000', 'Emma', 'Brown', 4, 'b3e5d2f2-7c8e-4bc3-8d0b-1f36c7fddf8e', '1998-04-18'),
    ('e523e456-789b-12d3-a456-426614174000', 'Charlie', 'Davis', 6, 'c2d6e3f3-5b7c-4ca2-9e1b-2f47c8dee9e7', '1993-01-29');