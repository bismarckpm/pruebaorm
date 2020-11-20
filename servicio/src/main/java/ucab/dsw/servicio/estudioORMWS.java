package ucab.dsw.servicio;
import ucab.dsw.accesodatos.DaoEstudio;
import ucab.dsw.dtos.EstudioDto;
import ucab.dsw.entidades.Encuesta;
import ucab.dsw.entidades.Estudio;
import ucab.dsw.entidades.Usuario;

import javax.servlet.http.HttpServletRequest;
import javax.faces.push.Push;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path( "/estudio" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class estudioORMWS {
    
    @PUT
    @Path( "/agregar" )
    public EstudioDto addEstudio(EstudioDto estudioDto )
    {
        EstudioDto resultado = new EstudioDto();
        try
        {
            DaoEstudio dao = new DaoEstudio();
            Estudio estudio = new Estudio();
            estudio.set_fechaCreacion( estudioDto.getFechaCreacion() );
            estudio.set_estatus( estudioDto.getEstatus() );
            Usuario usuario = new Usuario(estudioDto.getUsuario().getId());
            estudio.set_usuario( usuario );
            Usuario solicitud = new Usuario(estudioDto.getSolicitud().getId());
            estudio.set_solicitud( solicitud );
            Estudio resul = dao.insert( estudio );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path("/buscar")
    public List<Estudio> showEstudio()
    {
        List<Estudio> estudios = null;
        try {
            DaoEstudio dao = new DaoEstudio();
            estudios = dao.findAll(Estudio.class);
            System.out.println("Estudios: ");
            for(Estudio estudio : estudios) {
                System.out.print(estudio.get_fechaCreacion());
                System.out.print(", ");
                System.out.print(estudio.get_estatus());
                System.out.print(", ");
                System.out.print(estudio.get_usuario());
                System.out.print(", ");
                System.out.print(estudio.get_solicitud());
                System.out.println();
            }
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return estudios;
    }

    @PUT
    @Path( "/actualizar/{id}" )
    public EstudioDto editEstudio( EstudioDto estudioDto)
    {
        EstudioDto resultado = new EstudioDto();
        try
        {
            DaoEstudio dao = new DaoEstudio();
            Estudio estudio = new Estudio(estudioDto.getId());
            estudio.set_fechaCreacion( estudioDto.getFechaCreacion() );
            estudio.set_estatus( estudioDto.getEstatus() );
            Usuario usuario = new Usuario(estudioDto.getUsuario().getId());
            estudio.set_usuario( usuario );
            Usuario solicitud = new Usuario(estudioDto.getSolicitud().getId());
            estudio.set_solicitud( solicitud );
            Estudio resul = dao.update (estudio );
            resultado.setId(resul.get_id());

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @DELETE
    @Path( "/borrar/{id}" )
    public EstudioDto deleteEstudio( EstudioDto estudioDto)
    {
        EstudioDto resultado = new EstudioDto();
        try
        {
            DaoEstudio dao = new DaoEstudio();
            Estudio estudio = dao.find(estudioDto.getId(), Estudio.class);
            Estudio resul = dao.delete (estudio );
            resultado.setId(resul.get_id());

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }
}
