package ucab.dsw.dtos;

import java.util.Date;

public class PreguntaDTO {
    private String pregunta;
    private String fechaCreacion;
    private String estatus;
    private TipoPreguntaDTO tipoPreguntaDTO;
    private SubcategoriaDTO subcategoriaDTO;
    private UsuarioDto usuarioDto;
    private int idTipoPregunta;
    private int idSubcategoria;
    private int idUsuario;

    public int getIdTipoPregunta() {
        return idTipoPregunta;
    }

    public int getIdSubcategoria() {
        return idSubcategoria;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public TipoPreguntaDTO getTipoPreguntaDTO() {
        return tipoPreguntaDTO;
    }

    public void setTipoPreguntaDTO(TipoPreguntaDTO tipoPreguntaDTO) {
        this.tipoPreguntaDTO = tipoPreguntaDTO;
    }

    public UsuarioDto getUsuarioDto() {
        return usuarioDto;
    }

    public void setUsuarioDto(UsuarioDto usuarioDto) {
        this.usuarioDto = usuarioDto;
    }
}
