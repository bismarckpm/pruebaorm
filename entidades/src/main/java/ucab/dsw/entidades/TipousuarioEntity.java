package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tipousuario", schema = "taller", catalog = "")
public class TipousuarioEntity {
    private int id;
    private String descripcion;
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
        TipousuarioEntity that = (TipousuarioEntity) o;
        return id == that.id &&
                Objects.equals(descripcion, that.descripcion) &&
                Objects.equals(estatus, that.estatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion, estatus);
    }
}
