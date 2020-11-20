package ucab.dsw.dtos;

public class SubCategoriaDto extends DtoBase {
    private CategoriaDto cat_id;
    private String descripcion;
    private String estatus;

    public void setCatId(CategoriaDto catid){
        this.cat_id = catid;
    }
    public CategoriaDto get_catid(){
        return cat_id;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public String get_descripcion(){
        return descripcion;
    }

    public void setEstatus(String estatus){
        this.estatus = estatus;
    }
    public String get_estatus(){
        return estatus;
    }

    public SubCategoriaDto() {

    }
    public SubCategoriaDto(long id) throws Exception {
        super(id);
    }
}
