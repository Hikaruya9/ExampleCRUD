create database pub_bar
default character set utf8mb4
default collate utf8mb4_general_ci;

use pub_bar;

create table usuarios(
id int auto_increment primary key,
nome varchar(50),
email varchar(100)
) default charset utf8mb4;

SELECT * FROM usuarios;

insert into usuarios (nome,email) values
('Wallyson', 'wallyzinho@gmail.com'),
('Caio', 'caiozinho@gmail.com');





CREATE DATABASE exemplo_crud
DEFAULT CHARACTER SET utf8mb4
DEFAULT COLLATE utf8mb4_general_ci;

USE exemplo_crud;

CREATE TABLE usuario(
id int not null auto_increment primary key,
nome varchar(50) not null,
username varchar(50) not null,
password varchar(64) not null
) DEFAULT CHARSET=utf8mb4;

SELECT * FROM usuario;



CREATE TABLE produto(
id int not null AUTO_INCREMENT primary key,
nome varchar(50) not null,
valor decimal(15, 2) not null
) DEFAULT CHARSET=utf8mb4;

SELECT * FROM produto;



CREATE TABLE fornecedor(
id int not null AUTO_INCREMENT primary key,
razao_social varchar(75) not null,
nome_fantasia varchar(75) not null,
cnpj varchar(20) not null
) DEFAULT CHARSET=utf8mb4;

SELECT * FROM fornecedor;