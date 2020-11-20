package ucab.dsw.dtos;

import java.util.Date;

public class EstudioDTO extends DtoBase {
    private Date fechaCreacion;
    private UsuarioDto usuarioDto;
    private SolicitudDTO solicitudDTO;
    private String estatus;

    public EstudioDTO(long id) throws Exception {
        super(id);
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public UsuarioDto getUsuarioDto() {
        return usuarioDto;
    }

    public void setUsuarioDto(UsuarioDto usuarioDto) {
        this.usuarioDto = usuarioDto;
    }

    public SolicitudDTO getSolicitudDTO() {
        return solicitudDTO;
    }

    public void setSolicitudDTO(SolicitudDTO solicitudDTO) {
        this.solicitudDTO = solicitudDTO;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
