package ucab.dsw.dtos;

public class OpcionDto extends DtoBase
{

    private String descripcion;

    
    private String estatus;

    
    private TipoPreguntaDto tipopreguntaDto;
    
    
    public String getdescripcion()
    {
        return descripcion;
    }

    public void setdescripcion( String descripcion )
    {
        this.descripcion = descripcion;
    }

 
    public String getEstatus()
    {
        return estatus;
    }

    public void setEstatus( String estatus )
    {
        this.estatus = estatus;
    }

    public TipoPreguntaDto gettipopreguntaDto()
    {
        return tipopreguntaDto;
    }

    public void settipopreguntaDto( TipoPreguntaDto tipopreguntaDto )
    {
        this.tipopreguntaDto = tipopreguntaDto;
    }

}
