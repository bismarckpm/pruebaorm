package ucab.dsw.dtos;

import java.util.Date;

public class PreguntaDTO extends DtoBase {
    private String pregunta;
    private Date fechaCreacion;
    private String estatus;
    private TipoPreguntaDTO tipoPreguntaDTO;
    private PreguntaDTO preguntaDTO;
    private UsuarioDto usuarioDto;

    public PreguntaDTO(long id) throws Exception {
        super(id);
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
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

    public TipoPreguntaDTO getTipoPreguntaDTO() {
        return tipoPreguntaDTO;
    }

    public void setTipoPreguntaDTO(TipoPreguntaDTO tipoPreguntaDTO) {
        this.tipoPreguntaDTO = tipoPreguntaDTO;
    }

    public PreguntaDTO getPreguntaDTO() {
        return preguntaDTO;
    }

    public void setPreguntaDTO(PreguntaDTO preguntaDTO) {
        this.preguntaDTO = preguntaDTO;
    }

    public UsuarioDto getUsuarioDto() {
        return usuarioDto;
    }

    public void setUsuarioDto(UsuarioDto usuarioDto) {
        this.usuarioDto = usuarioDto;
    }
}
