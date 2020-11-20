package ucab.dsw.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "opcion" )
public class opcion extends EntidadBase
{
    @Column( name = "descripcion" )
    private String _descripcion;

    public String get_descripcion()
    {
        return _descripcion;
    }

    public void set_descripcion( String _descripcion )
    {
        this._descripcion = _descripcion;
    }

 
    public TipoPregunta get_tipopregunta()
    {
        return _tipoPregunta;
    }

    public void tipopregunta( TipoPregunta _tipoPregunta)
    {
        this._tipoPregunta = _tipoPregunta;
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

    @Column( name = "estatus" )
    private String _estatus;

    @ManyToOne
    @JoinColumn( name = "idtipopregunta" )
    private TipoPregunta _tipoPregunta;


    public opcion( long id )
    {
        super( id );
    }

    public opcion()
    {

    }
}