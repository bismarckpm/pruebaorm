package ucab.dsw.dtos;

/**
 * Created with IntelliJ IDEA.
 * User: Omar David
 * Date: 20/11/20
 * Time: 08:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class SolicitudDto extends DtoBase{

    private String nombre;
    private String fecha;
    private String estatus;
    private UsuarioDto usuario;
    private SubcategoriaDto subcategoria;

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

    public UsuarioDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
    }

    public SubcategoriaDto getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(SubcategoriaDto subcategoria) {
        this.subcategoria = subcategoria;
    }

    public SolicitudDto(long id) throws Exception {
        super(id);
    }

    public SolicitudDto() {
    }
}
