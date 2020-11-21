package ucab.dsw.dtos;

public class CategoriaDto extends DtoBase
{
    private String descripcion;

    public String getdescripcion()
    {
        return descripcion;
    }

    public void setdescripcion( String descripcion )
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
