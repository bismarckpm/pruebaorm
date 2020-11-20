package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoOpcion;
import ucab.dsw.accesodatos.DaoSolicitud;
import ucab.dsw.dtos.OpcionDto;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.entidades.Opcion;
import ucab.dsw.entidades.Pregunta;
import ucab.dsw.entidades.Solicitud;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path( "/prueba" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class prueba_Opcion extends AplicacionBase{
    @PUT
    @Path( "/addOpcion" )
    public OpcionDto addOpcion(OpcionDto OpcionDto ) throws Exception {
        OpcionDto resultado = new OpcionDto();
        try {
            DaoOpcion dao = new DaoOpcion();
            Opcion opcion = new Opcion();

            opcion.set_descripcion(OpcionDto.getDescripcion());
            opcion.set_estatus(OpcionDto.getEstatus());
            Pregunta idPregunta = new Pregunta(OpcionDto.getIdPregunta().getId());
            opcion.set_idPregunta(idPregunta);

            Opcion resul = dao.insert( opcion );
            resultado.setId( resul.get_id() );
        } catch ( Exception ex ) {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @PUT
    @Path( "/changeOpcion" )
    public OpcionDto changeOpcion(OpcionDto OpcionDto ) throws Exception {
        OpcionDto resultado = new OpcionDto();
        try {
            DaoOpcion dao = new DaoOpcion();
            Opcion opcion = new Opcion(OpcionDto.getId());

            opcion.set_descripcion(OpcionDto.getDescripcion());
            opcion.set_estatus(OpcionDto.getEstatus());
            Pregunta idPregunta = new Pregunta(OpcionDto.getIdPregunta().getId());
            opcion.set_idPregunta(idPregunta);

            Opcion resul = dao.update( opcion );
            resultado.setId( resul.get_id() );
        } catch ( Exception ex ) {
            String problema = ex.getMessage();
        }
        return  resultado;
    }
    @PUT
    @Path( "/{id}" )
    public OpcionDto deleteOpcion(long id ){
        OpcionDto resultado = new OpcionDto();
        try {
            DaoOpcion dao = new DaoOpcion();
            Opcion delete = dao.find( id,Opcion.class );
            Opcion resul = dao.delete( delete);
            resultado.setId( resul.get_id() );
        } catch ( Exception ex ) {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @PUT
    @Path( "/{id}" )
    public OpcionDto findOpcion(long id ) {
        OpcionDto resultado = new OpcionDto();
        try {
            DaoOpcion dao = new DaoOpcion();
            Opcion resul = dao.find( id,Opcion.class );
            resultado.setId( resul.get_id() );
        } catch ( Exception ex ) {
            String problema = ex.getMessage();
        }
        return  resultado;
    }
}
