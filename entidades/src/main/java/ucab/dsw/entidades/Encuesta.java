package ucab.dsw.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Encuesta implements Serializable {
    private int id;
    private Date fechacreacion;
    private String estatus;

    @Id
    @Column(name = "id", nullable = false)
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

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @JoinColumn(name = "idUsuario_Creador", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuarioCreador;

    @JoinColumn(name = "idUsuario_Analista", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuarioAnalista;

    @JoinColumn(name = "idEstudio", referencedColumnName = "id")
    @ManyToOne
    private Estudio estudio;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Encuesta encuesta = (Encuesta) o;
        return id == encuesta.id &&
                Objects.equals(fechacreacion, encuesta.fechacreacion) &&
                Objects.equals(estatus, encuesta.estatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fechacreacion, estatus);
    }
}
