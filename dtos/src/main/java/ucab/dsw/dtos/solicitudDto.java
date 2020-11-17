package ucab.dsw.dtos;

public class solicitudDto extends DtoBase
{
    private String nombre;

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre( String nombre )
    {
        this.nombre = nombre;
    }

    public String getfecha()
    {
        return fecha;
    }

    public void setfecha( String fecha )
    {
        this.fecha = fecha;
    }



    public UsuarioDto getUsuarioDto()
    {
        return UsuarioDto;
    }

    public void setUsuarioDto( UsuarioDto UsuarioDto )
    {
        this.UsuarioDto = UsuarioDto;
    }

    private String fecha;

    private UsuarioDto UsuarioDto;

    private SubcategoriaDto SubcategoriaDto;

    public SubcategoriaDto getSubcategoriaDtoDto()
    {
        return SubcategoriaDto;
    }

    public void SubcategoriaDtoDtoDto( SubcategoriaDto SubcategoriaDto )
    {
        this.SubcategoriaDto = SubcategoriaDto;
    }
    
    public String getEstatus()
    {
        return estatus;
    }

    public void setEstatus( String estatus )
    {
        this.estatus = estatus;
    }

    private String estatus;
}
