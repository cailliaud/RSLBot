CREATE SEQUENCE HERO_SEQUENCE START WITH 1 INCREMENT BY 1;
CREATE TABLE HERO
(
    ID                BIGINT IDENTITY,
    CREATION_TIME     TIMESTAMP NOT NULL,
    MODIFICATION_TIME TIMESTAMP,
    VERSION           INT       NOT NULL,
    NOM_ANGLAIS       VARCHAR   NOT NULL,
    NOM_FRANCAIS      VARCHAR   NOT NULL,
    FACTION           VARCHAR   NOT NULL,
    LIEN_ALUCARE      VARCHAR,
    LIEN_MISTER_TIX   VARCHAR,
    LIEN_INTELERIA    VARCHAR
);

