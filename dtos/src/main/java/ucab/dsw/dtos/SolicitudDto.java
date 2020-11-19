package ucab.dsw.dtos;

public class SolicitudDto  extends DtoBase{

    private UsuarioDto Usuario;
    private SubcategoriaDto SubcategoriaDto;
    private String nombre;
    private String fecha;
    private String estatus;

    public SolicitudDto(long id) throws Exception {
        super(id);
    }

    public SolicitudDto() {
    }

    public UsuarioDto getUsuario() {
        return Usuario;
    }

    public void setUsuario(UsuarioDto usuario) {
        Usuario = usuario;
    }

    public ucab.dsw.dtos.SubcategoriaDto getSubcategoriaDto() {
        return SubcategoriaDto;
    }

    public void setSubcategoriaDto(ucab.dsw.dtos.SubcategoriaDto subcategoriaDto) {
        SubcategoriaDto = subcategoriaDto;
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
}
