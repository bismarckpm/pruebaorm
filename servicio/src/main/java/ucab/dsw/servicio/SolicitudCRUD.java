package ucab.dsw.servicio;

import ucab.dsw.accesodatos.Dao;
import ucab.dsw.accesodatos.DaoSolicitud;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.entidades.SolicitudEnt;
import ucab.dsw.entidades.SubcategoriaEnt;
import ucab.dsw.entidades.Usuario;
import ucab.dsw.servicio.AplicacionBase;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path( "/Solicitud" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class SolicitudCRUD extends AplicacionBase {

    @PUT
    @Path( "/addSolicitud" )
    public SolicitudDto addSolicitud(SolicitudDto SolicitudDto )
    {
        SolicitudDto resultado = new SolicitudDto();
        try
        {
            DaoSolicitud dao = new DaoSolicitud();
            SolicitudEnt Solicitud = new SolicitudEnt();
            Solicitud.setNombre(SolicitudDto.getNombre());
            Solicitud.setFecha(SolicitudDto.getFecha());
            Solicitud.set_estatus(SolicitudDto.getEstatus());
            SubcategoriaEnt subcategoriaEnt = new SubcategoriaEnt(SolicitudDto.getSubcategoria().getId());
            Solicitud.setSubcategoria(subcategoriaEnt);
            Usuario usuario = new Usuario(SolicitudDto.getUsuario().getId());
            Solicitud.setUsuario(usuario);
            SolicitudEnt resul = dao.insert( Solicitud );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path("/getSolicitud")
    public List<SolicitudEnt> getSolicitudes() {

        List<SolicitudEnt> solicitudes = null;
        try {
            DaoSolicitud dao = new DaoSolicitud();
            solicitudes = dao.findAll(SolicitudEnt.class);
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        for (SolicitudEnt obj : solicitudes) {
            System.out.println(obj.getNombre());
        }
        return solicitudes;
    }

    @PUT
    @Path("/updateSolicitud/{id}")
    public SolicitudDto updateSolicitud(@PathParam("id") long id, SolicitudDto solicitudDto) {
        SolicitudDto resultado = new SolicitudDto();
        try {
            DaoSolicitud dao = new DaoSolicitud();
            SolicitudEnt solicitud = dao.find(id, SolicitudEnt.class);
            solicitud.setNombre(solicitudDto.getNombre());
            solicitud.set_estatus(solicitudDto.getEstatus());
            solicitud.setFecha(solicitudDto.getFecha());
            SubcategoriaEnt subcategoriaEnt = new SubcategoriaEnt(solicitudDto.getSubcategoria().getId());
            solicitud.setSubcategoria(subcategoriaEnt);
            Usuario usuario = new Usuario(solicitudDto.getUsuario().getId());
            solicitud.setUsuario(usuario);
            SolicitudEnt resul = dao.update(solicitud);
            resultado.setId(resul.get_id());
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }

    @DELETE
    @Path("/deleteSolicitud/{id}")
    public SolicitudDto deleteSolicitud(@PathParam("id") long id)
    {
        SolicitudDto resultado = new SolicitudDto();
        try
        {
            DaoSolicitud dao = new DaoSolicitud();
            SolicitudEnt solicitud = dao.find(id, SolicitudEnt.class);
            if(solicitud != null) {
                SolicitudEnt resul = dao.delete(solicitud);
                resultado.setId(resul.get_id());
            }
        }
        catch (Exception er){
            String problema = er.getMessage();
        }
        return resultado;
    }

}
