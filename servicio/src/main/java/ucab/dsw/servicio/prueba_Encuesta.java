package ucab.dsw.servicio;
import ucab.dsw.accesodatos.DaoEncuesta;
import ucab.dsw.dtos.EncuestaDto;

import ucab.dsw.entidades.*;

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
public class prueba_Encuesta extends AplicacionBase
{
    @PUT
    @Path( "/addcategoria" )
    public EncuestaDto addEncuesta( EncuestaDto EncuestaDto ) throws Exception
    {
        EncuestaDto resultado = new EncuestaDto();
        try
        {
            DaoEncuesta dao = new DaoEncuesta();
            Encuesta encuesta = new Encuesta();
            Encuesta.set_fechacreacion( EncuestaDto.getfechacreacion() );
            Encuesta.set_estatus( EncuestaDto.getestatus() );
            Encuesta resul = dao.insert( encuesta );
            resultado.setId( resul.get_id() );

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }
    @PUT
    @Path( "/changeEncuesta" )
    public EncuestaDto changeEncuesta( EncuestaDto EncuestaDto ) throws Exception
    {
        EncuestaDto resultado = new EncuestaDto();
        try
        {
            DaoEncuesta dao = new  DaoEncuesta();
            Encuesta encuesta = new Encuesta(EncuestaDto.getId());
            Encuesta.set_fechacreacion( EncuestaDto.getfechacreacion() );
            Encuesta.set_estatus( EncuestaDto.getestatus() );
            Encuesta resul = dao.update( encuesta );
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
    public EncuestaDto deleteEncuesta( long id )
    {
        EncuestaDto resultado = new EncuestaDto();
        try
        {
            DaoEncuesta dao = new  DaoEncuesta();
            Encuesta delete = dao.find( id,Encuesta.class );
            Encuesta resul = dao.delete( delete);
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
    public EncuestaDto findEncuesta( long id )
    {
        EncuestaDto resultado = new EncuestaDto();
        try
        {
            DaoEncuesta dao = new  DaoEncuesta();
            Encuesta resul = dao.find( id,Encuesta.class );
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

