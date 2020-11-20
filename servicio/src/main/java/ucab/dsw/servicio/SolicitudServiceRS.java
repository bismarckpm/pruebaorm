package ucab.dsw.servicio;

import interfaces.SolicitudDao;
import ucab.dsw.dtos.OpcionDTO;
import ucab.dsw.dtos.SolicitudDTO;
import ucab.dsw.entidades.*;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("/solicitudes")
public class SolicitudServiceRS {
    @Inject private SolicitudDao solicitudDao;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Solicitud> listarSolicitudes(){
        return solicitudDao.findAll();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Solicitud insertSolicitud(SolicitudDTO solicitudDTO){
        Solicitud solicitud = new Solicitud();
        solicitud.setEstatus(solicitudDTO.getEstatus());
        solicitud.setFecha(solicitudDTO.getFecha());
        solicitud.setNombre(solicitudDTO.getNombre());
        solicitud.setUsuario(new Usuario(solicitudDTO.getIdUsuario()));
        solicitud.setSubcategoria(new Subcategoria(solicitudDTO.getIdSubcategoria()));
        solicitudDao.insertSolicitud(solicitud);
        return solicitud;
    }

    @PUT
    @Path("{id}")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response updateSolicitud(@PathParam("id") int id, SolicitudDTO solicitudDTO){
        Solicitud solicitud = solicitudDao.find(new Solicitud(id));
        if (solicitud != null){
            solicitud.setEstatus(solicitudDTO.getEstatus());
            solicitud.setFecha(solicitudDTO.getFecha());
            solicitud.setNombre(solicitudDTO.getNombre());
            solicitud.setUsuario(new Usuario(solicitudDTO.getIdUsuario()));
            solicitud.setSubcategoria(new Subcategoria(solicitudDTO.getIdSubcategoria()));
            solicitudDao.updateSolicitud(solicitud);
            return Response.ok().entity(solicitud).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{id}")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response deleteSolicitud(@PathParam("id") int id){
        Solicitud solicitud = solicitudDao.find(new Solicitud(id));
        if (solicitud != null){
            solicitudDao.deleteSolicitud(solicitud);
            return Response.ok().entity(solicitud).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
