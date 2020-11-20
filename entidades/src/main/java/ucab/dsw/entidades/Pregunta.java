package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table( name = "pregunta" )
public class Pregunta extends EntidadBase {

    @Column( name = "pregunta" )
    private String _pregunta;

    @Column( name = "estatus" )
    private String _estatus;

    @ManyToOne
    @JoinColumn( name = "idUsuario" )
    private Usuario _usuario;

    @ManyToOne
    @JoinColumn( name = "idTipoPregunta" )
    private TipoPregunta _tipopregunta;

    @ManyToOne
    @JoinColumn( name = "idSubCategoria" )
    private Subcategoria _subcategoria;

    @Column(name = "fechacreacion")
    @Temporal(TemporalType.DATE)
    private java.util.Date _fecha;

    @OneToMany( mappedBy = "_pregunta", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<EjecucionEncuesta> _ejecuciones;

    @OneToMany( mappedBy = "_pregunta", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Opcion> _opciones;

    public String get_pregunta() {
        return _pregunta;
    }

    public void set_pregunta(String _pregunta) {
        this._pregunta = _pregunta;
    }

    @Override
    public String get_estatus() {
        return _estatus;
    }

    @Override
    public void set_estatus(String _estatus) {
        this._estatus = _estatus;
    }


    public Date get_fecha() {
        return _fecha;
    }

    public void set_fecha(Date _fecha) {
        this._fecha = _fecha;
    }

    public Pregunta(long id )
    {
        super( id );
    }

    public Pregunta()
    {

    }

    public Usuario get_usuario() {
        return _usuario;
    }

    public void set_usuario(Usuario _usuario) {
        this._usuario = _usuario;
    }

    public TipoPregunta get_tipopregunta() {
        return _tipopregunta;
    }

    public void set_tipopregunta(TipoPregunta _tipopregunta) {
        this._tipopregunta = _tipopregunta;
    }

    public Subcategoria get_subcategoria() {
        return _subcategoria;
    }

    public void set_subcategoria(Subcategoria _subcategoria) {
        this._subcategoria = _subcategoria;
    }
}
