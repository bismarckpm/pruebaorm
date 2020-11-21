package ucab.dsw.servicio;
import ucab.dsw.accesodatos.DaoSolicitud;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.entidades.Solicitud;
import ucab.dsw.entidades.Usuario;
import ucab.dsw.entidades.SubCategoria;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.*;


@Path( "/solicitud" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class SolicitudS {
    
    @POST
    @Path( "/addsolicitud" )
    public SolicitudDto addSolicitud( SolicitudDto solicitudDto )
    {
        SolicitudDto resultado = new SolicitudDto();
        try
        {
            DaoSolicitud dao = new DaoSolicitud();
            Solicitud solicitud = new Solicitud();
            solicitud.set_nombre( solicitudDto.getNombre() );
            solicitud.set_fecha( solicitudDto.getfecha() );
            solicitud.set_estatus( solicitudDto.getEstatus() );
            /*SubCategoria subCategoria = new SubCategoria(solicitudDto.getSubcategoriaDto().getId());
            solicitud.set_subcategoria( subCategoria );*/
            Usuario usuario = new Usuario(solicitudDto.getUsuarioDto().getId());
            solicitud.set_usuario( usuario );
            Solicitud resul = dao.insert( solicitud );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }
    
    
    @GET
    @Path("/getsolicitud/{id}")
    public SolicitudDto getSolicitud(@PathParam("id") long id, SolicitudDto solicitudDto){
        SolicitudDto res = new SolicitudDto();
        try{
            DaoSolicitud dao = new DaoSolicitud();
            Solicitud solicitud = dao.find(id, Solicitud.class);
            res.setId(solicitud.get_id());
        }catch (Exception ex){
            String problema = ex.getMessage();
        }
        return res;
    }
    
    @PUT
    @Path("/updatesolicitud/{id}")
    public SolicitudDto updateSolicitud(@PathParam("id") long id, SolicitudDto solicitudDto){
        SolicitudDto res = new SolicitudDto();
        try{
            DaoSolicitud dao = new DaoSolicitud();
            Solicitud solicitud = dao.find(id, Solicitud.class);
            solicitud.set_nombre( solicitudDto.getNombre() );
            solicitud.set_fecha( solicitudDto.getfecha() );
            solicitud.set_estatus( solicitudDto.getEstatus() );
            Solicitud r = dao.update(solicitud);
            /*SubCategoria subCategoria = new SubCategoria(solicitudDto.getSubcategoriaDto().getId());
            solicitud.set_subcategoria( subCategoria );*/
            Usuario usuario = new Usuario(solicitudDto.getUsuarioDto().getId());
            solicitud.set_usuario( usuario );
            res.setId(r.get_id());
        }catch (Exception ex){ 
            String problema = ex.getMessage();
        }
        return res;
    }
    
    
    @DELETE
    @Path("/deletesolicitud/{id}")
    public SolicitudDto deleteCategoria (@PathParam("id") long id, SolicitudDto solicitudDto){
        SolicitudDto res = new SolicitudDto();
        try{
            DaoSolicitud dao = new DaoSolicitud();
            Solicitud solicitud = dao.find(id, Solicitud.class);
            Solicitud r = dao.delete(solicitud);
            res.setId(r.get_id());
        }catch (Exception ex){ 
            String problema = ex.getMessage();
        }
        return res;
    }
}
