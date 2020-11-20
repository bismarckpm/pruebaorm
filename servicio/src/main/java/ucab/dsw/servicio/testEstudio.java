package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoEstudio;
import ucab.dsw.accesodatos.DaoTipoPregunta;
import ucab.dsw.dtos.EstudioDto;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.entidades.Estudio;
import ucab.dsw.entidades.Solicitud;
import ucab.dsw.entidades.TipoPregunta;
import ucab.dsw.entidades.Usuario;

import javax.faces.push.Push;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path( "/estudio" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class testEstudio extends AplicacionBase{

    @PUT
    @Path( "/add" )
    public EstudioDto addEstudio(EstudioDto estudioDto)
    {
        EstudioDto resultado = new EstudioDto();
        try
        {
            DaoEstudio dao = new DaoEstudio();
            Estudio estudio = new Estudio();

            estudio.set_fechacreacion(estudioDto.getFechacreacion());
            estudio.set_estatus(estudioDto.getEstatus());

            Usuario usuario = new Usuario(estudioDto.getUsuarioDto().getId());
            estudio.set_usuario(usuario);
            Solicitud solicitud = new Solicitud(estudioDto.getSolicitudDto().getId());
            estudio.set_solicitud(solicitud);

            Estudio resul = dao.insert( estudio );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @PUT
    @Path( "/update/{id}" )
    public EstudioDto updateEstudio(@PathParam("id") long id, EstudioDto estudioDto)
    {
        EstudioDto resultado = new EstudioDto();
        try
        {
            DaoEstudio dao = new DaoEstudio();
            Estudio estudio = new Estudio();
            estudio.set_fechacreacion(estudioDto.getFechacreacion());
            estudio.set_estatus(estudioDto.getEstatus());
            Usuario usuario = new Usuario(estudioDto.getUsuarioDto().getId());
            estudio.set_usuario(usuario);
            Solicitud solicitud = new Solicitud(estudioDto.getSolicitudDto().getId());
            estudio.set_solicitud(solicitud);
            Estudio resul = dao.update( estudio );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @DELETE
    @Path( "/delete/{id}" )
    public EstudioDto deleteEstudio(@PathParam("id")  long id )
    {
        EstudioDto resultado = new EstudioDto();
        try
        {
            DaoEstudio dao = new DaoEstudio();
            Estudio estudio = dao.find(id,Estudio.class);
            Estudio resul = dao.delete(estudio);
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }


    @GET
    @Path( "/find/{id}" )
    public EstudioDto findEstudio(@PathParam("id")  long id )
    {
        EstudioDto resultado = new EstudioDto();
        try
        {
            DaoEstudio dao = new DaoEstudio();
            Estudio estudio = dao.find(id,Estudio.class);
            resultado.setId( estudio.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

}
