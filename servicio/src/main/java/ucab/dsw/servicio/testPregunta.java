package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoPregunta;
import ucab.dsw.accesodatos.DaoTipoPregunta;
import ucab.dsw.dtos.PreguntaDto;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.entidades.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path( "/pregunta" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class testPregunta extends AplicacionBase {

    @PUT
    @Path( "/add" )
    public PreguntaDto addPregunta(PreguntaDto preguntaDto)
    {
        PreguntaDto resultado = new PreguntaDto();
        try
        {
            DaoPregunta dao = new DaoPregunta();
            Pregunta pregunta = new Pregunta();
            pregunta.set_pregunta(preguntaDto.getPregunta());
            pregunta.set_fechacreacion(preguntaDto.getFechacreacion());
            pregunta.set_estatus(preguntaDto.getEstatus());
            TipoPregunta tipoPregunta = new TipoPregunta(preguntaDto.getTipoPreguntaDto().getId());
            pregunta.set_tipopregunta(tipoPregunta);
            Subcategoria subcategoria = new Subcategoria(preguntaDto.getSubCategoriaDto().getId());
            pregunta.set_subcategoria( subcategoria );
            Usuario usuario = new Usuario(preguntaDto.getUsuarioDto().getId());
            pregunta.set_usuario(usuario);
            Pregunta resul = dao.insert(pregunta);
            resultado.setId(resul.get_id());
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @PUT
    @Path( "/update/{id}" )
    public PreguntaDto updatePregunta(@PathParam("id") long id, PreguntaDto preguntaDto)
    {
        PreguntaDto resultado = new PreguntaDto();
        try
        {
            DaoPregunta dao = new DaoPregunta();
            Pregunta pregunta =  dao.find(id,Pregunta.class);

            pregunta.set_pregunta(preguntaDto.getPregunta());
            pregunta.set_fechacreacion(preguntaDto.getFechacreacion());
            pregunta.set_estatus(preguntaDto.getEstatus());
            TipoPregunta tipoPregunta = new TipoPregunta(preguntaDto.getTipoPreguntaDto().getId());
            pregunta.set_tipopregunta(tipoPregunta);
            Subcategoria subcategoria = new Subcategoria(preguntaDto.getSubCategoriaDto().getId());
            pregunta.set_subcategoria( subcategoria );
            Usuario usuario = new Usuario(preguntaDto.getUsuarioDto().getId());
            pregunta.set_usuario(usuario);

            Pregunta resul = dao.update(pregunta);
            resultado.setId(resul.get_id());
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }


    @DELETE
    @Path( "/delete/{id}" )
    public PreguntaDto deletePregunta(@PathParam("id") long id)
    {
        PreguntaDto resultado = new PreguntaDto();
        try
        {
            DaoPregunta dao = new DaoPregunta();
            Pregunta pregunta = dao.find(id,Pregunta.class);
            Pregunta resul = dao.delete(pregunta);
            resultado.setId(resul.get_id());
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path( "/find/{id}" )
    public PreguntaDto findPregunta(@PathParam("id") long id)
    {
        PreguntaDto resultado = new PreguntaDto();
        try
        {
            DaoPregunta dao = new DaoPregunta();
            Pregunta pregunta = dao.find(id,Pregunta.class);
            resultado.setId(pregunta.get_id());
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

}
