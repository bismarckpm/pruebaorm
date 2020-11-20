create table tipopregunta
(
    id          int auto_increment
        primary key,
    descripcion varchar(45)                 not null,
    estatus     enum ('A', 'I') default 'A' not null
);

INSERT INTO mydb.tipopregunta (id, descripcion, estatus) VALUES (1, 'Simple', 'A');
INSERT INTO mydb.tipopregunta (id, descripcion, estatus) VALUES (2, 'Multiple', 'A');