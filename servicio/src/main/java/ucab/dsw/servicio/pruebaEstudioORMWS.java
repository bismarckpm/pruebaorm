package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoEstudio;
import ucab.dsw.dtos.EstudioDto;
import ucab.dsw.entidades.Estudio;
import ucab.dsw.entidades.Solicitud;
import ucab.dsw.entidades.Subcategoria;
import ucab.dsw.entidades.Usuario;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path( "/estudio" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class pruebaEstudioORMWS extends AplicacionBase {
    @POST
    @Path( "/add" )
    public EstudioDto addEstudio(EstudioDto EstudioDto)
    {
        EstudioDto resultado = new EstudioDto();
        try
        {
            DaoEstudio dao = new DaoEstudio();
            Estudio estudio = new Estudio();

            estudio.set_estatus( EstudioDto.getEstatus());
            estudio.set_fechacreacion(EstudioDto.getFechacreacion());

            Solicitud solicitud =new Solicitud(EstudioDto.getSolicitudDto().getId());
            estudio.set_solicitud(solicitud);

            Usuario usuario=new Usuario(EstudioDto.getUsuarioDto().getId());
            estudio.set_usuario(usuario);

            Estudio resul = dao.insert( estudio );
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
    public EstudioDto deleteEstudio(@PathParam("id") long  _id)
    {
        EstudioDto resultado = new EstudioDto();
        try
        {
            DaoEstudio dao = new DaoEstudio();
            Estudio estudio = dao.find(_id,Estudio.class);
            estudio.set_estatus("F");
            Estudio resul = dao.update(estudio);
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }


    @PUT
    @Path( "/edit/{id}" )
    public EstudioDto editEstudio(@PathParam("id") long _id, EstudioDto EstudioDto)
    {
        EstudioDto resultado = new EstudioDto();
        try
        {
            DaoEstudio dao = new DaoEstudio();
            Estudio estudio = dao.find(_id,Estudio.class);

            estudio.set_estatus( EstudioDto.getEstatus() );
            estudio.set_fechacreacion(EstudioDto.getFechacreacion());

            Solicitud solicitud =new Solicitud(EstudioDto.getSolicitudDto().getId());
            estudio.set_solicitud(solicitud);

            Usuario usuario=new Usuario(EstudioDto.getUsuarioDto().getId());
            estudio.set_usuario(usuario);

            Estudio resul = dao.update(estudio);
            resultado.setId( resul.get_id() );

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path( "/{id}" )
    public EstudioDto getEstudio(@PathParam("id") long  _id)
    {
        EstudioDto resultado = new EstudioDto();
        try
        {
            DaoEstudio dao = new DaoEstudio();
            Estudio estudio = dao.find(_id,Estudio.class);
            resultado.setId( estudio.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

}
