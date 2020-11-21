package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoSubCategoria;
import ucab.dsw.accesodatos.DaoTipoPregunta;
import ucab.dsw.accesodatos.DaoUsuario;
import ucab.dsw.dtos.SubCategoriaDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.Categoria;
import ucab.dsw.entidades.SubCategoria;
import ucab.dsw.entidades.Usuario;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path( "/sub-categoria" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class SubCategoriaORMWS {

    @POST
    @Path( "/add" )
    public SubCategoriaDto add(SubCategoriaDto subCategoriaDto ) throws Exception {

        SubCategoriaDto resultado = new SubCategoriaDto();
        try{

            SubCategoria subCategoria = new SubCategoria();
            DaoSubCategoria dao = new DaoSubCategoria();

            subCategoria.set_descripcion(subCategoriaDto.getDescripcion());
            subCategoria.set_estatus(subCategoriaDto.getEstatus());

            Categoria categoria = new Categoria(subCategoriaDto.getId());

            subCategoria.set_categoria(categoria);
            SubCategoria result = dao.insert(subCategoria);

            resultado.setId(result.get_id());

            return resultado;


        }catch (Exception ex){

            String problema = ex.getMessage();

        }

        return resultado;
    }

    @DELETE
    @Path( "/delete" )
    public SubCategoriaDto delete(long id ) {
        SubCategoriaDto subCategoriaDto = new SubCategoriaDto();

        try {
            DaoSubCategoria dao = new DaoSubCategoria();

            SubCategoria usuario = dao.find(id, SubCategoria.class);

            dao.delete( usuario );

            SubCategoria firstSubcategoria = dao.find(id, SubCategoria.class);

            subCategoriaDto.setId(firstSubcategoria.get_id());

            return subCategoriaDto;

        }catch ( Exception ex ){

            String problema = ex.getMessage();
        }
        return subCategoriaDto;
    }

    @GET
    @Path( "/first-one/{id}" )
    public SubCategoriaDto getFirstOne(long id ) {

        SubCategoriaDto subCategoriaDto = new SubCategoriaDto();

        try{
            DaoSubCategoria dao = new DaoSubCategoria();

            SubCategoria firstOneSubCategoria = dao.find( id, SubCategoria.class );
            subCategoriaDto.setId(firstOneSubCategoria.get_id());

            return subCategoriaDto;

        }catch (Exception ex ){

            String problema = ex.getMessage();

        }

        return subCategoriaDto;
    }


}
