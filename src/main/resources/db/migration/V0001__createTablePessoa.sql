CREATE TABLE pessoa(
    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null,
    telephone varchar(45) not null,
    primary key (id)
);