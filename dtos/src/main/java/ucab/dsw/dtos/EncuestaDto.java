package ucab.dsw.dtos;

import java.util.Date;

public class EncuestaDto extends DtoBase{

    public EncuestaDto() {}

    public EncuestaDto(long id) throws Exception{
        super(id);
    }

    private Date fechacreacion;
    private String estatus;
    private UsuarioDto usuarioCreadorDto;
    private UsuarioDto usuarioAnalistaDto;
    private EstudioDto estudioDto;


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

    public UsuarioDto getUsuarioCreadorDto() {
        return usuarioCreadorDto;
    }

    public void setUsuarioCreadorDto(UsuarioDto usuarioCreadorDto) {
        this.usuarioCreadorDto = usuarioCreadorDto;
    }

    public UsuarioDto getUsuarioAnalistaDto() {
        return usuarioAnalistaDto;
    }

    public void setUsuarioAnalistaDto(UsuarioDto usuarioAnalistaDto) {
        this.usuarioAnalistaDto = usuarioAnalistaDto;
    }

    public EstudioDto getEstudioDto() { return estudioDto; }

    public void setEstudioDto( EstudioDto estudioDto) { this.estudioDto = estudioDto; }

}
