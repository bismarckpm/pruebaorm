package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoEncuesta;
import ucab.dsw.dtos.EncuestaDto;
import ucab.dsw.entidades.Encuesta;
import ucab.dsw.entidades.Estudio;
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
 * Time: 09:38 PM
 * To change this template use File | Settings | File Templates.
 */
@Path( "/prueba" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class PruebaEncuesta extends AplicacionBase{
    @PUT
    @Path("/addencuesta")
    public EncuestaDto addEncuesta (EncuestaDto encuestaDto){
        EncuestaDto resultado = new EncuestaDto();

        try {
            DaoEncuesta dao = new DaoEncuesta();
            Encuesta encuesta = new Encuesta();
            encuesta.set_fechaCreacion(encuestaDto.getFechaCreacion());
            encuesta.set_estatus(encuestaDto.getEstatus());
            Usuario usuarioCreador = new Usuario(encuestaDto.getUsuarioCreador().getId());
            Usuario usuarioAnalista = new Usuario(encuestaDto.getUsuarioAnalista().getId());
            encuesta.set_usuarioCreador(usuarioCreador);
            encuesta.set_usuarioAnalista(usuarioAnalista);
            Estudio estudio = new Estudio(encuestaDto.getEstudio().getId());
            encuesta.set_estudio(estudio);
            Encuesta resul = dao.insert(encuesta);
            resultado.setId(resul.get_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    @PUT
    @Path( "/changeencuesta" )
    public EncuestaDto changeEncuesta (EncuestaDto encuestaDto){
        EncuestaDto resultado = new EncuestaDto();

        try {
            DaoEncuesta dao = new DaoEncuesta();
            Encuesta encuesta = new Encuesta(encuestaDto.getId());
            encuesta.set_fechaCreacion(encuestaDto.getFechaCreacion());
            encuesta.set_estatus(encuestaDto.getEstatus());
            Usuario usuarioCreador = new Usuario(encuestaDto.getUsuarioCreador().getId());
            Usuario usuarioAnalista = new Usuario(encuestaDto.getUsuarioAnalista().getId());
            encuesta.set_usuarioCreador(usuarioCreador);
            encuesta.set_usuarioAnalista(usuarioAnalista);
            Estudio estudio = new Estudio(encuestaDto.getEstudio().getId());
            encuesta.set_estudio(estudio);
            Encuesta resul = dao.update(encuesta);
            resultado.setId(resul.get_id());
        }catch ( Exception ex ){
            String problema = ex.getMessage();
        }

        return resultado;
    }

    @PUT
    @Path( "/deleteencuesta" )
    public EncuestaDto deleteEncuesta( long id ) {
        EncuestaDto resultado = new EncuestaDto();
        try
        {
            DaoEncuesta dao = new DaoEncuesta();
            Encuesta delete = dao.find( id, Encuesta.class );
            Encuesta resul = dao.delete( delete );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @PUT
    @Path( "/showencuesta" )
    public EncuestaDto showEncuesta( long id )
    {
        EncuestaDto resultado = new EncuestaDto();
        try {
            DaoEncuesta dao = new DaoEncuesta();
            Encuesta resul = dao.find( id, Encuesta.class );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }
}
