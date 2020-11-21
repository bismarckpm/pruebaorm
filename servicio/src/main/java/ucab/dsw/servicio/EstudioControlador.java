package ucab.dsw.servicio;


import ucab.dsw.accesodatos.DaoEstudio;
import ucab.dsw.dtos.EstudioDto;
import ucab.dsw.entidades.Estudio;
import ucab.dsw.entidades.Solicitud;
import ucab.dsw.entidades.Usuario;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path( "/estudios" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class EstudioControlador extends AplicacionBase{

    @GET
    @Path( "/{id}" )
    // @PathParam("id") Long id
    public EstudioDto obtenerEstudio(long id)
    {
        EstudioDto resultado = new EstudioDto();
        try{
            DaoEstudio dao = new DaoEstudio();
            Estudio encontrado = dao.find( id, Estudio.class);
            resultado.setId(encontrado.get_id());
            resultado.setFechaCreacion( encontrado.get_fechaCreacion());

        }catch (Exception e){
            String problema = e.getMessage();
        }

        return resultado;
    }

    @POST
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

    @PUT
    @Path("/")
    public EstudioDto modificarEstudio( EstudioDto estudioDto){
        EstudioDto resultado = new EstudioDto();
        try{
            DaoEstudio dao = new DaoEstudio();
            Estudio estudio = new Estudio( estudioDto.getId());
            estudio.set_fechaCreacion( estudioDto.getFechaCreacion());
            estudio.set_estatus( estudioDto.getEstatus());
            Usuario usuario = new Usuario( estudioDto.getUsuario().getId());
            estudio.set_Usuario(usuario);
            Solicitud solicitud = new Solicitud( estudioDto.getSolicitud().getId());
            estudio.set_solicitud( solicitud);
            Estudio resul = dao.update( estudio);
            resultado.setId( resul.get_id());
        }catch (Exception e){
            String problema = e.getMessage();
        }
        return resultado;
    }

    @DELETE
    @Path( "/{id}" )
    //@PathParam("id") Long id
    public EstudioDto borrarEstudio( Long id)
    {
        EstudioDto resultado = new EstudioDto();
        try{
            DaoEstudio dao = new DaoEstudio();
            Estudio paraBorrar = dao.find( id, Estudio.class);
            Estudio resul = dao.delete( paraBorrar);
            resultado.setId(resul.get_id());
        }catch (Exception e){
            String problema = e.getMessage();
        }

        return resultado;
    }
}
