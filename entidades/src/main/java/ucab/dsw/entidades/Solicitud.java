package ucab.dsw.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Solicitud implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "fecha", nullable = false, length = 45)
    private String fecha;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Basic
    @Column(name = "estatus", nullable = false)
    private String estatus;

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @JoinColumn(name = "idUsuario", referencedColumnName = "id")
    @ManyToOne
    private Solicitud idUsuario;

    @JoinColumn(name = "idSubcategoria", referencedColumnName = "id")
    @ManyToOne
    private Subcategoria subcategoria;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solicitud solicitud = (Solicitud) o;
        return id == solicitud.id &&
                Objects.equals(nombre, solicitud.nombre) &&
                Objects.equals(fecha, solicitud.fecha) &&
                Objects.equals(estatus, solicitud.estatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, fecha, estatus);
    }
}
