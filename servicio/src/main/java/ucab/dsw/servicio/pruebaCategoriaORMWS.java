package ucab.dsw.servicio;


import ucab.dsw.accesodatos.DaoCategoria;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.entidades.Categoria;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path( "/categoria" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class pruebaCategoriaORMWS extends AplicacionBase {

    @POST
    @Path( "/add" )
    public CategoriaDto addCategoria(CategoriaDto categoriaDto)
    {
        CategoriaDto resultado = new CategoriaDto();
        try
        {
            DaoCategoria dao = new DaoCategoria();
            Categoria categoria = new Categoria();
            categoria.set_descripcion(categoriaDto.getDescripcion());
            categoria.set_estatus( categoriaDto.getEstatus() );
            Categoria resul = dao.insert( categoria );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @DELETE
    @Path( "/delete/{id}" )
    public CategoriaDto deleteCategoria(@PathParam("id") long  _id)
    {
        CategoriaDto resultado = new CategoriaDto();
        try
        {
            DaoCategoria dao = new DaoCategoria();
            Categoria categoria = dao.find(_id,Categoria.class);
            Categoria resul = dao.delete(categoria);
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }


    @PUT
    @Path( "/edit/{id}" )
    public CategoriaDto editCategoria(@PathParam("id") long _id, CategoriaDto categoriaDto)
    {
        CategoriaDto resultado = new CategoriaDto();
        try
        {
            DaoCategoria dao = new DaoCategoria();
            Categoria categoria = dao.find(_id,Categoria.class);
            categoria.set_descripcion(categoriaDto.getDescripcion());
            categoria.set_estatus( categoriaDto.getEstatus() );
            Categoria resul = dao.update(categoria);
            resultado.setId( resul.get_id() );

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path( "/{id}" )
    public CategoriaDto getCategoria(@PathParam("id") long  _id)
    {
        CategoriaDto resultado = new CategoriaDto();
        try
        {
            DaoCategoria dao = new DaoCategoria();
            Categoria categoria = dao.find(_id,Categoria.class);
            resultado.setId( categoria.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }


}
