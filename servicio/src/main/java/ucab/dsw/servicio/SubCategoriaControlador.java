package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoSubCategoria;
import ucab.dsw.accesodatos.DaoTipoPregunta;
import ucab.dsw.dtos.SubCategoriaDto;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.entidades.Categoria;
import ucab.dsw.entidades.SubCategoria;
import ucab.dsw.entidades.TipoPregunta;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path( "/sub-categoria" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class SubCategoriaControlador extends AplicacionBase{

    @Path( "/new" )
    public SubCategoriaDto addSubCategoria(SubCategoriaDto subCategoriaDto ){
        SubCategoriaDto resultado = new SubCategoriaDto();
        String err = new String();
        try
        {
            DaoSubCategoria dao = new DaoSubCategoria();
            Categoria categoria = new Categoria(subCategoriaDto.get_catid().getId());
            SubCategoria subCategoria = new SubCategoria();
            subCategoria.set_estatus(subCategoria.get_estatus());
            subCategoria.set_descripcion(subCategoria.get_descripcion());
            subCategoria.setId_categoria(categoria);
            SubCategoria result = dao.insert(subCategoria );
            resultado.setId(result.get_id());
        }
        catch ( Exception ex )
        {
            err = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path( "ext/:tp_id" )
    public SubCategoriaDto obtenerSubCategoria(long tp_id){
        SubCategoriaDto resultado = new SubCategoriaDto();
        String err = new String();
        try{
            DaoSubCategoria dao = new DaoSubCategoria();
            SubCategoria encontrado = dao.find( tp_id,SubCategoria.class);
            resultado.setId(encontrado.get_id());
            resultado.setDescripcion( encontrado.get_descripcion());
        }catch (Exception e){
            err = e.getMessage();
        }

        return resultado;
    }

    @PUT
    @Path( "/update/:tp_id" )
    public SubCategoriaDto updateSubCategoria(SubCategoriaDto subCategoriaDto){
        SubCategoriaDto resultado = new SubCategoriaDto();
        try{
            DaoSubCategoria dao = new DaoSubCategoria();
            SubCategoria updSubCat = new SubCategoria(subCategoriaDto.getId());
            updSubCat.set_descripcion( subCategoriaDto.get_descripcion());
            updSubCat.set_estatus(subCategoriaDto.get_estatus());
            SubCategoria resul = dao.update(updSubCat);
            resultado.setId( resul.get_id());
        }catch (Exception e){
            String problema = e.getMessage();
        }
        return resultado;
    }

    @DELETE
    @Path( "/delete/:tp_id" )
    public SubCategoriaDto deleteSubCategoria(long id){
        SubCategoriaDto resultado = new SubCategoriaDto();
        try{
            DaoSubCategoria dao = new DaoSubCategoria();
            SubCategoria paraBorrar = dao.find( id, SubCategoria.class);
            SubCategoria resul = dao.delete(paraBorrar);
            resultado.setId(resul.get_id());
        }catch (Exception e){
            String problema = e.getMessage();
        }
        return resultado;
    }
}
