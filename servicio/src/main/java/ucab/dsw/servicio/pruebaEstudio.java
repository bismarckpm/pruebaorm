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
public class pruebaEstudio extends AplicacionBase{
    @PUT
    @Path( "/addestudio" )
    public EstudioDto addEstudio( EstudioDto estudioDto )
    {
        EstudioDto resultado = new EstudioDto();
        try
        {
            DaoEstudio dao = new DaoEstudio();
            Estudio estudio = new Estudio();
            estudio.setFechaCreacion(estudioDto.getFechaCreacion());
            estudio.set_estatus(estudioDto.getEstatus());
            Usuario usuario=new Usuario(estudioDto.getUsuarioDto().getId());
            estudio.setIdusuario(usuario);
            solicitud Solicitud=new solicitud(estudioDto.getSolicitudDto().getId());
            estudio.setIdsolicitud(Solicitud);
            Estudio resul = dao.insert(estudio);
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @DELETE
    @Path( "/eliminarestudio" )
    public void eliminarEstudio(EstudioDto ESTudioDTO )
    {
        EstudioDto resultado = new EstudioDto();
        try
        {
            DaoEstudio dao = new DaoEstudio();
            Estudio EST=new Estudio(ESTudioDTO.getId());
            Estudio ESTEliminar=dao.find(EST.get_id(),Estudio.class);
            EST.setIdsolicitud(ESTEliminar.getIdsolicitud());
            EST.set_estatus("E");
            EST.setIdusuario(ESTEliminar.getIdusuario());
            EST.setFechaCreacion(ESTEliminar.getFechaCreacion());
            EST.setIdsolicitud(ESTEliminar.getIdsolicitud());
            Estudio resul = dao.update( EST );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
    }

    @POST
    @Path( "/actualizarestudio" )
    public void actualizarEstudio(EstudioDto ESTdto )
    {
        EstudioDto resultado = new EstudioDto();
        try
        {
            DaoEstudio dao = new DaoEstudio();
            Estudio E = new Estudio(ESTdto.getId());
            Estudio EAactualizar= dao.find(E.get_id(),Estudio.class);
            if(ESTdto.getEstatus()!=null){
                E.set_estatus(ESTdto.getEstatus());
            }else {E.set_estatus(EAactualizar.get_estatus());}
            if(ESTdto.getFechaCreacion()!=null){
                E.setFechaCreacion(ESTdto.getFechaCreacion());
            }else {E.setFechaCreacion(EAactualizar.getFechaCreacion());}
            E.setIdsolicitud(EAactualizar.getIdsolicitud());
            E.setIdusuario(EAactualizar.getIdusuario());
            Estudio resul = dao.update( E );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
    }

    @GET
    @Path( "/leerEstudio" )
    public void leerEstudio(EstudioDto ESTdto )
    {
        EstudioDto resultado = new EstudioDto();
        try
        {
            DaoEstudio dao = new DaoEstudio();
            Estudio SUBC = new Estudio(ESTdto.getId());
            Estudio resul= dao.find(SUBC.get_id(),Estudio.class);
            System.out.println("Datos del Estudio:\n");
            System.out.println("Id="+resul.get_id()+"\n");
            System.out.println("Estatus="+resul.get_estatus()+"\n");
            System.out.println("Fecha creacion="+resul.getFechaCreacion()+"\n");
            System.out.println("Solicitud="+resul.getIdsolicitud()+"\n");
            System.out.println("Usuario="+resul.getIdusuario()+"\n");
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
    }
}
