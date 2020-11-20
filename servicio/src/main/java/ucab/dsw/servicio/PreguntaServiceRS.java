package ucab.dsw.servicio;

import interfaces.PreguntaDao;
import ucab.dsw.dtos.OpcionDTO;
import ucab.dsw.dtos.PreguntaDTO;
import ucab.dsw.entidades.*;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Date;
import java.util.List;

@Stateless
@Path("/preguntas")
public class PreguntaServiceRS {
    @Inject private PreguntaDao preguntaDao;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Pregunta> listarPreguntas(){
        List<Pregunta> preguntas = preguntaDao.findAll();
        return preguntas;
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Pregunta insertPregunta(PreguntaDTO preguntaDTO){
        Pregunta pregunta = new Pregunta();
        pregunta.setEstatus(preguntaDTO.getEstatus());
        pregunta.setFechacreacion(Date.valueOf(preguntaDTO.getFechaCreacion()));
        pregunta.setPregunta(preguntaDTO.getPregunta());
        pregunta.setSubcategoria(new Subcategoria(preguntaDTO.getIdSubcategoria()));
        pregunta.setTipopregunta(new Tipopregunta(preguntaDTO.getIdTipoPregunta()));
        pregunta.setUsuario(new Usuario(preguntaDTO.getIdUsuario()));
        preguntaDao.insertPregunta(pregunta);
        return pregunta;
    }

    @PUT
    @Path("{id}")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response updatePregunta(@PathParam("id") int id, PreguntaDTO preguntaDTO){
        Pregunta pregunta = preguntaDao.find(new Pregunta(id));
        if (pregunta != null){
            pregunta.setEstatus(preguntaDTO.getEstatus());
            pregunta.setFechacreacion(Date.valueOf(preguntaDTO.getFechaCreacion()));
            pregunta.setPregunta(preguntaDTO.getPregunta());
            pregunta.setSubcategoria(new Subcategoria(preguntaDTO.getIdSubcategoria()));
            pregunta.setTipopregunta(new Tipopregunta(preguntaDTO.getIdTipoPregunta()));
            pregunta.setUsuario(new Usuario(preguntaDTO.getIdUsuario()));
            preguntaDao.updatePregunta(pregunta);
            return Response.ok().entity(pregunta).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{id}")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response deletePregunta(@PathParam("id") int id){
        Pregunta pregunta = preguntaDao.find(new Pregunta(id));
        if (pregunta != null){
            preguntaDao.deletePregunta(pregunta);
            return Response.ok().entity(pregunta).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
