Controle Frota JDBC WEB
=======================
É um projeto academico para exemplificar um CRUD basico 
trabalhando com Java para WEB, com um  banco postgre em uma tabela veiculo
abaixo script para criação da tabela.


CREATE TABLE veiculo
(
  chassi character varying(15) NOT NULL,
  modelo character varying(15) NOT NULL,
  proprietario character varying(20) NOT NULL,
  placa character varying(10) NOT NULL,
  ano integer NOT NULL,
  CONSTRAINT pk1 PRIMARY KEY (placa)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE veiculo OWNER TO postgres;
