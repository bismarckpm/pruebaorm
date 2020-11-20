package ucab.dsw.dtos;

import java.util.Date;

public class EstudioDto extends DtoBase{

    public EstudioDto() {}

    public EstudioDto(long id) throws Exception{
        super(id);
    }

    private Date fechacreacion;
    private String estatus;
    private UsuarioDto usuarioDto;
    private SolicitudDto solicitudDto;

    public Date getFechacreacion()
    {
        return fechacreacion;
    }

    public void setFechacreacion( Date fechacreacion )
    {
        this.fechacreacion = fechacreacion;
    }

    public String getEstatus()
    {
        return estatus;
    }

    public void setEstatus( String estatus )
    {
        this.estatus = estatus;
    }

    public  UsuarioDto getUsuarioDto() { return  usuarioDto;}

    public void setUsuarioDto( UsuarioDto usuarioDto )
    {
        this.usuarioDto = usuarioDto;
    }

    public  SolicitudDto getSolicitudDto() { return  solicitudDto;}

    public void setSolicitudDto( SolicitudDto solicitudDto )
    {
        this.solicitudDto = solicitudDto;
    }
}
