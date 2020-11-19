package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoSubCategoria;
import ucab.dsw.accesodatos.DaoTipoPregunta;
import ucab.dsw.dtos.SubCategoriaDto;
import ucab.dsw.entidades.Categoria;
import ucab.dsw.entidades.SubCategoria;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
            DaoTipoPregunta daoaa = new DaoTipoPregunta();

            SubCategoria subCategoria = new SubCategoria();
            DaoSubCategoria dao = new DaoSubCategoria();

            subCategoria.setDescripcion(subCategoriaDto.getDescripcion());
            subCategoria.setEstatus(subCategoriaDto.getEstatus());

            Categoria categoria = new Categoria(subCategoriaDto.getId());

            subCategoria.set_idCategoria(categoria);
            SubCategoria result = dao.insert(subCategoria);

            resultado.setId(result.get_id());

            return resultado;


        }catch (Exception ex){

            String problema = ex.getMessage();

        }

        return resultado;
    }
}
