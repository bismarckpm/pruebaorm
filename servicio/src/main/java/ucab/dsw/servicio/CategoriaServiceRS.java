package ucab.dsw.servicio;

import interfaces.CategoriaDao;
import ucab.dsw.dtos.CategoriaDTO;
import ucab.dsw.entidades.Categoria;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("/categorias")
public class CategoriaServiceRS {
    @Inject
    private CategoriaDao categoriaDao;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Categoria> listarCategorias(){
        List<Categoria> categorias = categoriaDao.findAll();
        System.out.println("Categorías encontradas: "+categorias);
        return categorias;
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Categoria insertCategoria(CategoriaDTO categoriaInput){
        Categoria categoria = new Categoria();
        categoria.setDescripcion(categoriaInput.getDescripcion());
        categoria.setEstatus(categoriaInput.getEstatus());
        categoriaDao.insertCategoria(categoria);
        return categoria;
    }

    @PUT
    @Path("{id}")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response updateCategoria(@PathParam("id") int id, CategoriaDTO categoriaInput) {
        Categoria categoriaOld = categoriaDao.find(new Categoria(id));
        if (categoriaOld != null) {
            Categoria categoria = new Categoria(categoriaOld.getId(), categoriaInput.getDescripcion(), categoriaInput.getEstatus());
            categoriaDao.updateCategoria(categoria);
            return Response.ok().entity(categoria).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{id}")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response deleteCategoria(@PathParam("id") int id){
        Categoria categoriaOld = categoriaDao.find(new Categoria(id));
        if (categoriaOld != null) {
            categoriaDao.deleteCategoria(categoriaOld);
            return Response.ok().entity(categoriaOld).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
        //return Response.ok().build();
    }
}
