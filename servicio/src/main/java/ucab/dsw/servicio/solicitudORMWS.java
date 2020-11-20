package ucab.dsw.servicio;
import ucab.dsw.accesodatos.DaoUsuario;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.TipoUsuario;
import ucab.dsw.entidades.Usuario;

import ucab.dsw.accesodatos.DaoCategoria;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.entidades.Categoria;

import ucab.dsw.accesodatos.DaoOpcion;
import ucab.dsw.dtos.OpcionDto;
import ucab.dsw.entidades.Opcion;

import ucab.dsw.accesodatos.DaoSolicitud;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.entidades.Solicitud;

import ucab.dsw.accesodatos.DaoPregunta;
import ucab.dsw.dtos.PreguntaDto;
import ucab.dsw.entidades.Pregunta;

import ucab.dsw.entidades.SubCategoria;
import ucab.dsw.entidades.TipoPregunta;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path( "/solicitud" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class solicitudORMWS extends AplicacionBase{

    @PUT
    @Path( "/addsolicitud" )
    public SolicitudDto addSolicitud( SolicitudDto solicitudDto )
    {
        SolicitudDto resultado = new SolicitudDto();
        try
        {
            DaoSolicitud dao = new DaoSolicitud();
            Solicitud solicitud = new Solicitud();
            solicitud.set_nombre( solicitudDto.getNombre() );
            solicitud.set_fecha( solicitudDto.getFecha() );
            solicitud.set_estatus( solicitudDto.getEstatus() );
            Usuario usuario = new Usuario(solicitudDto.getUsuarioDto().getId());
            solicitud.set_usuario( usuario );
            SubCategoria subCategoria = new SubCategoria(solicitudDto.getSubCategoriaDto().getId());
            solicitud.set_subCategoria( subCategoria );
            Solicitud resul = dao.insert( solicitud );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @DELETE
    @Path ("/deleteSolicitud/{id}")
    public SolicitudDto deleteSolicitud (@PathParam("id") long id){
        SolicitudDto resultado = new SolicitudDto();

        try{
            DaoSolicitud dao = new DaoSolicitud();
            Solicitud solicitud = dao.find(id, Solicitud.class);
            if(solicitud != null){
                Solicitud result = dao.delete(solicitud);
                resultado.setId(result.get_id());
            }
        }
        catch (Exception e){
            String problem = e.getMessage();
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
            System.out.println("Solicitudes:");
            for (Solicitud solicitud : solicitudes) {
                System.out.print(solicitud.get_id());
                System.out.print(", ");
                System.out.print(solicitud.get_estatus());
                System.out.print(", ");
                System.out.print(solicitud.get_fecha());
                System.out.print(", ");
                System.out.print(solicitud.get_nombre());
                System.out.print(", ");
                System.out.print(solicitud.get_subCategoria().get_descripcion());
                System.out.print(", ");
                System.out.print(solicitud.get_usuario().get_nombre());
                System.out.println("");

            }
        }
        catch(Exception e){
            String problem = e.getMessage();
        }
        return solicitudes;
    }

    @PUT
    @Path( "/updatesolicitud/{id}" )
    public SolicitudDto updateSolicitud( @PathParam("id") long id , SolicitudDto solicitudDto )
    {
        SolicitudDto resultado = new SolicitudDto();
        try
        {
            DaoSolicitud dao = new DaoSolicitud();
            Solicitud solicitud = dao.find(id, Solicitud.class);
            solicitud.set_nombre( solicitudDto.getNombre() );
            solicitud.set_fecha( solicitudDto.getFecha() );
            solicitud.set_estatus( solicitudDto.getEstatus() );
            Usuario usuario = new Usuario(solicitudDto.getUsuarioDto().getId());
            solicitud.set_usuario( usuario );
            SubCategoria subCategoria = new SubCategoria(solicitudDto.getSubCategoriaDto().getId());
            solicitud.set_subCategoria( subCategoria );
            Solicitud resul = dao.update( solicitud );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

}
