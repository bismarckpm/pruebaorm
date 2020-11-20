package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "estudio", schema = "mydb")
public class EstudioEnt extends EntidadBase{

    @Basic
    @Column(name = "fechacreacion")

    private Date fechacreacion;
    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    @Column(name = "estatus")
    private String _estatus;

    @Override
    public String get_estatus() {
        return _estatus;
    }

    @Override
    public void set_estatus(String _estatus) {
        this._estatus = _estatus;
    }

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @ManyToOne
    @JoinColumn(name = "idSolicitud")
    private SolicitudEnt solicitud;
    public SolicitudEnt getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(SolicitudEnt solicitud) {
        this.solicitud = solicitud;
    }

    public EstudioEnt(long id )
    {
        super( id );
    }

    public EstudioEnt( )
    {

    }
}
