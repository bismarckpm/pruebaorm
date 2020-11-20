package ucab.dsw.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Opcion implements Serializable {
    public static final long serialVersionUID = 1L;

    private int id;
    private String descripcion;
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

    @JoinColumn(name = "idPregunta", referencedColumnName = "id")
    @ManyToOne
    private Pregunta pregunta;

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
        Opcion opcion = (Opcion) o;
        return id == opcion.id &&
                Objects.equals(descripcion, opcion.descripcion) &&
                Objects.equals(estatus, opcion.estatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion, estatus);
    }
}
