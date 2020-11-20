package ucab.dsw.servicio;
import com.sun.org.apache.bcel.internal.ExceptionConst;
import ucab.dsw.accesodatos.Dao;
import ucab.dsw.accesodatos.DaoCategoria;
import ucab.dsw.accesodatos.DaoUsuario;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.entidades.Categoria;
import ucab.dsw.entidades.TipoUsuario;
import ucab.dsw.entidades.Usuario;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/categoria")
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class CategoriaCrud extends AplicacionBase {

    @POST
    @Path( "/addCategory" )
    public CategoriaDto addCategory( CategoriaDto categoriaDto)
    {
        CategoriaDto resultado = new CategoriaDto();
        try
        {
            DaoCategoria dao = new DaoCategoria();
            Categoria categoria = new Categoria();
            categoria.set_descripcion( categoriaDto.getDescripcion() );
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

    @PUT
    @Path("/updateCategory/{id}")
    public CategoriaDto updateCategory(@PathParam("id") long id, CategoriaDto categoriaDto){
        CategoriaDto resultado = new CategoriaDto();

        try{
            DaoCategoria dao = new DaoCategoria();
            Categoria categoria = dao.find(id, Categoria.class);

            if(categoria!=null){
                categoria.set_descripcion(categoriaDto.getDescripcion());
                categoria.set_estatus(categoriaDto.getEstatus());
                Categoria resul = dao.update(categoria);
                resultado.setId(resul.get_id());
            }
        }catch (Exception ex){
            String problem = ex.getMessage();
        }
        return resultado;
    }

    @DELETE
    @Path("deleteCategory/{id}")
    public CategoriaDto deleteCategory (@PathParam("id") long id){
        CategoriaDto resultado = new CategoriaDto();

        try{
            DaoCategoria dao = new DaoCategoria();
            Categoria categoria = dao.find(id,Categoria.class);

            if(categoria != null){
                Categoria resul = dao.delete(categoria);
                resultado.setId(resul.get_id());
            }
        }catch(Exception ex){
            String problem = ex.getMessage();
        }
        return resultado;
    }

    @GET
    @Path("/showCategories")
    public List<Categoria> showCategories(){
        List<Categoria> categories = null;
        try{
            DaoCategoria dao= new DaoCategoria();
            categories = dao.findAll(Categoria.class);
        }catch (Exception ex){
            String problem = ex.getMessage();
        }
        return categories;
    }

}
