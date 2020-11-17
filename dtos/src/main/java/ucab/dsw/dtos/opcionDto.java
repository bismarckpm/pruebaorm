package ucab.dsw.dtos;

public class opcionDto extends DtoBase
{

    private String descripcion;

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

    private String estatus;

    public tipopreguntaDto gettipopreguntaDto()
    {
        return tipopreguntaDto;
    }

    public void settipopreguntaDto( tipopreguntaDto tipopreguntaDto )
    {
        this.tipopreguntaDto = tipopreguntaDto;
    }


    private tipopreguntaDto tipopreguntaDto;



}
