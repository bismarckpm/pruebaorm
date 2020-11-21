package ucab.dsw.servicio;
import ucab.dsw.accesodatos.DaoEstudio;
import ucab.dsw.dtos.EstudioDto;
import ucab.dsw.entidades.Estudio;

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


@Path( "/estudios" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class EstudioWS extends AplicacionBase{
    
    @POST
    @Path( "/" )
    public EstudioDto add( EstudioDto estudioDto ){
        EstudioDto resultado = new EstudioDto();
        try{

        }
        catch ( Exception ex ){
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path( "/{id}" )
    public EstudioDto get( @PathParam("id") long  _id ){
        EstudioDto resultado = new EstudioDto();
        try{

        }
        catch ( Exception ex ){
            String problema = ex.getMessage();
        }
        return  resultado;
    }
    
    @PUT
    @Path( "/{id}" )
    public EstudioDto update( @PathParam("id") long  _id, EstudioDto estudioDto ){
        EstudioDto resultado = new EstudioDto();
        try{

        }
        catch ( Exception ex ){
            String problema = ex.getMessage();
        }
        return  resultado;
    }
    
    @DELETE
    @Path( "/{id}" )
    public EstudioDto delete( @PathParam("id") long  _id ){
        EstudioDto resultado = new EstudioDto();
        try{

        }
        catch ( Exception ex ){
            String problema = ex.getMessage();
        }
        return  resultado;
    }
}
