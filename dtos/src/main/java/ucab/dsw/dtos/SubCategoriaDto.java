package ucab.dsw.dtos;

public class SubCategoriaDto extends DtoBase{

    private String descripcion;

    private String status;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SubCategoriaDto()
    {
    }

    public SubCategoriaDto( long id ) throws Exception
    {
        super( id );
    }
}
