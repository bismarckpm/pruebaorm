package ucab.dsw.dtos;

import java.util.Date;

public class SolicitudDTO extends DtoBase {
    private UsuarioDto usuarioDto;
    private SubcategoriaDTO subcategoriaDTO;
    private String nombre;
    private Date fecha;
    private String estatus;

    public SolicitudDTO(long id) throws Exception {
        super(id);
    }

    public UsuarioDto getUsuarioDto() {
        return usuarioDto;
    }

    public void setUsuarioDto(UsuarioDto usuarioDto) {
        this.usuarioDto = usuarioDto;
    }

    public SubcategoriaDTO getSubcategoriaDTO() {
        return subcategoriaDTO;
    }

    public void setSubcategoriaDTO(SubcategoriaDTO subcategoriaDTO) {
        this.subcategoriaDTO = subcategoriaDTO;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
