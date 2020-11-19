package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ejecucionencuesta", schema = "taller", catalog = "")
public class EjecucionencuestaEntity {
    private int id;
    private int idEncuesta;
    private int idPregunta;
    private int idUsuarioEncuestado;
    private Integer idOpcion;
    private String respuesta;
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
    @Column(name = "idEncuesta")
    public int getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(int idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    @Basic
    @Column(name = "idPregunta")
    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    @Basic
    @Column(name = "idUsuario_Encuestado")
    public int getIdUsuarioEncuestado() {
        return idUsuarioEncuestado;
    }

    public void setIdUsuarioEncuestado(int idUsuarioEncuestado) {
        this.idUsuarioEncuestado = idUsuarioEncuestado;
    }

    @Basic
    @Column(name = "idOpcion")
    public Integer getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(Integer idOpcion) {
        this.idOpcion = idOpcion;
    }

    @Basic
    @Column(name = "respuesta")
    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
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
        EjecucionencuestaEntity that = (EjecucionencuestaEntity) o;
        return id == that.id &&
                idEncuesta == that.idEncuesta &&
                idPregunta == that.idPregunta &&
                idUsuarioEncuestado == that.idUsuarioEncuestado &&
                Objects.equals(idOpcion, that.idOpcion) &&
                Objects.equals(respuesta, that.respuesta) &&
                Objects.equals(estatus, that.estatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idEncuesta, idPregunta, idUsuarioEncuestado, idOpcion, respuesta, estatus);
    }
}
