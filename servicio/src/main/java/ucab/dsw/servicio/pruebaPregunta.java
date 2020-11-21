package ucab.dsw.servicio;
import ucab.dsw.accesodatos.DaoPregunta;
import ucab.dsw.dtos.PreguntaDto;
import ucab.dsw.entidades.*;


import javax.ws.rs.*;
import java.util.List;

public class pruebaPregunta {
    @PUT
    @Path( "/addPregunta" )
    public PreguntaDto addPregunta(PreguntaDto preguntaDto ) throws Exception {
        PreguntaDto resultado = new PreguntaDto();
        try
        {
            DaoPregunta dao = new DaoPregunta();
            Pregunta pregunta = new Pregunta();
            pregunta.setPregunta( preguntaDto.getPregunta() );
            pregunta.setFechaCreacion( preguntaDto.getFechacreacion() );
            pregunta.set_estatus( preguntaDto.getEstatus() );
            TipoPregunta tipoPregunta = new TipoPregunta(preguntaDto.getTipoPreguntaDto().getId());
            pregunta.set_tipoPregunta( tipoPregunta );
            SubCategoria subcategoria = new SubCategoria(preguntaDto.getSubCategoriaDto().getId());
            pregunta.set_subcategoria( subcategoria );
            //Usuario usuario = new Usuario(preguntaDto.getUsuario.getId());
            //pregunta.set_usuario( usuario );
            Pregunta resul = dao.insert( pregunta );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path("/getPregunta")
    public List<Pregunta> getPregunta(){
        List<Pregunta> preguntas = null;
        try{
            DaoPregunta dao= new DaoPregunta();
            preguntas = dao.findAll(Pregunta.class);
        }catch (Exception ex){
            String problem = ex.getMessage();
        }
        return preguntas;
    }

    @PUT
    @Path("/updatePregunta/{id}")
    public PreguntaDto updatePregunta(@PathParam("id") long id, PreguntaDto preguntaDto){
        PreguntaDto resultado = new PreguntaDto();

        try{
            DaoPregunta dao = new DaoPregunta();
            Pregunta pregunta = dao.find(id, Pregunta.class);

            if(pregunta!=null){
                pregunta.setPregunta(preguntaDto.getPregunta());
                pregunta.set_estatus(preguntaDto.getEstatus());
                pregunta.setFechaCreacion(preguntaDto.getFechacreacion());
                Pregunta resul = dao.update(pregunta);
                resultado.setId(resul.get_id());
            }
        }catch (Exception ex){
            String problem = ex.getMessage();
        }
        return resultado;
    }

    @DELETE
    @Path("deletePregunta/{id}")
    public PreguntaDto deletePregunta (@PathParam("id") long id){
        PreguntaDto resultado = new PreguntaDto();

        try{
            DaoPregunta dao = new DaoPregunta();
            Pregunta pregunta = dao.find(id,Pregunta.class);

            if(pregunta != null){
                Pregunta resul = dao.delete(pregunta);
                resultado.setId(resul.get_id());
            }
        }catch(Exception ex){
            String problem = ex.getMessage();
        }
        return resultado;
    }


}