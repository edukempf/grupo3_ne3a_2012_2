DROP DATABASE IF EXISTS aluno;
CREATE DATABASE IF NOT EXISTS aluno ;
USE aluno;

DROP TABLE IF EXISTS Comidas;
CREATE TABLE Comidas
		(id INT NOT NULL AUTO_INCREMENT,         
		nome VARCHAR(50) NOT NULL,
    quantidade INT(3) NOT NULL,
		tipo ENUM('Kg','g') NOT NULL,
		PRIMARY KEY (id))
ENGINE = InnoDB;


DROP TABLE IF EXISTS Funcionario;
CREATE TABLE Funcionario
		(id INT NOT NULL AUTO_INCREMENT,
		nome VARCHAR(100) NOT NULL,
		cpf VARCHAR(11) UNIQUE NOT NULL,
    rg VARCHAR(15) UNIQUE NOT NULL,
		data_nascimento DATE NOT NULL,
    tipo ENUM('Solteiro','Casado','Viúvo','Divorsiado') NOT NULL,
		funcao VARCHAR(40) NOT NULL,
		PRIMARY KEY (id))
ENGINE = InnoDB;

DROP TABLE IF EXISTS Bebidas;
CREATE TABLE Bebidas
		(id INT NOT NULL AUTO_INCREMENT,
		tipo ENUM ('Suco','Refrigerante','Alcoolica') NOT NULL,
		nome VARCHAR(50) NOT NULL,
    quantidade INT(3) NOT NULL,
    preco DOUBLE(5,2) NOT NULL,
		PRIMARY KEY (id))
ENGINE = InnoDB;
