package ucab.dsw.servicio;
import com.sun.org.apache.bcel.internal.ExceptionConst;
import ucab.dsw.accesodatos.Dao;
import ucab.dsw.accesodatos.DaoCategoria;
import ucab.dsw.accesodatos.DaoSubcategoria;
import ucab.dsw.accesodatos.DaoUsuario;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.dtos.SubcategoriaDto;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.entidades.Categoria;
import ucab.dsw.entidades.Subcategoria;
import ucab.dsw.entidades.TipoUsuario;
import ucab.dsw.entidades.Usuario;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/subcategoria")
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class SubcategoriaCrud extends AplicacionBase {

    @POST
    @Path("/addSubCategory")
    public SubcategoriaDto addSubCategory(SubcategoriaDto subcategoriaDto) {

        SubcategoriaDto resultado = new SubcategoriaDto();
        try {
            DaoSubcategoria dao = new DaoSubcategoria();
            Subcategoria subcategoria = new Subcategoria();
            subcategoria.set_descripcion(subcategoriaDto.getDescripcion());
            subcategoria.set_estatus(subcategoriaDto.getEstatus());
            Categoria categoria = new Categoria(subcategoriaDto.getCategoriaDto().getId());
            subcategoria.set_categoria(categoria);
            Subcategoria resul = dao.insert(subcategoria);
            resultado.setId( resul.get_id() );
        } catch (Exception ex) {
            String problem = ex.getMessage();
        }
        return resultado;
    }

    @PUT //Revisar update, condicion dañada.
    @Path("/updateSubcategory/{id}")
    public SubcategoriaDto updateSubCategory(@PathParam("id") long id,SubcategoriaDto subcategoriaDto){
        SubcategoriaDto resultado = new SubcategoriaDto();
        try {
            DaoSubcategoria dao = new DaoSubcategoria();
            Subcategoria subcategoria = dao.find(id, Subcategoria.class);

            if(subcategoria != null){
                subcategoria.set_descripcion(subcategoriaDto.getDescripcion());
                subcategoria.set_estatus(subcategoriaDto.getEstatus());
               /* Categoria categoria = new Categoria(subcategoriaDto.getCategoriaDto().getId());
                subcategoria.set_categoria(categoria);*/ //Hay que revisar esto
                Subcategoria resul = dao.update(subcategoria);
                resultado.setId(resul.get_id());
            }
        }catch (Exception ex){
            String problem = ex.getMessage();
        }
        return resultado;

    }

    @DELETE
    @Path("/deleteSubCategory/{id}")
    public SubcategoriaDto deleteSubCategory(@PathParam("id") long id){
        SubcategoriaDto resultado = new SubcategoriaDto();

        try{
            DaoSubcategoria dao = new DaoSubcategoria();
            Subcategoria subcategoria = dao.find(id,Subcategoria.class);

            if(subcategoria != null){
                Subcategoria resul = dao.delete(subcategoria);
                resultado.setId(resul.get_id());
            }
        }catch(Exception ex){
            String problem = ex.getMessage();
        }
        return resultado;
    }

    @GET
    @Path("/showSubCategories")
    public List<Subcategoria> showSubCategories(){
        List<Subcategoria> subcategories = null;
        try{
            DaoSubcategoria dao= new DaoSubcategoria();
            subcategories = dao.findAll(Subcategoria.class);
        }catch (Exception ex){
            String problem = ex.getMessage();
        }
        return subcategories;
    }

}
