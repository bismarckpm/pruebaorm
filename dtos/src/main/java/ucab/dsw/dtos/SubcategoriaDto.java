package ucab.dsw.dtos;

public class SubcategoriaDto extends DtoBase{
    public SubcategoriaDto()
    {
    }
    public SubcategoriaDto(long id ) throws Exception
    { super( id ); }
    private String descripcion;

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion( String descripcion )
    {
        this.descripcion = descripcion;
    }

    public String getEstatus()
    {
        return estatus;
    }

    public void setEstatus( String estatus )
    {
        this.estatus = estatus;
    }

    private String estatus;

    public CategoriaDto getCategoriaDto() { return categoriaDto; }
    public void setCategoriaDto( CategoriaDto categoriaDto ) {this.categoriaDto = categoriaDto; }

    private CategoriaDto categoriaDto;
}
