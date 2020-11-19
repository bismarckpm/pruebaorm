package ucab.dsw.servicio;
import ucab.dsw.accesodatos.DaoEjecucionEncuesta;
import ucab.dsw.dtos.EjecucionEncuestaDto;
import ucab.dsw.entidades.EjecucionEncuesta;

import javax.servlet.http.HttpServletRequest;
import javax.faces.push.Push;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path( "/ejecucionEncuesta" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class ejecucionEncuestaORMWS {
    
    @PUT
    @Path( "/agregar" )
    public EjecucionEncuestaDto addEjecucionEncuesta(EjecucionEncuestaDto ejecucionEncuestaDto )
    {
        EjecucionEncuestaDto resultado = new EjecucionEncuestaDto();
        try
        {
            DaoEjecucionEncuesta dao = new DaoEjecucionEncuesta();
            EjecucionEncuesta ejecucionEncuesta = new EjecucionEncuesta();
            ejecucionEncuesta.set_descripcion( ejecucionEncuestaDto.getDescripcion() );
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

    @GET
    @Path("/buscar")
    public List<EjecucionEncuesta> showEjecucionEncuesta()
    {
        List<EjecucionEncuesta> ejecucionEncuestas = null;
        try {
            DaoEjecucionEncuesta dao = new DaoEjecucionEncuesta();
            ejecucionEncuestas = dao.findAll(EjecucionEncuesta.class);
            System.out.println("EjecucionEncuestas: ");
            for(EjecucionEncuesta ejecucionEncuesta : ejecucionEncuestas) {
                System.out.print(ejecucionEncuesta.get_id());
                System.out.print(", ");
                System.out.print(ejecucionEncuesta.get_descripcion());
                System.out.print(", ");
                System.out.print(ejecucionEncuesta.get_estatus());
                System.out.println();
            }
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return ejecucionEncuestas;
    }

    @PUT
    @Path( "/actualizar/{id}" )
    public EjecucionEncuestaDto editEjecucionEncuesta( EjecucionEncuestaDto ejecucionEncuestaDto)
    {
        EjecucionEncuestaDto resultado = new EjecucionEncuestaDto();
        try
        {
            DaoEjecucionEncuesta dao = new DaoEjecucionEncuesta();
            EjecucionEncuesta ejecucionEncuesta = new EjecucionEncuesta(ejecucionEncuestaDto.getId());
            ejecucionEncuesta.set_descripcion( ejecucionEncuestaDto.getDescripcion());
            ejecucionEncuesta.set_estatus (ejecucionEncuestaDto.getEstatus());
            EjecucionEncuesta resul = dao.update (ejecucionEncuesta );
            resultado.setId(resul.get_id());

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @DELETE
    @Path( "/borrar/{id}" )
    public EjecucionEncuestaDto deleteEjecucionEncuesta( EjecucionEncuestaDto ejecucionEncuestaDto)
    {
        EjecucionEncuestaDto resultado = new EjecucionEncuestaDto();
        try
        {
            DaoEjecucionEncuesta dao = new DaoEjecucionEncuesta();
            EjecucionEncuesta ejecucionEncuesta = dao.find(ejecucionEncuestaDto.getId(), EjecucionEncuesta.class);
            EjecucionEncuesta resul = dao.delete (ejecucionEncuesta );
            resultado.setId(resul.get_id());

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }
}
