package ucab.dsw.servicio;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ucab.dsw.accesodatos.DaoOpcion;
import ucab.dsw.dtos.OpcionDto;
import ucab.dsw.entidades.Opcion;
import ucab.dsw.entidades.Pregunta;

/**
 *
 * @author Omar David
 */
@Path( "/prueba" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class PruebaOpcion {
    @PUT
    @Path("/addopcion")
    public OpcionDto addOpcion (OpcionDto opcionDto){
        OpcionDto resultado = new OpcionDto();
        
        try {
            DaoOpcion dao = new DaoOpcion();
            Opcion opcion = new Opcion();
            opcion.setDescripcion(opcionDto.getDescripcion());
            opcion.set_estatus(opcionDto.getEstatus());
            Pregunta pregunta = new ucab.dsw.entidades.Pregunta(opcionDto.getPreguntaDto().getId());
            opcion.setIdPregunta(pregunta);
            Opcion resul = dao.insert(opcion);
            resultado.setId(resul.get_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    @PUT
    @Path( "/changeopcion" )
    public OpcionDto changeOpcion (OpcionDto opcionDto){
        OpcionDto resultado = new OpcionDto();

        try {
            DaoOpcion dao = new DaoOpcion();
            Opcion opcion = new Opcion(opcionDto.getId());
            opcion.setDescripcion(opcionDto.getDescripcion());
            opcion.set_estatus(opcionDto.getEstatus());
            Pregunta pregunta = new Pregunta(opcionDto.getPreguntaDto().getId());
            opcion.setIdPregunta(pregunta);
            Opcion resul = dao.update(opcion);
            resultado.setId(resul.get_id());
        }catch ( Exception ex ){
            String problema = ex.getMessage();
        }

        return resultado;
    }

    @PUT
    @Path( "/deleteopcion" )
    public OpcionDto deleteOpcion( long id ) {
        OpcionDto resultado = new OpcionDto();
        try
        {
            DaoOpcion dao = new DaoOpcion();
            Opcion delete = dao.find( id, Opcion.class );
            Opcion resul = dao.delete( delete );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;        
    }

    @PUT
    @Path( "/showopcion" )
    public OpcionDto showOpcion( long id )
    {
        OpcionDto resultado = new OpcionDto();
        try {
            DaoOpcion dao = new DaoOpcion();
            Opcion resul = dao.find( id, Opcion.class );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }
}
