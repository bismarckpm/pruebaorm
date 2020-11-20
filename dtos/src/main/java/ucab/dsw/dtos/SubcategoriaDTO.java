package ucab.dsw.dtos;

public class SubcategoriaDTO extends DtoBase {
    private CategoriaDTO categoriaDTO;
    private String descripcion;
    private String estatus;

    public SubcategoriaDTO(long id) throws Exception {
        super(id);
    }

    public CategoriaDTO getCategoriaDTO() {
        return categoriaDTO;
    }

    public void setCategoriaDTO(CategoriaDTO categoriaDTO) {
        this.categoriaDTO = categoriaDTO;
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
