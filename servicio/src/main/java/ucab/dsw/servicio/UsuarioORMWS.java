package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoUsuario;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.TipoUsuario;
import ucab.dsw.entidades.Usuario;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path( "/usuario" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class UsuarioORMWS extends AplicacionBase {


    @POST
    @Path( "/add" )
    public UsuarioDto add( UsuarioDto usuarioDto ) {

        UsuarioDto resultado = new UsuarioDto();

        try {

            DaoUsuario dao = new DaoUsuario();
            Usuario usuario = new Usuario();

            usuario.set_nombre( usuarioDto.getNombre() );
            usuario.set_apellido( usuarioDto.getApellido() );
            usuario.set_estatus( usuarioDto.getEstatus() );
            usuario.set_correoelectronico( usuarioDto.getCorreoelectronico() );

            TipoUsuario tipoUsuario = new TipoUsuario(usuarioDto.getTipoUsuarioDto().getId());

            usuario.set_tipousuario( tipoUsuario );
            Usuario resul = dao.insert( usuario );

            resultado.setId( resul.get_id() );

        }
        catch ( Exception ex ) {

            String problema = ex.getMessage();

        }
        return  resultado;
    }

    @DELETE
    @Path( "/delete" )
    public UsuarioDto delete( long id ) {
        UsuarioDto usuarioDto = new UsuarioDto();

        try {
            DaoUsuario dao = new DaoUsuario();

            Usuario usuario = dao.find(id, Usuario.class);

            dao.delete( usuario );

            Usuario firstUsuario = dao.find(id, Usuario.class);

            usuarioDto.setId(firstUsuario.get_id());

            return usuarioDto;

        }catch ( Exception ex ){

            String problema = ex.getMessage();
        }
        return usuarioDto;
    }

    @PUT
    @Path( "/update" )
    public UsuarioDto update( UsuarioDto usuarioDto) {

        try{
            DaoUsuario dao = new DaoUsuario();

            Usuario firstUsuario = dao.find( usuarioDto.getId(), Usuario.class );

            firstUsuario.set_apellido(usuarioDto.getApellido());
            firstUsuario.set_correoelectronico(usuarioDto.getCorreoelectronico());
            firstUsuario.set_nombre(usuarioDto.getNombre());
            firstUsuario.set_estatus(usuarioDto.getEstatus());

            Usuario usuarioUpdate = dao.update( firstUsuario );

            usuarioDto.setId(usuarioUpdate.get_id());

            return usuarioDto;


        }catch (Exception ex ){

            String problema = ex.getMessage();

        }

        return usuarioDto;
    }

    @GET
    @Path( "/first-one/{id}" )
    public UsuarioDto getFirstOne( long id ) {

        UsuarioDto usuarioDto = new UsuarioDto();

        try{
            DaoUsuario dao = new DaoUsuario();

            Usuario firstOneUsuario = dao.find( id, Usuario.class );
            usuarioDto.setId(firstOneUsuario.get_id());

            return usuarioDto;

        }catch (Exception ex ){

            String problema = ex.getMessage();

        }

        return usuarioDto;
    }


}
