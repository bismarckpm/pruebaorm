package ucab.dsw.servicio;
import ucab.dsw.accesodatos.DaoCategoria;
import ucab.dsw.dtos.categoriaDto;

import ucab.dsw.entidades.Categoria;
import ucab.dsw.entidades.Usuario;

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
public class prueba_Categoria extends AplicacionBase
{
    @PUT
    @Path( "/addcategoria" )
    public categoriaDto addCategoria( categoriaDto CategoriaDto ) throws Exception
    {
        categoriaDto resultado = new categoriaDto();
        try
        {
            DaoCategoria dao = new DaoCategoria();
            Categoria categoria = new Categoria();
            categoria.set_descripcion( CategoriaDto.getDescripcion() );
            categoria.set_estatus( CategoriaDto.getEstatus() );
            Categoria resul = dao.insert( categoria );
            resultado.setId( resul.get_id() );

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }
    @PUT
    @Path( "/changecategoria" )
    public categoriaDto changeCategoria( categoriaDto CategoriaDto ) throws Exception
    {
        categoriaDto resultado = new categoriaDto();
        try
        {
            DaoCategoria dao = new  DaoCategoria();
            Categoria categoria = new Categoria(CategoriaDto.getId());
            categoria.set_descripcion( CategoriaDto.getDescripcion() );
            categoria.set_estatus( CategoriaDto.getEstatus() );
            Categoria resul = dao.update( categoria );
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
    public categoriaDto deleteCategoria( long id )
    {
        categoriaDto resultado = new categoriaDto();
        try
        {
            DaoCategoria dao = new  DaoCategoria();
            Categoria delete = dao.find( id,Categoria.class );
            Categoria resul = dao.delete( delete);
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
    public categoriaDto findCategoria( long id )
    {
        categoriaDto resultado = new categoriaDto();
        try
        {
            DaoCategoria dao = new  DaoCategoria();
            Categoria resul = dao.find( id,Categoria.class );
            resultado.setDescripcion( resul.get_descripcion() );
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


