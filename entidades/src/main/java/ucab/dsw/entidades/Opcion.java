package ucab.dsw.entidades;

import javax.persistence.*;

@Entity
@Table( name = "opcion" )
public class Opcion extends EntidadBase{

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

    public Pregunta get_pregunta()
    {
        return _pregunta;
    }

    public void set_pregunta( Pregunta _pregunta )
    {
        this._pregunta = _pregunta;
    }

    @ManyToOne
    @JoinColumn( name = "idPregunta" )
    private Pregunta _pregunta;

    public Opcion( long id )
    {
        super( id );
    }

    public Opcion( )
    {

    }


}
