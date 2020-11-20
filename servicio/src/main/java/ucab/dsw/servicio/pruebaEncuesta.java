package ucab.dsw.servicio;

import ucab.dsw.accesodatos.*;
import ucab.dsw.dtos.*;
import ucab.dsw.entidades.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path( "/prueba" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class pruebaEncuesta extends AplicacionBase{
    @PUT
    @Path( "/addencuesta" )
    public EncuestaDto addEncuesta( EncuestaDto encuestaDto )
    {
        EncuestaDto resultado = new EncuestaDto();
        try
        {
            DaoEncuesta dao = new DaoEncuesta();
            Encuesta encuesta = new Encuesta();
            encuesta.setFechacreacion(encuestaDto.getFechaCreacion());
            encuesta.set_estatus(encuestaDto.getEstatus());
            Usuario usuarioCreador= new Usuario(encuestaDto.getUsuarioDtoCreador().getId());
            encuesta.setidUsuarioCreador(usuarioCreador);
            Usuario usuarioAnalista= new Usuario(encuestaDto.getUsuarioDtoAnalista().getId());
            encuesta.setidUsuarioAnalista(usuarioAnalista);
            Estudio estudio= new Estudio(encuestaDto.getEstudio().getId());
            encuesta.setIdEstudio(estudio);
            Encuesta resul = dao.insert(encuesta);
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @DELETE
    @Path( "/eliminarsubcategoria" )
    public void eliminarEncuesta(EncuestaDto encuestadto )
    {
        EncuestaDto resultado = new EncuestaDto();
        try
        {
            DaoEncuesta dao = new DaoEncuesta();
            Encuesta E=new Encuesta(encuestadto.getId());
            Encuesta EEliminar=dao.find(E.get_id(),Encuesta.class);
            E.set_estatus("E");
            E.setFechacreacion(EEliminar.getFechacreacion());
            E.setIdEstudio(EEliminar.getidEstudio());
            E.setidUsuarioAnalista(EEliminar.getidUsuarioAnalista());
            E.setidUsuarioCreador(EEliminar.getidUsuarioCreador());
            Encuesta resul = dao.update( E );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
    }

    @POST
    @Path( "/actualizarsubcategoria" )
    public void actualizarEncuesta(EncuestaDto encuestadto )
    {
        EncuestaDto resultado = new EncuestaDto();
        try
        {
            DaoEncuesta dao = new DaoEncuesta();
            Encuesta E=new Encuesta(encuestadto.getId());
            Encuesta EActualizar=dao.find(E.get_id(),Encuesta.class);
            if(encuestadto.getFechaCreacion()!=null){
                E.setFechacreacion(encuestadto.getFechaCreacion());
            }else {E.setFechacreacion(EActualizar.getFechacreacion());}
            if(encuestadto.getEstatus()!=null){
                E.set_estatus(encuestadto.getEstatus());
            }else {E.set_estatus(EActualizar.get_estatus());}
            E.setIdEstudio(EActualizar.getidEstudio());
            E.setidUsuarioCreador(EActualizar.getidUsuarioCreador());
            E.setidUsuarioAnalista(EActualizar.getidUsuarioAnalista());
            Encuesta resul = dao.update( E );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
    }

    @GET
    @Path( "/leerencuesta" )
    public void leerEncuesta(EncuestaDto ENCuesta )
    {
        EncuestaDto resultado = new EncuestaDto();
        try
        {
            DaoEncuesta dao = new DaoEncuesta();
            Encuesta E = new Encuesta(ENCuesta.getId());
            Encuesta resul= dao.find(E.get_id(),Encuesta.class);
            System.out.println("Datos de la Encuesta:\n");
            System.out.println("Id="+resul.get_id()+"\n");
            System.out.println("Fecha creacion="+resul.getFechacreacion()+"\n");
            System.out.println("Estatus="+resul.get_estatus()+"\n");
            System.out.println("Estudio="+resul.getidEstudio()+"\n");
            System.out.println("Usuario analista="+resul.getidUsuarioAnalista()+"\n");
            System.out.println("Usuario Creador="+resul.getidUsuarioCreador()+"\n");
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
    }
}
