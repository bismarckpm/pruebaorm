package ucab.dsw.servicio;


import ucab.dsw.accesodatos.DaoEstudio;
import ucab.dsw.dtos.EstudioDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.Estudio;
import ucab.dsw.entidades.Solicitud;
import ucab.dsw.entidades.Usuario;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path( "/estudio" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class EstudioControlador extends AplicacionBase{

    @GET
    @Path( "/{id}" )
    public EstudioDto getEstudio()
    {
        EstudioDto resultado = new EstudioDto();
        try{
            DaoEstudio dao = new DaoEstudio();
            Estudio estudio = new Estudio();

        }catch (Exception e){
            String problema = e.getMessage();
        }

        return resultado;
    }

    @PUT
    @Path("/")
    public EstudioDto crearEstudio( EstudioDto estudioDto){
        EstudioDto resultado = new EstudioDto();
        try{
            DaoEstudio dao = new DaoEstudio();
            Estudio estudio = new Estudio();
            estudio.set_fechaCreacion( estudioDto.getFechaCreacion());
            estudio.set_estatus( estudioDto.getEstatus());
            Usuario usuario = new Usuario( estudioDto.getUsuario().getId());
            estudio.set_Usuario(usuario);
            Solicitud solicitud = new Solicitud( estudioDto.getSolicitud().getId());
            estudio.set_solicitud(solicitud);
            Estudio resul = dao.insert( estudio);
            resultado.setId( resul.get_id());
        }catch (Exception e){
            String problema = e.getMessage();
        }
        return resultado;
    }
}
