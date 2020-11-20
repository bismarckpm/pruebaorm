package ucab.dsw.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ejecucionencuesta")
@NamedQueries({
        @NamedQuery(name = "Ejecucionencuesta.findAll", query = "SELECT ee FROM Ejecucionencuesta ee ORDER BY ee.id"),
        @NamedQuery(name = "Ejecucionencuesta.findBySurvey", query = "SELECT ee FROM Ejecucionencuesta ee WHERE ee.encuesta =:idEncuesta")
})
public class Ejecucionencuesta implements Serializable {
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
    @Column(name = "respuesta", nullable = true, length = 250)
    private String respuesta;

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

    @JoinColumn(name = "idOpcion", referencedColumnName = "id")
    @ManyToOne
    private Opcion opcion;

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    @Basic
    @Column(name = "estatus", nullable = true)
    private String estatus;

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Encuesta getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Opcion getOpcion() {
        return opcion;
    }

    public void setOpcion(Opcion opcion) {
        this.opcion = opcion;
    }

    public Ejecucionencuesta() {
    }

    public Ejecucionencuesta(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Ejecucionencuesta{" +
                "id=" + id +
                ", respuesta='" + respuesta + '\'' +
                ", estatus='" + estatus + '\'' +
                '}';
    }
}
