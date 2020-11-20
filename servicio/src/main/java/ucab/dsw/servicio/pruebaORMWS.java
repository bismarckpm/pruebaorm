package ucab.dsw.servicio;
import ucab.dsw.accesodatos.DaoCategoria;
import ucab.dsw.accesodatos.DaoSubCategoria;
import ucab.dsw.accesodatos.DaoUsuario;
import ucab.dsw.accesodatos.DaoOpcion;
import ucab.dsw.accesodatos.DaoSolicitud;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.dtos.SubCategoriaDto;
import ucab.dsw.dtos.OpcionDto;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.entidades.*;

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
}
