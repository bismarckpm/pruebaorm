package ucab.dsw.servicio;
import ucab.dsw.accesodatos.DaoCategoria;
import ucab.dsw.accesodatos.DaoSubCategoria;
import ucab.dsw.accesodatos.DaoTipoUsuario;
import ucab.dsw.accesodatos.DaoUsuario;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.dtos.SubCategoriaDto;
import ucab.dsw.entidades.Categoria;
import ucab.dsw.entidades.SubCategoria;
import ucab.dsw.entidades.TipoUsuario;
import ucab.dsw.entidades.Usuario;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path( "/prueba" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class pruebaSubCategoria extends AplicacionBase
{
    @PUT
    @Path( "/addSubcategoria" )
    public SubCategoriaDto addSubCategoria(SubCategoriaDto subcategoriaDto )
    {
        SubCategoriaDto resultado = new SubCategoriaDto();
        try
        {
            DaoSubCategoria dao = new DaoSubCategoria();
            SubCategoria subcategoria = new SubCategoria();
            subcategoria.set_descripcion( subcategoriaDto.getDescripcion());
            subcategoria.set_estatus (subcategoriaDto.getEstatus());
            Categoria categoria = new Categoria(subcategoriaDto.getCategoriaDto().getId());
            subcategoria.set_categoria( categoria );
            SubCategoria resul = dao.insert( subcategoria );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @Path("/getSubCategoria")
    public List<SubCategoria> getSubCategoria() {

        List<SubCategoria> subCategorias = null;
        try {
            DaoSubCategoria dao = new DaoSubCategoria();
            subCategorias = dao.findAll(SubCategoria.class);
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return subCategorias;
    }

    @PUT
    @Path( "/updateSubCategoria/{id}" )
    public SubCategoriaDto updateSubCategoria( SubCategoriaDto subcategoriaDto)
    {
        SubCategoriaDto resultado = new SubCategoriaDto();
        try
        {
            DaoSubCategoria dao = new DaoSubCategoria();
            SubCategoria subcategoria = new SubCategoria(subcategoriaDto.getId());
            subcategoria.set_descripcion( subcategoriaDto.getDescripcion());
            Categoria categoria = new Categoria(subcategoriaDto.getCategoriaDto().getId());
            subcategoria.set_categoria( categoria );
            subcategoria.set_estatus (subcategoriaDto.getEstatus());
            SubCategoria resul = dao.update (subcategoria );
            resultado.setId(resul.get_id());

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @DELETE
    @Path( "/deleteSubCategoria/{id}" )
    public SubCategoriaDto deleteSubCategoria( SubCategoriaDto subcategoriaDto) {
        SubCategoriaDto resultado = new SubCategoriaDto();
        try {
            DaoSubCategoria dao = new DaoSubCategoria();
            SubCategoria subcategoria = dao.find(subcategoriaDto.getId(), SubCategoria.class);
            SubCategoria resul = dao.delete(subcategoria);
            resultado.setId(resul.get_id());

        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }

}
