package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "ejecucionencuesta" )

public class EjecucionEncuesta extends EntidadBase
{


    @Column( name = "respuesta")
    private String _respuesta;

    public String get_respuesta()
    {
        return _respuesta;
    }

    public static void set_respuesta(String _respuesta) { this._respuesta = _respuesta; }

    @Override
    public String get_estatus()
    {
        return _estatus;
    }

    @Override
    public static void set_estatus(String _estatus)
    {
        this._estatus = _estatus;
    }

    @Column( name = "estatus" )
    private String _estatus;



    @ManyToOne
    @JoinColumn( name = "idEncuesta" )
    private Encuesta _Encuesta;


    @ManyToOne
    @JoinColumn( name = "idPregunta" )
    private Pregunta _Pregunta;


    @ManyToOne
    @JoinColumn( name = "idUsuario_Encuestado" )
    private Usuario _Usuario;


    @ManyToOne
    @JoinColumn( name = "idOpcion" )
    private TipoUsuario _TipoUsuario;

    public EjecucionEncuesta ( long id )
    {
        super( id );
    }

    public EjecucionEncuesta ( )
    {

    }
}
