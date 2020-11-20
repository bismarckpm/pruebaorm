package ucab.dsw.servicio;
import com.sun.org.apache.bcel.internal.ExceptionConst;
import ucab.dsw.accesodatos.Dao;
import ucab.dsw.accesodatos.DaoCategoria;
import ucab.dsw.accesodatos.DaoSolicitud;
import ucab.dsw.accesodatos.DaoUsuario;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.entidades.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/solicitud")
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class SolicitudCrud extends AplicacionBase{


    @POST
    @Path("/addSolicitud")
    public SolicitudDto addSolicitud(SolicitudDto solicitudDto){
        SolicitudDto resultado = new SolicitudDto();
        try{

            DaoSolicitud dao = new DaoSolicitud();
            Solicitud solicitud = new Solicitud();
            solicitud.set_nombre(solicitudDto.getNombre());
            solicitud.set_fecha(solicitudDto.getFecha());
            solicitud.set_estatus(solicitudDto.getEstatus());
            Usuario usuario = new Usuario(solicitudDto.getUsuarioDto().getId());
            solicitud.set_usuario(usuario);
            Subcategoria subcategoria = new Subcategoria(solicitudDto.getSubcategoriaDto().getId());
            solicitud.set_subcategoria(subcategoria);
            Solicitud resul = dao.insert(solicitud);
            resultado.setId( resul.get_id() );

        }catch(Exception ex){
            String problem = ex.getMessage();

        }
            return resultado;
    }


    @PUT
    @Path("/updateSolicitud/{id}")
    public SolicitudDto updateSolicitud(@PathParam("id") long id,SolicitudDto solicitudDto){
        SolicitudDto resultado = new SolicitudDto();
        try{
            DaoSolicitud dao = new DaoSolicitud();
            Solicitud solicitud = dao.find(id, Solicitud.class);

            if(solicitud != null){
                solicitud.set_nombre(solicitudDto.getNombre());
                solicitud.set_fecha(solicitudDto.getFecha());
                solicitud.set_estatus(solicitudDto.getEstatus());
                Usuario usuario = new Usuario(solicitudDto.getUsuarioDto().getId());
                Subcategoria subcategoria = new Subcategoria(solicitudDto.getSubcategoriaDto().getId());
                solicitud.set_usuario(usuario);
                solicitud.set_subcategoria(subcategoria);
                Solicitud resul = dao.update(solicitud);
                resultado.setId(resul.get_id());
            }
        }catch (Exception ex){
            String problem = ex.getMessage();
        }
        return resultado;
    }

    @DELETE
    @Path("/deleteSolicitud/{id}")
    public SolicitudDto deleteSolicitud (@PathParam("id") long id){
        SolicitudDto resultado = new SolicitudDto();

        try{
            DaoSolicitud dao = new DaoSolicitud();
            Solicitud solicitud = dao.find(id,Solicitud.class);

            if(solicitud != null){
                Solicitud resul = dao.delete(solicitud);
                resultado.setId(resul.get_id());
            }
        }catch (Exception ex){
            String problem = ex.getMessage();
        }
        return resultado;
    }

    @GET
    @Path("/showSolicitud")
    public List<Solicitud> showSolicitudes(){
        List<Solicitud> solicitudes = null;
        try{
         DaoSolicitud dao = new DaoSolicitud();
         solicitudes = dao.findAll(Solicitud.class);
        }catch (Exception ex){
            String problem = ex.getMessage();
        }
        return solicitudes;
    }
}
