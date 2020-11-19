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
public class pruebaEncuesta extends AplicacionBase{
    @PUT
    @Path( "/addencuesta" )
    public EncuestaDto addEncuesta( EncuestaDto encuestaDto )
    {
        EncuestaDto resultado = new EncuestaDto();
        try
        {
            DaoEncuesta dao = new DaoEncuesta();
            Encuesta encuesta = new Encuesta();
            encuesta.setFechacreacion(encuestaDto.getFechaCreacion());
            encuesta.set_estatus(encuestaDto.getEstatus());
            Usuario usuarioCreador= new Usuario(encuestaDto.getUsuarioDtoCreador().getId());
            encuesta.setidUsuarioCreador(usuarioCreador);
            Usuario usuarioAnalista= new Usuario(encuestaDto.getUsuarioDtoAnalista().getId());
            encuesta.setidUsuarioAnalista(usuarioAnalista);
            Estudio estudio= new Estudio(encuestaDto.getEstudio().getId());
            encuesta.setIdEstudio(estudio);
            Encuesta resul = dao.insert(encuesta);
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }
}
