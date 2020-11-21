package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "encuesta")
public class Encuesta extends EntidadBase{
    @Column(name = "fechacreacion")
    private Date _fechaCreacion;

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

    @ManyToOne
    @JoinColumn(name = "idEstudio")
    private Estudio _estudio;

    public Estudio get_estudio() {
        return _estudio;
    }

    public void set_estudio(Estudio _estudio) {
        this._estudio = _estudio;
    }

    @ManyToOne
    @JoinColumn(name = "idUsuario_Creador")
    private Usuario _usuarioCreador;

    public Usuario get_usuarioCreador() {
        return _usuarioCreador;
    }

    public void set_usuarioCreador(Usuario _usuarioCreador) {
        this._usuarioCreador = _usuarioCreador;
    }

    @ManyToOne
    @JoinColumn(name = "idUsuario_Analista", nullable = true)
    private Usuario _usuarioAnalista;

    public Usuario get_usuarioAnalista() {
        return _usuarioAnalista;
    }

    public void set_usuarioAnalista(Usuario _usuarioAnalista) {
        this._usuarioAnalista = _usuarioAnalista;
    }

    @OneToMany( mappedBy = "_encuesta", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<EjecucionEncuesta> _ejecucionEncuestas;
}
