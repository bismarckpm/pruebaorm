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


<<<<<<< HEAD

    public SubcategoriaDto getSubcategoriaDto()
=======
    private SubCategoriaDto SubcategoriaDto;

    public SubCategoriaDto getSubcategoriaDtoDto()
>>>>>>> 862e9d9e80dafcc6ba85e8ca693d53be620a940f
    {
        return SubcategoriaDto;
    }

<<<<<<< HEAD
    public void setSubcategoriaDto( SubcategoriaDto SubcategoriaDto )
=======
    public void SubcategoriaDtoDtoDto( SubCategoriaDto SubcategoriaDto )
>>>>>>> 862e9d9e80dafcc6ba85e8ca693d53be620a940f
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
