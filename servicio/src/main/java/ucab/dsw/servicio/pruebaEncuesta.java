package ucab.dsw.servicio;

import ucab.dsw.accesodatos.*;
import ucab.dsw.dtos.*;
import ucab.dsw.entidades.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

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
