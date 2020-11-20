package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoCategoria;
import ucab.dsw.accesodatos.DaoSolicitud;
import ucab.dsw.accesodatos.DaoSubCategoria;
import ucab.dsw.accesodatos.DaoUsuario;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.dtos.SubCategoriaDto;
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
    @Path( "/addSolicitud" )
    public SolicitudDto addSolicitud(SolicitudDto solicitudDto )
    {
        SolicitudDto resultado = new SolicitudDto();
        try
        {
            DaoSolicitud dao = new DaoSolicitud();
            Solicitud solicitud = new Solicitud();
            solicitud.set_nombre( solicitudDto.getNombre());
            solicitud.set_fecha( solicitudDto.getFecha());
            solicitud.set_estatus (solicitudDto.getEstatus());
            Usuario usuario = new Usuario(solicitudDto.getUsuarioDto().getId());
            solicitud.set_usuario( usuario );
            SubCategoria subcategoria = new SubCategoria(solicitudDto.getSubCategoriaDto().getId());
            solicitud.set_subcategoria( subcategoria );
            Solicitud resul = dao.insert( solicitud );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @PUT
    @Path( "/updateSolicitud/{id}" )
    public SolicitudDto updateSolicitud( SolicitudDto solicitudDto)
    {
        SolicitudDto resultado = new SolicitudDto();
        try
        {
            DaoSolicitud dao = new DaoSolicitud();
            Solicitud solicitud = new Solicitud(solicitudDto.getId());
            solicitud.set_nombre( solicitudDto.getNombre());
            Usuario usuario = new Usuario(solicitudDto.getUsuarioDto().getId());
            solicitud.set_usuario( usuario );
            SubCategoria subcategoria = new SubCategoria(solicitudDto.getSubCategoriaDto().getId());
            solicitud.set_subcategoria( subcategoria );
            subcategoria.set_estatus (solicitudDto.getEstatus());
            Solicitud resul = dao.update ( solicitud );
            resultado.setId(resul.get_id());

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @DELETE
    @Path( "/deleteSolicitud/{id}" )
    public SolicitudDto deleteSolicitud( SolicitudDto solicitudDto) {
        SolicitudDto resultado = new SolicitudDto();
        try {
            DaoSolicitud dao = new DaoSolicitud();
            Solicitud solicitud = dao.find(solicitudDto.getId(), Solicitud.class);
            Solicitud resul = dao.delete(solicitud);
            resultado.setId(resul.get_id());

        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }
}
