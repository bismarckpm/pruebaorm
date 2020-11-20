package ucab.dsw.servicio;

import ucab.dsw.accesodatos.Dao;
import ucab.dsw.accesodatos.DaoEncuesta;
import ucab.dsw.accesodatos.DaoTipoPregunta;
import ucab.dsw.dtos.EncuestaDto;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.entidades.Encuesta;
import ucab.dsw.entidades.Estudio;
import ucab.dsw.entidades.TipoPregunta;
import ucab.dsw.entidades.Usuario;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path( "/encuesta" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class testEncuesta extends  AplicacionBase {

    @PUT
    @Path( "/addencuesta" )
    public EncuestaDto addEncuesta(EncuestaDto encuestaDto)
    {
        EncuestaDto resultado = new EncuestaDto();
        try
        {
            DaoEncuesta dao = new DaoEncuesta();
            Encuesta encuesta = new Encuesta();
            encuesta.set_fechacreacion(encuestaDto.getFechacreacion());
            encuesta.set_estatus(encuestaDto.getEstatus());
            Usuario usuariocreador = new Usuario(encuestaDto.getUsuarioCreadorDto().getId());
            encuesta.set_usuariocreador(usuariocreador);
            Usuario usuarioanalista = new Usuario(encuestaDto.getUsuarioAnalistaDto().getId());
            encuesta.set_usuariocreador(usuarioanalista);
            Estudio estudio = new Estudio(encuestaDto.getEstudioDto().getId());
            encuesta.set_estudio(estudio);
            Encuesta resul = dao.insert(encuesta);
            resultado.setId(resul.get_id());
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }


    @PUT
    @Path( "/changeencuesta/{id}" )
    public EncuestaDto changeEncuesta(@PathParam("id") long id, EncuestaDto encuestaDto ) throws Exception
    {
        EncuestaDto resultado = new EncuestaDto();
        try
        {
            DaoEncuesta dao = new DaoEncuesta();
            Encuesta encuesta = new Encuesta(encuestaDto.getId());

            encuesta.set_fechacreacion(encuestaDto.getFechacreacion());
            encuesta.set_estatus(encuestaDto.getEstatus());
            Usuario usuariocreador = new Usuario(encuestaDto.getUsuarioCreadorDto().getId());
            encuesta.set_usuariocreador(usuariocreador);
            Usuario usuarioanalista = new Usuario(encuestaDto.getUsuarioAnalistaDto().getId());
            encuesta.set_usuariocreador(usuarioanalista);
            Estudio estudio = new Estudio(encuestaDto.getEstudioDto().getId());
            encuesta.set_estudio(estudio);
            Encuesta resul = dao.update( encuesta );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @DELETE
    @Path( "/deleteencuesta/{id}" )
    public EncuestaDto deleteEncuesta(@PathParam("id") long id ) throws Exception
    {
        EncuestaDto resultado = new EncuestaDto();
        try
        {
            DaoEncuesta dao = new DaoEncuesta();
            Encuesta encuesta = dao.find(id,Encuesta.class);
            Encuesta resul = dao.delete( encuesta );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path( "/getencuesta/{id}" )
    public EncuestaDto getEncuesta(@PathParam("id") long id ) throws Exception
    {
        EncuestaDto resultado = new EncuestaDto();
        try
        {
            DaoEncuesta dao = new DaoEncuesta();
            Encuesta resul = dao.find(id,Encuesta.class);
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }


    @GET
    @Path("/findallencuesta")
    public List<Encuesta> findAllEncuesta ()
    {
        List<Encuesta> resultado = null;

        try {
            DaoEncuesta dao = new DaoEncuesta();
            resultado = dao.findAll(Encuesta.class);
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return resultado;
    }

}
