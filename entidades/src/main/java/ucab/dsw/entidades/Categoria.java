package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categoria")
public class Categoria extends EntidadBase {

    @Column(name = "descripcion", length = 45)
    private String descripcion;

    @OneToMany( mappedBy = "categorias")
    private List<SubcategoriaEnt> subcategoriaEnts;

    public Categoria () {
    }
    public Categoria (long id) {
        super(id);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<SubcategoriaEnt> getSubcategorias() {
        return subcategoriaEnts;
    }

    public void setSubcategorias(List<SubcategoriaEnt> subcategoriaEnts) {
        this.subcategoriaEnts = subcategoriaEnts;
    }
}
