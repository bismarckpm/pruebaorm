package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoPregunta;
import ucab.dsw.accesodatos.DaoSolicitud;
import ucab.dsw.dtos.PreguntaDto;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.entidades.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path( "/prueba" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class prueba_Solicitud extends AplicacionBase{
    @PUT
    @Path( "/addSolicitud" )
    public SolicitudDto addSolicitud(SolicitudDto SolicitudDto ) throws Exception {
        SolicitudDto resultado = new SolicitudDto();
        try {
            DaoSolicitud dao = new DaoSolicitud();
            Solicitud solicitud = new Solicitud();

            solicitud.set_nombre(SolicitudDto.getNombre());
            solicitud.set_fecha(SolicitudDto.getFecha());
            solicitud.set_estatus(SolicitudDto.getEstatus());
            Usuario idUsuario = new Usuario(SolicitudDto.getIdUsuario().getId());
            solicitud.set_idUsuario(idUsuario);
            SubCategoria idSubCategoria = new SubCategoria(SolicitudDto.getIdSubCategoria().getId());
            solicitud.set_idSubCategoria(idSubCategoria);

            Solicitud resul = dao.insert( solicitud );
            resultado.setId( resul.get_id() );
        } catch ( Exception ex ) {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @PUT
    @Path( "/changeSolicitud" )
    public SolicitudDto changeSolicitud(SolicitudDto SolicitudDto ) throws Exception {
        SolicitudDto resultado = new SolicitudDto();
        try {
            DaoSolicitud dao = new DaoSolicitud();
            Solicitud solicitud = new Solicitud(SolicitudDto.getId());

            solicitud.set_nombre(SolicitudDto.getNombre());
            solicitud.set_fecha(SolicitudDto.getFecha());
            solicitud.set_estatus(SolicitudDto.getEstatus());
            Usuario idUsuario = new Usuario(SolicitudDto.getIdUsuario().getId());
            solicitud.set_idUsuario(idUsuario);
            SubCategoria idSubCategoria = new SubCategoria(SolicitudDto.getIdSubCategoria().getId());
            solicitud.set_idSubCategoria(idSubCategoria);

            Solicitud resul = dao.update( solicitud );
            resultado.setId( resul.get_id() );
        } catch ( Exception ex ) {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @PUT
    @Path( "/{id}" )
    public SolicitudDto deleteSolicitud( long id ){
        SolicitudDto resultado = new SolicitudDto();
        try {
            DaoSolicitud dao = new DaoSolicitud();
            Solicitud delete = dao.find( id,Solicitud.class );
            Solicitud resul = dao.delete( delete);
            resultado.setId( resul.get_id() );
        } catch ( Exception ex ) {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @PUT
    @Path( "/{id}" )
    public SolicitudDto findSolicitud(long id ) {
        SolicitudDto resultado = new SolicitudDto();
        try {
            DaoSolicitud dao = new  DaoSolicitud();
            Solicitud resul = dao.find( id,Solicitud.class );
            resultado.setId( resul.get_id() );
        } catch ( Exception ex ) {
            String problema = ex.getMessage();
        }
        return  resultado;
    }
}
