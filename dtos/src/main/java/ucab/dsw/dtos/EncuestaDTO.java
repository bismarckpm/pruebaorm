package ucab.dsw.dtos;

import java.util.Date;

public class EncuestaDTO extends DtoBase {
    private UsuarioDto usuarioCreador;
    private UsuarioDto usuarioAnalista;
    private EstudioDTO estudioDTO;
    private Date fechaCreacion;
    private String estatus;

    public EncuestaDTO(long id) throws Exception {
        super(id);
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

    public EstudioDTO getEstudioDTO() {
        return estudioDTO;
    }

    public void setEstudioDTO(EstudioDTO estudioDTO) {
        this.estudioDTO = estudioDTO;
    }

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
}
