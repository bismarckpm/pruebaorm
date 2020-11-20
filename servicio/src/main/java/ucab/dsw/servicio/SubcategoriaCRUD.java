package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoSubcategoria;
import ucab.dsw.dtos.SubcategoriaDto;
import ucab.dsw.entidades.Categoria;
import ucab.dsw.entidades.SubcategoriaEnt;

import javax.ws.rs.*;
import java.util.List;

public class SubcategoriaCRUD {

    @PUT
    @Path( "/addsubcategoria" )
    public SubcategoriaDto addSubcategoria(SubcategoriaDto subcategoriaDto ) throws Exception {

        SubcategoriaDto resultado = new SubcategoriaDto(1);
        try
        {
            DaoSubcategoria dao = new DaoSubcategoria();
            SubcategoriaEnt subcategoria = new SubcategoriaEnt();
            subcategoria.setDescripcion( subcategoriaDto.getDescripcion());
            subcategoria.set_estatus( subcategoriaDto.getEstatus() );
            Categoria categoria = new Categoria(subcategoriaDto.getCategorias().getId());
            subcategoria.setCategorias( categoria );
            SubcategoriaEnt resul = dao.insert( subcategoria );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path("/getSubcategorias")
    public List<SubcategoriaEnt> getSubcategorias() {

        List<SubcategoriaEnt> subcategorias = null;
        try {
            DaoSubcategoria dao = new DaoSubcategoria();
            subcategorias = dao.findAll(SubcategoriaEnt.class);
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        for (SubcategoriaEnt obj : subcategorias) {
            System.out.println(obj.getDescripcion());
        }
        return subcategorias;
    }

    @PUT
    @Path("/updateUsuario/{id}")
    public SubcategoriaDto updateSubcategoria(@PathParam("id") long id, SubcategoriaDto subcategoriaDto) throws Exception {
        SubcategoriaDto resultado = new SubcategoriaDto(1);
        try {
            DaoSubcategoria dao = new DaoSubcategoria();
            SubcategoriaEnt subcategoria = dao.find(id, SubcategoriaEnt.class);
            subcategoria.setDescripcion(subcategoriaDto.getDescripcion());
            SubcategoriaEnt resul = dao.update(subcategoria);
            resultado.setId(resul.get_id());
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }

    @DELETE
    @Path("/deleteUsuario/{id}")
    public SubcategoriaDto deleteSubcategoria(@PathParam("id") long id)
    {
        SubcategoriaDto resultado = new SubcategoriaDto();
        try
        {
            DaoSubcategoria dao = new DaoSubcategoria();
            SubcategoriaEnt subcategoria = dao.find(id, SubcategoriaEnt.class);
            if(subcategoria != null) {
                SubcategoriaEnt resul = dao.delete(subcategoria);
                resultado.setId(resul.get_id());
            }
        }
        catch (Exception er){
            String problema = er.getMessage();
        }
        return resultado;
    }

}
