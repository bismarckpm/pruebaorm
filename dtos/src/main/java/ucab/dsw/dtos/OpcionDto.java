package ucab.dsw.dtos;

public class OpcionDto extends DtoBase {
    private String descripcion;
    private String estatus;
    private PreguntaDto preguntaDto;

    public PreguntaDto getPreguntaDto() {
        return preguntaDto;
    }

    public void setPreguntaDto(PreguntaDto preguntaDto) {
        this.preguntaDto = preguntaDto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public OpcionDto()
    {
    }

    public OpcionDto( long id ) throws Exception
    {
        super( id );
    }
}