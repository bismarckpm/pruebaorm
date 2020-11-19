package ucab.dsw.dtos;

public class SubcategoriaDto extends DtoBase{

    private CategoriaDto CategoriaDto;
    private String descripcion;
    private String estatus;

    public ucab.dsw.dtos.CategoriaDto getCategoriaDto() {
        return CategoriaDto;
    }

    public void setCategoriaDto(ucab.dsw.dtos.CategoriaDto categoriaDto) {
        CategoriaDto = categoriaDto;
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

    public SubcategoriaDto(long id) throws Exception {
        super(id);
    }

    public SubcategoriaDto() {
    }
}
