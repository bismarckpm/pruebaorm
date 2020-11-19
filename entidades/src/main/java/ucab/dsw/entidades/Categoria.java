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

    public String get_descripcion() {
        return _descripcion;
    }

    public void set_descripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public List<Subcategoria> get_subcategorias() {
        return _subcategorias;
    }

    public void set_subcategorias(List<Subcategoria> _subcategorias) {
        this._subcategorias = _subcategorias;
    }
}
