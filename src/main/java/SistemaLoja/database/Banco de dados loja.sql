CREATE DATABASE LOJA;
USE LOJA;

-- ESTADO
CREATE TABLE ESTADO (
	ID_ESTADO INT NOT NULL IDENTITY(1,1),
	SIGLA CHAR(2) NOT NULL,
	NOME VARCHAR(100) NOT NULL,

	CONSTRAINT PK_ID_ESTADO PRIMARY KEY(ID_ESTADO)
);

-- CIDADE
CREATE TABLE CIDADE (
	ID_CIDADE INT NOT NULL IDENTITY(1,1),
	NOME VARCHAR(100) NOT NULL,

	CONSTRAINT PK_CIDADE PRIMARY KEY(ID_CIDADE)
);

ALTER TABLE CIDADE
	ADD CONSTRAINT PK_CIDADE PRIMARY KEY(ID_CIDADE)

ALTER TABLE CIDADE 
	ADD IDFK_ESTADO INT NOT NULL,
	CONSTRAINT PK_ESTADO_CIDADE FOREIGN KEY(IDFK_ESTADO) REFERENCES ESTADO(ID_ESTADO)	

-- BAIRRO 
CREATE TABLE BAIRRO (
	ID_BAIRRO INT NOT NULL IDENTITY(1,1),
	NOME VARCHAR(100) NOT NULL,

	CONSTRAINT PK_BAIRRO PRIMARY KEY(ID_BAIRRO)
);

ALTER TABLE BAIRRO
	ADD IDFK_CIDADE INT NOT NULL,
	CONSTRAINT FK_CIDADE_BAIRRO FOREIGN KEY(IDFK_CIDADE) REFERENCES CIDADE(ID_CIDADE)

-- RUA
CREATE TABLE RUA(
	ID_RUA INT NOT NULL IDENTITY(1,1),
	NOME VARCHAR(100) NOT NULL,

	CONSTRAINT PK_RUA PRIMARY KEY(ID_RUA)
);

ALTER TABLE RUA
	ADD IDFK_BAIRRO INT NOT NULL,
	CONSTRAINT FK_BAIRRO_RUA FOREIGN KEY(IDFK_BAIRRO) REFERENCES BAIRRO(ID_BAIRRO)

-- RESIDENCIA 
CREATE TABLE RESIDENCIA(
	ID_RESIDENCIA INT NOT NULL IDENTITY(1,1),
	NUMERO INT NOT NULL,
	DESCRICAO VARCHAR(100),

	CONSTRAINT PK_RESIDENCIA PRIMARY KEY(ID_RESIDENCIA)
);

ALTER TABLE RESIDENCIA 
	ADD IDFK_RUA INT NOT NULL,
	CONSTRAINT FK_RUA_RESIDENCIA FOREIGN KEY(IDFK_RUA) REFERENCES RUA(ID_RUA)

-- TELEFONE 
CREATE TABLE TELEFONE (
	ID_TELEFONE INT NOT NULL IDENTITY(1,1),
	TELEFONE VARCHAR(14) NOT NULL,

	CONSTRAINT PK_TELEFONE PRIMARY KEY(ID_TELEFONE),
        CONSTRAINT UK_TELEFONE UNIQUE(TELEFONE)
);

-- CLIENTES
CREATE TABLE CLIENTE (
	ID_CLIENTE INT NOT NULL IDENTITY(1,1),
	NOME VARCHAR(100) NOT NULL,
	DATA_NASC DATETIME NOT NULL,
	EMAIL VARCHAR(320),
	
	CONSTRAINT PK_CLIENTE PRIMARY KEY(ID_CLIENTE)
);

ALTER TABLE CLIENTE 
	ADD IDFK_TELEFONE INT NOT NULL,
	CONSTRAINT FK_TELEFONE_CLIENTE FOREIGN KEY(IDFK_TELEFONE) REFERENCES TELEFONE(ID_TELEFONE)

ALTER TABLE CLIENTE
	ADD IDFK_RESIDENCIA INT NOT NULL,
	CONSTRAINT FK_RESIDENCIA_CLIENTE FOREIGN KEY(IDFK_RESIDENCIA) REFERENCES RESIDENCIA(ID_RESIDENCIA)

-- VENDA
CREATE TABLE VENDA(
	ID_VENDA INT NOT NULL IDENTITY(1,1),
	DATA_HORA_VENDA DATETIME NOT NULL,
	TOTAL NUMERIC(15,2) NOT NULL,

	CONSTRAINT PK_VENDA PRIMARY KEY(ID_VENDA)
);

ALTER TABLE VENDA
	ADD IDFK_CLIENTE INT NOT NULL,
	CONSTRAINT FK_CLIENTE_VENDA FOREIGN KEY(IDFK_CLIENTE) REFERENCES CLIENTE(ID_CLIENTE)

-- DISTRIBUIDORES
CREATE TABLE DISTRIBUIDOR (
	ID_DISTRIBUIDOR INT NOT NULL IDENTITY(1,1),
	NOME_FANTASIA VARCHAR(100) NOT NULL,
	RAZAO_SOCIAL VARCHAR(100) NOT NULL,
	EMAIL VARCHAR(320) NOT NULL,

	CONSTRAINT PK_DISTRIBUIDOR PRIMARY KEY(ID_DISTRIBUIDOR)
);

ALTER TABLE DISTRIBUIDOR
	ADD IDFK_TELEFONE INT NOT NULL,
	CONSTRAINT FK_TELEFONE_DISTRIBUIDOR FOREIGN KEY(IDFK_TELEFONE) REFERENCES TELEFONE(ID_TELEFONE)

-- PRODUTOS
CREATE TABLE PRODUTO (
	ID_PRODUTO INT NOT NULL IDENTITY(1,1),
	ESTOQUE INT NOT NULL,
	DATA_VALIDADE DATETIME NOT NULL,
	DESCRICAO VARCHAR(500) NOT NULL,
	PRECO_CUSTO NUMERIC(15,2) NOT NULL,
	PRECO_VENDA NUMERIC(15,2) NOT NULL,

	CONSTRAINT PK_PRODUTO PRIMARY KEY(ID_PRODUTO)
);

ALTER TABLE PRODUTO
	ADD IDFK_DISTRIBUIDOR INT NOT NULL,
	CONSTRAINT FK_DISTRIBUIDOR_PRODUTO FOREIGN KEY(IDFK_DISTRIBUIDOR) REFERENCES DISTRIBUIDOR(ID_DISTRIBUIDOR)

-- ITENS VENDA
CREATE TABLE ITENS_VENDA (
	ID_ITENS_VENDA INT NOT NULL,
	QUANTIDADE INT NOT NULL,
	SUB_TOTAL INT NOT NULL,

	CONSTRAINT PK_ITENS_VENDA PRIMARY KEY(ID_ITENS_VENDA)
);

ALTER TABLE ITENS_VENDA
	ADD IDFK_VENDA INT NOT NULL,
	CONSTRAINT FK_VENDA_ITENS_VENDA FOREIGN KEY(IDFK_VENDA) REFERENCES VENDA(ID_VENDA)

ALTER TABLE ITENS_VENDA
	ADD IDFK_PRODUTO INT NOT NULL,
	CONSTRAINT FK_PRODUTO_ITENS_VENDA FOREIGN KEY(IDFK_PRODUTO) REFERENCES PRODUTO(ID_PRODUTO)




