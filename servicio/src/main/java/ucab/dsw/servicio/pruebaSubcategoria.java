package ucab.dsw.servicio;
import ucab.dsw.accesodatos.DaoSubcategoria;
import ucab.dsw.dtos.SubcategoriaDto;
import ucab.dsw.dtos.CategoriaDto;

import ucab.dsw.entidades.Subcategoria;
import ucab.dsw.entidades.Categoria;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path( "/prueba" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class pruebaSubcategoria extends AplicacionBase {
    @PUT
    @Path("/addSubcategoria")
    public SubcategoriaDto addSubcategoria(SubcategoriaDto subCategoriaDto) throws Exception {
        SubcategoriaDto resultado = new SubcategoriaDto();
        try {
            DaoSubcategoria dao = new DaoSubcategoria();
            Subcategoria subcategoria = new Subcategoria();
            subcategoria.set_descripcion(subCategoriaDto.getDescripcion());
            subcategoria.set_estatus(subCategoriaDto.getEstatus());
            Categoria categoria = new Categoria(subCategoriaDto.getCategoriaDto().getId());
            subcategoria.set_Categoria(categoria);
            Subcategoria resul = dao.insert(subcategoria);
            resultado.setId(resul.get_id());

        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }

    @PUT
    @Path("/changeSubCategoria")
    public SubcategoriaDto changeSubcategoria(SubcategoriaDto subcategoriaDto) throws Exception {
        SubcategoriaDto resultado = new SubcategoriaDto();
        try {
            DaoSubcategoria dao = new DaoSubcategoria();
            Subcategoria subcategoria = new Subcategoria(subcategoriaDto.getId());
            subcategoria.set_descripcion(subcategoriaDto.getDescripcion());
            subcategoria.set_estatus(subcategoriaDto.getEstatus());
            Categoria categoria = new Categoria(subcategoriaDto.getCategoriaDto().getId());
            subcategoria.set_Categoria(categoria);
            Subcategoria resul = dao.update(subcategoria);
            resultado.setId(resul.get_id());

        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }

    @PUT
    @Path("/{id}")
    public SubcategoriaDto deleteSubcategoria(long id) {
        SubcategoriaDto resultado = new SubcategoriaDto();
        try {
            DaoSubcategoria dao = new DaoSubcategoria();
            Subcategoria delete = dao.find(id, Subcategoria.class);
            Subcategoria resul = dao.delete(delete);
            resultado.setId(resul.get_id());
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }


    @PUT
    @Path("/{id}")
    public SubcategoriaDto showSubcategoria(long id) {
        SubcategoriaDto resultado = new SubcategoriaDto();
        try {
            DaoSubcategoria dao = new DaoSubcategoria();
            Subcategoria resul = dao.find(id, Subcategoria.class);
            resultado.setId(resul.get_id());
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }

    @GET
    @Path("/consulta")
    public String consulta() {
        return "Epa";
    }
}
