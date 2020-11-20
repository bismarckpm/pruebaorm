package ucab.dsw.dtos;

public class SolicitudDto extends DtoBase{
    //Contructor
    public SolicitudDto(long id) throws Exception { super(id); }
    public SolicitudDto() { }

    //Columnas
    private String nombre;
    private String fecha;
    private String estatus;
    private UsuarioDto idUsuario;
    private SubCategoriaDto idSubCategoria;

    //Getter and Setter
    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getFecha() { return fecha; }

    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getEstatus() { return estatus; }

    public void setEstatus(String estatus) { this.estatus = estatus; }

    public UsuarioDto getIdUsuario() { return idUsuario; }

    public void setIdUsuario(UsuarioDto idUsuario) { this.idUsuario = idUsuario; }

    public SubCategoriaDto getIdSubCategoria() { return idSubCategoria; }

    public void setIdSubCategoria(SubCategoriaDto idSubCategoria) { this.idSubCategoria = idSubCategoria; }
}
