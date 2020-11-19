package ucab.dsw.dtos;

public class CategoriaDto extends DtoBase
{
    public CategoriaDto()
    {
    }

    public CategoriaDto ( long id ) throws Exception
    {
        super( id );
    }

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
}