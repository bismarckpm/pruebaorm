package ucab.dsw.servicio;

import interfaces.EncuestaDao;
import ucab.dsw.dtos.EncuestaDTO;
import ucab.dsw.entidades.Encuesta;
import ucab.dsw.entidades.Estudio;
import ucab.dsw.entidades.Usuario;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Path("/encuestas")
public class EncuestaServiceRS {
    @Inject
    EncuestaDao encuestaDao;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Encuesta> listarEncuestas(){
        List<Encuesta> encuestas = encuestaDao.findAll();
        return encuestas;
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Encuesta insertEncuesta(EncuestaDTO encuestaDTO){
        Encuesta encuesta = new Encuesta();
        encuesta.setEstatus(encuestaDTO.getEstatus());
        encuesta.setEstudio(new Estudio(encuestaDTO.getIdEstudio()));
        encuesta.setFechacreacion(Date.valueOf(encuestaDTO.getFechaCreacion()));
        encuesta.setUsuarioAnalista(new Usuario(encuestaDTO.getIdUsuarioAnalista()));
        encuesta.setUsuarioCreador(new Usuario(encuestaDTO.getIdUsuarioCreador()));
        encuestaDao.insertEncuesta(encuesta);
        return encuesta;
    }

    @PUT
    @Path("{id}")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response updateEncuesta(@PathParam("id") int id, EncuestaDTO encuestaDTO){
        Encuesta encuesta = encuestaDao.find(new Encuesta(encuestaDTO.getId()));
        if (encuesta != null){
            encuesta.setEstatus(encuestaDTO.getEstatus());
            encuesta.setEstudio(new Estudio(encuestaDTO.getIdEstudio()));
            encuesta.setFechacreacion(Date.valueOf(encuestaDTO.getFechaCreacion()));
            encuesta.setUsuarioAnalista(new Usuario(encuestaDTO.getIdUsuarioAnalista()));
            encuesta.setUsuarioCreador(new Usuario(encuestaDTO.getIdUsuarioCreador()));
            encuestaDao.insertEncuesta(encuesta);
            return Response.ok().entity(encuesta).build();
        }
        else return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{id}")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response deleteEncuesta(@PathParam("id") int id){
        Encuesta encuesta = encuestaDao.find(new Encuesta(id));
        if (encuesta != null){
            encuestaDao.deleteEncuesta(encuesta);
            return Response.ok().entity(encuesta).build();
        }
        else return Response.status(Response.Status.NOT_FOUND).build();
    }
}
