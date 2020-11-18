package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "tipopregunta" )
public class TipoPregunta extends EntidadBase{

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

    public List<Pregunta> get_preguntas()
    {
        return _preguntas;
    }

    public void set_preguntas( List<Pregunta> _preguntas )
    {
        this._preguntas = _preguntas;
    }

    @OneToMany( mappedBy = "_tipopregunta", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Pregunta> _preguntas;

    public TipoPregunta(){

    }

    public TipoPregunta( long id )
    {
        super( id );
    }

}
