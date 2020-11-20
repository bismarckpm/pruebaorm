package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoSolicitud;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.entidades.SolicitudEnt;
import ucab.dsw.entidades.SubcategoriaEnt;
import ucab.dsw.entidades.Usuario;
import ucab.dsw.servicio.AplicacionBase;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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

}
