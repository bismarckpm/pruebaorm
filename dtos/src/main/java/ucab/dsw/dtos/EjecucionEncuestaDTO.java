package ucab.dsw.dtos;

public class EjecucionEncuestaDTO extends DtoBase {
    private EncuestaDTO encuestaDTO;
    private PreguntaDTO preguntaDTO;
    private UsuarioDto usuarioDto;
    private OpcionDTO opcionDTO;
    private String respuesta;
    private String estatus;

    public EjecucionEncuestaDTO(long id) throws Exception {
        super(id);
    }

    public EncuestaDTO getEncuestaDTO() {
        return encuestaDTO;
    }

    public void setEncuestaDTO(EncuestaDTO encuestaDTO) {
        this.encuestaDTO = encuestaDTO;
    }

    public PreguntaDTO getPreguntaDTO() {
        return preguntaDTO;
    }

    public void setPreguntaDTO(PreguntaDTO preguntaDTO) {
        this.preguntaDTO = preguntaDTO;
    }

    public UsuarioDto getUsuarioDto() {
        return usuarioDto;
    }

    public void setUsuarioDto(UsuarioDto usuarioDto) {
        this.usuarioDto = usuarioDto;
    }

    public OpcionDTO getOpcionDTO() {
        return opcionDTO;
    }

    public void setOpcionDTO(OpcionDTO opcionDTO) {
        this.opcionDTO = opcionDTO;
    }

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
}
