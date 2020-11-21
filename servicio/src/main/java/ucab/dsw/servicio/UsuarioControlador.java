package ucab.dsw.servicio;


import ucab.dsw.accesodatos.DaoUsuario;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.TipoUsuario;
import ucab.dsw.entidades.Usuario;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path( "/usuarios" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class UsuarioControlador extends AplicacionBase{

    @GET
    @Path( "/{id}" )
    public UsuarioDto obtenerUsuario( long id )
    {
        UsuarioDto resultado = new UsuarioDto();
        try {
            DaoUsuario dao = new DaoUsuario();
            Usuario resul = dao.find( id,Usuario.class);
            resultado.setId( resul.get_id());
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @POST
    @Path( "/" )
    public UsuarioDto crearUsuario( UsuarioDto usuarioDto)
    {
        UsuarioDto resultado = new UsuarioDto();
        try
        {
            DaoUsuario dao = new DaoUsuario();
            Usuario usuario = new Usuario();
            usuario.set_nombre( usuarioDto.getNombre());
            usuario.set_apellido( usuarioDto.getApellido());
            usuario.set_estatus( usuarioDto.getEstatus());
            usuario.set_correoelectronico( usuarioDto.getCorreoelectronico());
            TipoUsuario tipoUsuario = new TipoUsuario(usuarioDto.getTipoUsuarioDto().getId());
            usuario.set_tipousuario( tipoUsuario);
            Usuario resul = dao.insert( usuario);
            resultado.setId( resul.get_id());
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @PUT
    @Path( "/" )
    public UsuarioDto modificarUsuario( UsuarioDto usuarioDto )
    {
        UsuarioDto resultado = new UsuarioDto();
        try
        {
            DaoUsuario dao = new DaoUsuario();
            Usuario usuario = new Usuario(usuarioDto.getId());
            usuario.set_nombre( usuarioDto.getNombre());
            usuario.set_apellido( usuarioDto.getApellido());
            usuario.set_estatus( usuarioDto.getEstatus());
            usuario.set_correoelectronico( usuarioDto.getCorreoelectronico());
            TipoUsuario tipoUsuario = new TipoUsuario(usuarioDto.getTipoUsuarioDto().getId());
            usuario.set_tipousuario( tipoUsuario);
            Usuario resul = dao.update( usuario);
            resultado.setId( resul.get_id());
        }
        catch ( Exception ex)
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @DELETE
    @Path( "/{id}" )
    public UsuarioDto borrarUsuario( long id )
    {
        UsuarioDto resultado = new UsuarioDto();
        try
        {
            DaoUsuario dao = new DaoUsuario();
            Usuario paraBorrar = dao.find( id,Usuario.class);
            Usuario resul = dao.delete( paraBorrar);
            resultado.setId( resul.get_id());
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }
}
