package ucab.dsw.dtos;

public class TipoPreguntaDTO extends DtoBase {
    private String descripcion;
    private String estatus;

    public TipoPreguntaDTO(long id) throws Exception {
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
}
