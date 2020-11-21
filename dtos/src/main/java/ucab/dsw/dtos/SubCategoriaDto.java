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

    public void setDescripcion(String _descripcion){
        this.descripcion = _descripcion;
    }
    public String get_descripcion(){
        return descripcion;
    }

    public void setEstatus(String _estatus){
        this.estatus = _estatus;
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
