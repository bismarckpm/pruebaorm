package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ejecucionencuesta")
public class Ejecucionencuesta extends EntidadBase {

    @Column(name = "respuesta", length = 250)
    private String respuesta;

    @ManyToOne
    @JoinColumn( name = "idEncuesta" )
    private Encuesta encuesta;

    @ManyToOne
    @JoinColumn( name = "idPregunta" )
    private Pregunta pregunta;

    @ManyToOne
    @JoinColumn( name = "idUsuario_Encuestado" )
    private Usuario usuario;

    @ManyToOne
    @JoinColumn( name = "idOpcion" )
    private Opcion opcion;

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
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
}
