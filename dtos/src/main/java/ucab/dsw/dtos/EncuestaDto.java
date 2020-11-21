package ucab.dsw.dtos;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Omar David
 * Date: 20/11/20
 * Time: 08:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class EncuestaDto extends DtoBase {

    private Date fechaCreacion;
    private String estatus;
    private UsuarioDto usuarioCreador;
    private UsuarioDto usuarioAnalista;
    private EstudioDto estudio;

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

    public UsuarioDto getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(UsuarioDto usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    public UsuarioDto getUsuarioAnalista() {
        return usuarioAnalista;
    }

    public void setUsuarioAnalista(UsuarioDto usuarioAnalista) {
        this.usuarioAnalista = usuarioAnalista;
    }

    public EstudioDto getEstudio() {
        return estudio;
    }

    public void setEstudio(EstudioDto estudio) {
        this.estudio = estudio;
    }

    public EncuestaDto(long id) throws Exception {
        super(id);
    }

    public EncuestaDto() {
    }
}
