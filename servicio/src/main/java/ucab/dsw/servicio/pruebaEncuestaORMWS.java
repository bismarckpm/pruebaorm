package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoEncuesta;
import ucab.dsw.dtos.EncuestaDto;
import ucab.dsw.entidades.Encuesta;
import ucab.dsw.entidades.Estudio;
import ucab.dsw.entidades.Usuario;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path( "/encuesta" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class pruebaEncuestaORMWS extends AplicacionBase {
    @POST
    @Path( "/add" )
    public EncuestaDto addEncuesta(EncuestaDto EncuestaDto)
    {
        EncuestaDto resultado = new EncuestaDto();
        try
        {
            DaoEncuesta dao = new DaoEncuesta();
            Encuesta encuesta = new Encuesta();

            encuesta.set_estatus( EncuestaDto.getEstatus() );
            encuesta.set_fechacreacion(EncuestaDto.getFechacreacion());

            Estudio estudio =new Estudio(EncuestaDto.getEstudioDto().getId());
            encuesta.set_estudio(estudio);

            Usuario usuarioAnalista=new Usuario(EncuestaDto.getUsuarioAnalistaDto().getId());
            encuesta.set_usuarioAnalista(usuarioAnalista);

            Usuario usuarioCreador=new Usuario(EncuestaDto.getUsuarioCreadorDto().getId());
            encuesta.set_usuarioCreador(usuarioCreador);

            Encuesta resul = dao.insert( encuesta );
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
    public EncuestaDto deleteEncuesta(@PathParam("id") long  _id)
    {
        EncuestaDto resultado = new EncuestaDto();
        try
        {
            DaoEncuesta dao = new DaoEncuesta();
            Encuesta encuesta = dao.find(_id,Encuesta.class);
            encuesta.set_estatus("F");
            Encuesta resul = dao.update(encuesta);
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
    public EncuestaDto editEncuesta(@PathParam("id") long _id, EncuestaDto EncuestaDto)
    {
        EncuestaDto resultado = new EncuestaDto();
        try
        {
            DaoEncuesta dao = new DaoEncuesta();
            Encuesta encuesta = dao.find(_id,Encuesta.class);

            encuesta.set_estatus( EncuestaDto.getEstatus() );
            encuesta.set_fechacreacion(EncuestaDto.getFechacreacion());

            Estudio estudio =new Estudio(EncuestaDto.getEstudioDto().getId());
            encuesta.set_estudio(estudio);

            Usuario usuarioAnalista=new Usuario(EncuestaDto.getUsuarioAnalistaDto().getId());
            encuesta.set_usuarioAnalista(usuarioAnalista);

            Usuario usuarioCreador=new Usuario(EncuestaDto.getUsuarioCreadorDto().getId());
            encuesta.set_usuarioCreador(usuarioCreador);

            Encuesta resul = dao.update(encuesta);
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
    public EncuestaDto getEncuesta(@PathParam("id") long  _id)
    {
        EncuestaDto resultado = new EncuestaDto();
        try
        {
            DaoEncuesta dao = new DaoEncuesta();
            Encuesta encuesta = dao.find(_id,Encuesta.class);
            resultado.setId( encuesta.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

}
