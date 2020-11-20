package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Categoria extends EntidadBase {

    @Column(name = "descripcion", length = 45)
    private String descripcion;

    @OneToMany( mappedBy = "categoria")
    private List<Subcategoria> subcategorias;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Subcategoria> getSubcategorias() {
        return subcategorias;
    }

    public void setSubcategorias(List<Subcategoria> subcategorias) {
        this.subcategorias = subcategorias;
    }
}
