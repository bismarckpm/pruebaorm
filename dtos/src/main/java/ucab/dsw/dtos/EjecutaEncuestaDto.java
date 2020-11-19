package ucab.dsw.dtos;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class EjecutaEncuestaDto extends DtoBase{

    private String respuesta;
    private String estatus;
    private EncuestaDto idEncuesta;
    private PreguntaDto idPregunta;
    private UsuarioDto idUsuario_Encuestado;
    private OpcionDto idOpcion;

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

    public EncuestaDto getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(EncuestaDto idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public PreguntaDto getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(PreguntaDto idPregunta) {
        this.idPregunta = idPregunta;
    }

    public UsuarioDto getIdUsuario_Encuestado() {
        return idUsuario_Encuestado;
    }

    public void setIdUsuario_Encuestado(UsuarioDto idUsuario_Encuestado) {
        this.idUsuario_Encuestado = idUsuario_Encuestado;
    }

    public OpcionDto getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(OpcionDto idOpcion) {
        this.idOpcion = idOpcion;
    }

    public EjecutaEncuestaDto()
    {
    }

    public EjecutaEncuestaDto( long id ) throws Exception
    {
        super( id );
    }
}
