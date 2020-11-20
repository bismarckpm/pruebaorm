package ucab.dsw.servicio;
import ucab.dsw.accesodatos.DaoEstudio;
import ucab.dsw.accesodatos.DaoSolicitud;
import ucab.dsw.accesodatos.DaoTipoUsuario;
import ucab.dsw.dtos.EstudioDto;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.entidades.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path( "/Estudio" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class EstudioCrud extends AplicacionBase{

    @PUT
    @Path( "/addSolicitud" )
    public EstudioDto addEstudio(EstudioDto estudioDto)
    {
        EstudioDto resultado = new EstudioDto();
        try
        {
            DaoEstudio dao = new DaoEstudio();
            EstudioEnt estudio = new EstudioEnt();
            estudio.setFechacreacion(estudioDto.getFechacreacion());
            estudio.set_estatus(estudioDto.get_estatus());
            Usuario usuario = new Usuario(estudioDto.getUsuario().getId());
            estudio.setUsuario(usuario);
            SolicitudEnt solicitud = new SolicitudEnt(estudioDto.getSolicitud().getId());
            estudio.setSolicitud(solicitud);
            EstudioEnt resul = dao.insert( estudio );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path("/getEstudio")
    public List<EstudioEnt> getEstudios() {

        List<EstudioEnt> estudios = null;
        try {
            DaoEstudio dao = new DaoEstudio();
            estudios = dao.findAll(EstudioEnt.class);
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        for (EstudioEnt obj : estudios) {
            System.out.println(obj.getFechacreacion());
        }
        return estudios;
    }

    @PUT
    @Path("/updateEstudio/{id}")
    public EstudioDto updateEstudio(@PathParam("id") long id, EstudioDto estudioDto) {
        EstudioDto resultado = new EstudioDto();
        try {
            DaoEstudio dao = new DaoEstudio();
            EstudioEnt estudio = dao.find(id, EstudioEnt.class);
            estudio.setFechacreacion(estudioDto.getFechacreacion());
            estudio.set_estatus(estudioDto.get_estatus());
            Usuario usuario = new Usuario(estudioDto.getUsuario().getId());
            estudio.setUsuario(usuario);
            SolicitudEnt solicitud = new SolicitudEnt(estudioDto.getSolicitud().getId());
            estudio.setSolicitud(solicitud);
            EstudioEnt resul = dao.update(estudio);
            resultado.setId(resul.get_id());
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }
    @DELETE
    @Path("/deleteEstudio/{id}")
    public EstudioDto deleteEstudio(@PathParam("id") long id)
    {
        EstudioDto resultado = new EstudioDto();
        try
        {
            DaoEstudio dao = new DaoEstudio();
            EstudioEnt estudio = dao.find(id, EstudioEnt.class);
            if(estudio != null) {
                EstudioEnt resul = dao.delete(estudio);
                resultado.setId(resul.get_id());
            }
        }
        catch (Exception er){
            String problema = er.getMessage();
        }
        return resultado;
    }
}
