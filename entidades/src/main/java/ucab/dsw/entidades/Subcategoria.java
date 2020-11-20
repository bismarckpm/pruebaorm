package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Subcategoria extends EntidadBase {

    @Column(name = "descripcion", length = 45)
    private String descripcion;

    @ManyToOne
    @JoinColumn( name = "idCategoria" )
    private Categoria categorias;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
