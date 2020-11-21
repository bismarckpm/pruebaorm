package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoPregunta;
import ucab.dsw.dtos.PreguntaDto;
import ucab.dsw.entidades.Pregunta;
import ucab.dsw.entidades.Subcategoria;
import ucab.dsw.entidades.TipoPregunta;
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
 * Time: 09:47 PM
 * To change this template use File | Settings | File Templates.
 */
@Path( "/prueba" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class PruebaPregunta extends AplicacionBase
{
    @PUT
    @Path( "/addpregunta" )
    public PreguntaDto addPregunta( PreguntaDto preguntaDto )
    {
        PreguntaDto resultado = new PreguntaDto();
        try
        {
            DaoPregunta dao = new DaoPregunta();
            Pregunta pregunta = new Pregunta();
            pregunta.set_pregunta(preguntaDto.getPregunta());
            pregunta.set_fechacreacion(preguntaDto.getFechacreacion());
            pregunta.set_estatus(preguntaDto.getStatus());
            TipoPregunta tipoPregunta = new TipoPregunta(preguntaDto.getTipopregunta().getId());
            Subcategoria subcategoria = new Subcategoria(preguntaDto.getSubcategoria().getId());
            Usuario usuario = new Usuario(preguntaDto.getIdusuario().getId());
            pregunta.set_tipopregunta(tipoPregunta);
            pregunta.set_subcategoria(subcategoria);
            pregunta.set_idusuario(usuario);
            Pregunta resul = dao.insert( pregunta );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }
    @PUT
    @Path( "/changepregunta" )
    public PreguntaDto changePregunta( PreguntaDto preguntaDto ) throws Exception
    {
        PreguntaDto resultado = new PreguntaDto();
        try
        {
            DaoPregunta dao = new DaoPregunta();
            Pregunta pregunta = new Pregunta(preguntaDto.getId());
            pregunta.set_pregunta(preguntaDto.getPregunta());
            pregunta.set_fechacreacion(preguntaDto.getFechacreacion());
            pregunta.set_estatus(preguntaDto.getStatus());
            TipoPregunta tipoPregunta = new TipoPregunta(preguntaDto.getTipopregunta().getId());
            Subcategoria subcategoria = new Subcategoria(preguntaDto.getSubcategoria().getId());
            Usuario usuario = new Usuario(preguntaDto.getIdusuario().getId());
            pregunta.set_tipopregunta(tipoPregunta);
            pregunta.set_subcategoria(subcategoria);
            pregunta.set_idusuario(usuario);
            Pregunta resul = dao.update( pregunta );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @PUT
    @Path( "/deletepregunta" )
    public PreguntaDto deletePregunta( long id )
    {
        PreguntaDto resultado = new PreguntaDto();
        try
        {
            DaoPregunta dao = new DaoPregunta();
            Pregunta delete = dao.find( id, Pregunta.class );
            Pregunta resul = dao.delete( delete );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }


    @PUT
    @Path( "/showpregunta" )
    public PreguntaDto showPregunta( long id )
    {
        PreguntaDto resultado = new PreguntaDto();
        try {
            DaoPregunta dao = new DaoPregunta();
            Pregunta resul = dao.find( id, Pregunta.class );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

}
