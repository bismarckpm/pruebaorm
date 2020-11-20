create table subcategoria
(
    id          int auto_increment
        primary key,
    idCategoria int                         not null,
    descripcion varchar(45)                 not null,
    estatus     enum ('A', 'I') default 'A' not null,
    constraint fk_SubCategoria_Categoria1
        foreign key (idCategoria) references categoria (id)
);

create index fk_SubCategoria_Categoria1_idx
    on subcategoria (idCategoria);

INSERT INTO mydb.subcategoria (id, idCategoria, descripcion, estatus) VALUES (1, 1, 'Leche', 'A');
INSERT INTO mydb.subcategoria (id, idCategoria, descripcion, estatus) VALUES (2, 2, 'Alcoholicas', 'A');