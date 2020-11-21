package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoEstudio;
import ucab.dsw.dtos.EstudioDto;
import ucab.dsw.entidades.Estudio;
import ucab.dsw.entidades.Solicitud;
import ucab.dsw.entidades.Usuario;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created with IntelliJ IDEA.
 * User: Omar David
 * Date: 20/11/20
 * Time: 09:21 PM
 * To change this template use File | Settings | File Templates.
 */
@Path( "/prueba" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class PruebaEstudio extends AplicacionBase{
    @PUT
    @Path("/addestudio")
    public EstudioDto addEstudio (EstudioDto estudioDto){
        EstudioDto resultado = new EstudioDto();

        try {
            DaoEstudio dao = new DaoEstudio();
            Estudio estudio = new Estudio();
            estudio.setFechaCreacion(estudioDto.getFechaCreacion());
            estudio.set_estatus(estudioDto.getEstatus());
            Usuario usuario = new Usuario(estudioDto.getUsuario().getId());
            Solicitud solicitud = new Solicitud(estudioDto.getSolicitud().getId());
            estudio.setUsuario(usuario);
            estudio.setSolicitud(solicitud);
            Estudio resul = dao.insert(estudio);
            resultado.setId(resul.get_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    @PUT
    @Path( "/changeestudio" )
    public EstudioDto changeEstudio (EstudioDto estudioDto){
        EstudioDto resultado = new EstudioDto();

        try {
            DaoEstudio dao = new DaoEstudio();
            Estudio estudio = new Estudio(estudioDto.getId());
            estudio.setFechaCreacion(estudioDto.getFechaCreacion());
            estudio.set_estatus(estudioDto.getEstatus());
            Usuario usuario = new Usuario(estudioDto.getUsuario().getId());
            Solicitud solicitud = new Solicitud(estudioDto.getSolicitud().getId());
            estudio.setUsuario(usuario);
            estudio.setSolicitud(solicitud);
            Estudio resul = dao.update(estudio);
            resultado.setId(resul.get_id());
        }catch ( Exception ex ){
            String problema = ex.getMessage();
        }

        return resultado;
    }

    @PUT
    @Path( "/deleteestudio" )
    public EstudioDto deleteEstudio( long id ) {
        EstudioDto resultado = new EstudioDto();
        try
        {
            DaoEstudio dao = new DaoEstudio();
            Estudio delete = dao.find( id, Estudio.class );
            Estudio resul = dao.delete( delete );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @PUT
    @Path( "/showestudio" )
    public EstudioDto showEstudio( long id )
    {
        EstudioDto resultado = new EstudioDto();
        try {
            DaoEstudio dao = new DaoEstudio();
            Estudio resul = dao.find( id, Estudio.class );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }
}
