package ucab.dsw.entidades;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "estudio", schema = "taller", catalog = "")
public class EstudioEntity {
    private int id;
    private Date fechacreacion;
    private int idUsuario;
    private int idSolicitud;
    private String estatus;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fechacreacion")
    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    @Basic
    @Column(name = "idUsuario")
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Basic
    @Column(name = "idSolicitud")
    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    @Basic
    @Column(name = "estatus")
    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstudioEntity that = (EstudioEntity) o;
        return id == that.id &&
                idUsuario == that.idUsuario &&
                idSolicitud == that.idSolicitud &&
                Objects.equals(fechacreacion, that.fechacreacion) &&
                Objects.equals(estatus, that.estatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fechacreacion, idUsuario, idSolicitud, estatus);
    }
}
