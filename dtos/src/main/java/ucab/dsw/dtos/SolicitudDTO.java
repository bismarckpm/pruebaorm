package ucab.dsw.dtos;

import java.util.Date;

public class SolicitudDTO {
    private UsuarioDto usuarioDto;
    private SubcategoriaDTO subcategoriaDTO;
    private int idSubcategoria;
    private int idUsuario;
    private String nombre;
    private String fecha;
    private String estatus;

    public int getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(int idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
