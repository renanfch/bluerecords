CREATE TABLE cashback_tbl
(
    id_cashback  INT NOT NULL AUTO_INCREMENT,
    id_genero INT,
    dia_semana INT,
    porcentagem_cash_back INT,
    PRIMARY KEY (id_cashback)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO cashback_tbl(id_genero, dia_semana, porcentagem_cash_back)
    VALUES(1,1,40),
          (1,2,10),
          (1,3,15),
          (1,4,15),
          (1,5,15),
          (1,6,20),
          (1,7,40),

          (2,1,30),
          (2,2,5),
          (2,3,10),
          (2,4,15),
          (2,5,20),
          (2,6,25),
          (2,7,30),

          (3,1,35),
          (3,2,3),
          (3,3,5),
          (3,4,8),
          (3,5,13),
          (3,6,18),
          (3,7,25),

          (4,1,25),
          (4,2,7),
          (4,3,6),
          (4,4,2),
          (4,5,10),
          (4,6,15),
          (4,7,20);
