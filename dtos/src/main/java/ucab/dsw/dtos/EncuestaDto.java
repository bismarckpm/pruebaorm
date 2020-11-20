package ucab.dsw.dtos;

public class EncuestaDto extends DtoBase
{
    private UsuarioDto UsuarioDto;
    private EstudioDto EstudioDto;

    public EncuestaDto()
    {
    }

    public EncuestaDto ( long id ) throws Exception
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


    public UsuarioDto getUsuarioDto()
    {
        return UsuarioDto;
    }

    public void setUsuarioDto( UsuarioDto UsuarioDto )
    {
        this.UsuarioDto = UsuarioDto;
    }

    public EstudioDto getEstudioDto()
    {
        return EstudioDto;
    }

    public void setEstudioDto( EstudioDto EstudioDto )
    {
        this.EstudioDto = EstudioDto;
    }
}

