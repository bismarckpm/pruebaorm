create table tipousuario
(
    id          int auto_increment
        primary key,
    descripcion varchar(45)                 not null,
    estatus     enum ('A', 'I') default 'A' not null
);

INSERT INTO mydb.tipousuario (id, descripcion, estatus) VALUES (1, 'Admin', 'A');
INSERT INTO mydb.tipousuario (id, descripcion, estatus) VALUES (2, 'Analista', 'A');
INSERT INTO mydb.tipousuario (id, descripcion, estatus) VALUES (3, 'Cliente', 'A');
INSERT INTO mydb.tipousuario (id, descripcion, estatus) VALUES (4, 'Encuestado', 'A');