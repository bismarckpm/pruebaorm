package ucab.dsw.servicio;
import ucab.dsw.accesodatos.DaoUsuario;
import ucab.dsw.accesodatos.DaoUsuario;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.Usuario;
import ucab.dsw.entidades.TipoUsuario;
import ucab.dsw.entidades.Usuario;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


@Path( "/prueba" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class pruebaORMWS extends AplicacionBase
{
    @PUT
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
        return  resultado;
    }

    @GET
    @Path( "/consulta" )
    public String consulta()
    {
        return "Epa";
    }

    @DELETE
    @Path( "/delete/{id}" )
    public UsuarioDto deleteUsuario(@PathParam("id") long  _id)
    {
        UsuarioDto resultado = new UsuarioDto();
        try
        {
            DaoUsuario dao = new DaoUsuario();
            Usuario usuario = dao.find(_id,Usuario.class);
            usuario.set_estatus("I");
            Usuario resul = dao.update(usuario);
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }


    @PUT
    @Path( "/edit/{id}" )
    public UsuarioDto editUsuario(@PathParam("id") long _id, UsuarioDto usuarioDto)
    {
        UsuarioDto resultado = new UsuarioDto();
        try
        {
            DaoUsuario dao = new DaoUsuario();
            Usuario usuario = dao.find(_id,Usuario.class);
            usuario.set_nombre( usuarioDto.getNombre() );
            usuario.set_apellido( usuarioDto.getApellido() );
            usuario.set_estatus( usuarioDto.getEstatus() );
            usuario.set_correoelectronico( usuarioDto.getCorreoelectronico() );
            TipoUsuario tipoUsuario = new TipoUsuario(usuarioDto.getTipoUsuarioDto().getId());
            usuario.set_tipousuario( tipoUsuario );
            Usuario resul = dao.update(usuario);
            resultado.setId( resul.get_id() );

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path( "/{id}" )
    public UsuarioDto getUsuario(@PathParam("id") long  _id)
    {
        UsuarioDto resultado = new UsuarioDto();
        try
        {
            DaoUsuario dao = new DaoUsuario();
            Usuario usuario = dao.find(_id,Usuario.class);
            resultado.setId( usuario.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }


}
