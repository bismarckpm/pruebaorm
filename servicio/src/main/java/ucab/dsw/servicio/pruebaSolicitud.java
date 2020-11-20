package ucab.dsw.servicio;
import ucab.dsw.accesodatos.*;
import ucab.dsw.dtos.*;
import ucab.dsw.entidades.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
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

    @DELETE
    @Path( "/eliminarsolicitud" )
    public void eliminarSolicitud(SolicitudDto SOLdto )
    {
        SolicitudDto resultado = new SolicitudDto();
        try
        {
            DaoSolicitud dao = new DaoSolicitud();
            solicitud S=new solicitud(SOLdto.getId());
            solicitud Seliminar=dao.find(S.get_id(),solicitud.class);
            S.set_subCategoria(Seliminar.get_subCategoria());
            S.set_usuario(Seliminar.get_usuario());
            S.set_estatus("I");
            S.setNombre(Seliminar.getNombre());
            S.setFecha(Seliminar.getFecha());
            solicitud resul = dao.update( S );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
    }

    @POST
    @Path( "/actualizarsolicitud" )
    public void actualizarolicitud(SolicitudDto SOLdto )
    {
        SolicitudDto resultado = new SolicitudDto();
        try
        {
            DaoSolicitud dao = new DaoSolicitud();
            solicitud S=new solicitud(SOLdto.getId());
            solicitud Sactualizar=dao.find(S.get_id(),solicitud.class);
            if(SOLdto.getEstatus()!=null){
                S.set_estatus(SOLdto.getEstatus());
            }else{S.set_estatus(Sactualizar.get_estatus());}
            if(SOLdto.getFecha()!=null){
                S.setFecha(SOLdto.getFecha());
            }else{S.setFecha(Sactualizar.getFecha());}
            if(SOLdto.getNombre()!=null){
                S.setNombre(SOLdto.getNombre());
            }else{S.setNombre(Sactualizar.getNombre());}
            S.set_usuario(Sactualizar.get_usuario());
            S.set_subCategoria(Sactualizar.get_subCategoria());
            solicitud resul = dao.update( S );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
    }

    @GET
    @Path( "/leersolicitud" )
    public void leerSolicitud(SolicitudDto SOLdto )
    {
        SolicitudDto resultado = new SolicitudDto();
        try
        {
            DaoSolicitud dao = new DaoSolicitud();
            solicitud S=new solicitud(SOLdto.getId());
            solicitud resul=dao.find(S.get_id(),solicitud.class);
            System.out.println("Datos del Estudio:\n");
            System.out.println("Id="+resul.get_id()+"\n");
            System.out.println("Estatus="+resul.get_estatus()+"\n");
            System.out.println("Nombre="+resul.getNombre()+"\n");
            System.out.println("Fecha="+resul.getFecha()+"\n");
            System.out.println("Usuario="+resul.get_usuario()+"\n");
            System.out.println("Sub categoria="+resul.get_subCategoria()+"\n");
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
    }
}
