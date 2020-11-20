package ucab.dsw.dtos;

import java.util.Date;

public class PreguntaDto extends DtoBase{
    private String pregunta;
    private Date fechacreacion;
    private String estatus;
    private UsuarioDto usuarioDto;
    private TipoPreguntaDto tipoPreguntaDto;
    private SubcategoriaDto subCategoriaDto;

    public SubcategoriaDto getSubCategoriaDto() {
        return subCategoriaDto;
    }

    public void setSubCategoriaDto(SubcategoriaDto subCategoriaDto) {
        this.subCategoriaDto = subCategoriaDto;
    }

    public TipoPreguntaDto getTipoPreguntaDto() {
        return tipoPreguntaDto;
    }

    public void setTipoPreguntaDto(TipoPreguntaDto tipoPreguntaDto) {
        this.tipoPreguntaDto = tipoPreguntaDto;
    }

    public UsuarioDto getUsuarioDto() {
        return usuarioDto;
    }

    public void setUsuarioDto(UsuarioDto usuarioDto) {
        this.usuarioDto = usuarioDto;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public PreguntaDto()
    {
    }

    public PreguntaDto( long id ) throws Exception
    {
        super( id );
    }



}