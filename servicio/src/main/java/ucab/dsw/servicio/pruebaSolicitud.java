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
public class pruebaSolicitud extends AplicacionBase{

    @PUT
    @Path( "/addsolicitud" )
    public SolicitudDto addSolicitud( SolicitudDto solicitudDto )
    {
        SolicitudDto resultado = new SolicitudDto();
        try
        {
            DaoSolicitud dao = new DaoSolicitud();
            solicitud Solicitud = new solicitud();
            Solicitud.setNombre(solicitudDto.getNombre());
            Solicitud.setFecha(solicitudDto.getFecha());
            Solicitud.set_estatus(solicitudDto.getEstatus());
            Usuario usuario=new Usuario(solicitudDto.getIdusuario().getId());
            Solicitud.set_usuario(usuario);
            subCategoria subcatego =new subCategoria(solicitudDto.getIdsubcategoria().getId());
            Solicitud.set_subCategoria(subcatego);
            solicitud resul = dao.insert(Solicitud);
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }
}
