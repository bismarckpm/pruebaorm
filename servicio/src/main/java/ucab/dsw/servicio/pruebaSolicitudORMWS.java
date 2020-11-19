package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoSolicitud;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.entidades.Subcategoria;
import ucab.dsw.entidades.Solicitud;
import ucab.dsw.entidades.Usuario;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path( "/solicitud" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class pruebaSolicitudORMWS extends AplicacionBase{
    @POST
    @Path( "/add" )
    public SolicitudDto addSolicitud(SolicitudDto SolicitudDto)
    {
        SolicitudDto resultado = new SolicitudDto();
        try
        {
            DaoSolicitud dao = new DaoSolicitud();
            Solicitud solicitud = new Solicitud();
            solicitud.set_nombre(SolicitudDto.getNombre());
            solicitud.set_estatus( SolicitudDto.getEstatus() );
            solicitud.set_fecha(SolicitudDto.getFecha());

            Subcategoria subcategoria=new Subcategoria(SolicitudDto.getSubcategoriaDto().getId());
            solicitud.set_subcategoria(subcategoria);

            Usuario usuario=new Usuario(SolicitudDto.getUsuarioDto().getId());
            solicitud.set_usuarioSolicitud(usuario);

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
    @Path( "/delete/{id}" )
    public SolicitudDto deleteSolicitud(@PathParam("id") long  _id)
    {
        SolicitudDto resultado = new SolicitudDto();
        try
        {
            DaoSolicitud dao = new DaoSolicitud();
            Solicitud solicitud = dao.find(_id,Solicitud.class);
            Solicitud resul = dao.delete(solicitud);
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }


    @PUT
    @Path( "/edit/{id}" )
    public SolicitudDto editSolicitud(@PathParam("id") long _id, SolicitudDto SolicitudDto)
    {
        SolicitudDto resultado = new SolicitudDto();
        try
        {
            DaoSolicitud dao = new DaoSolicitud();
            Solicitud solicitud = dao.find(_id,Solicitud.class);
            solicitud.set_nombre(SolicitudDto.getNombre());
            solicitud.set_estatus( SolicitudDto.getEstatus() );
            solicitud.set_fecha(SolicitudDto.getFecha());

            Subcategoria subcategoria=new Subcategoria(SolicitudDto.getSubcategoriaDto().getId());
            solicitud.set_subcategoria(subcategoria);

            Usuario usuario=new Usuario(SolicitudDto.getUsuarioDto().getId());
            solicitud.set_usuarioSolicitud(usuario);

            Solicitud resul = dao.update(solicitud);
            resultado.setId( resul.get_id() );

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path( "/{id}" )
    public SolicitudDto getSolicitud(@PathParam("id") long  _id)
    {
        SolicitudDto resultado = new SolicitudDto();
        try
        {
            DaoSolicitud dao = new DaoSolicitud();
            Solicitud solicitud = dao.find(_id,Solicitud.class);
            resultado.setId( solicitud.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }
}
