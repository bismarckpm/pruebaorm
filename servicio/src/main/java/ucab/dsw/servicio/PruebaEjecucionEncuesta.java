package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoEjecucionEncuesta;
import ucab.dsw.dtos.EjecucionEncuestaDto;
import ucab.dsw.entidades.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created with IntelliJ IDEA.
 * User: Omar David
 * Date: 20/11/20
 * Time: 10:13 PM
 * To change this template use File | Settings | File Templates.
 */
@Path( "/prueba" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class PruebaEjecucionEncuesta extends AplicacionBase
{
    @PUT
    @Path( "/addejecucionencuesta" )
    public EjecucionEncuestaDto addEjecucionEncuesta( EjecucionEncuestaDto ejecucionEncuestaDto )
    {
        EjecucionEncuestaDto resultado = new EjecucionEncuestaDto();
        try
        {
            DaoEjecucionEncuesta dao = new DaoEjecucionEncuesta();
            EjecucionEncuesta ejecucion = new EjecucionEncuesta();
            ejecucion.setRespuesta(ejecucionEncuestaDto.getRespuesta());
            ejecucion.set_estatus(ejecucionEncuestaDto.getEstatus());
            Encuesta encuesta = new Encuesta(ejecucionEncuestaDto.getEncuesta().getId());
            Pregunta pregunta = new Pregunta(ejecucionEncuestaDto.getPregunta().getId());
            Usuario usuario = new Usuario(ejecucionEncuestaDto.getUsuarioEncuestado().getId());
            Opcion opcion = new Opcion(ejecucionEncuestaDto.getOpcion().getId());
            ejecucion.set_encuesta(encuesta);
            ejecucion.set_pregunta(pregunta);
            ejecucion.set_usuarioEncuestado(usuario);
            ejecucion.set_opcion(opcion);
            EjecucionEncuesta resul = dao.insert(ejecucion);
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }
    @PUT
    @Path( "/changeejecucion" )
    public EjecucionEncuestaDto changeEjecucionEncuesta( EjecucionEncuestaDto ejecucionEncuestaDto ) throws Exception
    {
        EjecucionEncuestaDto resultado = new EjecucionEncuestaDto();
        try
        {
            DaoEjecucionEncuesta dao = new DaoEjecucionEncuesta();
            EjecucionEncuesta ejecucion = new EjecucionEncuesta(ejecucionEncuestaDto.getId());
            ejecucion.setRespuesta(ejecucionEncuestaDto.getRespuesta());
            ejecucion.set_estatus(ejecucionEncuestaDto.getEstatus());
            Encuesta encuesta = new Encuesta(ejecucionEncuestaDto.getEncuesta().getId());
            Pregunta pregunta = new Pregunta(ejecucionEncuestaDto.getPregunta().getId());
            Usuario usuario = new Usuario(ejecucionEncuestaDto.getUsuarioEncuestado().getId());
            Opcion opcion = new Opcion(ejecucionEncuestaDto.getOpcion().getId());
            ejecucion.set_encuesta(encuesta);
            ejecucion.set_pregunta(pregunta);
            ejecucion.set_usuarioEncuestado(usuario);
            ejecucion.set_opcion(opcion);
            EjecucionEncuesta resul = dao.update(ejecucion);
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @PUT
    @Path( "/deleteejecucionencuesta" )
    public EjecucionEncuestaDto deleteEjecucionEncuesta( long id )
    {
        EjecucionEncuestaDto resultado = new EjecucionEncuestaDto();
        try
        {
            DaoEjecucionEncuesta dao = new DaoEjecucionEncuesta();
            EjecucionEncuesta delete = dao.find( id, EjecucionEncuesta.class );
            EjecucionEncuesta resul = dao.delete( delete );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }


    @PUT
    @Path( "/showejecucionencuesta" )
    public EjecucionEncuestaDto showEjecucionEncuesta( long id )
    {
        EjecucionEncuestaDto resultado = new EjecucionEncuestaDto();
        try {
            DaoEjecucionEncuesta dao = new DaoEjecucionEncuesta();
            EjecucionEncuesta resul = dao.find( id, EjecucionEncuesta.class );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

}

