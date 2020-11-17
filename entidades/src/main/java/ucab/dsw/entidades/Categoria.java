package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="categoria")
public class Categoria extends EntidadBase {

    @Column(name = "descripcion")
    private String _descripcion;

    @OneToMany( mappedBy = "_categoria", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Subcategoria> _subcategorias;

    public Categoria(long id) {
        super(id);
    }

    public Categoria() {
    }
}
