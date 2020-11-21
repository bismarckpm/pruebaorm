package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoPregunta;
import ucab.dsw.accesodatos.DaoUsuario;
import ucab.dsw.dtos.PreguntaDto;
import ucab.dsw.entidades.*;

import javax.ws.rs.*;

public class PreguntaWS extends AplicacionBase{


    @POST
    @Path( "/enviarpregunta/{id}" )
    public PreguntaDto add(PreguntaDto preguntaDto ){
        PreguntaDto resultado = new PreguntaDto();
        try{
            DaoPregunta dao = new DaoPregunta();
            Pregunta pregunta = new Pregunta();



        }
        catch ( Exception ex ){
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path( "/getpregunta/{id}" )
    public PreguntaDto get( @PathParam("id") long  _id ,PreguntaDto preguntaDto){
        PreguntaDto resultado = new PreguntaDto();
        try{
            DaoPregunta dao = new DaoPregunta();
            Pregunta pregunta = dao.find(_id, Pregunta.class);
            resultado.setId(pregunta.get_id());
        }
        catch ( Exception ex ){
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @PUT
    @Path( "/addpregunta" )
    public PreguntaDto addpregunta( PreguntaDto preguntaDto ){
        PreguntaDto resultado = new PreguntaDto();
        try{

            DaoPregunta dao = new DaoPregunta();
            Pregunta pregunta = new Pregunta();
            pregunta.set_pregunta( preguntaDto.getPregunta() );
            pregunta.set_fechaCreacion( preguntaDto.getFechaCreacion() );
            pregunta.set_estatus( preguntaDto.getEstatus() );
            TipoPregunta tipoPregunta = new TipoPregunta( preguntaDto.geTipoPregunta().getId() );
            pregunta.set_idTipoPregunta( tipoPregunta );
            SubCategoria subCategoria = new SubCategoria( preguntaDto.getSubcategoriaDto().getId() );
            pregunta.set_subCategoria( subCategoria);
            Usuario usuario = new Usuario( preguntaDto.getUsuarioDto().getId() );
            pregunta.set_usuarioPregunta( usuario );
            Pregunta resul = dao.insert( pregunta );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex ){
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @DELETE
    @Path( "/deletepregunta/{id}" )
    public PreguntaDto deletepregunta( @PathParam("id") long  _id ,PreguntaDto preguntaDto){
        PreguntaDto resultado = new PreguntaDto();
        try{
            DaoPregunta dao = new DaoPregunta();
            Pregunta pregunta = dao.find(_id, Pregunta.class);
            Pregunta p = dao.delete(pregunta);
            resultado.setId(p.get_id());
        }
        catch ( Exception ex ){
            String problema = ex.getMessage();
        }
        return  resultado;
    }
}
