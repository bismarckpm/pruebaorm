package ucab.dsw.dtos;

import java.util.Date;

public class EstudioDto extends DtoBase{
    private Date fechacreacion;
    private UsuarioDto usuarioDto;
    private SolicitudDto solicitudDto;
    private String estatus;

    public EstudioDto(long id) throws Exception {
        super(id);
    }

    public EstudioDto() {
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public UsuarioDto getUsuarioDto() {
        return usuarioDto;
    }

    public void setUsuarioDto(UsuarioDto usuarioDto) {
        this.usuarioDto = usuarioDto;
    }

    public SolicitudDto getSolicitudDto() {
        return solicitudDto;
    }

    public void setSolicitudDto(SolicitudDto solicitudDto) {
        this.solicitudDto = solicitudDto;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
