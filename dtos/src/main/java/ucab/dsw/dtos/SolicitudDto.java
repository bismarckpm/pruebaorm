package ucab.dsw.dtos;

/**
 *
 * @author Omar David
 */
public class SolicitudDto extends DtoBase{
    private String nombre;
    private String fecha;
    private String estatus;
    private UsuarioDto usuarioDto;
//    private SubcategoriaDto subcategoriaDto;

    public SolicitudDto(long id) throws Exception {
        super(id);
    }

    public SolicitudDto() {
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

    public UsuarioDto getUsuarioDto() {
        return usuarioDto;
    }

    public void setUsuarioDto(UsuarioDto usuarioDto) {
        this.usuarioDto = usuarioDto;
    }

//    public SubcategoriaDto getSubcategoriaDto() {
//        return subcategoriaDto;
//    }
//
//    public void setSubcategoriaDto(SubcategoriaDto subcategoriaDto) {
//        this.subcategoriaDto = subcategoriaDto;
//    }
    
    
}
