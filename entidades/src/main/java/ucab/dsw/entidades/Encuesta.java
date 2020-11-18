package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "encuesta")
public class Encuesta extends EntidadBase {

    @Column(name = "fechacreacion")
    private Date _fechaCreacion;

    @Column(name = "estatus")
    private String _estatus;

    @ManyToOne
    @JoinColumn(name = "idUsuario_Creador", nullable = false)
    private Usuario _usuarioCreador;

    @ManyToOne
    @JoinColumn(name = "idUsuario_Analista")
    private Usuario _usuarioAnalista;

    @ManyToOne
    @JoinColumn(name = "idEstudio", nullable = false)
    private Estudio _estudio;

    public Encuesta(long id) {
        super(id);
    }

    public Encuesta() {
    }

    public Date get_fechaCreacion() {
        return _fechaCreacion;
    }

    public void set_fechaCreacion(Date _fechaCreacion) {
        this._fechaCreacion = _fechaCreacion;
    }

    @Override
    public String get_estatus() {
        return _estatus;
    }

    @Override
    public void set_estatus(String _estatus) {
        this._estatus = _estatus;
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
