create table ejecucionencuesta
(
    id                   int auto_increment
        primary key,
    idEncuesta           int                         not null,
    idPregunta           int                         not null,
    idUsuario_Encuestado int                         not null,
    idOpcion             int                         null,
    respuesta            varchar(250)                null,
    estatus              enum ('P', 'C') default 'P' null,
    constraint fk_EjecucionEncuesta_Encuesta1
        foreign key (idEncuesta) references encuesta (id),
    constraint fk_EjecucionEncuesta_Opcion1
        foreign key (idOpcion) references opcion (id),
    constraint fk_EjecucionEncuesta_Pregunta1
        foreign key (idPregunta) references pregunta (id),
    constraint fk_EjecucionEncuesta_Usuario1
        foreign key (idUsuario_Encuestado) references usuario (id)
);

create index fk_EjecucionEncuesta_Encuesta1_idx
    on ejecucionencuesta (idEncuesta);

create index fk_EjecucionEncuesta_Opcion1_idx
    on ejecucionencuesta (idOpcion);

create index fk_EjecucionEncuesta_Pregunta1_idx
    on ejecucionencuesta (idPregunta);

create index fk_EjecucionEncuesta_Usuario1_idx
    on ejecucionencuesta (idUsuario_Encuestado);

INSERT INTO mydb.ejecucionencuesta (id, idEncuesta, idPregunta, idUsuario_Encuestado, idOpcion, respuesta, estatus) VALUES (1, 1, 1, 4, 1, 'respuesta1', 'P');
INSERT INTO mydb.ejecucionencuesta (id, idEncuesta, idPregunta, idUsuario_Encuestado, idOpcion, respuesta, estatus) VALUES (2, 2, 2, 4, 2, 'respuesta2', 'P');