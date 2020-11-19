package ucab.dsw.dtos;

import java.util.Date;

public class PreguntaDto extends DtoBase{

    public PreguntaDto()
    {
    }

    public PreguntaDto( long id ) throws Exception
    {
        super( id );
    }

    private String pregunta;

    private String estatus;

    private Date fechacreacion;

    public String getPregunta()
    {
        return pregunta;
    }

    public void setPregunta( String pregunta )
    {
        this.pregunta = pregunta;
    }

    public String getEstatus()
    {
        return estatus;
    }

    public void setEstatus( String estatus )
    {
        this.estatus = estatus;
    }

    public Date getFechacreacion(  ) { return fechacreacion; }

    public void setFechacreacion( Date fechacreacion ) { this.fechacreacion = fechacreacion; }

    private UsuarioDto usuarioDto;

    public UsuarioDto getUsuarioDto()
    {
        return usuarioDto;
    }

    public void setUsuarioDto( UsuarioDto usuarioDto )
    {
        this.usuarioDto = usuarioDto;
    }

    private TipoPreguntaDto tipoPreguntaDto;

    public TipoPreguntaDto getTipoPreguntaDto()
    {
        return tipoPreguntaDto;
    }

    public void setTipoPreguntaDto( TipoPreguntaDto tipoPreguntaDto )
    {
        this.tipoPreguntaDto = tipoPreguntaDto;
    }

    private SubCategoriaDto subCategoriaDto;

    public SubCategoriaDto getSubCategoriaDto()
    {
        return subCategoriaDto;
    }

    public void setSubCategoriaDto( SubCategoriaDto subCategoriaDto )
    {
        this.subCategoriaDto = subCategoriaDto;
    }

}
