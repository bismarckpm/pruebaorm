create table opcion
(
    id          int auto_increment
        primary key,
    descripcion varchar(45)                 not null,
    estatus     enum ('A', 'I') default 'A' not null,
    idPregunta  int                         not null,
    constraint fk_Opcion_Pregunta1
        foreign key (idPregunta) references pregunta (id)
);

create index fk_Opcion_Pregunta1_idx
    on opcion (idPregunta);

INSERT INTO mydb.opcion (id, descripcion, estatus, idPregunta) VALUES (1, 'Opcion1', 'A', 1);
INSERT INTO mydb.opcion (id, descripcion, estatus, idPregunta) VALUES (2, 'Opcion2', 'A', 2);