create table usuario
(
    id                int auto_increment
        primary key,
    nombre            varchar(45)                      not null,
    apellido          varchar(45)                      not null,
    correoelectronico varchar(150)                     not null,
    estatus           enum ('A', 'I', 'B') default 'A' not null,
    idTipoUsuario     int                              not null,
    constraint fk_Usuario_TipoUsuario
        foreign key (idTipoUsuario) references tipousuario (id)
);

create index fk_Usuario_TipoUsuario_idx
    on usuario (idTipoUsuario);

INSERT INTO mydb.usuario (id, nombre, apellido, correoelectronico, estatus, idTipoUsuario) VALUES (1, 'Gabriel ', 'Romero', 'gabriel@gmail.com', 'A', 1);
INSERT INTO mydb.usuario (id, nombre, apellido, correoelectronico, estatus, idTipoUsuario) VALUES (2, 'Bryan', 'Rodriguez', 'elbrayan@gmail.com', 'A', 2);
INSERT INTO mydb.usuario (id, nombre, apellido, correoelectronico, estatus, idTipoUsuario) VALUES (3, 'Diorfelis', 'Medina', 'diorfelis@gmail.com', 'A', 3);
INSERT INTO mydb.usuario (id, nombre, apellido, correoelectronico, estatus, idTipoUsuario) VALUES (4, 'Carlos', 'Puentes', 'carlos@gmail.com', 'A', 4);