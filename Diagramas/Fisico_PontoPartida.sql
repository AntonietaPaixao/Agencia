/* Logico_PontoPartida: */

CREATE DATABASE AGENCIA;

USE AGENCIA;

CREATE TABLE ENDERECO (
    idEndereco INT NOT NULL AUTO_INCREMENT,
    numero VARCHAR(10),
    logradouro VARCHAR(50),
    estadoUF VARCHAR(2),
    bairro VARCHAR(20),
    cidade VARCHAR(20),
	PRIMARY KEY (idEndereco)
);

CREATE TABLE PESSOA (
    idPessoa INT NOT NULL AUTO_INCREMENT,
    CPF VARCHAR(11),
    nomePessoa VARCHAR(50),
    dataNascimento VARCHAR(10),
    sexo VARCHAR(10),
    telefone VARCHAR(20),
    email VARCHAR(20),
	FK_ENDERECO_idEndereco INT,
	PRIMARY KEY (idPessoa),
	FOREIGN KEY (FK_ENDERECO_idEndereco)
	REFERENCES ENDERECO(idEndereco)
    );
	
	CREATE TABLE PARTIDA (
    idPartida INT NOT NULL AUTO_INCREMENT,
    Data VARCHAR(10),
    nomeCampeonato VARCHAR(10),
    timeCasa VARCHAR(10),
    timeConvidado VARCHAR(10),
	PRIMARY KEY(idPartida)
);

CREATE TABLE PACOTEPARTIDA (
    idPacotePartida INT NOT NULL AUTO_INCREMENT,
    dataSaida VARCHAR(10),
    dataRetorno VARCHAR(10),
    valorPacote DECIMAL,
    nomePacote VARCHAR(20),
    FK_PARTIDA_idPartida INT,
	PRIMARY KEY (idPacotePartida),
	FOREIGN KEY (FK_PARTIDA_idPartida)
	REFERENCES PARTIDA(idPartida)
);

CREATE TABLE COMPRA (
    idCompra INT NOT NULL AUTO_INCREMENT,
    valorCompra DECIMAL,
    quantPacotes INTEGER,
    dataCompra VARCHAR(10),
    FK_PESSOA_idPessoa INT,
	PRIMARY KEY(idCompra),
	FOREIGN KEY (FK_PESSOA_idPessoa)
	REFERENCES PESSOA(idPessoa)
);


CREATE TABLE ITENSCOMPRA (
    idItemCompra INT NOT NULL AUTO_INCREMENT,
	FK_COMPRA_idCompra INT,
    FK_PACOTEPARTIDA_idPacotePartida INT,
	PRIMARY KEY(idItemCompra),
	FOREIGN KEY (FK_COMPRA_idCompra)
	REFERENCES COMPRA(idCompra),
	FOREIGN KEY (FK_PACOTEPARTIDA_idPacotePartida)
	REFERENCES PACOTEPARTIDA(idPacotePartida)		
);

