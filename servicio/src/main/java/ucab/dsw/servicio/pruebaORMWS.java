package ucab.dsw.servicio;
import ucab.dsw.accesodatos.DaoCategoria;
import ucab.dsw.accesodatos.DaoEncuesta;
import ucab.dsw.accesodatos.DaoUsuario;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.dtos.EncuestaDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
<<<<<<< HEAD
            Usuario result = dao.insert( usuario );
            resultado.setId( result.get_id() );
=======

            Usuario resul = dao.insert( usuario );
            resultado.setId( resul.get_id() );
>>>>>>> 18306e02dbb87b05e8ed4f696540e88bd40b3b48
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
}
