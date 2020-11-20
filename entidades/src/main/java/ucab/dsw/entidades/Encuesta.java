package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="encuesta")
public class Encuesta extends EntidadBase {

    @Column(name = "fechacreacion")
    @Temporal(TemporalType.DATE)
    private Date _fechacreacion;

    @ManyToOne
    @JoinColumn(name = "idUsuario_Creador")
    private Usuario _usuarioCreador;

    @ManyToOne
    @JoinColumn(name = "idUsuario_Analista")
    private Usuario _usuarioAnalista;

    @ManyToOne
    @JoinColumn(name = "idEstudio")
    private Estudio _estudio;

    @OneToMany( mappedBy = "_encuesta", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<EjecucionEncuesta> _ejecuciones;


    public Encuesta(long id) {
        super(id);
    }

    public Encuesta() {
    }

    public Date get_fechacreacion() {
        return _fechacreacion;
    }

    public void set_fechacreacion(Date _fechacreacion) {
        this._fechacreacion = _fechacreacion;
    }

    public Usuario get_usuarioCreador() {
        return _usuarioCreador;
    }

    public void set_usuarioCreador(Usuario _usuarioCreador) {
        this._usuarioCreador = _usuarioCreador;
    }

    public Usuario get_usuarioAnalista() {
        return _usuarioAnalista;
    }

    public void set_usuarioAnalista(Usuario _usuarioAnalista) {
        this._usuarioAnalista = _usuarioAnalista;
    }

    public Estudio get_estudio() {
        return _estudio;
    }

    public void set_estudio(Estudio _estudio) {
        this._estudio = _estudio;
    }
}
