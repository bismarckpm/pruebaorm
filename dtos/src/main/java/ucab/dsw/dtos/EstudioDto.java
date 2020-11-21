package ucab.dsw.dtos;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.util.Date;

public class EstudioDto extends DtoBase{

    private Date fechacreacion;
    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    private String _estatus;

    public String get_estatus() {
        return _estatus;
    }

    public void set_estatus(String _estatus) {
        this._estatus = _estatus;
    }

    private UsuarioDto usuario;
    public UsuarioDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
    }

    private SolicitudDto solicitud;
    public SolicitudDto getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(SolicitudDto solicitud) {
        this.solicitud = solicitud;
    }

    public EstudioDto(){}

    public EstudioDto(long id) throws Exception{
        super(id);
    }
}
