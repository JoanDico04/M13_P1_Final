INSERT INTO TEMPORADA (any_temporada) VALUES (2023);
INSERT INTO TEMPORADA (any_temporada) VALUES (2024);

INSERT INTO CATEGORIA (nom, edat_min, edat_max) VALUES ('Benjamí', 7, 8);
INSERT INTO CATEGORIA (nom, edat_min, edat_max) VALUES ('Aleví', 9, 10);
INSERT INTO CATEGORIA (nom, edat_min, edat_max) VALUES ('Infantil', 12, 13);
INSERT INTO CATEGORIA (nom, edat_min, edat_max) VALUES ('Cadet', 14, 15);
INSERT INTO CATEGORIA (nom, edat_min, edat_max) VALUES ('Juvenil', 16, 17);
INSERT INTO CATEGORIA (nom, edat_min, edat_max) VALUES ('Senior', 18, 21);


-- Temporada 2023
INSERT INTO EQUIP (nom, tipus) VALUES ('FutbolClub Barcelona', 'masculí');
INSERT INTO EQUIP (nom, tipus) VALUES ('FutbolClub Barcelona Femení', 'femení');

INSERT INTO EQUIP (nom, tipus) VALUES ('Real Madrid CF', 'masculí');
INSERT INTO EQUIP (nom, tipus) VALUES ('Real Madrid CF Femení', 'femení');

-- Temporada 2024
INSERT INTO EQUIP (nom, tipus) VALUES ('Atlético de Madrid', 'masculí');
INSERT INTO EQUIP (nom, tipus) VALUES ('Atlético de Madrid Femení', 'femení');

INSERT INTO EQUIP (nom, tipus) VALUES ('Valencia CF', 'masculí');
INSERT INTO EQUIP (nom, tipus) VALUES ('Valencia CF Femení', 'femení');

-- Temporada 2023
INSERT INTO EQUIP_TEMPORADA (equip_id, temporada_any) 
VALUES ((SELECT id FROM EQUIP WHERE nom = 'FutbolClub Barcelona'), 2023);
INSERT INTO EQUIP_TEMPORADA (equip_id, temporada_any) 
VALUES ((SELECT id FROM EQUIP WHERE nom = 'FutbolClub Barcelona Femení'), 2023);

INSERT INTO EQUIP_TEMPORADA (equip_id, temporada_any) 
VALUES ((SELECT id FROM EQUIP WHERE nom = 'Real Madrid CF'), 2023);
INSERT INTO EQUIP_TEMPORADA (equip_id, temporada_any) 
VALUES ((SELECT id FROM EQUIP WHERE nom = 'Real Madrid CF Femení'), 2023);

-- Temporada 2024
INSERT INTO EQUIP_TEMPORADA (equip_id, temporada_any) 
VALUES ((SELECT id FROM EQUIP WHERE nom = 'Atlético de Madrid'), 2024);
INSERT INTO EQUIP_TEMPORADA (equip_id, temporada_any) 
VALUES ((SELECT id FROM EQUIP WHERE nom = 'Atlético de Madrid Femení'), 2024);

INSERT INTO EQUIP_TEMPORADA (equip_id, temporada_any) 
VALUES ((SELECT id FROM EQUIP WHERE nom = 'Valencia CF'), 2024);
INSERT INTO EQUIP_TEMPORADA (equip_id, temporada_any) 
VALUES ((SELECT id FROM EQUIP WHERE nom = 'Valencia CF Femení'), 2024);

-- Insertar jugadores hombres
INSERT INTO JUGADOR (nom, cognoms, sexe, data_naix, IdLegal, any_fi_revisio_medica, adreça, IBAN, foto) 
VALUES ('Carlos', 'García López', 'M', TO_DATE('2001-01-01', 'YYYY-MM-DD'), 'IDM1', 2024, 'Calle Ejemplo 1', 'ES0000000000000000000111', 'https://img.freepik.com/vector-premium/caricatura-hombre-barba-jeans-azules_388558-463.jpg');
INSERT INTO JUGADOR (nom, cognoms, sexe, data_naix, IdLegal, any_fi_revisio_medica, adreça, IBAN, foto) 
VALUES ('Miguel', 'Martínez Sánchez', 'M', TO_DATE('2010-02-02', 'YYYY-MM-DD'), 'IDM2', 2023, 'Calle Ejemplo 2', 'ES0000000000000000000222', 'https://img.freepik.com/vector-premium/caricatura-hombre-barba-jeans-azules_388558-463.jpg');
INSERT INTO JUGADOR (nom, cognoms, sexe, data_naix, IdLegal, any_fi_revisio_medica, adreça, IBAN, foto) 
VALUES ('Luis', 'Fernández Ruiz', 'M', TO_DATE('2019-03-03', 'YYYY-MM-DD'), 'IDM3', 2024, 'Calle Ejemplo 3', 'ES0000000000000000000333', 'https://img.freepik.com/vector-premium/caricatura-hombre-barba-jeans-azules_388558-463.jpg');
INSERT INTO JUGADOR (nom, cognoms, sexe, data_naix, IdLegal, any_fi_revisio_medica, adreça, IBAN, foto) 
VALUES ('David', 'Hernández Gómez', 'M', TO_DATE('2004-04-04', 'YYYY-MM-DD'), 'IDM4', 2025, 'Calle Ejemplo 4', 'ES0000000000000000000444', 'https://img.freepik.com/vector-premium/caricatura-hombre-barba-jeans-azules_388558-463.jpg');
INSERT INTO JUGADOR (nom, cognoms, sexe, data_naix, IdLegal, any_fi_revisio_medica, adreça, IBAN, foto) 
VALUES ('Javier', 'López Díaz', 'M', TO_DATE('2006-05-05', 'YYYY-MM-DD'), 'IDM5', 2025, 'Calle Ejemplo 5', 'ES0000000000000000000555', 'https://img.freepik.com/vector-premium/caricatura-hombre-barba-jeans-azules_388558-463.jpg');
INSERT INTO JUGADOR (nom, cognoms, sexe, data_naix, IdLegal, any_fi_revisio_medica, adreça, IBAN, foto) 
VALUES ('Luis', 'Martínez Pérez', 'M', TO_DATE('2001-01-01', 'YYYY-MM-DD'), 'IDM6', 2024, 'Calle Ejemplo 2', 'ES0000000000000000000222', 'https://img.freepik.com/vector-premium/caricatura-hombre-barba-jeans-azules_388558-463.jpg');
INSERT INTO JUGADOR (nom, cognoms, sexe, data_naix, IdLegal, any_fi_revisio_medica, adreça, IBAN, foto) 
VALUES ('David', 'Sánchez Ruiz', 'M', TO_DATE('2001-01-01', 'YYYY-MM-DD'), 'IDM7', 2024, 'Calle Ejemplo 3', 'ES0000000000000000000333', 'https://img.freepik.com/vector-premium/caricatura-hombre-barba-jeans-azules_388558-463.jpg');
INSERT INTO JUGADOR (nom, cognoms, sexe, data_naix, IdLegal, any_fi_revisio_medica, adreça, IBAN, foto) 
VALUES ('Juan', 'Gómez Hernández', 'M', TO_DATE('2001-01-01', 'YYYY-MM-DD'), 'IDM8', 2024, 'Calle Ejemplo 4', 'ES0000000000000000000444', 'https://img.freepik.com/vector-premium/caricatura-hombre-barba-jeans-azules_388558-463.jpg');
INSERT INTO JUGADOR (nom, cognoms, sexe, data_naix, IdLegal, any_fi_revisio_medica, adreça, IBAN, foto) 
VALUES ('Pedro', 'López Fernández', 'M', TO_DATE('2001-01-01', 'YYYY-MM-DD'), 'IDM9', 2024, 'Calle Ejemplo 5', 'ES0000000000000000000555', 'https://img.freepik.com/vector-premium/caricatura-hombre-barba-jeans-azules_388558-463.jpg');
INSERT INTO JUGADOR (nom, cognoms, sexe, data_naix, IdLegal, any_fi_revisio_medica, adreça, IBAN, foto) 
VALUES ('Luis', 'Martínez Pérez', 'M', TO_DATE('2001-01-01', 'YYYY-MM-DD'), 'IDM6', 2024, 'Calle Ejemplo 2', 'ES0000000000000000000222', 'https://img.freepik.com/vector-premium/caricatura-hombre-barba-jeans-azules_388558-463.jpg');
INSERT INTO JUGADOR (nom, cognoms, sexe, data_naix, IdLegal, any_fi_revisio_medica, adreça, IBAN, foto) 
VALUES ('David', 'Sánchez Ruiz', 'M', TO_DATE('2001-01-01', 'YYYY-MM-DD'), 'IDM7', 2024, 'Calle Ejemplo 3', 'ES0000000000000000000333', 'https://img.freepik.com/vector-premium/caricatura-hombre-barba-jeans-azules_388558-463.jpg');
INSERT INTO JUGADOR (nom, cognoms, sexe, data_naix, IdLegal, any_fi_revisio_medica, adreça, IBAN, foto) 
VALUES ('Juan', 'Gómez Hernández', 'M', TO_DATE('2001-01-01', 'YYYY-MM-DD'), 'IDM8', 2024, 'Calle Ejemplo 4', 'ES0000000000000000000444', 'https://img.freepik.com/vector-premium/caricatura-hombre-barba-jeans-azules_388558-463.jpg');
INSERT INTO JUGADOR (nom, cognoms, sexe, data_naix, IdLegal, any_fi_revisio_medica, adreça, IBAN, foto) 
VALUES ('Pedro', 'López Fernández', 'M', TO_DATE('2001-01-01', 'YYYY-MM-DD'), 'IDM9', 2024, 'Calle Ejemplo 5', 'ES0000000000000000000555', 'https://img.freepik.com/vector-premium/caricatura-hombre-barba-jeans-azules_388558-463.jpg');






-- Insertar jugadores mujeres
INSERT INTO JUGADOR (nom, cognoms, sexe, data_naix, IdLegal, any_fi_revisio_medica, adreça, IBAN, foto) 
VALUES ('María', 'Pérez López', 'F', TO_DATE('2001-06-06', 'YYYY-MM-DD'), 'IDF16', 2023, 'Calle Ejemplo 16', 'ES0000000000000000001666', 'https://img.freepik.com/vector-gratis/mujer-profesional-vestimenta-negocios_1308-174170.jpg');
INSERT INTO JUGADOR (nom, cognoms, sexe, data_naix, IdLegal, any_fi_revisio_medica, adreça, IBAN, foto) 
VALUES ('Laura', 'Gómez Sánchez', 'F', TO_DATE('2010-07-07', 'YYYY-MM-DD'), 'IDF17', 2025, 'Calle Ejemplo 17', 'ES0000000000000000001777', 'https://img.freepik.com/vector-gratis/mujer-profesional-vestimenta-negocios_1308-174170.jpg');
INSERT INTO JUGADOR (nom, cognoms, sexe, data_naix, IdLegal, any_fi_revisio_medica, adreça, IBAN, foto) 
VALUES ('Ana', 'Martínez Ruiz', 'F', TO_DATE('2019-08-08', 'YYYY-MM-DD'), 'IDF18', 2024, 'Calle Ejemplo 18', 'ES0000000000000000001888', 'https://img.freepik.com/vector-gratis/mujer-profesional-vestimenta-negocios_1308-174170.jpg');
INSERT INTO JUGADOR (nom, cognoms, sexe, data_naix, IdLegal, any_fi_revisio_medica, adreça, IBAN, foto) 
VALUES ('Lucía', 'Hernández Díaz', 'F', TO_DATE('2004-09-09', 'YYYY-MM-DD'), 'IDF19', 2025, 'Calle Ejemplo 19', 'ES0000000000000000001999', 'https://img.freepik.com/vector-gratis/mujer-profesional-vestimenta-negocios_1308-174170.jpg');
INSERT INTO JUGADOR (nom, cognoms, sexe, data_naix, IdLegal, any_fi_revisio_medica, adreça, IBAN, foto) 
VALUES ('Carmen', 'López Gómez', 'F', TO_DATE('2006-10-10', 'YYYY-MM-DD'), 'IDF20', 2025, 'Calle Ejemplo 20', 'ES0000000000000000002000', 'https://img.freepik.com/vector-gratis/mujer-profesional-vestimenta-negocios_1308-174170.jpg');
INSERT INTO JUGADOR (nom, cognoms, sexe, data_naix, IdLegal, any_fi_revisio_medica, adreça, IBAN, foto) 
VALUES ('Ana', 'González Martínez', 'F', TO_DATE('2001-06-06', 'YYYY-MM-DD'), 'IDF21', 2023, 'Calle Ejemplo 17', 'ES0000000000000000001777', 'https://img.freepik.com/vector-gratis/mujer-profesional-vestimenta-negocios_1308-174170.jpg');
INSERT INTO JUGADOR (nom, cognoms, sexe, data_naix, IdLegal, any_fi_revisio_medica, adreça, IBAN, foto) 
VALUES ('Laura', 'Hernández García', 'F', TO_DATE('2001-06-06', 'YYYY-MM-DD'), 'IDF22', 2023, 'Calle Ejemplo 18', 'ES0000000000000000001888', 'https://img.freepik.com/vector-gratis/mujer-profesional-vestimenta-negocios_1308-174170.jpg');
INSERT INTO JUGADOR (nom, cognoms, sexe, data_naix, IdLegal, any_fi_revisio_medica, adreça, IBAN, foto) 
VALUES ('Elena', 'Ramírez Ruiz', 'F', TO_DATE('2001-06-06', 'YYYY-MM-DD'), 'IDF23', 2023, 'Calle Ejemplo 19', 'ES0000000000000000001999', 'https://img.freepik.com/vector-gratis/mujer-profesional-vestimenta-negocios_1308-174170.jpg');
INSERT INTO JUGADOR (nom, cognoms, sexe, data_naix, IdLegal, any_fi_revisio_medica, adreça, IBAN, foto) 
VALUES ('Sofía', 'Díaz Torres', 'F', TO_DATE('2001-06-06', 'YYYY-MM-DD'), 'IDF24', 2023, 'Calle Ejemplo 20', 'ES0000000000000000002000', 'https://img.freepik.com/vector-gratis/mujer-profesional-vestimenta-negocios_1308-174170.jpg');
INSERT INTO JUGADOR (nom, cognoms, sexe, data_naix, IdLegal, any_fi_revisio_medica, adreça, IBAN, foto) 
VALUES ('Ana', 'González Martínez', 'F', TO_DATE('2012-06-06', 'YYYY-MM-DD'), 'IDF25', 2023, 'Calle Ejemplo 17', 'ES0000000000000000001777', 'https://img.freepik.com/vector-gratis/mujer-profesional-vestimenta-negocios_1308-174170.jpg');
INSERT INTO JUGADOR (nom, cognoms, sexe, data_naix, IdLegal, any_fi_revisio_medica, adreça, IBAN, foto) 
VALUES ('Laura', 'Hernández García', 'F', TO_DATE('2011-06-06', 'YYYY-MM-DD'), 'IDF26', 2023, 'Calle Ejemplo 18', 'ES0000000000000000001888', 'https://img.freepik.com/vector-gratis/mujer-profesional-vestimenta-negocios_1308-174170.jpg');
INSERT INTO JUGADOR (nom, cognoms, sexe, data_naix, IdLegal, any_fi_revisio_medica, adreça, IBAN, foto) 
VALUES ('Elena', 'Ramírez Ruiz', 'F', TO_DATE('2012-06-06', 'YYYY-MM-DD'), 'IDF27', 2023, 'Calle Ejemplo 19', 'ES0000000000000000001999', 'https://img.freepik.com/vector-gratis/mujer-profesional-vestimenta-negocios_1308-174170.jpg');
INSERT INTO JUGADOR (nom, cognoms, sexe, data_naix, IdLegal, any_fi_revisio_medica, adreça, IBAN, foto) 
VALUES ('Sofía', 'Díaz Torres', 'F', TO_DATE('2013-06-06', 'YYYY-MM-DD'), 'IDF28', 2023, 'Calle Ejemplo 20', 'ES0000000000000000002000', 'https://img.freepik.com/vector-gratis/mujer-profesional-vestimenta-negocios_1308-174170.jpg');




