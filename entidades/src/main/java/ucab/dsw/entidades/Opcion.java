package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name= "opcion")
public class Opcion extends EntidadBase{

    public String get_descripcion() { return _descripcion; }

    public void set_descripcion( String _descripcion ) { this._descripcion = _descripcion; }

    @Column( name = "descripcion")
    private String _descripcion;

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

    /*
    public Pregunta get_pregunta() { return _pregunta ;}

    public void set_pregunta( Pregunta _pregunta ) { this._pregunta = _pregunta; }

    @ManyToOne
    @JoinColumn( name = "idPregunta" )
    private Pregunta _pregunta;

    public List<EjecucionEncuesta> get_ejecucionencuestas()
    {
        return _ejecucionencuestas;
    }

    public void set_ejecucionencuestas( List<EjecucionEncuesta> _ejecucionencuestas )
    {
        this._ejecucionencuestas = _ejecucionencuestas;
    }

    @OneToMany( mappedBy = "_opcion", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<EjecucionEncuesta> _ejecucionencuestas;
    */

    public Opcion(long id) { super ( id );}

    public Opcion(){

    }
}
