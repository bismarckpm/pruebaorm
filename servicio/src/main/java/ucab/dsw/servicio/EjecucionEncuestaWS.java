package ucab.dsw.servicio;
import ucab.dsw.accesodatos.DaoEjecucionEncuesta;
import ucab.dsw.dtos.EjecucionEncuestaDto;
import ucab.dsw.entidades.EjecucionEncuesta;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


@Path( "/ejecuciones-encuestas" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class EjecucionEncuestaWS extends AplicacionBase{
    
    @POST
    @Path( "/" )
    public EjecucionEncuestaDto add( EjecucionEncuestaDto encuestaDto ){
        EjecucionEncuestaDto resultado = new EjecucionEncuestaDto();
        try{

        }
        catch ( Exception ex ){
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path( "/{id}" )
    public EjecucionEncuestaDto get( @PathParam("id") long  _id ){
        EjecucionEncuestaDto resultado = new EjecucionEncuestaDto();
        try{

        }
        catch ( Exception ex ){
            String problema = ex.getMessage();
        }
        return  resultado;
    }
    
    @PUT
    @Path( "/{id}" )
    public EjecucionEncuestaDto update( @PathParam("id") long  _id, EjecucionEncuestaDto encuestaDto ){
        EjecucionEncuestaDto resultado = new EjecucionEncuestaDto();
        try{

        }
        catch ( Exception ex ){
            String problema = ex.getMessage();
        }
        return  resultado;
    }
    
    @DELETE
    @Path( "/{id}" )
    public EjecucionEncuestaDto delete( @PathParam("id") long  _id ){
        EjecucionEncuestaDto resultado = new EjecucionEncuestaDto();
        try{

        }
        catch ( Exception ex ){
            String problema = ex.getMessage();
        }
        return  resultado;
    }
}
