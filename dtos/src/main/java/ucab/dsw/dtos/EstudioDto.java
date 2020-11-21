package ucab.dsw.dtos;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Omar David
 * Date: 20/11/20
 * Time: 08:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class EstudioDto extends DtoBase{

    private Date fechaCreacion;
    private  String estatus;
    private UsuarioDto usuario;
    private SolicitudDto solicitud;

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

    public UsuarioDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
    }

    public SolicitudDto getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(SolicitudDto solicitud) {
        this.solicitud = solicitud;
    }

    public EstudioDto(long id) throws Exception {
        super(id);
    }

    public EstudioDto() {
    }
}
