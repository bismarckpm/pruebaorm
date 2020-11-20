package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoEjecucionEncuesta;
import ucab.dsw.accesodatos.DaoOpcion;
import ucab.dsw.dtos.EjecucionEncuestaDto;
import ucab.dsw.dtos.OpcionDto;
import ucab.dsw.entidades.*;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path( "/ejecucionencuesta" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class testEjecucionEncuesta extends AplicacionBase{

    @PUT
    @Path( "/addejecucionencuesta" )
    public EjecucionEncuestaDto addEjecucionEncuesta(EjecucionEncuestaDto ejecucionEncuestaDto)
    {
        EjecucionEncuestaDto resultado = new EjecucionEncuestaDto();
        try
        {
            DaoEjecucionEncuesta dao = new DaoEjecucionEncuesta();
            EjecucionEncuesta ejecucionEncuesta = new EjecucionEncuesta();
            Encuesta encuesta = new Encuesta(ejecucionEncuestaDto.getEncuestaDto().getId());
            ejecucionEncuesta.set_encuesta(encuesta);
            Pregunta pregunta = new Pregunta(ejecucionEncuestaDto.getPreguntaDto().getId());
            ejecucionEncuesta.set_pregunta(pregunta);
            Usuario usuario = new Usuario(ejecucionEncuestaDto.getUsuarioDto().getId());
            ejecucionEncuesta.set_usuario(usuario);
            Opcion opcion = new Opcion(ejecucionEncuestaDto.getOpcionDto().getId());
            ejecucionEncuesta.set_opcion(opcion);
            ejecucionEncuesta.set_respuesta( ejecucionEncuestaDto.getRespuesta() );
            ejecucionEncuesta.set_estatus( ejecucionEncuestaDto.getEstatus() );
            EjecucionEncuesta resul = dao.insert( ejecucionEncuesta );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;


    }

    @PUT
    @Path( "/changeejecucionencuesta/{id}" )
    public EjecucionEncuestaDto modifyEjecucionEncuesta(EjecucionEncuestaDto ejecucionEncuestaDto ) throws Exception
    {
        EjecucionEncuestaDto resultado = new EjecucionEncuestaDto();
        try
        {
            DaoEjecucionEncuesta dao = new DaoEjecucionEncuesta();
            EjecucionEncuesta ejecucionEncuesta = new EjecucionEncuesta(ejecucionEncuestaDto.getId());
            Encuesta encuesta = new Encuesta(ejecucionEncuestaDto.getEncuestaDto().getId());
            ejecucionEncuesta.set_encuesta(encuesta);
            Pregunta pregunta = new Pregunta(ejecucionEncuestaDto.getPreguntaDto().getId());
            ejecucionEncuesta.set_pregunta(pregunta);
            Usuario usuario = new Usuario(ejecucionEncuestaDto.getUsuarioDto().getId());
            ejecucionEncuesta.set_usuario(usuario);
            Opcion opcion = new Opcion(ejecucionEncuestaDto.getOpcionDto().getId());
            ejecucionEncuesta.set_opcion(opcion);
            ejecucionEncuesta.set_respuesta( ejecucionEncuestaDto.getRespuesta() );
            ejecucionEncuesta.set_estatus( ejecucionEncuestaDto.getEstatus() );
            EjecucionEncuesta resul = dao.update( ejecucionEncuesta );
            resultado.setId( resul.get_id() );

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @DELETE
    @Path("/{id}")
    public EjecucionEncuestaDto deleteEjecucionEncuesta(long id )
    {
        EjecucionEncuestaDto resultado = new EjecucionEncuestaDto();

        try {
            DaoEjecucionEncuesta dao = new DaoEjecucionEncuesta();
            EjecucionEncuesta findid = dao.find(id,EjecucionEncuesta.class);
            EjecucionEncuesta deleteid = dao.delete(findid);
            resultado.setId( deleteid.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path("/Consultarejecucionencuesta/{id}")
    public EjecucionEncuestaDto consultarEjecucionEncuesta (long id)
    {
        EjecucionEncuestaDto resultado = new EjecucionEncuestaDto();

        try {
            DaoEjecucionEncuesta dao = new DaoEjecucionEncuesta();
            EjecucionEncuesta findid = dao.find(id,EjecucionEncuesta.class);
            resultado.setId(findid.get_id());
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return resultado;
    }
}
