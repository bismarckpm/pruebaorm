package ucab.dsw.dtos;

public class EjecucionEncuestaDto extends DtoBase{
    
    public EjecucionEncuestaDto( long id ) throws Exception{
        super( id );
    }
  
    public EjecucionEncuestaDto(){
    }
    
    private EncuestaDto encuestaDto;
//    private PreguntaDto preguntaDto;
    private UsuarioDto usuarioEncuestadoDto;
    private opcionDto opcionDto;
    private String respuesta;
    private String estatus;

    public EncuestaDto getEncuestaDto() {
        return encuestaDto;
    }

    public void setEncuestaDto(EncuestaDto encuestaDto) {
        this.encuestaDto = encuestaDto;
    }

//    public PreguntaDto getPreguntaDto() {
//        return preguntaDto;
//    }
//
//    public void setPreguntaDto(PreguntaDto preguntaDto) {
//        this.preguntaDto = preguntaDto;
//    }

    public UsuarioDto getUsuarioEncuestadoDto() {
        return usuarioEncuestadoDto;
    }

    public void setUsuarioEncuestadoDto(UsuarioDto usuarioEncuestadoDto) {
        this.usuarioEncuestadoDto = usuarioEncuestadoDto;
    }

    public opcionDto getOpcionDto() {
        return opcionDto;
    }

    public void setOpcionDto(opcionDto opcionDto) {
        this.opcionDto = opcionDto;
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
