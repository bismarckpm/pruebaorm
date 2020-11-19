package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "solicitud", schema = "taller", catalog = "")
public class SolicitudEntity {
    private int id;
    private int idUsuario;
    private int idSubCategoria;
    private String nombre;
    private String fecha;
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
    @Column(name = "idUsuario")
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Basic
    @Column(name = "idSubCategoria")
    public int getIdSubCategoria() {
        return idSubCategoria;
    }

    public void setIdSubCategoria(int idSubCategoria) {
        this.idSubCategoria = idSubCategoria;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "fecha")
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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
        SolicitudEntity that = (SolicitudEntity) o;
        return id == that.id &&
                idUsuario == that.idUsuario &&
                idSubCategoria == that.idSubCategoria &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(fecha, that.fecha) &&
                Objects.equals(estatus, that.estatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idUsuario, idSubCategoria, nombre, fecha, estatus);
    }
}
