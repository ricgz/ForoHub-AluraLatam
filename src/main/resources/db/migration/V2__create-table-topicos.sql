create table topicos (

    id bigint not null auto_increment,
    usuario_id bigint not null,
    titulo varchar(100) not null unique,
    mensaje varchar(255) not null unique,
    curso varchar(30) not null,
    creado datetime not null,
    estado tinyint,
    primary key(id)
);