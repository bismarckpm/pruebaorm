package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.Objects;

@Entity
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

}
