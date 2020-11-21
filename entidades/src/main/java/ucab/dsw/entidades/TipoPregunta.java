package ucab.dsw.entidades;

import javax.persistence.*;

@Entity
@Table( name = "tipopregunta" )
public class TipoPregunta extends EntidadBase {


    @Column( name = "descripcion")
    private String descripcion;

    @Column( name = "estatus")
    private String _estatus;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

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

    public TipoPregunta(long id )
    {
        super( id );
    }

    public TipoPregunta( )
    {

    }
}
