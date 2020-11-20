package ucab.dsw.servicio;

import ucab.dsw.accesodatos.*;
import ucab.dsw.dtos.*;
import ucab.dsw.entidades.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


@Path( "/prueba" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )

public class pruebaOpcion extends AplicacionBase{

    @PUT
    @Path( "/addOpcion" )
    public OpcionDto addOpcion(OpcionDto opcionDto )
    {
        OpcionDto resultado = new OpcionDto();
        try
        {
            DaoOpcion dao = new DaoOpcion();
            Opcion opcion = new Opcion();
            opcion.set_descripcion( opcionDto.getDescripcion() );
            opcion.set_estatus( opcionDto.getEstatus() );
            //TipoUsuario tipoUsuario = new TipoUsuario(usuarioDto.getTipoUsuarioDto().getId());
            //usuario.set_tipousuario( tipoUsuario );
            Opcion resul = dao.insert( opcion );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @PUT
    @Path( "/updateOpcion/{id}" )
    public OpcionDto updateOpcion( OpcionDto opcionDto)
    {
        OpcionDto resultado = new OpcionDto();
        try
        {
            DaoOpcion dao = new DaoOpcion();
            Opcion opcion = new Opcion(opcionDto.getId());
            opcion.set_descripcion( opcionDto.getDescripcion());
            opcion.set_estatus (opcionDto.getEstatus());
            Opcion resul = dao.update ( opcion );
            resultado.setId(resul.get_id());

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @DELETE
    @Path( "/deleteOpcion/{id}" )
    public OpcionDto deleteOpcion( OpcionDto opcionDto) {
        OpcionDto resultado = new OpcionDto();
        try {
            DaoOpcion dao = new DaoOpcion();
            Opcion opcion = dao.find(opcionDto.getId(), Opcion.class);
            Opcion resul = dao.delete(opcion);
            resultado.setId(resul.get_id());

        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }
}
