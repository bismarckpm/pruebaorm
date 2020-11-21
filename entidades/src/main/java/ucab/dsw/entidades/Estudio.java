package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "estudio")
public class Estudio extends EntidadBase{
    @Column(name = "fechacreacion")
    private Date _fechaCreacion;

    public Estudio(long id) {
        super(id);
    }

    public Estudio() {
    }

    public Date getFechaCreacion() {
        return _fechaCreacion;
    }

    public void setFechaCreacion(Date _fechaCreacion) {
        this._fechaCreacion = _fechaCreacion;
    }

    //relaciones de entidad estudio
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario _usuario;

    @ManyToOne
    @JoinColumn(name = "idSolicitud")
    private Solicitud _solicitud;

    public Usuario getUsuario() {
        return _usuario;
    }

    public void setUsuario(Usuario _usuario) {
        this._usuario = _usuario;
    }

    public Solicitud getSolicitud() {
        return _solicitud;
    }

    public void setSolicitud(Solicitud _solicitud) {
        this._solicitud = _solicitud;
    }

    //relacion con encuesta
    @OneToMany( mappedBy = "_estudio", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Encuesta> _encuestas;

}
