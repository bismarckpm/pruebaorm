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
    public void set_fechacreacion() {this._fechacreacion = _fechacreacion;}

    @Column(name = "estatus")
    private String _estatus;

    @Override
    public String get_estatus() {
        return super.get_estatus();
    }
    @Override
    public void set_estatus(String _estatus) {
        super.set_estatus(_estatus);
    }


    //ManyToOne
    @ManyToOne
    @JoinColumn(name="idUsuario_Creador")
    private Usuario _usuariocreador;

    @ManyToOne
    @JoinColumn(name="idUsuario_Analista")
    private Usuario _usuarioanalista;

    @ManyToOne
    @JoinColumn(name = "idEstudio")
    private Estudio _estudio;

    /* EjecucionEncuesta
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
    */


    public Encuesta(long id )
    {
        super( id );
    }

    public Encuesta( )
    {

    }

}
