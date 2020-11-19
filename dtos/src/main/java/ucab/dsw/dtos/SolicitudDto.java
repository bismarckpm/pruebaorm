package ucab.dsw.dtos;

public class SolicitudDto extends DtoBase{

    public SolicitudDto(){}
    public SolicitudDto(long id) throws Exception {super(id);}
    private String nombre;

    private String estatus;

    private UsuarioDto usuarioDto;

    public UsuarioDto getUsuarioDto()
    {
        return usuarioDto;
    }

    public void setUsuarioDto( UsuarioDto usuarioDto )
    {
        this.usuarioDto = usuarioDto;
    }

    private SubCategoriaDto subCategoriaDto;

    public SubCategoriaDto getSubCategoriaDto()
    {
        return subCategoriaDto;
    }

    public void setSubCategoriaDto( SubCategoriaDto subCategoriaDto )
    {
        this.subCategoriaDto = subCategoriaDto;
    }

    private String fecha;

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre( String nombre )
    {
        this.nombre = nombre;
    }

    public String getEstatus()
    {
        return estatus;
    }

    public void setEstatus( String estatus )
    {
        this.estatus = estatus;
    }

    public String getFecha( ) { return fecha; }

    public void setFecha( String fecha) { this.fecha = fecha; }


}


