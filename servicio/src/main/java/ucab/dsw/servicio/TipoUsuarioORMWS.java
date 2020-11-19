package ucab.dsw.servicio;


import ucab.dsw.accesodatos.DaoTipoUsuario;
import ucab.dsw.accesodatos.DaoUsuario;
import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.TipoUsuario;
import ucab.dsw.entidades.Usuario;
import ucab.dsw.excepciones.PruebaExcepcion;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path( "/tipo-usuario" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class TipoUsuarioORMWS {

    @POST
    @Path( "/add" )
    public TipoUsuarioDto add( TipoUsuarioDto tipoUsuarioDto ) {

        TipoUsuarioDto resultado = new TipoUsuarioDto();
        try{

            DaoTipoUsuario dao = new DaoTipoUsuario();
            TipoUsuario tipoUsuario = new TipoUsuario();

            tipoUsuario.set_descripcion(tipoUsuarioDto.getDescripcion());
            tipoUsuario.set_estatus(tipoUsuarioDto.getEstatus());

            TipoUsuario result = dao.insert(tipoUsuario);

            resultado.setId(result.get_id());

            return resultado;


        }catch (Exception ex){

            String problema = ex.getMessage();

        }

        return resultado;
    }

    @DELETE
    @Path( "/delete" )
    public TipoUsuarioDto delete( Long id ) {

        TipoUsuarioDto resultado = new TipoUsuarioDto();

        try{
            DaoTipoUsuario dao = new DaoTipoUsuario();
            TipoUsuario tipoUsuario = dao.find(id, TipoUsuario.class);

            dao.delete(tipoUsuario);

            TipoUsuario firstTipoUsuario = dao.find(id, TipoUsuario.class);

            resultado.setId(firstTipoUsuario.get_id());

            return resultado;


        }catch (Exception ex){
            String problema = ex.getMessage();
        }

        return resultado;
    }

    @PUT
    @Path( "/update" )
    public TipoUsuarioDto update( TipoUsuarioDto tipoUsuarioDto ) {
        try {
            DaoTipoUsuario dao = new DaoTipoUsuario();

            TipoUsuario tipoUsuario = dao.find(tipoUsuarioDto.getId(), TipoUsuario.class);

            tipoUsuario.set_estatus(tipoUsuarioDto.getEstatus());
            tipoUsuario.set_descripcion(tipoUsuarioDto.getDescripcion());

            TipoUsuario resultado = dao.update(tipoUsuario);

            tipoUsuarioDto.setId(resultado.get_id());

            return tipoUsuarioDto;

        }catch (Exception ex){
            String problema = ex.getMessage();
        }

        return tipoUsuarioDto;
    }


    @GET
    @Path( "/first-one/{id}" )
    public TipoUsuarioDto getFirstOne(long id ) {

        TipoUsuarioDto tipoUsuarioDto = new TipoUsuarioDto();

        try{
            DaoTipoUsuario dao = new DaoTipoUsuario();

            TipoUsuario firstOneTipoUsuario = dao.find( id, TipoUsuario.class );
            tipoUsuarioDto.setId(firstOneTipoUsuario.get_id());

            return tipoUsuarioDto;

        }catch (Exception ex ){

            String problema = ex.getMessage();

        }

        return tipoUsuarioDto;
    }
}
