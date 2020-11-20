package ucab.dsw.servicio;

import interfaces.EjecucionEncuestaDao;
import ucab.dsw.dtos.EjecucionEncuestaDTO;
import ucab.dsw.entidades.*;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("/ejecucion-encuesta")
public class EjecucionEncuestaServiceRS {
    @Inject
    EjecucionEncuestaDao ejecucionEncuestaDao;

    // ID DE ENCUESTA
    @Path("{id}")
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Ejecucionencuesta> listarEjecucionesEncuestas(@PathParam("id") Integer id){
        List<Ejecucionencuesta> ejecucionencuestas = ejecucionEncuestaDao.findBySurvey(id);
        return ejecucionencuestas;
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ejecucionencuesta insertEjecucion(EjecucionEncuestaDTO ejecucionEncuestaDTO){
        Ejecucionencuesta ejecucionencuesta = new Ejecucionencuesta();
        ejecucionencuesta.setRespuesta(ejecucionEncuestaDTO.getRespuesta());
        ejecucionencuesta.setEstatus(ejecucionEncuestaDTO.getEstatus());


        ejecucionencuesta.setEncuesta(new Encuesta(ejecucionEncuestaDTO.getIdEncuesta()));
        ejecucionencuesta.setPregunta(new Pregunta(ejecucionEncuestaDTO.getIdPregunta()));
        ejecucionencuesta.setUsuario(new Usuario(ejecucionEncuestaDTO.getIdUsuario()));

        if ((Integer) ejecucionEncuestaDTO.getIdOpcion() != 0){
            ejecucionencuesta.setOpcion(new Opcion(ejecucionEncuestaDTO.getIdOpcion()));
        }

        ejecucionEncuestaDao.insertEjecucionEncuesta(ejecucionencuesta);
        return ejecucionencuesta;
    }

    // ID EJECUCION
    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("update/{id}")
    public Response updateEjecucion(@PathParam("id") int id, EjecucionEncuestaDTO ejecucionEncuestaDTO){
        Ejecucionencuesta ejecucionencuesta = ejecucionEncuestaDao.find(new Ejecucionencuesta(id));

        if (ejecucionencuesta != null){
            ejecucionencuesta.setRespuesta(ejecucionEncuestaDTO.getRespuesta());
            ejecucionencuesta.setEstatus(ejecucionEncuestaDTO.getEstatus());


            ejecucionencuesta.setEncuesta(new Encuesta(ejecucionEncuestaDTO.getIdEncuesta()));
            ejecucionencuesta.setPregunta(new Pregunta(ejecucionEncuestaDTO.getIdPregunta()));
            ejecucionencuesta.setUsuario(new Usuario(ejecucionEncuestaDTO.getIdUsuario()));

            if ((Integer) ejecucionEncuestaDTO.getIdOpcion() != 0){
                ejecucionencuesta.setOpcion(new Opcion(ejecucionEncuestaDTO.getIdOpcion()));
            }

            System.out.println(ejecucionencuesta.toString());
            ejecucionEncuestaDao.updateEjecucionEncuesta(ejecucionencuesta);
            return Response.ok().entity(ejecucionencuesta).build();
        }

        else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    // ID EJECUCION
    @DELETE
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("delete/{id}")
    public Response deleteEjecucion(@PathParam("id") int id){
        Ejecucionencuesta ejecucionencuesta = ejecucionEncuestaDao.find(new Ejecucionencuesta(id));

        if (ejecucionencuesta != null){
            ejecucionEncuestaDao.deleteEjecucionEncuesta(ejecucionencuesta);
            return Response.ok().entity(ejecucionencuesta).build();
        }

        else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
