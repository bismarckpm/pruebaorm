package ucab.dsw.servicio;

import interfaces.SubcategoriaDao;
import ucab.dsw.dtos.CategoriaDTO;
import ucab.dsw.dtos.SubcategoriaDTO;
import ucab.dsw.entidades.Categoria;
import ucab.dsw.entidades.Subcategoria;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("/subcategorias")
public class SubcategoriaServiceRS {
    @Inject
    private SubcategoriaDao subcategoriaDao;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Subcategoria> listarSubcategorias(){
        List<Subcategoria> subcategorias = subcategoriaDao.findAll();
        return subcategorias;
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Subcategoria insertSubcategoria(SubcategoriaDTO subcategoriaDTO){
        Subcategoria subcategoria = new Subcategoria();
        subcategoria.setDescripcion(subcategoriaDTO.getDescripcion());
        subcategoria.setEstatus(subcategoriaDTO.getEstatus());
        subcategoria.setCategoria(new Categoria(subcategoriaDTO.getIdCategoria()));
        subcategoriaDao.insertSubcategoria(subcategoria);
        return subcategoria;
    }

    @PUT
    @Path("{id}")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response updateSubcategoria(@PathParam("id") int id, SubcategoriaDTO subcategoriaDTO) {
        Subcategoria subcategoriaOld = subcategoriaDao.find(new Subcategoria(id));
        if (subcategoriaOld != null) {
            subcategoriaOld.setDescripcion(subcategoriaDTO.getDescripcion());
            subcategoriaOld.setEstatus(subcategoriaDTO.getEstatus());
            subcategoriaOld.setCategoria(new Categoria(subcategoriaDTO.getIdCategoria()));
            subcategoriaDao.updateSubcategoria(subcategoriaOld);
            return Response.ok().entity(subcategoriaOld).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{id}")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response deletesubCategoria(@PathParam("id") int id){
        Subcategoria subcategoriaOld = subcategoriaDao.find(new Subcategoria(id));
        if (subcategoriaOld != null) {
            subcategoriaDao.deleteSubcategoria(subcategoriaOld);
            return Response.ok().entity(subcategoriaOld).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
