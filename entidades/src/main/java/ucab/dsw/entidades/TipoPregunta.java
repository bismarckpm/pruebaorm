package ucab.dsw.entidades;

import ucab.dsw.entidades.enums.EstadoEnum;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table( name = "tipopregunta" )
public class TipoPregunta extends EntidadBase {

    @Column(name="descripcion")
    private String _descripcion;

    @Column( name = "estatus" )
    private String _estatus;

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

    public String get_descripcion()
    {
        return _descripcion;
    }

    public void set_descripcion( String _descripcion )
    {
        this._descripcion = _descripcion;
    }

    public TipoPregunta(long id) throws Exception{ super(id);}

    public TipoPregunta(){}
}
