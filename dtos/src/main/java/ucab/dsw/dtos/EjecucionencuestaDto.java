package ucab.dsw.dtos;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class EjecucionencuestaDto extends DtoBase {

    private String respuesta;

    private String estatus;

    private EncuestaDto encuesta;

    private PreguntaDto pregunta;

    private UsuarioDto usuario;

    private OpcionDto opcion;

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public EncuestaDto getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(EncuestaDto encuesta) {
        this.encuesta = encuesta;
    }

    public PreguntaDto getPregunta() {
        return pregunta;
    }

    public void setPregunta(PreguntaDto pregunta) {
        this.pregunta = pregunta;
    }

    public UsuarioDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
    }

    public OpcionDto getOpcion() {
        return opcion;
    }

    public void setOpcion(OpcionDto opcion) {
        this.opcion = opcion;
    }
}
