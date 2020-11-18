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

    @ManyToOne
    @JoinColumn( name = "idPregunta" )
    private Pregunta _pregunta;

    public Opcion( long id )
    {
        super( id );
    }

    public Opcion(){

        }


}
