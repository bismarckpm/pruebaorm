package ucab.dsw.servicio;
import ucab.dsw.accesodatos.DaoEstudio;
import ucab.dsw.accesodatos.DaoSolicitud;
import ucab.dsw.dtos.EstudioDto;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.entidades.EstudioEnt;
import ucab.dsw.entidades.SolicitudEnt;
import ucab.dsw.entidades.SubcategoriaEnt;
import ucab.dsw.entidades.Usuario;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
}
