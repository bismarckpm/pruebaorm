package ucab.dsw.entidades;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "pregunta", schema = "taller", catalog = "")
public class PreguntaEntity {
    private int id;
    private String pregunta;
    private Date fechacreacion;
    private String estatus;
    private int idTipoPregunta;
    private int idSubCategoria;
    private int idUsuario;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "pregunta")
    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
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
    @Column(name = "estatus")
    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @Basic
    @Column(name = "idTipoPregunta")
    public int getIdTipoPregunta() {
        return idTipoPregunta;
    }

    public void setIdTipoPregunta(int idTipoPregunta) {
        this.idTipoPregunta = idTipoPregunta;
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
    @Column(name = "idUsuario")
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PreguntaEntity that = (PreguntaEntity) o;
        return id == that.id &&
                idTipoPregunta == that.idTipoPregunta &&
                idSubCategoria == that.idSubCategoria &&
                idUsuario == that.idUsuario &&
                Objects.equals(pregunta, that.pregunta) &&
                Objects.equals(fechacreacion, that.fechacreacion) &&
                Objects.equals(estatus, that.estatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pregunta, fechacreacion, estatus, idTipoPregunta, idSubCategoria, idUsuario);
    }
}
