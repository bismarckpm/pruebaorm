package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "encuesta" )

public class Encuesta extends EntidadBase
{


    @Column( name = "fechacreacion", nullable = false )
    private String _fechacreacion;

    public String get_fechacreacion()
    {
        return _fechacreacion;
    }

    public void set_fechacreacion(String _fechacreacion) { this._fechacreacion = _fechacreacion; }

    @Override
    public String get_estatus()
    {
        return _estatus;
    }

    @Override
    public void set_estatus(String _estatus)
    {
        this._estatus = _estatus;
    }

    @Column( name = "estatus" )
    private String _estatus;



    @ManyToOne
    @JoinColumn( name = "idEstudio" )
    private Estudio _Estudio;


    @ManyToOne
    @JoinColumn( name = "idUsuario_Analista" )
    private Usuario _UsuarioA;


    @ManyToOne
    @JoinColumn( name = "idUsuario_Creador" )
    private Usuario _UsuarioC;


    @OneToMany( mappedBy = "_Encuesta", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<EjecucionEncuesta> _ejecuciones;

    public Encuesta ( long id )
    {
        super( id );
    }

    public Encuesta ( )
    {

    }
}
