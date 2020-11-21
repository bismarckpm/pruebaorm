package ucab.dsw.dtos;

public class TipoPreguntaDto extends DtoBase{
    private String descripcion;
    private String estatus;

    public TipoPreguntaDto(long id) throws Exception {
        super(id);
    }

    public TipoPreguntaDto() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
