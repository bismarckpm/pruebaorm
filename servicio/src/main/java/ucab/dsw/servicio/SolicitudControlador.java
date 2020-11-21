package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoSolicitud;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.entidades.Solicitud;
import ucab.dsw.entidades.SubCategoria;
import ucab.dsw.entidades.Usuario;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path( "/solicitud" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class SolicitudControlador extends AplicacionBase {

    @Path( "/new" )
    public SolicitudDto addSolicitud(SolicitudDto solicitudDto ){
        SolicitudDto resultado = new SolicitudDto();
        String err = new String();
        try
        {
            DaoSolicitud dao = new DaoSolicitud();
            Solicitud solicitud = new Solicitud();
            //REL
            solicitud.set_SubCategoria(new SubCategoria(solicitudDto.get_SubCategoria().getId()));
            solicitud.set_Usuario(new Usuario(solicitudDto.get_Usuario().getId()));
            //OWN
            solicitud.set_estatus(solicitudDto.get_estatus());
            solicitud.set_creado(solicitudDto.get_Fecha());
            solicitud.set_Nombre(solicitudDto.get_Nombre());

            Solicitud result = dao.insert(solicitud);
            resultado.setId(result.get_id());
        }
        catch ( Exception ex )
        {
            err = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path( "ext/:tp_id" )
    public SolicitudDto obtenerSolicitud(long tp_id){
        SolicitudDto resultado = new SolicitudDto();
        String err = new String();
        try{
            DaoSolicitud dao = new DaoSolicitud();
            Solicitud encontrado = dao.find( tp_id,Solicitud.class);
            resultado.setId(encontrado.get_id());
            resultado.setNombre( encontrado.getNombre());
        }catch (Exception e){
            err = e.getMessage();
        }

        return resultado;
    }

    @PUT
    @Path( "/update/:tp_id" )
    public SolicitudDto updateSolicitud(SolicitudDto solicitudDto){
        SolicitudDto resultado = new SolicitudDto();
        String err = new String();
        try{
            DaoSolicitud dao = new DaoSolicitud();
            Solicitud updSolicitud = new Solicitud(solicitudDto.getId());
            //REL
            updSolicitud.set_SubCategoria(new SubCategoria(solicitudDto.get_SubCategoria().getId()));
            updSolicitud.set_Usuario(new Usuario(solicitudDto.get_Usuario().getId()));
            //OWN
            updSolicitud.set_estatus(solicitudDto.get_estatus());
            updSolicitud.set_creado(solicitudDto.get_Fecha());
            updSolicitud.set_Nombre("upd_nombre");
            Solicitud resul = dao.update(updSolicitud);
            resultado.setId( resul.get_id());
        }catch (Exception e){
            err = e.getMessage();
        }
        return resultado;
    }

    @DELETE
    @Path( "/delete/:tp_id" )
    public SolicitudDto deleteSolicitud(long id){
        SolicitudDto resultado = new SolicitudDto();
        String err = new String();
        try{
            DaoSolicitud dao = new DaoSolicitud();
            Solicitud paraBorrar = dao.find( id, Solicitud.class);
            Solicitud resul = dao.delete(paraBorrar);
            resultado.setId(resul.get_id());
        }catch (Exception e){
           err = e.getMessage();
        }
        return resultado;
    }

}
