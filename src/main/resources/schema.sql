CREATE TABLE PAIS(
ID_PAIS IDENTITY NOT NULL PRIMARY KEY,
CODIGO VARCHAR(2) NOT NULL,
NOMBRE VARCHAR(100) NOT NULL
);

CREATE TABLE CIUDAD( 
ID_CIUDAD IDENTITY NOT NULL PRIMARY KEY, 
CODIGO_CIUDAD VARCHAR(4) NOT NULL, 
CODIGO_PAIS INT NOT NULL, 
NOMBRE VARCHAR(100) NOT NULL,
foreign key (CODIGO_PAIS) references PAIS(ID_PAIS )
);

CREATE TABLE USER (

ID IDENTITY NOT NULL PRIMARY KEY,
USERNAME VARCHAR(100) NOT NULL,
PASSWORD VARCHAR(100) NOT NULL,
FIRSTNAME VARCHAR(100) NOT NULL, 
LASTNAME VARCHAR(100) NOT NULL, 
EMAIL VARCHAR(100) NOT NULL, 
ENABLED INT NOT NULL
);

CREATE TABLE AUTHORITY (
ID IDENTITY NOT NULL PRIMARY KEY,
NAME VARCHAR(100) NOT NULL,
);


CREATE TABLE USER_AUTHORITY (
USER_ID INT NOT NULL,
AUTHORITY_ID INT NOT NULL,
foreign key (USER_ID) references USER(ID ),
foreign key (AUTHORITY_ID) references AUTHORITY(ID )
 );