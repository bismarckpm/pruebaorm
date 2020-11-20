create table estudio
(
    id            int auto_increment
        primary key,
    fechacreacion date                                   not null,
    idUsuario     int                                    not null,
    idSolicitud   int                                    not null,
    estatus       enum ('C', 'EP', 'F', 'E') default 'C' not null,
    constraint fk_Estudio_Solicitud1
        foreign key (idSolicitud) references solicitud (id),
    constraint fk_Estudio_Usuario1
        foreign key (idUsuario) references usuario (id)
);

create index fk_Estudio_Solicitud1_idx
    on estudio (idSolicitud);

create index fk_Estudio_Usuario1_idx
    on estudio (idUsuario);

INSERT INTO mydb.estudio (id, fechacreacion, idUsuario, idSolicitud, estatus) VALUES (1, '2020-11-21', 3, 1, 'C');
INSERT INTO mydb.estudio (id, fechacreacion, idUsuario, idSolicitud, estatus) VALUES (2, '2020-11-21', 3, 2, 'C');