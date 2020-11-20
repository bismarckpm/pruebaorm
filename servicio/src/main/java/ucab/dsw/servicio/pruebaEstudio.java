package ucab.dsw.servicio;

import ucab.dsw.accesodatos.*;
import ucab.dsw.dtos.*;
import ucab.dsw.entidades.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

public class pruebaEstudio extends AplicacionBase{

    @PUT
    @Path( "/addestudio" )
    public EstudioDto addEstudio(EstudioDto estudioDto )
    {
        EstudioDto resultado = new EstudioDto();
        try
        {
            DaoEstudio dao = new DaoEstudio();
            Estudio estudio = new Estudio();
            estudio.set_estatus( estudioDto.getEstatus() );
            Usuario usuario = new Usuario(estudioDto.getUsuario().getId());
            estudio.set_usuario( usuario );
         // Solicitud solicitud = new Usuario(estudioDto.getSolicitud().getId());
          // estudio.set_solicitud( solicitud );
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
    @Path( "/updateestudio/{id}" )
    public EstudioDto updateEstudio( EstudioDto estudioDto)
    {
        EstudioDto resultado = new EstudioDto();
        try
        {
            DaoEstudio dao = new DaoEstudio();
            Estudio estudio = new Estudio(estudioDto.getId());
            estudio.set_estatus( estudioDto.getEstatus() );
            Usuario usuario = new Usuario(estudioDto.getUsuario().getId());
            estudio.set_usuario( usuario );
            // Solicitud solicitud = new Usuario(estudioDto.getSolicitud().getId());
            // estudio.set_solicitud( solicitud );
            Estudio resul = dao.update (estudio);
            resultado.setId(resul.get_id());

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @DELETE
    @Path( "/deleteestudio/{id}" )
    public EstudioDto deleteEstudio( EstudioDto estudioDto) {
        EstudioDto resultado = new EstudioDto();
        try {
            DaoEstudio dao = new DaoEstudio();
            Estudio estudio = dao.find(estudioDto.getId(), Estudio.class);
            Estudio resul = dao.delete(estudio);
            resultado.setId(resul.get_id());

        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }

}
