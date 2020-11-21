package ucab.dsw.dtos;

import java.util.Date;

public class EncuestaDto extends DtoBase {

    private Date fechacreacion;
    private String estatus;
    private UsuarioDto usuarioAnalistaDto;
    private UsuarioDto usuarioCreadorDto;
    private EstudioDto estudioDto;

    public String getEstatus()
    {
        return estatus;
    }

    public void setEstatus( String estatus )
    {
        this.estatus = estatus;
    }

    public Date getFechacreacion()
    {
        return fechacreacion;
    }

    public void setFechacreacion( Date fechacreacion )
    {
        this.fechacreacion = fechacreacion;
    }

    public UsuarioDto getUsuarioAnalistaDto()
    {
        return usuarioAnalistaDto;
    }

    public void setUsuarioAnalistaDto( UsuarioDto usuarioAnalistaDto )
    {
        this.usuarioAnalistaDto = usuarioAnalistaDto;
    }

    public UsuarioDto getUsuarioCreadorDto()
    {
        return usuarioCreadorDto;
    }

    public void setUsuarioCreadorDto( UsuarioDto usuarioCreadorDto ) {
        this.usuarioCreadorDto = usuarioCreadorDto;
    }

    public EstudioDto getEstudioDto()
    {
        return estudioDto;
    }

    public void setEstudioDto( EstudioDto estudioDto )
    {
        this.estudioDto = estudioDto;
    }

    public EncuestaDto (){}

    public EncuestaDto(long id) throws Exception{
        super(id);
    }

}
