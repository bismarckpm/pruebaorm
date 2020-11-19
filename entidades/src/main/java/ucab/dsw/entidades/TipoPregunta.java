package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "tipopregunta")
public class TipoPregunta extends EntidadBase {

    @Column( name = "descripcion", nullable = false )
    private String _descripcion;

    public String get_descripcion()
    {
        return _descripcion;
    }

    public void set_descripcion( String _descripcion )
    {
        this._descripcion = _descripcion;
    }


/*
    @OneToMany( mappedBy = "_tipopregunta", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Pregunta> _pregunta;

    public List<Pregunta> get_pregunta()
    {
        return _pregunta;
    }

    public void set_pregunta( List<Pregunta> _pregunta )
    {
        this._pregunta = _pregunta;
    }
*/

    public TipoPregunta( long id )
    {
        super( id );
    }

    public TipoPregunta( )
    {

    }
}
