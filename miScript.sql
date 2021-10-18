CREATE DATABASE avaliacao2;
use avaliacao2;
CREATE TABLE PRODUTO (
id INT auto_increment, 
nome  varchar(50) not null, 
descricao varchar(255) not null, 
desconto decimal not null, 
dataInicio date not null, 
dataFim date, 
primary key (id)) 
Engine = InnoDB;