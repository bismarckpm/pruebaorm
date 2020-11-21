package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoPregunta;
import ucab.dsw.dtos.PreguntaDto;
import ucab.dsw.entidades.Pregunta;
import ucab.dsw.entidades.SubcategoriaEnt;
import ucab.dsw.entidades.TipoPregunta;
import ucab.dsw.entidades.Usuario;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path( "/preguntaCRUD" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class PreguntaCRUD {

    @PUT
    @Path( "/addpregunta" )
    public PreguntaDto addPregunta(PreguntaDto preguntaDto )
    {
        PreguntaDto resultado = new PreguntaDto();
        try
        {
            DaoPregunta dao = new DaoPregunta();
            Pregunta pregunta = new Pregunta();
            pregunta.set_pregunta( preguntaDto.getPregunta() );
            pregunta.set_fechacreacion( preguntaDto.getFechacreacion() );
            pregunta.set_estatus( preguntaDto.getEstatus() );
            TipoPregunta tipoPregunta = new TipoPregunta(preguntaDto.getTipoPreguntaDto().getId());
            pregunta.set_tipopregunta( tipoPregunta );
            Usuario usuario = new Usuario(preguntaDto.getUsuarioDto().getId());
            pregunta.set_usuario( usuario );
            SubcategoriaEnt subcategoria = new SubcategoriaEnt(preguntaDto.getSubcategoriaDto().getId());
            pregunta.set_subcategoria( subcategoria );
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
    public List<Pregunta> getPregunta() {

        List<Pregunta> preguntas = null;
        try {
            DaoPregunta dao = new DaoPregunta();
            preguntas = dao.findAll(Pregunta.class);
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        for (Pregunta obj : preguntas){
            System.out.println(obj.get_pregunta());
        }
        return preguntas;
    }


    @PUT
    @Path("/updatePregunta/{id}")
    public PreguntaDto updatePregunta(@PathParam("id") long id, PreguntaDto preguntaDto) {
        PreguntaDto resultado = new PreguntaDto();
        try {
            DaoPregunta dao = new DaoPregunta();
            Pregunta pregunta = dao.find(id, Pregunta.class);
            pregunta.set_pregunta( preguntaDto.getPregunta() );
            pregunta.set_fechacreacion( preguntaDto.getFechacreacion() );
            pregunta.set_estatus( preguntaDto.getEstatus() );
            TipoPregunta tipoPregunta = new TipoPregunta(preguntaDto.getTipoPreguntaDto().getId());
            pregunta.set_tipopregunta( tipoPregunta );
            Usuario usuario = new Usuario(preguntaDto.getUsuarioDto().getId());
            pregunta.set_usuario( usuario );
            SubcategoriaEnt subcategoria = new SubcategoriaEnt(preguntaDto.getSubcategoriaDto().getId());
            pregunta.set_subcategoria( subcategoria );
            Pregunta resul = dao.update(pregunta);
            resultado.setId(resul.get_id());

        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }


    @DELETE
    @Path("/deletePregunta/{id}")
    public PreguntaDto deletePregunta(@PathParam("id") long id){
        PreguntaDto resultado = new PreguntaDto();
        try
        {
            DaoPregunta dao = new DaoPregunta();
            Pregunta pregunta = dao.find(id, Pregunta.class);
            if (pregunta != null) {
                Pregunta resul = dao.delete(pregunta);
                resultado.setId(resul.get_id());
            }
        }
        catch (Exception ex){
            String problema = ex.getMessage();
        }
        return resultado;
    }
}
