package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoCategoria;
import ucab.dsw.accesodatos.DaoEncuesta;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.dtos.EncuestaDto;
import ucab.dsw.entidades.Categoria;
import ucab.dsw.entidades.Encuesta;
import ucab.dsw.entidades.Estudio;
import ucab.dsw.entidades.Usuario;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path( "/prueba" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class EncuestaController extends AplicacionBase{
    @PUT
    @Path( "/addencuesta" )
    public EncuestaDto addEncuesta(EncuestaDto encuestaDto )
    {
        EncuestaDto resultado = new EncuestaDto();
        try
        {
            DaoEncuesta dao = new DaoEncuesta();
            Encuesta encuesta = new Encuesta();
            encuesta.set_estatus(encuestaDto.getStatus());
            encuesta.set_fechacreacion( encuestaDto.getFechaCreacion());
            Usuario usuarioCreador = new Usuario(encuestaDto.getIdUsuario_Creador().getId());
            Usuario usuarioAnalista = new Usuario(encuestaDto.getIdUsuario_Analista().getId());
            encuesta.set_idUsuario_Creador(usuarioCreador);
            encuesta.set_idUsuario_Analista(usuarioAnalista);
            Estudio estudio = new Estudio(encuestaDto.getIdEstudio().getId());
            encuesta.set_idEstudio(estudio);
            Encuesta resul = dao.insert( encuesta );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @PUT
    @Path("/modifyEncuesta")
    public EncuestaDto modificarEncuesta(EncuestaDto encuestaDto){
        EncuestaDto resultado = new EncuestaDto();
        try{
            DaoEncuesta dao = new DaoEncuesta();
            Encuesta encuesta = new Encuesta(encuestaDto.getId());
            encuesta.set_estatus(encuestaDto.getStatus());
            encuesta.set_fechacreacion( encuestaDto.getFechaCreacion());
            encuesta.set_idUsuario_Creador(new Usuario(encuestaDto.getIdUsuario_Creador().getId()));
            encuesta.set_idUsuario_Analista(new Usuario(encuestaDto.getIdUsuario_Analista().getId()));
            encuesta.set_idEstudio(new Estudio(encuestaDto.getIdEstudio().getId()));
            Encuesta resul = dao.update( encuesta );
            resultado.setId( resul.get_id() );
        }catch (Exception e){
            String problema = e.getMessage();
        }
        return resultado;
    }

    @PUT
    @Path("/deleteEncuesta")
    public EncuestaDto deleteEncuesta(EncuestaDto encuestaDto){
        EncuestaDto resultado = new EncuestaDto();
        try{
            DaoEncuesta dao = new DaoEncuesta();
            Encuesta encuesta = dao.find(encuestaDto.getId(), Encuesta.class);
            encuesta.set_estatus(encuestaDto.getStatus());
            Encuesta resul = dao.update( encuesta );
            resultado.setId( resul.get_id());
        }catch (Exception e){
            String problema = e.getMessage();
        }
        return resultado;
    }
    @GET
    @Path( "/{id}" )
    // @PathParam("id") Long id
    public EncuestaDto obtenerEncuesta(EncuestaDto encuestaDto)
    {
        EncuestaDto resultado = new EncuestaDto();
        try{
            DaoEncuesta dao = new DaoEncuesta();
            Encuesta encontrado = dao.find(encuestaDto.getId(), Encuesta.class);
            resultado.setId(encontrado.get_id());
        }
        catch (Exception e){
            String problema = e.getMessage();
        }

        return resultado;
    }

}
