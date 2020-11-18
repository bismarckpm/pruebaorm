package ucab.dsw.entidades;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="subcategoria")
public class Subcategoria extends EntidadBase{

    @Column(name ="descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name="idCategoria")
    private Categoria _categoria;

    @Override
    public String get_estatus()
    {
        return _estatus;
    }

    @Override
    public void set_estatus( String _estatus )
    {
        this._estatus = _estatus;
    }

    @Column( name = "estatus" )
    private String _estatus;

    @OneToMany( mappedBy = "_subcategoria", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Solicitud> _solicitud;

    public List<Solicitud> get_solicitud() {
        return _solicitud;
    }

    public void set_solicitud(List<Solicitud> _solicitud) {
        this._solicitud = _solicitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria get_categoria() {
        return _categoria;
    }

    public void set_categoria(Categoria _categoria) {
        this._categoria = _categoria;
    }

    public Subcategoria(long id) {
        super(id);
    }

    public Subcategoria() {
    }
}
