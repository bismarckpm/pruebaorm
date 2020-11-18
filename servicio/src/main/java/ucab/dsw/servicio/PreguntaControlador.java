package ucab.dsw.servicio;


import ucab.dsw.accesodatos.DaoPregunta;
import ucab.dsw.dtos.PreguntaDto;
import ucab.dsw.entidades.Pregunta;
import ucab.dsw.entidades.SubCategoria;
import ucab.dsw.entidades.TipoPregunta;
import ucab.dsw.entidades.Usuario;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path( "/preguntas" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class PreguntaControlador extends AplicacionBase {

    @GET
    @Path( "/{id}" )
    // @PathParam("id") Long id
    public PreguntaDto obtenerPregunta(long id)
    {
        PreguntaDto resultado = new PreguntaDto();
        try{
            DaoPregunta dao = new DaoPregunta();
            Pregunta encontrado = dao.find( id, Pregunta.class);
            resultado.setId( encontrado.get_id());
            resultado.setFechaCreacion( encontrado.get_fechaCreacion());
            resultado.setEstatus( encontrado.get_estatus());
            resultado.setPregunta( encontrado.get_pregunta());
        }catch (Exception e){
            String problema = e.getMessage();
        }
        return resultado;
    }

    @POST
    @Path("/")
    public PreguntaDto crearPregunta( PreguntaDto preguntaDto){
        PreguntaDto resultado = new PreguntaDto();
        try{
            DaoPregunta dao = new DaoPregunta();
            Pregunta pregunta = new Pregunta();
            pregunta.set_fechaCreacion( preguntaDto.getFechaCreacion());
            pregunta.set_estatus( preguntaDto.getEstatus());
            pregunta.set_pregunta( preguntaDto.getPregunta());
            Usuario usuario = new Usuario( preguntaDto.getUsuario().getId());
            pregunta.set_usuario(usuario);
            TipoPregunta tipoPregunta = new TipoPregunta(
                    preguntaDto.getTipoPregunta().getId());
            pregunta.set_tipoPregunta( tipoPregunta);
            SubCategoria subCategoria = new SubCategoria(
                    preguntaDto.getSubCategoria().getId());
            pregunta.set_subCategoria( subCategoria);
            Pregunta resul = dao.insert( pregunta);
            resultado.setId( resul.get_id());
        }catch (Exception e){
            String problema = e.getMessage();
        }
        return resultado;
    }

    @PUT
    @Path("/")
    public PreguntaDto modificarPregunta( PreguntaDto preguntaDto){
        PreguntaDto resultado = new PreguntaDto();
        try{
            DaoPregunta dao = new DaoPregunta();
            Pregunta pregunta = new Pregunta( preguntaDto.getId());
            pregunta.set_fechaCreacion( preguntaDto.getFechaCreacion());
            pregunta.set_estatus( preguntaDto.getEstatus());
            pregunta.set_pregunta( preguntaDto.getPregunta());
            Usuario usuario = new Usuario( preguntaDto.getUsuario().getId());
            pregunta.set_usuario(usuario);
            TipoPregunta tipoPregunta = new TipoPregunta(
                    preguntaDto.getTipoPregunta().getId());
            pregunta.set_tipoPregunta( tipoPregunta);
            SubCategoria subCategoria = new SubCategoria(
                    preguntaDto.getSubCategoria().getId());
            pregunta.set_subCategoria( subCategoria);
            Pregunta resul = dao.update( pregunta);
            resultado.setId( resul.get_id());
        }catch (Exception e){
            String problema = e.getMessage();
        }
        return resultado;
    }

    @DELETE
    @Path( "/{id}" )
    //@PathParam("id") Long id
    public PreguntaDto borrarPregunta( Long id)
    {
        PreguntaDto resultado = new PreguntaDto();
        try{
            DaoPregunta dao = new DaoPregunta();
            Pregunta paraBorrar = dao.find( id, Pregunta.class);
            Pregunta resul = dao.delete( paraBorrar);
            resultado.setId(resul.get_id());
        }catch (Exception e){
            String problema = e.getMessage();
        }

        return resultado;
    }
}
