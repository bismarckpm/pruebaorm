package ucab.dsw.dtos;

public class SolicitudDto extends DtoBase{
    public SolicitudDto()
    {
    }

    public SolicitudDto( long id ) throws Exception
    {
        super( id );
    }

    public String getNombre() { return nombre; }

    public void setNombre( String nombre ) { this.nombre = nombre; }

    private String nombre;

    public String getFecha() { return fecha; }

    public void setFecha( String fecha ) { this.fecha = fecha; }

    private String fecha;

    public String getEstatus()
    {
        return estatus;
    }

    public void setEstatus( String estatus )
    {
        this.estatus = estatus;
    }

    private String estatus;

    public UsuarioDto getUsuarioDto()
    {
        return usuarioDto;
    }

    public void setUsuarioDto( UsuarioDto usuarioDto )
    {
        this.usuarioDto = usuarioDto;
    }

    private UsuarioDto usuarioDto;

    public SubCategoriaDto getSubCategoriaDto()
    {
        return subCategoriaDto;
    }

    public void setSubCategoriaDto( SubCategoriaDto subCategoriaDto )
    {
        this.subCategoriaDto = subCategoriaDto;
    }

    private SubCategoriaDto subCategoriaDto;
}
