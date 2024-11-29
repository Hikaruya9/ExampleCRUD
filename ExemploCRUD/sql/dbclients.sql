CREATE DATABASE dbclients
DEFAULT CHARACTER SET utf8mb4
DEFAULT COLLATE utf8mb4_general_ci;

USE dbclients;

CREATE TABLE user(
id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
username varchar(50) NOT NULL,
password varchar(300) NOT NULL
)DEFAULT CHARSET=utf8mb4;

DROP TABLE user;

SELECT * FROM user;

CREATE TABLE client(
id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
name varchar(100) NOT NULL,
CPFCNPJ varchar(14) NOT NULL,
email varchar(100) NOT NULL,
phone_number varchar(20) NOT NULL,
adress varchar(100) NOT NULL
)DEFAULT CHARSET=utf8mb4;

SELECT * FROM client;