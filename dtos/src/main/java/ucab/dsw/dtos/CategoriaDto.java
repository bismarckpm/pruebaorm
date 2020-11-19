package ucab.dsw.dtos;

public class CategoriaDto extends DtoBase {
    private String estatus;
    private String descripcion;

    public CategoriaDto(long id) throws Exception {
        super(id);
    }

    public CategoriaDto() {
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
