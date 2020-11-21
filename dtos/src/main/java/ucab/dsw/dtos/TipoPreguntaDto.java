package ucab.dsw.dtos;

public class TipoPreguntaDto extends DtoBase {

    private String descripcion;
    private String estatus;

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

    public TipoPreguntaDto(){

    }

    public TipoPreguntaDto (long id) throws Exception{
        super(id);
    }
}
