create table categoria
(
    id          int auto_increment
        primary key,
    descripcion varchar(45)                 not null,
    estatus     enum ('A', 'I') default 'A' not null
);

INSERT INTO mydb.categoria (id, descripcion, estatus) VALUES (1, 'Lacteos', 'A');
INSERT INTO mydb.categoria (id, descripcion, estatus) VALUES (2, 'Bebidas', 'A');