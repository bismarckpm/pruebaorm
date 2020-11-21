package ucab.dsw.dtos;

public class PreguntaDto extends DtoBase
{
    public PreguntaDto()
    {
    }

    public PreguntaDto( long id ) throws Exception
    { super( id ); }

    private String pregunta;
    private String fechacreacion;

    public String getPregunta() { return pregunta; }
    public void setPregunta(String pregunta) { this.pregunta = pregunta; }

    public String getFechaCreacion() { return fechacreacion; }
    public void setFechaCreacion(String fechacreacion) { this.fechacreacion = fechacreacion; }


    public TipoPreguntaDto geTipoPregunta()
    {
        return tipopreguntaDto;
    }
    public void setTipoPregunta(TipoPreguntaDto tipopreguntaDto) { this.tipopreguntaDto = tipopreguntaDto; }

    public SubCategoriaDto getSubcategoriaDtoDto()
    {
        return SubcategoriaDto;
    }
    public void setSubcategoriaDto( SubCategoriaDto SubcategoriaDto )
    {
        this.SubcategoriaDto = SubcategoriaDto;
    }

    public UsuarioDto getUsuarioDto()
    {
        return UsuarioDto;
    }
    public void setUsuarioDto( UsuarioDto UsuarioDto )
    {
        this.UsuarioDto = UsuarioDto;
    }


    private TipoPreguntaDto tipopreguntaDto;
    private SubCategoriaDto SubcategoriaDto;
    private UsuarioDto UsuarioDto;


    public String getEstatus()
    {
        return estatus;
    }
    public void setEstatus( String estatus )
    {
        this.estatus = estatus;
    }

    private String estatus;

}
