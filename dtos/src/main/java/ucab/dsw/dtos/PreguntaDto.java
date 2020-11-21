package ucab.dsw.dtos;

import java.util.Date;

public class PreguntaDto extends DtoBase {

    private String pregunta;
    private Date fechacreacion;
    private String estatus;
    private TipoPreguntaDto tipoPreguntaDto;
    private UsuarioDto usuarioDto;
    private SubcategoriaDto subcategoriaDto;

    public String getPregunta()
    {
        return pregunta;
    }

    public void setPregunta( String pregunta )
    {
        this.pregunta = pregunta;
    }

    public Date getFechacreacion()
    {
        return fechacreacion;
    }

    public void setFechacreacion( Date fechacreacion )
    {
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

    public TipoPreguntaDto getTipoPreguntaDto()
    {
        return tipoPreguntaDto;
    }

    public void setTipoPreguntaDto( TipoPreguntaDto tipoPreguntaDto )
    {
        this.tipoPreguntaDto = tipoPreguntaDto;
    }

    public UsuarioDto getUsuarioDto()
    {
        return usuarioDto;
    }

    public void setUsuarioDto( UsuarioDto usuarioDto )
    {
        this.usuarioDto = usuarioDto;
    }

    public SubcategoriaDto getSubcategoriaDto()
    {
        return subcategoriaDto;
    }

    public void setSubcategoriaDto( SubcategoriaDto subcategoriaDto )
    {
        this.subcategoriaDto = subcategoriaDto;
    }

    public PreguntaDto() {
    }

    public PreguntaDto( long id ) throws Exception {
        super( id );
    }

}
