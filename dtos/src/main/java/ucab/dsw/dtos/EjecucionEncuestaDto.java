package ucab.dsw.dtos;

public class EjecucionEncuestaDto extends DtoBase
{

    private ucab.dsw.dtos.TipoUsuarioDto tipoUsuarioDto;
    private ucab.dsw.dtos.UsuarioDto usuarioDto;
    private ucab.dsw.dtos.EncuestaDto encuestaDto;
    private ucab.dsw.dtos.PreguntaDto preguntaDto;


    public EjecucionEncuestaDto (long id ) throws Exception
    {
        super( id );
    }

    public String getestatus()
    {
        return estatus;
    }

    public void setestatus( String estatus )
    {
        this.estatus = estatus;
    }

    private String estatus;

    public String getrespuesta()
    {
        return respuesta;
    }

    public void setrespuesta( String respuesta )
    {
        this.respuesta = respuesta;
    }

    private String respuesta;

    public TipoUsuarioDto getTipoUsuarioDto()
    {
        return tipoUsuarioDto;
    }

    public void setTipoUsuarioDto( TipoUsuarioDto tipoUsuarioDto )
    {
        this.tipoUsuarioDto = tipoUsuarioDto;
    }

    public UsuarioDto getUsuario() { return usuarioDto; }

    public void setUsuarioDto( UsuarioDto usuarioDto )
    {
        this.usuarioDto = usuarioDto;
    }

    public EncuestaDto getEncuestaDto() { return encuestaDto; }

    public void setEncuestaDto( EncuestaDto encuestaDto )
    {
        this.encuestaDto = encuestaDto;
    }

    public PreguntaDto getPreguntaDto() { return preguntaDto; }

    public void setPreguntaDto( PreguntaDto preguntaDto )
    {
        this.preguntaDto = preguntaDto;
    }

}
