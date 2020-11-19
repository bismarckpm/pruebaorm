package ucab.dsw.entidades;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Tipopregunta implements Serializable {
    private int id;
    private String descripcion;
    private Object estatus;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "descripcion", nullable = false, length = 45)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "estatus", nullable = false)
    public Object getEstatus() {
        return estatus;
    }

    public void setEstatus(Object estatus) {
        this.estatus = estatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tipopregunta that = (Tipopregunta) o;
        return id == that.id &&
                Objects.equals(descripcion, that.descripcion) &&
                Objects.equals(estatus, that.estatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion, estatus);
    }
}
