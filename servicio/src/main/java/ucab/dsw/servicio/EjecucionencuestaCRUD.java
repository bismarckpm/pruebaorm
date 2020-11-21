package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoEjecucionencuesta;
import ucab.dsw.accesodatos.DaoEstudio;
import ucab.dsw.dtos.EjecucionencuestaDto;
import ucab.dsw.dtos.EstudioDto;
import ucab.dsw.entidades.*;

import javax.ws.rs.*;
import java.util.List;

public class EjecucionencuestaCRUD {

    @PUT
    @Path( "/addEjecucion" )
    public EjecucionencuestaDto addEjecucionencuesta(EjecucionencuestaDto ejecucionencuestaDto)
    {
        EjecucionencuestaDto resultado = new EjecucionencuestaDto();
        try
        {
            DaoEjecucionencuesta dao = new DaoEjecucionencuesta();
            Ejecucionencuesta ejecucionencuesta = new Ejecucionencuesta();
            ejecucionencuesta.setRespuesta(ejecucionencuestaDto.getRespuesta());
            ejecucionencuesta.set_estatus(ejecucionencuestaDto.getEstatus());
            Encuesta encuesta = new Encuesta(ejecucionencuestaDto.getEncuesta().getId());
            ejecucionencuesta.setEncuesta(encuesta);
            Pregunta pregunta = new Pregunta(ejecucionencuestaDto.getPregunta().getId());
            ejecucionencuesta.setPregunta(pregunta);
            Usuario usuario = new Usuario(ejecucionencuestaDto.getUsuario().getId());
            ejecucionencuesta.setUsuario(usuario);
            Opcion opcion = new Opcion(ejecucionencuesta.getOpcion().get_id());
            ejecucionencuesta.setOpcion(opcion);
            Ejecucionencuesta resul = dao.insert( ejecucionencuesta );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path("/getEjecucionencuesta")
    public List<Ejecucionencuesta> getEjecucionencuesta() {

        List<Ejecucionencuesta> ejecucionencuestas = null;
        try {
            DaoEjecucionencuesta dao = new DaoEjecucionencuesta();
            ejecucionencuestas = dao.findAll(Ejecucionencuesta.class);
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        for (Ejecucionencuesta obj : ejecucionencuestas) {
            System.out.println(obj.getRespuesta());
        }
        return ejecucionencuestas;
    }

    @PUT
    @Path("/updateEjecucionencuesta/{id}")
    public EjecucionencuestaDto UpdateEjecucionencuesta(@PathParam("id") long id, EjecucionencuestaDto ejecucionencuestaDto) {
        EjecucionencuestaDto resultado = new EjecucionencuestaDto();
        try {
            DaoEjecucionencuesta dao = new DaoEjecucionencuesta();
            Ejecucionencuesta ejecucionencuesta = dao.find(id, Ejecucionencuesta.class);
            ejecucionencuesta.setRespuesta(ejecucionencuestaDto.getRespuesta());
            ejecucionencuesta.set_estatus(ejecucionencuestaDto.getEstatus());
            Encuesta encuesta = new Encuesta(ejecucionencuestaDto.getEncuesta().getId());
            ejecucionencuesta.setEncuesta(encuesta);
            Pregunta pregunta = new Pregunta(ejecucionencuestaDto.getPregunta().getId());
            ejecucionencuesta.setPregunta(pregunta);
            Usuario usuario = new Usuario(ejecucionencuestaDto.getUsuario().getId());
            ejecucionencuesta.setUsuario(usuario);
            Opcion opcion = new Opcion(ejecucionencuesta.getOpcion().get_id());
            ejecucionencuesta.setOpcion(opcion);
            Ejecucionencuesta resul = dao.update(ejecucionencuesta);
            resultado.setId(resul.get_id());
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }

    @DELETE
    @Path("/deleteEjecucionencuesta/{id}")
    public EjecucionencuestaDto deleteejecucionencuesta(@PathParam("id") long id)
    {
        EjecucionencuestaDto resultado = new EjecucionencuestaDto();
        try
        {
            DaoEjecucionencuesta dao = new DaoEjecucionencuesta();
            Ejecucionencuesta ejecucionencuesta = dao.find(id, Ejecucionencuesta.class);
            if(ejecucionencuesta != null) {
                Ejecucionencuesta resul = dao.delete(ejecucionencuesta);
                resultado.setId(resul.get_id());
            }
        }
        catch (Exception er){
            String problema = er.getMessage();
        }
        return resultado;
    }

}
