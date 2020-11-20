package ucab.dsw.dtos;

import java.util.Date;

public class EstudioDTO {
    private String fechaCreacion;
    private int idUsuario;
    private int idSolicitud;
    private UsuarioDto usuarioDto;
    private SolicitudDTO solicitudDTO;
    private String estatus;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
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

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
