package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoSolicitud;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.entidades.Solicitud;
import ucab.dsw.entidades.Subcategoria;
import ucab.dsw.entidades.Usuario;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created with IntelliJ IDEA.
 * Solicitud: Omar David
 * Date: 20/11/20
 * Time: 10:02 PM
 * To change this template use File | Settings | File Templates.
 */
@Path( "/prueba" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class PruebaSolicitud extends AplicacionBase
{
    @PUT
    @Path( "/addsolicitud" )
    public SolicitudDto addSolicitud( SolicitudDto solicitudDto )
    {
        SolicitudDto resultado = new SolicitudDto();
        try
        {
            DaoSolicitud dao = new DaoSolicitud();
            Solicitud solicitud = new Solicitud();
            solicitud.setNombre(solicitudDto.getNombre());
            solicitud.setFecha(solicitudDto.getFecha());
            solicitud.set_estatus(solicitudDto.getEstatus());
            Usuario usuario = new Usuario(solicitudDto.getUsuario().getId());
            Subcategoria subcategoria = new Subcategoria(solicitudDto.getSubcategoria().getId());
            solicitud.setUsuario(usuario);
            solicitud.setSubcategoria(subcategoria);
            Solicitud resul = dao.insert(solicitud);
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }
    @PUT
    @Path( "/changesolicitud" )
    public SolicitudDto changeSolicitud( SolicitudDto solicitudDto ) throws Exception
    {
        SolicitudDto resultado = new SolicitudDto();
        try
        {
            DaoSolicitud dao = new DaoSolicitud();
            Solicitud solicitud = new Solicitud(solicitudDto.getId());
            solicitud.setNombre(solicitudDto.getNombre());
            solicitud.setFecha(solicitudDto.getFecha());
            solicitud.set_estatus(solicitudDto.getEstatus());
            Usuario usuario = new Usuario(solicitudDto.getUsuario().getId());
            Subcategoria subcategoria = new Subcategoria(solicitudDto.getSubcategoria().getId());
            solicitud.setUsuario(usuario);
            solicitud.setSubcategoria(subcategoria);
            Solicitud resul = dao.update(solicitud);
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @PUT
    @Path( "/deletesolicitud" )
    public SolicitudDto deleteSolicitud( long id )
    {
        SolicitudDto resultado = new SolicitudDto();
        try
        {
            DaoSolicitud dao = new DaoSolicitud();
            Solicitud delete = dao.find( id, Solicitud.class );
            Solicitud resul = dao.delete( delete );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }


    @PUT
    @Path( "/showsolicitud" )
    public SolicitudDto showSolicitud( long id )
    {
        SolicitudDto resultado = new SolicitudDto();
        try {
            DaoSolicitud dao = new DaoSolicitud();
            Solicitud resul = dao.find( id, Solicitud.class );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

}
