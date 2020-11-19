package ucab.dsw.dtos;

public class CategoriaDto extends DtoBase
{

    public CategoriaDto() {

    }

    public CategoriaDto(long id) throws Exception {
        super(id);
    }

    private String descripcion;
    private String estatus;

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


}
