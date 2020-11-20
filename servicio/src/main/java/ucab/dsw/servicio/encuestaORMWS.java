package ucab.dsw.servicio;
import ucab.dsw.accesodatos.DaoEncuesta;
import ucab.dsw.dtos.EncuestaDto;
import ucab.dsw.entidades.Encuesta;
import ucab.dsw.entidades.Encuesta;
import ucab.dsw.entidades.Usuario;
import ucab.dsw.entidades.Estudio;

import javax.servlet.http.HttpServletRequest;
import javax.faces.push.Push;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path( "/encuesta" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class encuestaORMWS {

    @PUT
    @Path( "/agregar" )
    public EncuestaDto addEncuesta(EncuestaDto encuestaDto )
    {
        EncuestaDto resultado = new EncuestaDto();
        try
        {
            DaoEncuesta dao = new DaoEncuesta();
            Encuesta encuesta = new Encuesta();
            encuesta.set_fechaCreacion( encuestaDto.getFechaCreacion() );
            encuesta.set_estatus( encuestaDto.getEstatus() );
            Usuario usuarioCreador = new Usuario(encuestaDto.getUsuarioCreadorDto().getId());
            encuesta.set_usuariocreador( usuarioCreador );
            Usuario usuarioAnalista = new Usuario(encuestaDto.getUsuarioAnalistaDto().getId());
            encuesta.set_usuarioanalista( usuarioAnalista );
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
    @Path("/buscar")
    public List<Encuesta> showEncuesta()
    {
        List<Encuesta> encuestas = null;
        try {
            DaoEncuesta dao = new DaoEncuesta();
            encuestas = dao.findAll(Encuesta.class);
            System.out.println("Encuestas: ");
            for(Encuesta encuesta : encuestas) {
                System.out.print(encuesta.get_id());
                System.out.print(", ");
                System.out.print(encuesta.get_fechaCreacion());
                System.out.print(", ");
                System.out.print(encuesta.get_estatus());
                System.out.print(", ");
                System.out.print(encuesta.get_usuariocreador());
                System.out.print(", ");
                System.out.print(encuesta.get_usuarioanalista());
                System.out.print(", ");
                System.out.print(encuesta.get_estudio());
                System.out.println();
            }
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return encuestas;
    }

    @PUT
    @Path( "/actualizar/{id}" )
    public EncuestaDto editEncuesta( EncuestaDto encuestaDto)
    {
        EncuestaDto resultado = new EncuestaDto();
        try
        {
            DaoEncuesta dao = new DaoEncuesta();
            Encuesta encuesta = new Encuesta();
            encuesta.set_fechaCreacion( encuestaDto.getFechaCreacion() );
            encuesta.set_estatus( encuestaDto.getEstatus() );
            Usuario usuarioCreador = new Usuario(encuestaDto.getUsuarioCreadorDto().getId());
            encuesta.set_usuariocreador( usuarioCreador );
            Usuario usuarioAnalista = new Usuario(encuestaDto.getUsuarioAnalistaDto().getId());
            encuesta.set_usuarioanalista( usuarioAnalista );
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
    @Path( "/borrar/{id}" )
    public EncuestaDto deleteEncuesta( EncuestaDto encuestaDto)
    {
        EncuestaDto resultado = new EncuestaDto();
        try
        {
            DaoEncuesta dao = new DaoEncuesta();
            Encuesta encuesta = dao.find(encuestaDto.getId(), Encuesta.class);
            Encuesta resul = dao.delete (encuesta );
            resultado.setId(resul.get_id());

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }
}
