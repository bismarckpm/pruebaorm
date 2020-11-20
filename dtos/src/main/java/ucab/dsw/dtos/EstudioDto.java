package ucab.dsw.dtos;

public class EstudioDto extends DtoBase
{
    private ucab.dsw.dtos.UsuarioDto UsuarioDto;

    public EstudioDto()
    {
    }

    public EstudioDto ( long id ) throws Exception
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

    private String fechacreacion;

    public String getfechacreacion()
    {
        return fechacreacion;
    }

    public void setfechacreacion( String fechacreacion )
    {
        this.fechacreacion = fechacreacion;
    }


    public UsuarioDto getUsuario1Dto()
    {
        return UsuarioDto;
    }

    public void setUsuarioDto( UsuarioDto UsuarioDto )
    {
        this.UsuarioDto = UsuarioDto;
    }

    public SolicitudDto getSolicitudDto()
    {
        return SolicitudDto;
    }

    public void setSolicitudDto( SolicitudDto SolicitudDto )
    {
        this.SolicitudDto = SolicitudDto;
    }
}
