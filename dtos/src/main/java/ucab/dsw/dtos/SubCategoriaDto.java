package ucab.dsw.dtos;

public class SubCategoriaDto extends DtoBase {

    public SubCategoriaDto()
    {
    }

    public SubCategoriaDto ( long id ) throws Exception
    {
        super( id );
    }

    private String descripcion;

    private String estatus;

    private categoriaDto CategoriaDto;

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

    public categoriaDto getcategoriaDto()
    {
        return CategoriaDto;
    }

    public void setcategoriaDto( categoriaDto CategoriaDto )
    {
        this.CategoriaDto = CategoriaDto;
    }

}
