package ucab.dsw.entidades;

import javax.persistence.*;

@Entity
@Table( name = "opcion" )
public class Opcion extends EntidadBase{

    @Column( name = "descripcion" )
    private String descripcion;

    public String get_descripcion()
    {
        return descripcion;
    }

    public void set_descripcion( String descripcion )
    {
        this.descripcion = descripcion;
    }

    @ManyToOne
    @JoinColumn( name = "idPregunta" )
    private Pregunta pregunta;

    public Opcion( long id )
    {
        super( id );
    }

    public Opcion(){

    }

    public Pregunta get_pregunta()
    {
        return pregunta;
    }

    public void set_pregunta( Pregunta pregunta )
    {
        this.pregunta = pregunta;
    }

}
