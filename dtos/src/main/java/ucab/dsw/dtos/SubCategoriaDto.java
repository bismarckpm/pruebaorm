package ucab.dsw.dtos;


public class SubCategoriaDto extends DtoBase{

    private String descripcion;

    private String estatus;

    private CategoriaDto CategoriaDto;



    public CategoriaDto getCategoriaDto() {
        return CategoriaDto;
    }

    public void setCategoriaDto(CategoriaDto categoriaDto) {
        CategoriaDto = categoriaDto;
    }

    public SubCategoriaDto(){}

    public SubCategoriaDto(long id ) throws Exception { super( id ); }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public SubCategoriaDto()
    {
    }

    public SubCategoriaDto( long id ) throws Exception
    {
        super( id );
    }
}
