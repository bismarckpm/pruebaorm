create table encuesta
(
    id                 int auto_increment
        primary key,
    idUsuario_Creador  int                                    not null,
    idUsuario_Analista int                                    null,
    idEstudio          int                                    not null,
    fechacreacion      date                                   not null,
    estatus            enum ('C', 'EP', 'F', 'E') default 'C' not null,
    constraint fk_Encuesta_Estudio1
        foreign key (idEstudio) references estudio (id),
    constraint fk_Encuesta_Usuario1
        foreign key (idUsuario_Creador) references usuario (id),
    constraint fk_Encuesta_Usuario2
        foreign key (idUsuario_Analista) references usuario (id)
);

create index fk_Encuesta_Estudio1_idx
    on encuesta (idEstudio);

create index fk_Encuesta_Usuario1_idx
    on encuesta (idUsuario_Creador);

create index fk_Encuesta_Usuario2_idx
    on encuesta (idUsuario_Analista);

INSERT INTO mydb.encuesta (id, idUsuario_Creador, idUsuario_Analista, idEstudio, fechacreacion, estatus) VALUES (1, 1, 2, 1, '2020-11-21', 'C');
INSERT INTO mydb.encuesta (id, idUsuario_Creador, idUsuario_Analista, idEstudio, fechacreacion, estatus) VALUES (2, 1, 2, 2, '2020-11-23', 'C');