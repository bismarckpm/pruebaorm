package ucab.dsw.servicio;
import ucab.dsw.accesodatos.DaoCategoria;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.entidades.Categoria;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.*;


@Path( "/categoria" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class CategoriaS {
    
    @POST
    @Path( "/addcategoria" )
    public CategoriaDto addCategoria( CategoriaDto categoriaDto )
    {
        CategoriaDto resultado = new CategoriaDto();
        try
        {
            DaoCategoria dao = new DaoCategoria();
            Categoria categoria = new Categoria();
            categoria.set_descripcion( categoriaDto.getdescripcion() );
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
    
    
    @GET
    @Path("/getcategoria/{id}")
    public CategoriaDto getCategoria(@PathParam("id") long id, CategoriaDto categoriaDto){
        CategoriaDto res = new CategoriaDto();
        try{
            DaoCategoria dao = new DaoCategoria();
            Categoria categoria = dao.find(id, Categoria.class);
            res.setId(categoria.get_id());
        }catch (Exception ex){
            String problema = ex.getMessage();
        }
        return res;
    }
    
    @PUT
    @Path("/updatecategoria/{id}")
    public CategoriaDto updateCategoria(@PathParam("id") long id, CategoriaDto categoriaDto){
        CategoriaDto res = new CategoriaDto();
        try{
            DaoCategoria dao = new DaoCategoria();
            Categoria categoria = dao.find(id, Categoria.class);
            categoria.set_descripcion( categoriaDto.getdescripcion() );
            categoria.set_estatus( categoriaDto.getEstatus() );
            Categoria r = dao.update(categoria);
            res.setId(r.get_id());
        }catch (Exception ex){ 
            String problema = ex.getMessage();
        }
        return res;
    }
    
    
    @DELETE
    @Path("/deletecategoria/{id}")
    public CategoriaDto deleteCategoria (@PathParam("id") long id, CategoriaDto categoriaDto){
        CategoriaDto res = new CategoriaDto();
        try{
            DaoCategoria dao = new DaoCategoria();
            Categoria categoria = dao.find(id, Categoria.class);
            Categoria r = dao.delete(categoria);
            res.setId(r.get_id());
        }catch (Exception ex){ 
            String problema = ex.getMessage();
        }
        return res;
    }
}
