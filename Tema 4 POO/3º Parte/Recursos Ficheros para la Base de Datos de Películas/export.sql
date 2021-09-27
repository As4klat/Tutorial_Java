--
-- File generated with SQLiteStudio v3.2.1 on mi. mar. 6 14:37:29 2019
--
-- Text encoding used: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: actores
DROP TABLE IF EXISTS actores;
CREATE TABLE actores (id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL, nombre VARCHAR NOT NULL, fechaNacimiento DATE NOT NULL);

-- Table: actoresPeliculas
DROP TABLE IF EXISTS actoresPeliculas;
CREATE TABLE actoresPeliculas (idActor INTEGER REFERENCES actores (id) ON DELETE CASCADE ON UPDATE CASCADE NOT NULL, idPelicula INTEGER NOT NULL REFERENCES peliculas (id) ON DELETE CASCADE ON UPDATE CASCADE, principal BOOLEAN NOT NULL, PRIMARY KEY (idActor, idPelicula));

-- Table: peliculas
DROP TABLE IF EXISTS peliculas;
CREATE TABLE peliculas (id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL, titulo VARCHAR NOT NULL, anno INTEGER NOT NULL, tieneOscar BOOLEAN NOT NULL, valoracion DOUBLE);

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
