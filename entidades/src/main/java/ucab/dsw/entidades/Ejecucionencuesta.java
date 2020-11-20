package ucab.dsw.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Ejecucionencuesta implements Serializable {
    private int id;
    private String respuesta;
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
    @Column(name = "respuesta", nullable = true, length = 250)
    public String getRespuesta() {
        return respuesta;
    }

    @JoinColumn(name = "idEncuesta", referencedColumnName = "id")
    @ManyToOne
    private Encuesta encuesta;

    @JoinColumn(name = "idPregunta", referencedColumnName = "id")
    @ManyToOne
    private Pregunta pregunta;

    @JoinColumn(name = "idUsuario_Encuestado", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuario;

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    @Basic
    @Column(name = "estatus", nullable = true)
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
        Ejecucionencuesta that = (Ejecucionencuesta) o;
        return id == that.id &&
                Objects.equals(respuesta, that.respuesta) &&
                Objects.equals(estatus, that.estatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, respuesta, estatus);
    }
}
