CREATE TABLE IF NOT EXISTS gamesDB
(
    id    BIGSERIAL PRIMARY KEY ,
    title  VARCHAR(200) NOT NULL ,
    genre VARCHAR(254) NOT NULL ,
    releaseDate VARCHAR(20)  NOT NULL
    description VARCHAR(500)  NOT NULL
    imgPath VARCHAR(20)
    );