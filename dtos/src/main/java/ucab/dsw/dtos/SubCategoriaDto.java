
package ucab.dsw.dtos;


public class SubCategoriaDto  extends DtoBase {

    public SubCategoriaDto()
    {  }

    public SubCategoriaDto( long id ) throws Exception
    { super( id ); }

    private categoriaDto categoriaDto;

    private String descripcion;
    private String estatus;

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String _descripcion) { this.descripcion = _descripcion; }

    public String getEstatus()
    {
        return estatus;
    }
    public void setEstatus( String estatus )
    {
        this.estatus = estatus;
    }

    public ucab.dsw.dtos.categoriaDto getCategoriaDto() { return categoriaDto; }
    public void setCategoriaDto(categoriaDto categoriaDto) { this.categoriaDto = categoriaDto; }


    
}
