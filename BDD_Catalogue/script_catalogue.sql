DROP DATABASE IF EXISTS CATALOGUE;
CREATE DATABASE CATALOGUE;
USE CATALOGUE;

CREATE TABLE MaisonEdition(
   id BIGINT,
   Adresse VARCHAR(50) NOT NULL,
   Date_creation DATE NOT NULL,
   PRIMARY KEY(id)
);

CREATE TABLE Thematiques(
   id BIGINT,
   Nom VARCHAR(50) NOT NULL,
   PRIMARY KEY(id)
);

CREATE TABLE Clients(
   id BIGINT,
   identifiant VARCHAR(50) NOT NULL,
   PRIMARY KEY(id)
);

CREATE TABLE Magazines(
   id BIGINT,
   Nom VARCHAR(50) NOT NULL,
   Numéro VARCHAR(50) NOT NULL,
   Date_publication DATE NOT NULL,
   fk_ME BIGINT NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(fk_ME) REFERENCES MaisonEdition(id)
);

CREATE TABLE Articles(
   id BIGINT,
   Titre VARCHAR(200) NOT NULL,
   Auteur VARCHAR(50) NOT NULL,
   Texte VARCHAR(50),
   Image VARCHAR(50),
   fk_magazine BIGINT NOT NULL,
   fk_thematique BIGINT NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(fk_thematique) REFERENCES Thematiques(id),
   FOREIGN KEY(fk_magazine) REFERENCES Magazines(id)
);

CREATE TABLE Maison_Thematique(
   fk_ME BIGINT,
   fk_thematique BIGINT,
   PRIMARY KEY(fk_ME, fk_thematique),
   FOREIGN KEY(fk_ME) REFERENCES MaisonEdition(id),
   FOREIGN KEY(fk_thematique) REFERENCES Thematiques(id)
);

CREATE TABLE Article_Client(
   fk_article BIGINT,
   fk_client BIGINT,
   PRIMARY KEY(fk_article, fk_client),
   FOREIGN KEY(fk_article) REFERENCES Articles(id),
   FOREIGN KEY(fk_client) REFERENCES Clients(id)
);