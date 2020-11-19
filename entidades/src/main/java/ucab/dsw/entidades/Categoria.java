package ucab.dsw.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "categoria" )
public class Categoria extends EntidadBase{

    @Column(name = "descripcion")
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

    public Categoria( long id )
    {
        super( id );
    }

    public Categoria()
    {

    }

}
