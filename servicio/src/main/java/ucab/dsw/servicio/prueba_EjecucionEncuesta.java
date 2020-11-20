package ucab.dsw.servicio;
import ucab.dsw.accesodatos.DaoEjecucionEncuesta;
import ucab.dsw.dtos.EjecucionEncuestaDto;

import ucab.dsw.entidades.EjecucionEncuesta;
import ucab.dsw.entidades.TipoUsuario;
import ucab.dsw.entidades.Usuario;
import ucab.dsw.entidades.Encuesta;
import ucab.dsw.entidades.Pregunta;


import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


@Path( "/prueba" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class prueba_EjecucionEncuesta extends AplicacionBase
{
    @PUT
    @Path( "/addEjecucionEncuesta" )
    public EjecucionEncuestaDto addEjecucionEncuesta( EjecucionEncuestaDto EjecucionEncuestaDto ) throws Exception
    {
        EjecucionEncuestaDto resultado = new EjecucionEncuestaDto();
        try
        {
            DaoEjecucionEncuesta dao = new DaoEjecucionEncuesta();
            EjecucionEncuesta ejecucionEncuesta = new EjecucionEncuesta();
            EjecucionEncuesta.set_respuesta( EjecucionEncuestaDto.getrespuesta() );
            EjecucionEncuesta.set_estatus( EjecucionEncuestaDto.getestatus() );
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
    @Path( "/changeEjecucionEncuesta" )
    public EjecucionEncuestaDto changeEjecucionEncuesta( EjecucionEncuestaDto EjecucionEncuestaDto ) throws Exception
    {
        EjecucionEncuestaDto resultado = new EjecucionEncuestaDto();
        try
        {
            DaoEjecucionEncuesta dao = new  DaoEjecucionEncuesta();
            EjecucionEncuesta estudio = new EjecucionEncuesta(EjecucionEncuestaDto.getId());
            EjecucionEncuesta.set_respuesta( EjecucionEncuestaDto.getrespuesta() );
            EjecucionEncuesta.set_estatus( EjecucionEncuestaDto.getestatus() );
            EjecucionEncuesta resul = dao.update( estudio );
            resultado.setId( resul.get_id() );

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @PUT
    @Path( "/{id}" )
    public EjecucionEncuestaDto deleteEjecucionEncuesta( long id )
    {
        EjecucionEncuestaDto resultado = new EjecucionEncuestaDto();
        try
        {
            DaoEjecucionEncuesta dao = new  DaoEjecucionEncuesta();
            EjecucionEncuesta delete = dao.find( id,EjecucionEncuesta.class );
            EjecucionEncuesta resul = dao.delete( delete);
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }


    @PUT
    @Path( "/{id}" )
    public EjecucionEncuestaDto findEjecucionEncuesta( long id )
    {
        EjecucionEncuestaDto resultado = new EjecucionEncuestaDto();
        try
        {
            DaoEjecucionEncuesta dao = new  DaoEjecucionEncuesta();
            EjecucionEncuesta resul = dao.find( id,EjecucionEncuesta.class );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path( "/consulta" )
    public String consulta()
    {
        return "Epa";
    }
}
