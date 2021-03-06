CREATE TABLE disco_tbl
(
    id_disco  INT NOT NULL AUTO_INCREMENT,
    id_genero INT,
    nome      varchar(255),
    valor     decimal(12, 2),
    PRIMARY KEY (id_disco)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE genero_tbl
(
    id_genero INT NOT NULL AUTO_INCREMENT,
    descricao varchar(255),
    PRIMARY KEY (id_genero)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO genero_tbl(descricao) values('ROCK');
INSERT INTO genero_tbl(descricao) values('MPB');
INSERT INTO genero_tbl(descricao) values('CLASSIC');
INSERT INTO genero_tbl(descricao) values('POP');

CREATE TABLE cliente_tbl
(
    id_cliente     INT NOT NULL AUTO_INCREMENT,
    nome           varchar(255),
    total_cashback decimal(12, 2),
    PRIMARY KEY (id_cliente)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE venda_tbl
(
    id_venda   INT NOT NULL AUTO_INCREMENT,
    id_cliente int,
    data_venda date,
    total_cash_back double,
    PRIMARY KEY (id_venda)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE venda_itens_tbl
(
    id_venda_itens INT NOT NULL AUTO_INCREMENT,
    id_venda       int,
    id_discos      int,
    valor          decimal(12, 2),
    quantidade     int,
    cash_back      decimal(12,2),
    PRIMARY KEY (id_venda_itens)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


