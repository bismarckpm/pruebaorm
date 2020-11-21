
package ucab.dsw.entidades;
import javax.persistence.*;


@Entity
@Table( name = "tipopregunta" )
public class TipoPregunta extends EntidadBase {

    public TipoPregunta(long id ) { super( id ); }

    public TipoPregunta()
    {

    }

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




}
