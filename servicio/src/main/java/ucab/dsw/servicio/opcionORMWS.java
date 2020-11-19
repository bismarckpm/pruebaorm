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


@Path( "/opcion" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class opcionORMWS extends AplicacionBase{

    @PUT
    @Path( "/addopcion" )
    public OpcionDto addOpcion( OpcionDto opcionDto )
    {
        OpcionDto resultado = new OpcionDto();
        try
        {
            DaoOpcion dao = new DaoOpcion();
            Opcion opcion = new Opcion();
            opcion.set_descripcion( opcionDto.getDescripcion() );
            opcion.set_estatus( opcionDto.getEstatus() );
            Pregunta pregunta = new Pregunta(opcionDto.getPreguntaDto().getId());
            opcion.set_pregunta( pregunta );
            Opcion resul = dao.insert( opcion );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @DELETE
    @Path ("/deleteOpcion/{id}")
    public OpcionDto deleteOpcion (@PathParam("id") long id){
        OpcionDto resultado = new OpcionDto();

        try{
            DaoOpcion dao = new DaoOpcion();
            Opcion opcion = dao.find(id, Opcion.class);
            if(opcion != null){
                Opcion result = dao.delete(opcion);
                resultado.setId(result.get_id());
            }
        }
        catch (Exception e){
            String problem = e.getMessage();
        }
        return resultado;
    }

    @GET
    @Path("/showOpcion")
    public List<Opcion> showOpciones(){
        List<Opcion> opciones = null;
        try{
            DaoOpcion dao = new DaoOpcion();
            opciones = dao.findAll(Opcion.class);
            System.out.println("Opciones:");
            for (Opcion opcion : opciones) {
                System.out.print(opcion.get_id());
                System.out.print(", ");
                System.out.print(opcion.get_estatus());
                System.out.print(", ");
                System.out.print(opcion.get_descripcion());
                System.out.print(", ");
                System.out.print(opcion.get_pregunta().get_pregunta());
                System.out.println("");

            }
        }
        catch(Exception e){
            String problem = e.getMessage();
        }
        return opciones;
    }

    @PUT
    @Path( "/updateopcion/{id}" )
    public OpcionDto updateOpcion( @PathParam("id") long id , OpcionDto opcionDto)
    {
        OpcionDto resultado = new OpcionDto();
        try
        {
            DaoOpcion dao = new DaoOpcion();
            Opcion opcion = dao.find(id, Opcion.class);
            opcion.set_descripcion( opcionDto.getDescripcion() );
            opcion.set_estatus( opcionDto.getEstatus() );
            Pregunta pregunta = new Pregunta(opcionDto.getPreguntaDto().getId());
            opcion.set_pregunta( pregunta );
            Opcion resul = dao.update(opcion);
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }
}
