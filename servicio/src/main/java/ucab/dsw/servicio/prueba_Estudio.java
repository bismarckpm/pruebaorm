package ucab.dsw.servicio;
import ucab.dsw.accesodatos.DaoEstudio;
import ucab.dsw.dtos.EstudioDto;

import ucab.dsw.entidades.Estudio;
import ucab.dsw.entidades.Solicitud;
import ucab.dsw.entidades.Usuario;
import ucab.dsw.entidades.Encuesta;


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
public class prueba_Estudio extends AplicacionBase
{
    @PUT
    @Path( "/addEstudio" )
    public EstudioDto addEstudio( EstudioDto EstudioDto ) throws Exception
    {
        EstudioDto resultado = new EstudioDto();
        try
        {
            DaoEstudio dao = new DaoEstudio();
            Estudio encuesta = new Estudio();
            Estudio.set_fechacreacion( EstudioDto.getfechacreacion() );
            Estudio.set_estatus( EstudioDto.getestatus() );
            Estudio resul = dao.insert( encuesta );
            resultado.setId( resul.get_id() );

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }
    @PUT
    @Path( "/changeEstudio" )
    public EstudioDto changeEstudio( EstudioDto EstudioDto ) throws Exception
    {
        EstudioDto resultado = new EstudioDto();
        try
        {
            DaoEstudio dao = new  DaoEstudio();
            Estudio estudio = new Estudio(EstudioDto.getId());
            Estudio.set_fechacreacion( EstudioDto.getfechacreacion() );
            Estudio.set_estatus( EstudioDto.getestatus() );
            Estudio resul = dao.update( estudio );
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
    public EstudioDto deleteEstudio( long id )
    {
        EstudioDto resultado = new EstudioDto();
        try
        {
            DaoEstudio dao = new  DaoEstudio();
            Estudio delete = dao.find( id,Estudio.class );
            Estudio resul = dao.delete( delete);
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
    public EstudioDto findEstudio( long id )
    {
        EstudioDto resultado = new EstudioDto();
        try
        {
            DaoEstudio dao = new  DaoEstudio();
            Estudio resul = dao.find( id,Estudio.class );
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
