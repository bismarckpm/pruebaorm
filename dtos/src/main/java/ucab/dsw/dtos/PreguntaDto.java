package ucab.dsw.dtos;

import java.util.Date;

public class PreguntaDto extends DtoBase{

    private Date fechaCreacion;
    private String estatus;
    private String pregunta;
    private UsuarioDto usuario;
    private TipoPreguntaDto tipoPregunta;
    private SubCategoriaDto subCategoria;

    public PreguntaDto(long id) throws Exception {
        super(id);
    }

    public PreguntaDto() {
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

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public UsuarioDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
    }

    public TipoPreguntaDto getTipoPregunta() {
        return tipoPregunta;
    }

    public void setTipoPregunta(TipoPreguntaDto tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }

    public SubCategoriaDto getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(SubCategoriaDto subCategoria) {
        this.subCategoria = subCategoria;
    }
}
