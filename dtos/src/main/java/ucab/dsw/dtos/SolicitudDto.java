package ucab.dsw.dtos;

public class SolicitudDto extends DtoBase{

    public SolicitudDto(){}

    public SolicitudDto(long id) throws Exception{
        super(id);
    }

    private UsuarioDto usuarioDto;
    private SubCategoriaDto subcategoriaDto;
    private String nombre;
    private String fecha;
    private String estatus;

    public void setNombre(String N){this.nombre=N;}
    public String getNombre(){return this.nombre;}

    public void setFecha(String F){this.fecha=F;}
    public String getFecha(){return this.fecha;}

    public void setEstatu(String E){this.estatus=E;}
    public String getEstatus(){return this.estatus;}

    public void setIdusuario(UsuarioDto id){this.usuarioDto=id;}
    public UsuarioDto getIdusuario(){return this.usuarioDto;}

    public void setIdsubcategoria(SubCategoriaDto id){this.subcategoriaDto=id;}
    public SubCategoriaDto getIdsubcategoria(){return this.subcategoriaDto;}



}
