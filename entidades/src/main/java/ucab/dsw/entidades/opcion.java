package ucab.dsw.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table( name = "opcion" )
public class Opcion extends EntidadBase
{
    @Column( name = "descripcion" )
    private String _descripcion;

    @Column( name = "estatus" )
    private String _estatus;

    @ManyToOne
    @JoinColumn( name = "idtipopregunta" )
    private TipoPregunta _tipopregunta;
    
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
        return _tipopregunta;
    }

    public void set_tipopregunta( TipoPregunta _tipopregunta )
    {
        this._tipopregunta = _tipopregunta;
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

   

    public Opcion( long id )
    {
        super( id );
    }

    public Opcion()
    {

    }
}