package ucab.dsw.servicio;
import ucab.dsw.accesodatos.DaoUsuario;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.TipoUsuario;
import ucab.dsw.entidades.Usuario;

import ucab.dsw.accesodatos.DaoCategoria;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.entidades.Categoria;

import ucab.dsw.accesodatos.DaoOpcion;
import ucab.dsw.dtos.OpcionDto;
import ucab.dsw.entidades.Opcion;

import ucab.dsw.accesodatos.DaoSolicitud;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.entidades.Solicitud;

import ucab.dsw.accesodatos.DaoPregunta;
import ucab.dsw.dtos.PreguntaDto;
import ucab.dsw.entidades.Pregunta;

import ucab.dsw.entidades.SubCategoria;
import ucab.dsw.entidades.TipoPregunta;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path( "/pregunta" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class preguntaORMWS extends AplicacionBase{

    @PUT
    @Path( "/addpregunta" )
    public PreguntaDto addPregunta( PreguntaDto preguntaDto )
    {
        PreguntaDto resultado = new PreguntaDto();
        try
        {
            DaoPregunta dao = new DaoPregunta();
            Pregunta pregunta = new Pregunta();
            pregunta.set_pregunta( preguntaDto.getPregunta() );
            pregunta.set_estatus( preguntaDto.getEstatus() );
            pregunta.set_fechacreacion( preguntaDto.getFechacreacion() );
            TipoPregunta tipoPregunta = new TipoPregunta(preguntaDto.getTipoPreguntaDto().getId());
            SubCategoria subCategoria = new SubCategoria(preguntaDto.getSubCategoriaDto().getId());
            Usuario usuario = new Usuario(preguntaDto.getUsuarioDto().getId());
            pregunta.set_tipoPregunta( tipoPregunta );
            pregunta.set_subCategoria( subCategoria );
            pregunta.set_usuario( usuario );
            Pregunta resul = dao.insert( pregunta );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;


    }

    @DELETE
    @Path ("/deletePregunta/{id}")
    public PreguntaDto deletePregunta (@PathParam("id") long id){
        PreguntaDto resultado = new PreguntaDto();

        try{
            DaoPregunta dao = new DaoPregunta();
            Pregunta pregunta = dao.find(id, Pregunta.class);
            if(pregunta != null){
                Pregunta result = dao.delete(pregunta);
                resultado.setId(result.get_id());
            }
        }
        catch (Exception e){
            String problem = e.getMessage();
        }
        return resultado;
    }

    @GET
    @Path("/showPregunta")
    public List<Pregunta> showPreguntas(){
        List<Pregunta> preguntas = null;
        try{
            DaoPregunta dao = new DaoPregunta();
            preguntas = dao.findAll(Pregunta.class);
            System.out.println("Preguntas:");
            for (Pregunta pregunta : preguntas) {
                System.out.print(pregunta.get_id());
                System.out.print(", ");
                System.out.print(pregunta.get_estatus());
                System.out.print(", ");
                System.out.print(pregunta.get_pregunta());
                System.out.print(", ");
                System.out.print(pregunta.get_fechacreacion());
                System.out.print(", ");
                System.out.print(pregunta.get_subCategoria().get_descripcion());
                System.out.print(", ");
                System.out.print(pregunta.get_tipoPregunta().getDescripcion());
                System.out.print(", ");
                System.out.print(pregunta.get_usuario().get_nombre());
                System.out.println("");

            }
        }
        catch(Exception e){
            String problem = e.getMessage();
        }
        return preguntas;
    }

    @PUT
    @Path( "/updatepregunta/{id}" )
    public PreguntaDto updatePregunta( @PathParam("id") long id , PreguntaDto preguntaDto )
    {
        PreguntaDto resultado = new PreguntaDto();
        try
        {
            DaoPregunta dao = new DaoPregunta();
            Pregunta pregunta = dao.find(id, Pregunta.class);
            pregunta.set_pregunta( preguntaDto.getPregunta() );
            pregunta.set_estatus( preguntaDto.getEstatus() );
            pregunta.set_fechacreacion( preguntaDto.getFechacreacion() );
            TipoPregunta tipoPregunta = new TipoPregunta(preguntaDto.getTipoPreguntaDto().getId());
            SubCategoria subCategoria = new SubCategoria(preguntaDto.getSubCategoriaDto().getId());
            Usuario usuario = new Usuario(preguntaDto.getUsuarioDto().getId());
            pregunta.set_tipoPregunta( tipoPregunta );
            pregunta.set_subCategoria( subCategoria );
            pregunta.set_usuario( usuario );
            Pregunta resul = dao.update( pregunta );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;


    }
}
