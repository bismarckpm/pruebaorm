package ucab.dsw.servicio;

import interfaces.EstudioDao;
import ucab.dsw.dtos.EstudioDTO;
import ucab.dsw.dtos.SubcategoriaDTO;
import ucab.dsw.entidades.*;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Date;
import java.util.List;

@Stateless
@Path("/estudios")
public class EstudioServiceRS {
    @Inject private EstudioDao estudioDao;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Estudio> listarEstudios(){
        return estudioDao.findAll();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Estudio insertEstudio(EstudioDTO estudioDTO){
        Estudio estudio = new Estudio();
        estudio.setEstatus(estudioDTO.getEstatus());
        estudio.setFechacreacion(Date.valueOf(estudioDTO.getFechaCreacion()));
        estudio.setUsuario(new Usuario(estudioDTO.getIdUsuario()));
        estudio.setSolicitud(new Solicitud(estudioDTO.getIdSolicitud()));
        estudioDao.insertEstudio(estudio);
        return estudio;
    }


    @PUT
    @Path("{id}")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response updateEstudio(@PathParam("id") int id, EstudioDTO estudioDTO){
        Estudio estudio = estudioDao.find(new Estudio(id));
        if (estudio != null){
            estudio.setEstatus(estudioDTO.getEstatus());
            estudio.setFechacreacion(Date.valueOf(estudioDTO.getFechaCreacion()));
            estudio.setUsuario(new Usuario(estudioDTO.getIdUsuario()));
            estudio.setSolicitud(new Solicitud(estudioDTO.getIdSolicitud()));
            estudioDao.insertEstudio(estudio);
            return Response.ok().entity(estudio).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{id}")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response deleteEstudio(@PathParam("id") int id){
        Estudio estudio = estudioDao.find(new Estudio(id));
        if (estudio != null){
            estudioDao.deleteEstudio(estudio);
            return Response.ok().entity(estudio).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
