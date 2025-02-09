DROP TABLE EQUIP_CATEGORIA CASCADE CONSTRAINTS PURGE;
DROP TABLE EQUIP_TEMPORADA CASCADE CONSTRAINTS PURGE;
DROP TABLE MEMBRE CASCADE CONSTRAINTS PURGE;
DROP TABLE JUGADOR CASCADE CONSTRAINTS PURGE;
DROP TABLE USUARI CASCADE CONSTRAINTS PURGE;
DROP TABLE EQUIP CASCADE CONSTRAINTS PURGE;
DROP TABLE TEMPORADA CASCADE CONSTRAINTS PURGE;
DROP TABLE CATEGORIA CASCADE CONSTRAINTS PURGE;


CREATE TABLE CATEGORIA (
    id NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    nom VARCHAR2(100) NOT NULL,
    edat_min NUMBER NOT NULL,
    edat_max NUMBER NOT NULL
);


CREATE TABLE TEMPORADA (
    id NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    any_temporada NUMBER
);

CREATE TABLE EQUIP (
    id NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    nom VARCHAR2(100) NOT NULL,
    tipus VARCHAR2(50) NOT NULL
);

CREATE TABLE USUARI (
    login VARCHAR2(50) PRIMARY KEY,
    nom VARCHAR2(100) NOT NULL,
    password VARCHAR2(100) NOT NULL
);

CREATE TABLE JUGADOR (
    id NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    nom VARCHAR2(100) NOT NULL,
    cognoms VARCHAR2(150) NOT NULL,
    sexe CHAR(1),
    data_naix DATE,
    IdLegal VARCHAR2(50) UNIQUE NOT NULL,
    any_fi_revisio_medica NUMBER,
    adreça VARCHAR2(255),
    IBAN VARCHAR2(24),
    foto VARCHAR2(255)
);

CREATE TABLE MEMBRE (
    equip_id NUMBER,
    jugador_id NUMBER,
    titular_convidat VARCHAR2(20),
    PRIMARY KEY (equip_id, jugador_id),
    FOREIGN KEY (equip_id) REFERENCES EQUIP(id) ON DELETE CASCADE,
    FOREIGN KEY (jugador_id) REFERENCES JUGADOR(id) ON DELETE CASCADE
);

CREATE TABLE EQUIP_TEMPORADA (
    equip_id NUMBER,
    temporada_any NUMBER,
    PRIMARY KEY (equip_id, temporada_any),
    FOREIGN KEY (equip_id) REFERENCES EQUIP(id) ON DELETE CASCADE,
    FOREIGN KEY (temporada_any) REFERENCES TEMPORADA(any_temporada) ON DELETE CASCADE
); 

CREATE TABLE EQUIP_CATEGORIA (
    equip_id NUMBER,
    categoria_id NUMBER,
    PRIMARY KEY (equip_id, categoria_id),
    FOREIGN KEY (equip_id) REFERENCES EQUIP(id) ON DELETE CASCADE,
    FOREIGN KEY (categoria_id) REFERENCES CATEGORIA(id) ON DELETE CASCADE
);
