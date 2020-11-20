package ucab.dsw.dtos;

public class EjecucionEncuestaDto extends DtoBase{
    public EjecucionEncuestaDto() {}

    public EjecucionEncuestaDto(long id) throws Exception{
        super(id);
    }

    private String respuesta;
    private String estatus;
    private EncuestaDto encuestaDto;
    private PreguntaDto preguntaDto;
    private UsuarioDto usuarioDto;
    private OpcionDto opcionDto;

    public String getRespuesta(){return respuesta;}
    public void setRespuesta(String respuesta){this.respuesta = respuesta;}

    public String getEstatus(){return estatus;}
    public void setEstatus(String estatus){this.estatus = estatus;}

    public EncuestaDto getEncuestaDto(){return encuestaDto;}
    public void setEncuestaDto(EncuestaDto encuestaDto){this.encuestaDto = encuestaDto;}

    public PreguntaDto getPreguntaDto(){return preguntaDto;}
    public void setPreguntaDto(PreguntaDto preguntaDto){this.preguntaDto = preguntaDto;}

    public UsuarioDto getUsuarioDto(){return usuarioDto;}
    public void setUsuarioDto(UsuarioDto usuarioDto){this.usuarioDto = usuarioDto;}

    public OpcionDto getOpcionDto(){return opcionDto;}
    public void setOpcionDto(OpcionDto OpcionDto){this.opcionDto = OpcionDto;}
}
