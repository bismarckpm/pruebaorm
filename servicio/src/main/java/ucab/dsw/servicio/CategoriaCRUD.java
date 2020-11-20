package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoCategoria;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.entidades.Categoria;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path( "/categoriaCRUD" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class CategoriaCRUD extends AplicacionBase{

    @PUT
    @Path( "/addCategoria" )
    public CategoriaDto addCategoria(CategoriaDto categoriaDto)
    {
        CategoriaDto resultado = new CategoriaDto();
        try
        {
            DaoCategoria dao = new DaoCategoria();
            Categoria categoria = new Categoria();
            categoria.setDescripcion( categoriaDto.getDescripcion() );
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
    @Path("/getCategoria")
    public List<Categoria> getCategoria() {

        List<Categoria> categorias = null;
        try {
            DaoCategoria dao = new DaoCategoria();
            categorias = dao.findAll(Categoria.class);
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        for (Categoria obj : categorias) {
            System.out.println(obj.getDescripcion());
        }
        return categorias;
    }

    @PUT
    @Path("/updateCategoria/{id}")
    public CategoriaDto updateCategoria(@PathParam("id") long id, CategoriaDto categoriaDto) {
        CategoriaDto resultado = new CategoriaDto();
        try {
            DaoCategoria dao = new DaoCategoria();
            Categoria categoria = dao.find(id, Categoria.class);
            categoria.setDescripcion(categoriaDto.getDescripcion());
            categoria.set_estatus(categoriaDto.getEstatus());
            Categoria resul = dao.update(categoria);
            resultado.setId(resul.get_id());
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }

    @DELETE
    @Path("/deleteCategoria/{id}")
    public CategoriaDto deleteCategoria(@PathParam("id") long id)
    {
        CategoriaDto resultado = new CategoriaDto();
        try
        {
            DaoCategoria dao = new DaoCategoria();
            Categoria categorias = dao.find(id, Categoria.class);
            if(categorias != null) {
                Categoria resul = dao.delete(categorias);
                resultado.setId(resul.get_id());
            }
        }
        catch (Exception er){
            String problema = er.getMessage();
        }
        return resultado;
    }

}
