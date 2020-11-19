package ucab.dsw.servicio;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path( "/solicitud" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class SolicitudControlador extends AplicacionBase {
    /*
    //SOLICITUDES
    @POST
    @Path( "/new" )
    public SolicitudDto addSolicitud(SolicitudDto SolicitudData) {

    }

    @PUT
    @Path( "/update" )
    public SolicitudDto updSolicitud(SolicitudDto SolicitudData) {

    }

    @GET
    @Path( "/all" )
    public List<SolicitudDto> getAllSolicitud() {

    }

    @GET
    @Path( "/:s_id/:u_id" )
    public SolicitudDto getSolicitud(){

    }

    @DELETE
    @Path( "/delete" )
    public SolicitudDto deleteSolicitud(){

    }
    */
}
