create table solicitud
(
    id             int auto_increment
        primary key,
    idUsuario      int                         not null,
    idSubCategoria int                         not null,
    nombre         varchar(45)                 not null,
    fecha          date                        null,
    estatus        enum ('A', 'I') default 'A' not null,
    constraint fk_Solicitud_SubCategoria1
        foreign key (idSubCategoria) references subcategoria (id),
    constraint fk_Solicitud_Usuario1
        foreign key (idUsuario) references usuario (id)
);

create index fk_Solicitud_SubCategoria1_idx
    on solicitud (idSubCategoria);

create index fk_Solicitud_Usuario1_idx
    on solicitud (idUsuario);

INSERT INTO mydb.solicitud (id, idUsuario, idSubCategoria, nombre, fecha, estatus) VALUES (1, 3, 1, 'Solcitud1', '2020-11-21', 'A');
INSERT INTO mydb.solicitud (id, idUsuario, idSubCategoria, nombre, fecha, estatus) VALUES (2, 3, 2, 'Solicitud2', '2020-11-21', 'A');