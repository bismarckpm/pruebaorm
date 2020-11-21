package ucab.dsw.dtos;

public class SolicitudDto extends DtoBase {
    private String nombre;
    private String estatus;
    private String fecha;
    private SubCategoriaDto _SubCategoria;
    public SubCategoriaDto get_SubCategoria(){return this._SubCategoria;}
    public void set_SubCategoria(SubCategoriaDto _SubCat){this._SubCategoria = _SubCat;}

    private UsuarioDto _Usuario;
    public UsuarioDto get_Usuario(){ return this._Usuario; }
    public void set_Usuario(UsuarioDto _Usuario){this._Usuario = _Usuario;}

    public void setEstatus(String _estatus){
        this.estatus = _estatus;
    }
    public String get_estatus(){
        return estatus;
    }

    public void setFecha(String _fecha){
        this.fecha = _fecha;
    }
    public String get_Fecha(){
        return this.fecha;
    }

    public void setNombre(String _nombre){
        this.nombre = _nombre;
    }
    public String get_Nombre(){
        return this.nombre;
    }

    public SolicitudDto(){}

    public SolicitudDto(long id) throws Exception{ super(id);}
}
