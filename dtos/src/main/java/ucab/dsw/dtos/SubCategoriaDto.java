package ucab.dsw.dtos;

public class SubCategoriaDto extends DtoBase{
    public SubCategoriaDto() {

    }

    public SubCategoriaDto(long id) throws Exception {
        super(id);
    }

    private String descripcion;
    private String estatus;
    private CategoriaDto categoriaDto;

    public void setDescripcion(String D){
        this.descripcion=D;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public void setEstatus(String E){
        this.estatus=E;
    }

    public String getEstatus(){
        return this.estatus;
    }

    public void setCategoriaDto(CategoriaDto CDTO){
        this.categoriaDto=CDTO;
    }

    public CategoriaDto getCategoriaDto(){
        return this.categoriaDto;
    }

}
