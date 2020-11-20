package ucab.dsw.servicio;

import interfaces.TipoPreguntaDao;
import ucab.dsw.dtos.CategoriaDTO;
import ucab.dsw.dtos.TipoPreguntaDTO;
import ucab.dsw.entidades.Categoria;
import ucab.dsw.entidades.Tipopregunta;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("/tipos-pregunta")
public class TipoPreguntaServiceRS {
    @Inject
    TipoPreguntaDao tipoPreguntaDao;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Tipopregunta> listasTipos(){
        return tipoPreguntaDao.findAll();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Tipopregunta insertarTipoPregunta(TipoPreguntaDTO tipoPreguntaDTO){
        Tipopregunta tipopregunta = new Tipopregunta();
        tipopregunta.setDescripcion(tipoPreguntaDTO.getDescripcion());
        tipopregunta.setEstatus(tipoPreguntaDTO.getEstatus());
        tipoPreguntaDao.insertTipoPregunta(tipopregunta);
        return tipopregunta;
    }

    @PUT
    @Path("{id}")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response updateTipoPregunta(@PathParam("id") int id, TipoPreguntaDTO tipoPreguntaDTO){
        Tipopregunta tipopregunta = tipoPreguntaDao.find(new Tipopregunta(id));
        if (tipopregunta != null){
            tipopregunta.setDescripcion(tipoPreguntaDTO.getDescripcion());
            tipopregunta.setEstatus(tipoPreguntaDTO.getEstatus());
            tipoPreguntaDao.updateTipoPregunta(tipopregunta);
            return Response.ok().entity(tipopregunta).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{id}")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response deleteCategoria(@PathParam("id") int id){
        Tipopregunta tipopregunta = tipoPreguntaDao.find(new Tipopregunta(id));
        if (tipopregunta != null){
            tipoPreguntaDao.deleteTipoPregunta(tipopregunta);
            return Response.ok().entity(tipopregunta).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
