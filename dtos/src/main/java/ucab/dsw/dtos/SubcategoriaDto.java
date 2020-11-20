package ucab.dsw.dtos;

public class SubcategoriaDto extends DtoBase {

    public SubcategoriaDto()
    {
    }

    public SubcategoriaDto( long id ) throws Exception
    {
        super( id );
    }

    private String descripcion;

    private String estatus;

    private CategoriaDto categorias;

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

    public CategoriaDto getCategorias() {
        return categorias;
    }

    public void setCategorias(CategoriaDto categorias) {
        this.categorias = categorias;
    }
}
