package ucab.dsw.dtos;

import java.util.Date;

public class PreguntaDto extends DtoBase{

    public PreguntaDto(long id) throws Exception {
        super(id);
    }

    public PreguntaDto() {
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public String getEstatus()
    {
        return estatus;
    }

    public void setEstatus( String estatus )
    {
        this.estatus = estatus;
    }

    public TipoPreguntaDto getTipoPreguntaDto() {
        return tipoPreguntaDto;
    }

    public void setTipoPreguntaDto(TipoPreguntaDto tipoPreguntaDto) {
        this.tipoPreguntaDto = tipoPreguntaDto;
    }

    public SubCategoriaDto getSubCategoriaDto() {
        return subCategoriaDto;
    }

    public void setSubCategoriaDto(SubCategoriaDto subcategoriaDto) {
        this.subCategoriaDto = subcategoriaDto;
    }

    public UsuarioDto getUsuarioDto() { return usuarioDto; }

    public void setUsuarioDto(UsuarioDto usuarioDto) { this.usuarioDto = usuarioDto; }

    private String estatus;
    private Date fechacreacion;
    private String pregunta;
    private TipoPreguntaDto tipoPreguntaDto;
    private SubCategoriaDto subCategoriaDto;
    private UsuarioDto usuarioDto;
}
