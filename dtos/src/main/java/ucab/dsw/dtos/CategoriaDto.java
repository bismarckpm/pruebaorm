package ucab.dsw.dtos;

public class CategoriaDto extends DtoBase{

    private String descripcion;
    private String status;

    public String getDescripcion() { return descripcion; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
    public CategoriaDto()
    {
    }

    public CategoriaDto( long id ) throws Exception
    {
        super( id );
    }
}
