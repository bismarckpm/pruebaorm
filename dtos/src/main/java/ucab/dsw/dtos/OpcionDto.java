package ucab.dsw.dtos;

/**
 *
 * @author Omar David
 */
public class OpcionDto extends DtoBase{
    private String descripcion;
    private String estatus;
    private PreguntaDto preguntaDto;

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

    public PreguntaDto getPreguntaDto() {
        return preguntaDto;
    }

    public void setPreguntaDto(PreguntaDto preguntaDto) {
        this.preguntaDto = preguntaDto;
    }

    
}
