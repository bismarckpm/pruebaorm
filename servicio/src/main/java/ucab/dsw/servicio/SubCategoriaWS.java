package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoPregunta;
import ucab.dsw.accesodatos.DaoSubCategoria;
import ucab.dsw.dtos.PreguntaDto;
import ucab.dsw.dtos.SubCategoriaDto;
import ucab.dsw.entidades.*;

import javax.ws.rs.*;

public class SubCategoriaWS {


    @POST
    @Path( "/enviarsubcategoria/{id}" )
    public SubCategoriaDto add(SubCategoriaDto subCategoriaDto ){
        SubCategoriaDto resultado = new SubCategoriaDto();
        try{
            DaoSubCategoria dao = new DaoSubCategoria();



        }
        catch ( Exception ex ){
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path( "/getsubcategoria/{id}" )
    public SubCategoriaDto get(@PathParam("id") long  _id , SubCategoriaDto subCategoriaDto){
        SubCategoriaDto resultado = new SubCategoriaDto();
        try{
            DaoSubCategoria dao = new DaoSubCategoria();
            SubCategoria subCategoria = dao.find(_id, SubCategoria.class);
            resultado.setId(subCategoria.get_id());
        }
        catch ( Exception ex ){
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @PUT
    @Path( "/addsubcategoria" )
    public SubCategoriaDto addsubcategoria( SubCategoriaDto subCategoriaDto ){
        SubCategoriaDto resultado = new SubCategoriaDto();
        try{

            DaoSubCategoria dao = new DaoSubCategoria();
            SubCategoria subCategoria = new SubCategoria();
            subCategoria.set_descripcion(subCategoriaDto.getDescripcion() );
            subCategoria.set_estatus(subCategoriaDto.getEstatus() );
            Categoria catego = new Categoria( subCategoriaDto.getCategoriaDto().getId());
            subCategoria.set_categoria( catego );
            SubCategoria resul = dao.insert( subCategoria );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex ){
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @DELETE
    @Path( "/deletesubcategoria/{id}" )
    public SubCategoriaDto deletesubcategoria(@PathParam("id") long  _id , SubCategoriaDto subCategoriaDto){
        SubCategoriaDto resultado = new SubCategoriaDto();
        try{
            DaoSubCategoria dao = new DaoSubCategoria();
            SubCategoria subCategoria = dao.find(_id, SubCategoria.class);
            SubCategoria sub = dao.delete(subCategoria);
            resultado.setId(sub.get_id());
        }
        catch ( Exception ex ){
            String problema = ex.getMessage();
        }
        return  resultado;
    }
}
