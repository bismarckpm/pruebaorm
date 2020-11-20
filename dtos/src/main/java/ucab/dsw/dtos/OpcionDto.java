package ucab.dsw.dtos;

public class OpcionDto extends DtoBase{

    public OpcionDto()
    {
    }

    public OpcionDto( long id ) throws Exception
    {
        super( id );
    }

    public String getDescripcion() { return descripcion; }

    public void setDescripcion( String descripcion ) { this.descripcion = descripcion; }

    private String descripcion;

    public String getEstatus()
    {
        return estatus;
    }

    public void setEstatus( String estatus )
    {
        this.estatus = estatus;
    }

    private String estatus;

    /*
    public PreguntaDto getPreguntaDto() { return preguntaDto; }

    public void setPreguntaDto( PreguntaDto preguntaDto )
    {
        this.preguntaDto = preguntaDto;
    }

    private PreguntaDto preguntaDto;
     */
}
