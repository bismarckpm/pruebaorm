package ucab.dsw.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Estudio implements Serializable {
    public static final long serialVersionUID = 1L;

    private int id;
    private Date fechacreacion;
    private String estatus;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fechacreacion", nullable = false)
    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    @Basic
    @Column(name = "estatus", nullable = false)
    public String getEstatus() {
        return estatus;
    }

    @JoinColumn(name = "idUsuario", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuario;

    @JoinColumn(name = "idSolicitud", referencedColumnName = "id")
    @ManyToOne
    private Solicitud solicitud;

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estudio estudio = (Estudio) o;
        return id == estudio.id &&
                Objects.equals(fechacreacion, estudio.fechacreacion) &&
                Objects.equals(estatus, estudio.estatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fechacreacion, estatus);
    }
}
