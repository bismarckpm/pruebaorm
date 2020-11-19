package ucab.dsw.entidades;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="estudio")
public class Estudio extends EntidadBase {

    @Column(name = "fechacreacion")
    @Temporal(TemporalType.DATE)
    private Date _fechacreacion;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario _usuario;

    @ManyToOne
    @JoinColumn(name = "idSolicitud")
    private Solicitud _solicitud;

    @OneToMany( mappedBy = "_estudio", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Encuesta> _encuestas;

    public Estudio(long id) {
        super(id);
    }

    public Estudio() {
    }

    public Date get_fechacreacion() {
        return _fechacreacion;
    }

    public void set_fechacreacion(Date _fechacreacion) {
        this._fechacreacion = _fechacreacion;
    }

    public Usuario get_usuario() {
        return _usuario;
    }

    public void set_usuario(Usuario _usuario) {
        this._usuario = _usuario;
    }

    public Solicitud get_solicitud() {
        return _solicitud;
    }

    public void set_solicitud(Solicitud _solicitud) {
        this._solicitud = _solicitud;
    }

    public List<Encuesta> get_encuestas() {
        return _encuestas;
    }

    public void set_encuestas(List<Encuesta> _encuestas) {
        this._encuestas = _encuestas;
    }
}



