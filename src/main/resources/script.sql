create database desafio default character set utf8 default collate utf8_general_ci;

create table heroi (
	idheroi int not null auto_increment,
	nome varchar(80) not null,
	foto blob,
	descricao varchar(120),
	flagfavorito boolean,
    primary key (idHeroi)
) default charset = utf8;

INSERT INTO heroi (nome, foto, descricao, flagfavorito)
VALUES ('Batman', LOAD_FILE('C:\Users\Cleverson Rossi\Pictures\batman.jpg'), 'Luta contra o pinguim', true);
INSERT INTO heroi (nome, foto, descricao, flagfavorito)
VALUES ('Superman', LOAD_FILE('C:\Users\Cleverson Rossi\Pictures\superman.jpg'), 'Luta contra os vilões da cidade', false);
INSERT INTO heroi (nome, foto, descricao, flagfavorito)
VALUES ('Incrível Huk', LOAD_FILE('C:\Users\Cleverson Rossi\Pictures\huk.jpg'), 'Luta contra os vilões', false);
INSERT INTO heroi (nome, foto, descricao, flagfavorito)
VALUES ('Capitão América', LOAD_FILE('C:\Users\Cleverson Rossi\Pictures\capitao.jpg'), 'Luta contra todoss os vilões', true);