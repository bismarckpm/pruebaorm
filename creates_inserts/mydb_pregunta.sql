create table pregunta
(
    id             int auto_increment
        primary key,
    pregunta       varchar(345)    not null,
    fechacreacion  date            not null,
    estatus        enum ('A', 'I') not null,
    idTipoPregunta int             not null,
    idSubCategoria int             not null,
    idUsuario      int             not null,
    constraint fk_Pregunta_SubCategoria1
        foreign key (idSubCategoria) references subcategoria (id),
    constraint fk_Pregunta_TipoPregunta1
        foreign key (idTipoPregunta) references tipopregunta (id),
    constraint fk_Pregunta_Usuario1
        foreign key (idUsuario) references usuario (id)
);

create index fk_Pregunta_SubCategoria1_idx
    on pregunta (idSubCategoria);

create index fk_Pregunta_TipoPregunta1_idx
    on pregunta (idTipoPregunta);

create index fk_Pregunta_Usuario1_idx
    on pregunta (idUsuario);

INSERT INTO mydb.pregunta (id, pregunta, fechacreacion, estatus, idTipoPregunta, idSubCategoria, idUsuario) VALUES (1, '¿Cuanto es 2 + 2?', '2020-11-21', 'A', 1, 1, 1);
INSERT INTO mydb.pregunta (id, pregunta, fechacreacion, estatus, idTipoPregunta, idSubCategoria, idUsuario) VALUES (2, '¿Que hora es?', '2020-11-26', 'A', 2, 2, 1);