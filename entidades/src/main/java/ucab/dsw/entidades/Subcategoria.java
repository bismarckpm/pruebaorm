package ucab.dsw.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Subcategoria implements Serializable {
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

    @JoinColumn(name = "idCategoria", referencedColumnName = "id")
    @ManyToOne
    private Categoria categoria;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subcategoria that = (Subcategoria) o;
        return id == that.id &&
                Objects.equals(descripcion, that.descripcion) &&
                Objects.equals(estatus, that.estatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion, estatus);
    }
}
