package ucab.dsw.dtos;

import java.util.Date;

public class EstudioDto extends DtoBase {

    public EstudioDto(long id) throws Exception {
        super(id);
    }

    public EstudioDto() {
    }

    private Date fechaCreacion;
    private String estatus;
    private SolicitudDto solicitud;
    private UsuarioDto usuario;

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public SolicitudDto getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(SolicitudDto solicitud) {
        this.solicitud = solicitud;
    }

    public UsuarioDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
    }
}
