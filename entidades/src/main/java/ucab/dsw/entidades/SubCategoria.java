
package ucab.dsw.entidades;
import javax.persistence.*;

@Entity
@Table( name = "subcategoria" )
public class SubCategoria extends EntidadBase {

    public SubCategoria(long id ) { super( id ); }

    public SubCategoria()
    {

    }

    @ManyToOne
    @JoinColumn( name = "idCategoria" )
    private Categoria _categoria;

    @Column( name = "descripcion" )
    private String _descripcion;

    @Column( name = "estatus" )
    private String _estatus;

    public String get_descripcion() { return _descripcion; }

    public void set_descripcion(String _descripcion) { this._descripcion = _descripcion; }

    @Override public String get_estatus()
    {
        return _estatus;
    }

    @Override
    public void set_estatus( String _estatus )
    {
        this._estatus = _estatus;
    }

    public Categoria get_categoria() { return _categoria; }

    public void set_categoria(Categoria _categoria) { this._categoria = _categoria; }



}


