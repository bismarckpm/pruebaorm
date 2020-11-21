package ucab.dsw.dtos;

public class SolicitudDto extends DtoBase
{
    private String nombre;

    private String estatus;
     
    private String fecha;

    private UsuarioDto UsuarioDto;

    private SubcategoriaDto SubcategoriaDto;
    
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



    public SubcategoriaDto getSubcategoriaDto()
    {
        return SubcategoriaDto;
    }

    public void setSubcategoriaDto( SubcategoriaDto SubcategoriaDto )
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

   
}
