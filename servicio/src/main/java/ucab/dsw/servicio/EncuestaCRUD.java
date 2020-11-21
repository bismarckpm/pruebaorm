package ucab.dsw.servicio;


import ucab.dsw.accesodatos.DaoEncuesta;
import ucab.dsw.dtos.EncuestaDto;
import ucab.dsw.entidades.Encuesta;
import ucab.dsw.entidades.EstudioEnt;
import ucab.dsw.entidades.Usuario;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path( "/encuestaCRUD" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class EncuestaCRUD extends AplicacionBase {

    @PUT
    @Path( "/addEncuesta" )
    public EncuestaDto addEncuesta(EncuestaDto encuestaDto )
    {
        EncuestaDto resultado = new EncuestaDto();
        try
        {
            DaoEncuesta dao = new DaoEncuesta();
            Encuesta encuesta = new Encuesta();
            encuesta.set_fechacreacion( encuestaDto.getFechacreacion() );
            encuesta.set_estatus( encuestaDto.getEstatus() );
            Usuario usuarioAnalista = new Usuario(encuestaDto.getUsuarioAnalistaDto().getId());
            encuesta.set_usuarioanalista( usuarioAnalista );
            Usuario usuarioCreador = new Usuario(encuestaDto.getUsuarioCreadorDto().getId());
            encuesta.set_usuariocreador( usuarioCreador );
            EstudioEnt estudio = new EstudioEnt(encuestaDto.getEstudioDto().getId());
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
    @Path("/getEncuesta")
    public List<Encuesta> getEncuesta() {

        List<Encuesta> encuestas = null;
        try {
            DaoEncuesta dao = new DaoEncuesta();
            encuestas = dao.findAll(Encuesta.class);
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        for (Encuesta obj : encuestas){
            System.out.println(obj.get_id()+ " " + obj.get_fechacreacion());
        }
        return encuestas;
    }


    @PUT
    @Path("/updateEncuesta/{id}")
    public EncuestaDto updateEncuesta(@PathParam("id") long id, EncuestaDto encuestaDto) {
        EncuestaDto resultado = new EncuestaDto();
        try {
            DaoEncuesta dao = new DaoEncuesta();
            Encuesta encuesta = dao.find(id, Encuesta.class);
            encuesta.set_fechacreacion( encuestaDto.getFechacreacion() );
            encuesta.set_estatus( encuestaDto.getEstatus() );
            Usuario usuarioAnalista = new Usuario(encuestaDto.getUsuarioAnalistaDto().getId());
            encuesta.set_usuarioanalista( usuarioAnalista );
            Usuario usuarioCreador = new Usuario(encuestaDto.getUsuarioCreadorDto().getId());
            encuesta.set_usuariocreador( usuarioCreador );
            EstudioEnt estudio = new EstudioEnt(encuesta.get_estudio().get_id());
            encuesta.set_estudio( estudio );
            Encuesta resul = dao.update(encuesta);
            resultado.setId(resul.get_id());

        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }


    @DELETE
    @Path("/deleteEncuesta/{id}")
    public EncuestaDto deleteEncuesta(@PathParam("id") long id){
        EncuestaDto resultado = new EncuestaDto();
        try
        {
            DaoEncuesta dao = new DaoEncuesta();
            Encuesta encuesta = dao.find(id, Encuesta.class);
            if (encuesta != null) {
                Encuesta resul = dao.delete(encuesta);
                resultado.setId(resul.get_id());
            }
        }
        catch (Exception ex){
            String problema = ex.getMessage();
        }
        return resultado;
    }
}
