package ucab.dsw.servicio;
import ucab.dsw.accesodatos.DaoUsuario;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.TipoUsuario;
import ucab.dsw.entidades.Usuario;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path( "/prueba" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class pruebaORMWS extends AplicacionBase
{
    @POST
    @Path( "/adduser" )
    public UsuarioDto addUser( UsuarioDto usuarioDto )
    {
        UsuarioDto resultado = new UsuarioDto();
        try
        {
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
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return resultado;
    }

    @PUT
    @Path( "/edituser/{id}" )
    public Usuario editUser(@PathParam("id") int id, UsuarioDto usuarioDto )
    {
        DaoUsuario dao = new DaoUsuario();
        Usuario usuario = dao.find(usuarioDto.getId(), Usuario.class);
        try
        {
            usuario.set_nombre( usuarioDto.getNombre() );
            usuario.set_apellido( usuarioDto.getApellido() );
            usuario.set_estatus( usuarioDto.getEstatus() );
            usuario.set_correoelectronico( usuarioDto.getCorreoelectronico() );
            TipoUsuario tipoUsuario = new TipoUsuario(usuarioDto.getTipoUsuarioDto().getId());
            usuario.set_tipousuario( tipoUsuario );
            Usuario resul = dao.update(usuario);
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return usuario;
    }

    @DELETE
    @Path( "/deleteuser/{id}" )
    public Usuario deleteUser(@PathParam("id") int id)
    {
        DaoUsuario dao = new DaoUsuario();
        Usuario usuario = dao.find((long) id, Usuario.class);
        try
        {
            Usuario resul = dao.delete(usuario);
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return usuario;
    }

    @GET
    @Path( "/consulta" )
    public List<Usuario> consulta(){
        DaoUsuario dao = new DaoUsuario();
        return dao.findAll(Usuario.class);
    }
}
