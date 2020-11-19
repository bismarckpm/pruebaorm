package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoCategoria;
import ucab.dsw.accesodatos.DaoEjecutaEncuesta;
import ucab.dsw.accesodatos.DaoEncuesta;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.dtos.EjecutaEncuestaDto;
import ucab.dsw.dtos.EncuestaDto;
import ucab.dsw.entidades.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path( "/prueba" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class EjecutaEncuestaController extends AplicacionBase{

    @PUT
    @Path( "/addejecutaencuesta" )
    public EjecutaEncuestaDto addEjecutaEncuesta(EjecutaEncuestaDto ejecutaEncuestaDto )
    {
        EjecutaEncuestaDto resultado = new EjecutaEncuestaDto();
        try
        {
            DaoEjecutaEncuesta dao = new DaoEjecutaEncuesta();
            EjecutaEncuesta ejecutaEncuesta = new EjecutaEncuesta();
            ejecutaEncuesta.set_estatus(ejecutaEncuestaDto.getEstatus());
            ejecutaEncuesta.set_respuesta(ejecutaEncuestaDto.getRespuesta());
            Usuario idUsuarioEncuestado = new Usuario(ejecutaEncuestaDto.getIdUsuario_Encuestado().getId());
            ejecutaEncuesta.setIdUsuario_Encuestado(idUsuarioEncuestado);
            Encuesta encuesta = new Encuesta(ejecutaEncuestaDto.getIdEncuesta().getId());
            ejecutaEncuesta.setIdEncuesta(encuesta);
            Opcion opcion = new Opcion(ejecutaEncuestaDto.getIdOpcion().getId());
            ejecutaEncuesta.setIdOpcion(opcion);
            Pregunta pregunta = new Pregunta(ejecutaEncuestaDto.getIdPregunta().getId());
            ejecutaEncuesta.setIdPregunta(pregunta);
            EjecutaEncuesta resul = dao.insert( ejecutaEncuesta );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }
    @PUT
    @Path( "/modifyejecutaencuesta" )
    public EjecutaEncuestaDto modifyEjecutaEncuesta(EjecutaEncuestaDto ejecutaEncuestaDto )
    {
        EjecutaEncuestaDto resultado = new EjecutaEncuestaDto();
        try
        {
            DaoEjecutaEncuesta dao = new DaoEjecutaEncuesta();
            EjecutaEncuesta ejecutaEncuesta = new EjecutaEncuesta(ejecutaEncuestaDto.getId());
            ejecutaEncuesta.set_estatus(ejecutaEncuestaDto.getEstatus());
            ejecutaEncuesta.set_respuesta(ejecutaEncuestaDto.getRespuesta());
            Usuario idUsuarioEncuestado = new Usuario(ejecutaEncuestaDto.getIdUsuario_Encuestado().getId());
            ejecutaEncuesta.setIdUsuario_Encuestado(idUsuarioEncuestado);
            Encuesta encuesta = new Encuesta(ejecutaEncuestaDto.getIdEncuesta().getId());
            ejecutaEncuesta.setIdEncuesta(encuesta);
            Opcion opcion = new Opcion(ejecutaEncuestaDto.getIdOpcion().getId());
            ejecutaEncuesta.setIdOpcion(opcion);
            Pregunta pregunta = new Pregunta(ejecutaEncuestaDto.getIdPregunta().getId());
            ejecutaEncuesta.setIdPregunta(pregunta);
            EjecutaEncuesta resul = dao.update( ejecutaEncuesta );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path( "/{id}" )
    // @PathParam("id") Long id
    public EjecutaEncuestaDto obtenerEjecutaEncuesta(EjecutaEncuestaDto ejecutaEncuestaDto)
    {
        EjecutaEncuestaDto resultado = new EjecutaEncuestaDto();
        try{
            DaoEjecutaEncuesta dao = new DaoEjecutaEncuesta();
            EjecutaEncuesta encontrado = dao.find(ejecutaEncuestaDto.getId(), EjecutaEncuesta.class);
            resultado.setId(encontrado.get_id());
        }
        catch (Exception e){
            String problema = e.getMessage();
        }

        return resultado;
    }

    @PUT
    @Path("/deleteEncuesta")
    public EjecutaEncuestaDto deleteEjecutaEncuesta(EjecutaEncuestaDto ejecutaEncuestaDto){
        EjecutaEncuestaDto resultado = new EjecutaEncuestaDto();
        try{
            DaoEjecutaEncuesta dao = new DaoEjecutaEncuesta();
            EjecutaEncuesta ejecutaEncuesta = dao.find(ejecutaEncuestaDto.getId(), EjecutaEncuesta.class);
            ejecutaEncuesta.set_estatus(ejecutaEncuestaDto.getEstatus());
            EjecutaEncuesta resul = dao.update( ejecutaEncuesta );
            resultado.setId( resul.get_id());
        }catch (Exception e){
            String problema = e.getMessage();
        }
        return resultado;
    }
}
