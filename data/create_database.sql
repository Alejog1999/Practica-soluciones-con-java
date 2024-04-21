CREATE TABLE IF NOT EXISTS "Peliculas" (
	"Id"	INTEGER,
	"Titulo" TEXT NOT NULL,
    "Id_director" INTEGER NOT NULL,
    "Year" INTEGER NOT NULL,
    "Url_caratula" TEXT NOT NULL,
    "Id_genero" INTEGER NOT NULL,
    "Es_animacion" INTEGER NOT NULL,
	PRIMARY KEY("Id" AUTOINCREMENT),
	FOREIGN KEY("Id_genero") REFERENCES "Generos"("Id"),
	FOREIGN KEY("Id_director") REFERENCES "Directores"("Id")
);

CREATE TABLE "Generos" (
	"Id"	INTEGER,
	"Descripcion"	TEXT NOT NULL,
	PRIMARY KEY("Id" AUTOINCREMENT)
);

CREATE TABLE "Repartos" (
	"Id_pelicula"	INTEGER,
	"Id_artista"	INTEGER,
	PRIMARY KEY("Id_pelicula","Id_artista"),
	FOREIGN KEY("Id_artista") REFERENCES "Artistas"("Id"),
	FOREIGN KEY("Id_pelicula") REFERENCES "Peliculas"("Id")
);

CREATE TABLE "Artistas" (
	"Id"	INTEGER,
	"Nombre"	TEXT NOT NULL,
	"Url_foto"	TEXT NOT NULL,
	"Url_web"	TEXT NOT NULL,
	PRIMARY KEY("Id" AUTOINCREMENT)
);

CREATE TABLE "Directores" (
	"Id"	INTEGER,
	"Nombre"	TEXT NOT NULL,
	"Url_foto"	TEXT NOT NULL,
	"Url_web"	TEXT NOT NULL,
	PRIMARY KEY("Id" AUTOINCREMENT)
);



INSERT INTO Generos (Id, Descripcion) VALUES (1, "FICCION");
INSERT INTO Generos (Id, Descripcion) VALUES (2, "SUSPENSO");	
INSERT INTO Generos (Id, Descripcion) VALUES (3, "COMEDIA"); 
INSERT INTO Generos (Id, Descripcion) VALUES (4, "ACCION");
INSERT INTO Generos (Id, Descripcion) VALUES (5, "INFANTIL");


INSERT INTO Directores(Id, Nombre, Url_foto, Url_web) VALUES (1, "Joe Johnston", "www.wikipedia.org/Foto/Joe_Johnston",  "www.wikipedia.org/Joe_Johnston");
INSERT INTO Directores(Id, Nombre, Url_foto, Url_web) VALUES (2, "José Luis Garci", "www.wikipedia.org/Foto/José_Luis_Garci",  "www.wikipedia.org/José_Luis_Garci");
INSERT INTO Directores(Id, Nombre, Url_foto, Url_web) VALUES (3, "Charles Chaplin", "www.wikipedia.org/Foto/Charles_Chaplin",  "www.wikipedia.org/Charles_Chaplin");
INSERT INTO Directores(Id, Nombre, Url_foto, Url_web) VALUES (4, "Jaume Collet-Serra", "www.wikipedia.org/Foto/Jaume_Collet-Serra",  "www.wikipedia.org/Jaume_Collet-Serra");
INSERT INTO Directores(Id, Nombre, Url_foto, Url_web) VALUES (5, "Jeff Fowler", "www.wikipedia.org/Foto/Jeff_Fowler",  "www.wikipedia.org/Jeff_Fowler");

INSERT INTO Artistas(Id, Nombre, Url_foto, Url_web) VALUES (1, "Millie Bobby Brown", "www.wikipedia.org/Foto/Alberto_Sordi", "www.wikipedia.org/Alberto_Sordi");
INSERT INTO Artistas(Id, Nombre, Url_foto, Url_web) VALUES (2, "Alfredo Landa", "www.wikipedia.org/Foto/Alfredo_Landa", "www.wikipedia.org/Alfredo_Landa");
INSERT INTO Artistas(Id, Nombre, Url_foto, Url_web) VALUES (3, "Charles Chaplin", "www.wikipedia.org/Foto/Charles_Chaplin", "www.wikipedia.org/Charles_Chaplin");
INSERT INTO Artistas(Id, Nombre, Url_foto, Url_web) VALUES (4, "Dwayne Johnson", "www.wikipedia.org/Foto/Dwayne_Johnson", "www.wikipedia.org/Dwayne_Johnson");
INSERT INTO Artistas(Id, Nombre, Url_foto, Url_web) VALUES (5, "Jim Carrey", "www.wikipedia.org/Foto/Jim_Carrey", "www.wikipedia.org/Jim_Carrey");

INSERT INTO Peliculas (Id, Titulo, Id_director, Year, Url_caratula, Id_genero, Es_animacion) VALUES (1, "Las crónicas de Narnia: La silla de plata", 1, 2024, "www.wikipedia.org/Las_crónicas_de_Narnia:_La_silla_de_plata", 1, 0);
INSERT INTO Peliculas (Id, Titulo, Id_director, Year, Url_caratula, Id_genero, Es_animacion) VALUES (2, "El crack", 2, 1981, "www.wikipedia.org/El_crack", 2, 0);
INSERT INTO Peliculas (Id, Titulo, Id_director, Year, Url_caratula, Id_genero, Es_animacion) VALUES (3, "El gran dictador", 3, 1940, "www.wikipedia.org/La_vida_es_bella", 3, 0);
INSERT INTO Peliculas (Id, Titulo, Id_director, Year, Url_caratula, Id_genero, Es_animacion) VALUES (4, "Black adam", 4, 2022, "www.wikipedia.org/Alicia_en_el_pais_de_las_maravillas", 4, 0);
INSERT INTO Peliculas (Id, Titulo, Id_director, Year, Url_caratula, Id_genero, Es_animacion) VALUES (5, "SONIC", 5, 2020, "www.wikipedia.org/SONIC", 5, 1);

INSERT INTO Repartos (Id_pelicula, Id_artista) VALUES (1, 1);
INSERT INTO Repartos (Id_pelicula, Id_artista) VALUES (2, 2);
INSERT INTO Repartos (Id_pelicula, Id_artista) VALUES (3, 3);
INSERT INTO Repartos (Id_pelicula, Id_artista) VALUES (4, 4);
INSERT INTO Repartos (Id_pelicula, Id_artista) VALUES (5, 5);



COMMIT;







