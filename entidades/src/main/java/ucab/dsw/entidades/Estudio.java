package ucab.dsw.entidades;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Omar David
 */
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
    
    //relaciones de entidad estuido
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
    
    
}
