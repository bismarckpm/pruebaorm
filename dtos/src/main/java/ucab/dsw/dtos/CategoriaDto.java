package ucab.dsw.dtos;

public class CategoriaDto extends DtoBase{

    private String descripcion;
    private String estatus;

    public String getDescripcion() { return descripcion; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getStatus() { return estatus; }

    public void setStatus(String status) { this.estatus = status; }
    public CategoriaDto()
    {
    }

    public CategoriaDto( long id ) throws Exception
    {
        super( id );
    }
}
