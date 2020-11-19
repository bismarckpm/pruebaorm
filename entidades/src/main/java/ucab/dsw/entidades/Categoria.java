package ucab.dsw.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "categoria")
@NamedQueries({
        @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c ORDER BY c.id")
})
public class Categoria implements Serializable {
    public static final long serialVersionUID = 1L;

    private int id;
    private String descripcion;
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
    @Column(name = "descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        Categoria categoria = (Categoria) o;
        return id == categoria.id &&
                Objects.equals(descripcion, categoria.descripcion) &&
                Objects.equals(estatus, categoria.estatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion, estatus);
    }
}
