package ucab.dsw.servicio;
import ucab.dsw.accesodatos.DaoEncuesta;
import ucab.dsw.dtos.EncuestaDto;
import ucab.dsw.entidades.Encuesta;

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


@Path( "/encuestas" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class EncuestaWS extends AplicacionBase{
    
    @POST
    @Path( "/" )
    public EncuestaDto add( EncuestaDto encuestaDto ){
        EncuestaDto resultado = new EncuestaDto();
        try{

        }
        catch ( Exception ex ){
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path( "/{id}" )
    public EncuestaDto get( @PathParam("id") long  _id ){
        EncuestaDto resultado = new EncuestaDto();
        try{

        }
        catch ( Exception ex ){
            String problema = ex.getMessage();
        }
        return  resultado;
    }
    
    @PUT
    @Path( "/" )
    public EncuestaDto update( @PathParam("id") long  _id, EncuestaDto encuestaDto ){
        EncuestaDto resultado = new EncuestaDto();
        try{

        }
        catch ( Exception ex ){
            String problema = ex.getMessage();
        }
        return  resultado;
    }
    
    @DELETE
    @Path( "/" )
    public EncuestaDto delete( @PathParam("id") long  _id ){
        EncuestaDto resultado = new EncuestaDto();
        try{

        }
        catch ( Exception ex ){
            String problema = ex.getMessage();
        }
        return  resultado;
    }
}
