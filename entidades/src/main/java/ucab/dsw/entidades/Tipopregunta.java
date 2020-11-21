package ucab.dsw.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table( name = "tipopregunta" )
public class Tipopregunta extends EntidadBase
{
    @Column( name = "descripcion")
    private String _descripcion;

    @OneToMany( mappedBy = "idtipopregunta", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Pregunta> Pregunta;

    public String get_descripcion()
    {
        return _descripcion;
    }

    public void set_descripcion( String _descripcion )
    {
        this._descripcion = _descripcion;
    }

    public List<Pregunta> get_Pregunta()
    {
        return this.Pregunta;
    }

    public void set_Pregunta(  List<Pregunta> P )
    {
        this.Pregunta = P;
    }

    public Tipopregunta(long id )
    {
        super( id );
    }

    public Tipopregunta( )
    {

    }
}

