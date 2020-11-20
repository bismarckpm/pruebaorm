package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="subcategoria")
public class Subcategoria extends EntidadBase{

    @Column(name = "descripcion")
    private String _descripcion;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria _categoria;

    @OneToMany( mappedBy = "_subcategoria", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Solicitud> _solicitudes;

    @OneToMany( mappedBy = "_subcategoria", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Pregunta> _preguntas;

    public Subcategoria(long id) {
        super(id);
    }

    public Subcategoria() {
    }

    public String get_descripcion() {
        return _descripcion;
    }

    public void set_descripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public Categoria get_categoria() {
        return _categoria;
    }

    public void set_categoria(Categoria _categoria) {
        this._categoria = _categoria;
    }

    public List<Solicitud> get_solicitudes() {
        return _solicitudes;
    }

    public void set_solicitudes(List<Solicitud> _solicitudes) {
        this._solicitudes = _solicitudes;
    }
}
