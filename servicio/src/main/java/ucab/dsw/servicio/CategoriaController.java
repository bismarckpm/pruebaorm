package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoCategoria;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.entidades.Categoria;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path( "/prueba" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class CategoriaController extends AplicacionBase{

    @PUT
    @Path( "/addcategory" )
    public CategoriaDto addCategory(CategoriaDto categoriaDto )
    {
        CategoriaDto resultado = new CategoriaDto();
        try
        {
            DaoCategoria dao = new DaoCategoria();
            Categoria categoria = new Categoria();
            categoria.set_descripcion( categoriaDto.getDescripcion());
            categoria.set_estatus(categoriaDto.getStatus());
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
    @Path("/modifyCategory")
    public CategoriaDto modificarCategoria( CategoriaDto categoriaDto){
        CategoriaDto resultado = new CategoriaDto();
        try{
            DaoCategoria dao = new DaoCategoria();
            Categoria categoria = new Categoria( categoriaDto.getId());
            categoria.set_descripcion( categoriaDto.getDescripcion());
            categoria.set_estatus( categoriaDto.getStatus());
            Categoria resul = dao.update( categoria );
            resultado.setId( resul.get_id());
        }catch (Exception e){
            String problema = e.getMessage();
        }
        return resultado;
    }
    @DELETE
    @Path("/deleteCategory")
    public CategoriaDto deleteCategoria( CategoriaDto categoriaDto){
        CategoriaDto resultado = new CategoriaDto();
        try{
            DaoCategoria dao = new DaoCategoria();
            Categoria categoria = dao.find(categoriaDto.getId(), Categoria.class);
            categoria.set_estatus(categoriaDto.getStatus());
            Categoria resul = dao.update( categoria );
            resultado.setId( resul.get_id());
        }catch (Exception e){
            String problema = e.getMessage();
        }
        return resultado;
    }

    @GET
    @Path( "/{id}" )
    // @PathParam("id") Long id
    public CategoriaDto obtenerCategoria(CategoriaDto categoriaDto)
    {
        CategoriaDto resultado = new CategoriaDto();
        try{
            DaoCategoria dao = new DaoCategoria();
            Categoria encontrado = dao.find(categoriaDto.getId(), Categoria.class);
            resultado.setId(encontrado.get_id());
        }
        catch (Exception e){
            String problema = e.getMessage();
        }

        return resultado;
    }
}
