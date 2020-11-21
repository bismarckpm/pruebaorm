package ucab.dsw.servicio;

import ucab.dsw.accesodatos.*;
import ucab.dsw.dtos.*;
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
public class PruebaEjecucionEncuesta extends AplicacionBase{
    @PUT
    @Path( "/addejecucionencuesta" )
    public DtoEjecucionEncuesta addEjecucionEncuesta( EncuestaDto encuestaDto )
    {
        DtoEjecucionEncuesta resultado = new DtoEjecucionEncuesta();
        try
        {
            DaoEjecucionEncuesta dao = new DaoEjecucionEncuesta();
            Ejecucionencuesta encuesta = new Ejecucionencuesta();

            encuesta.set_estatus(encuestaDto.getEstatus());
            Usuario usuarioencuestado= new Usuario(encuestaDto.getUsuarioDtoCreador().getId());
            encuesta.setidUsuarioEncuestado(usuarioencuestado);

            Pregunta pregunta= new Pregunta(DtoEjecucionEncuestaDto.getPregunta().getId());
            encuesta.setIdPregunta(estudio);
            Encuesta resul = dao.insert(encuesta);
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return resultado;
    }
}

