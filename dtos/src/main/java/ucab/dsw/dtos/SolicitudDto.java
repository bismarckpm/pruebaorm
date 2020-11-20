package ucab.dsw.dtos;

public class SolicitudDto extends DtoBase{
    private String nombre;
    private String fecha;
    private String estatus;

    public SolicitudDto()
    {
    }

    public SolicitudDto( long id ) throws Exception
    {
        super( id );
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    private SubcategoriaDto subcategoria;
    public SubcategoriaDto getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(SubcategoriaDto subcategoria) {
        this.subcategoria = subcategoria;
    }

    private UsuarioDto usuario;
    public UsuarioDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
    }


}
