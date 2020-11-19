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
public class pruebaEstudio extends AplicacionBase{
    @PUT
    @Path( "/addestudio" )
    public EstudioDto addEstudio( EstudioDto estudioDto )
    {
        EstudioDto resultado = new EstudioDto();
        try
        {
            DaoEstudio dao = new DaoEstudio();
            Estudio estudio = new Estudio();
            estudio.setFechaCreacion(estudioDto.getFechaCreacion());
            estudio.set_estatus(estudioDto.getEstatus());
            Usuario usuario=new Usuario(estudioDto.getUsuarioDto().getId());
            estudio.setIdusuario(usuario);
            solicitud Solicitud=new solicitud(estudioDto.getSolicitudDto().getId());
            estudio.setIdsolicitud(Solicitud);
            Estudio resul = dao.insert(estudio);
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }
}
