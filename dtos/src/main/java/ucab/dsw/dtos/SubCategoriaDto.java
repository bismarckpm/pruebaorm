package ucab.dsw.dtos;

public class SubCategoriaDto extends DtoBase{

    public SubCategoriaDto()
    {
    }

    public SubCategoriaDto( long id ) throws Exception
    {
        super( id );
    }

    public String getDescripcion() { return descripcion; }

    public void setDescripcion( String descripcion ) { this.descripcion = descripcion; }

    private String descripcion;

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

    public void setCategoriaDto( CategoriaDto categoriaDto )
    {
        this.categoriaDto = categoriaDto;
    }

    private CategoriaDto categoriaDto;


}
