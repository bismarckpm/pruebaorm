package ucab.dsw.servicio;

import interfaces.OpcionDao;
import ucab.dsw.dtos.OpcionDTO;
import ucab.dsw.entidades.Opcion;
import ucab.dsw.entidades.Pregunta;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("/opciones")
public class OpcionServiceRS {
    @Inject private OpcionDao opcionDao;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Opcion> listarOpciones(){
        List<Opcion> opciones = opcionDao.findAll();
        return opciones;
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Opcion insertOpcion(OpcionDTO opcionDTO){
        Opcion opcion = new Opcion();
        opcion.setDescripcion(opcionDTO.getDescripcion());
        opcion.setEstatus(opcionDTO.getEstatus());
        opcion.setPregunta(new Pregunta(opcionDTO.getIdPregunta()));
        opcionDao.insertOpcion(opcion);
        return opcion;
    }

    @PUT
    @Path("{id}")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response updateOpcion(@PathParam("id") int id, OpcionDTO opcionDTO) {
        Opcion opcion = opcionDao.find(new Opcion(id));
        if (opcion != null){
            opcion.setDescripcion(opcionDTO.getDescripcion());
            opcion.setEstatus(opcionDTO.getEstatus());
            opcion.setPregunta(new Pregunta(opcionDTO.getIdPregunta()));
            opcionDao.updateOpcion(opcion);
            return Response.ok().entity(opcion).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{id}")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response deleteOpcion(@PathParam("id") int id){
        Opcion opcion = opcionDao.find(new Opcion(id));
        if (opcion != null){
            opcionDao.deleteOpcion(opcion);
            return Response.ok().entity(opcion).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
