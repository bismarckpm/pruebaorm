package ucab.dsw.servicio;

import ucab.dsw.accesodatos.*;
import ucab.dsw.dtos.*;
import ucab.dsw.entidades.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class pruebaEncuesta extends AplicacionBase{

    @PUT
    @Path( "/addencuesta" )
    public EncuestaDto addEncuesta(EncuestaDto encuestaDto )
    {
        EncuestaDto resultado = new EncuestaDto();
        try
        {
            DaoEncuesta dao = new DaoEncuesta();
            Encuesta encuesta = new Encuesta();
            encuesta.set_fechaCreacion( encuestaDto.getFechaCreacion() );
            encuesta.set_estatus( encuestaDto.getEstatus() );
            Usuario usuarioC = new Usuario(encuestaDto.getUsuarioCreadorDto().getId());
            encuesta.set_usuarioC( usuarioC );
            Usuario usuarioA = new Usuario(encuestaDto.getUsuarioAnalistaDto().getId());
            encuesta.set_usuarioA( usuarioA );
            Estudio estudio = new Estudio(encuestaDto.getEstudioDto().getId());
            encuesta.set_estudio( estudio );
            Encuesta resul = dao.insert( encuesta );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path ("/listencuesta")
    public List<Encuesta> listEncuesta( )
    {
        List<Encuesta> encuestas= null;
        try
        {
            DaoEncuesta dao = new DaoEncuesta();
            encuestas = dao.findAll(Encuesta.class);
            for (Encuesta encuesta: encuestas) {
                System.out.println("Usuario Creador:" + encuesta.get_usuarioC());
                System.out.println("Usuario Analista:"+ encuesta.get_usuarioA());
                System.out.println("Estudio:"+encuesta.get_estudio() );
                System.out.println("Fecha:"+encuesta.get_estatus() );
            }
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  encuestas;
    }

    @PUT
    @Path( "/updateencuesta/{id}" )
    public EncuestaDto updateEncuesta( EncuestaDto encuestaDto)
    {
        EncuestaDto resultado = new EncuestaDto();
        try
        {
            DaoEncuesta dao = new DaoEncuesta();
            Encuesta encuesta = new Encuesta(encuestaDto.getId());
            encuesta.set_fechaCreacion( encuestaDto.getFechaCreacion() );
            encuesta.set_estatus( encuestaDto.getEstatus() );
            Usuario usuarioC = new Usuario(encuestaDto.getUsuarioCreadorDto().getId());
            encuesta.set_usuarioC( usuarioC );
            Usuario usuarioA = new Usuario(encuestaDto.getUsuarioAnalistaDto().getId());
            encuesta.set_usuarioA( usuarioA );
            Estudio estudio = new Estudio(encuestaDto.getEstudioDto().getId());
            encuesta.set_estudio( estudio );
            Encuesta resul = dao.update (encuesta );
            resultado.setId(resul.get_id());

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @DELETE
    @Path( "/deleteencuesta/{id}" )
    public EncuestaDto deleteEncuesta( EncuestaDto encuestaDto) {
        EncuestaDto resultado = new EncuestaDto();
        try {
            DaoEncuesta dao = new DaoEncuesta();
            Encuesta encuesta = dao.find(encuestaDto.getId(), Encuesta.class);
            Encuesta resul = dao.delete(encuesta);
            resultado.setId(resul.get_id());

        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }

}
