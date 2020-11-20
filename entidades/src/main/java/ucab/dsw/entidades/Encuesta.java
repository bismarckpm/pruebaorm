package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.List;
import java.util.Date;

@Entity
@Table( name = "encuesta")
public class Encuesta extends  EntidadBase{


    @Column(name = "fechacreacion")
    private Date _fechacreacion;

    public Date get_fechacreacion() {return _fechacreacion;}
    public void set_fechacreacion(Date _fechacreacion) {
        this._fechacreacion = _fechacreacion;
    }


    //ManyToOne
    @ManyToOne
    @JoinColumn(name="idUsuario_Creador")
    private Usuario _usuariocreador;

    public Usuario get_usuariocreador() {
        return _usuariocreador;
    }
    public void set_usuariocreador(Usuario _usuariocreador) {
        this._usuariocreador = _usuariocreador;
    }

    @ManyToOne
    @JoinColumn(name="idUsuario_Analista")
    private Usuario _usuarioanalista;

    public Usuario get_usuarioanalista() {
        return _usuarioanalista;
    }
    public void set_usuarioanalista(Usuario _usuarioanalista) {
        this._usuarioanalista = _usuarioanalista;
    }

    @ManyToOne
    @JoinColumn(name = "idEstudio")
    private Estudio _estudio;

    public Estudio get_estudio() {
        return _estudio;
    }
    public void set_estudio(Estudio _estudio) {
        this._estudio = _estudio;
    }


    @OneToMany( mappedBy = "_encuesta", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<EjecucionEncuesta> _ejecucionencuesta;

    public List<EjecucionEncuesta> get_ejecucionencuesta()
    {
        return _ejecucionencuesta;
    }

    public void set_ejecucionencuesta( List<EjecucionEncuesta> _ejecucionencuesta )
    {
        this._ejecucionencuesta = _ejecucionencuesta;
    }



    public Encuesta(long id )
    {
        super( id );
    }

    public Encuesta( )
    {

    }

}
