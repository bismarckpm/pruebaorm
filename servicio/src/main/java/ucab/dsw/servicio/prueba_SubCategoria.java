package ucab.dsw.servicio;
import ucab.dsw.accesodatos.DaoSubCategoria;
import ucab.dsw.dtos.SubCategoriaDto;

import ucab.dsw.entidades.SubCategoria;
import ucab.dsw.entidades.Categoria;
import ucab.dsw.entidades.TipoUsuario;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


@Path( "/prueba" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class prueba_SubCategoria extends AplicacionBase
{
    @PUT
    @Path( "/addSubCategoria" )
    public SubCategoriaDto addSubCategoria( SubCategoriaDto subCategoriaDto ) throws Exception
    {
        SubCategoriaDto resultado = new SubCategoriaDto();
        try
        {
            DaoSubCategoria dao = new DaoSubCategoria();
            SubCategoria subcategoria = new SubCategoria();
            subcategoria.set_descripcion( subCategoriaDto.getDescripcion() );
            subcategoria.set_estatus( subCategoriaDto.getEstatus() );
            Categoria categoria = new Categoria(subCategoriaDto.getcategoriaDto().getId());
            subcategoria.set_Categoria( categoria );
            SubCategoria resul = dao.insert( subcategoria );
            resultado.setId( resul.get_id() );

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }
    @PUT
    @Path( "/changeSubCategoria" )
    public SubCategoriaDto changeSubCategoria( SubCategoriaDto subCategoriaDto ) throws Exception
    {
        SubCategoriaDto resultado = new SubCategoriaDto();
        try
        {
            DaoSubCategoria dao = new DaoSubCategoria();
            SubCategoria subcategoria = new SubCategoria(subCategoriaDto.getId());
            subcategoria.set_descripcion( subCategoriaDto.getDescripcion() );
            subcategoria.set_estatus( subCategoriaDto.getEstatus() );
            Categoria categoria = new Categoria(subCategoriaDto.getcategoriaDto().getId());
            subcategoria.set_Categoria( categoria );
            SubCategoria resul = dao.update( subcategoria );
            resultado.setId( resul.get_id() );

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @PUT
    @Path( "/{id}" )
    public SubCategoriaDto deleteSubCategoria( long id )
    {
        SubCategoriaDto resultado = new SubCategoriaDto();
        try
        {
            DaoSubCategoria dao = new DaoSubCategoria();
            SubCategoria delete = dao.find( id,SubCategoria.class );
            SubCategoria resul = dao.delete( delete);
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }


    @PUT
    @Path( "/{id}" )
    public SubCategoriaDto findSubCategoria( long id )
    {
        SubCategoriaDto resultado = new SubCategoriaDto();
        try
        {
            DaoSubCategoria dao = new DaoSubCategoria();
            SubCategoria resul = dao.find( id,SubCategoria.class );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path( "/consulta" )
    public String consulta()
    {
        return "Epa";
    }
}