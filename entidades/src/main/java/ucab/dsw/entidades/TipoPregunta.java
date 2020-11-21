package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "tipopregunta" )
public class TipoPregunta extends EntidadBase{

    @Column( name = "descripcion", nullable = false )
    private String descripcion;

    public String get_descripcion()
    {
        return descripcion;
    }

    public void set_descripcion( String descripcion )
    {
        this.descripcion = descripcion;
    }

    public List<Pregunta> get_preguntas()
    {
        return preguntas;
    }

    public void set_preguntas( List<Pregunta> preguntas )
    {
        this.preguntas = preguntas;
    }

    @OneToMany( mappedBy = "tipopregunta", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Pregunta> preguntas;

    public TipoPregunta(){

    }

    public TipoPregunta( long id ) {
        super(id);
    }

}
