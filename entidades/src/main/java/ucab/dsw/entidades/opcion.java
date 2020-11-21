package ucab.dsw.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
        return _tipoPregunta;
    }

<<<<<<< HEAD
    public void set_tipopregunta( TipoPregunta _tipopregunta )
=======
    public void tipopregunta( TipoPregunta _tipoPregunta)
>>>>>>> 862e9d9e80dafcc6ba85e8ca693d53be620a940f
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

<<<<<<< HEAD
   
=======
    @Column( name = "estatus" )
    private String _estatus;

    @ManyToOne
    @JoinColumn( name = "idtipopregunta" )
    private TipoPregunta _tipoPregunta;

>>>>>>> 862e9d9e80dafcc6ba85e8ca693d53be620a940f

    public Opcion( long id )
    {
        super( id );
    }

    public Opcion()
    {

    }
}