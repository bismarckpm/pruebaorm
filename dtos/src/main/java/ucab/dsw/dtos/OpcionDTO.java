package ucab.dsw.dtos;

public class OpcionDTO extends DtoBase {
    private String descripcion;
    private String estatus;
    private PreguntaDTO preguntaDTO;

    public OpcionDTO(long id) throws Exception {
        super(id);
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

    public PreguntaDTO getPreguntaDTO() {
        return preguntaDTO;
    }

    public void setPreguntaDTO(PreguntaDTO preguntaDTO) {
        this.preguntaDTO = preguntaDTO;
    }
}
