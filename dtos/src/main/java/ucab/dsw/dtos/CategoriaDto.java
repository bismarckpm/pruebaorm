package ucab.dsw.dtos;

<<<<<<< HEAD
public class CategoriaDto extends DtoBase {
    public CategoriaDto() {

=======
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
>>>>>>> 18306e02dbb87b05e8ed4f696540e88bd40b3b48
    }
}
