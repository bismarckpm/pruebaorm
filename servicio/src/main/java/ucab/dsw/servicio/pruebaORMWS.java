package ucab.dsw.servicio;
import ucab.dsw.accesodatos.DaoUsuario;
import ucab.dsw.dtos.RespuestaDto;
import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.TipoUsuario;
import ucab.dsw.entidades.Usuario;
import ucab.dsw.excepciones.PruebaExcepcion;
import ucab.dsw.mappers.UsuarioMapper;
import ucab.dsw.utilidades.JWT;

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
    public RespuestaDto<UsuarioDto> addUser( UsuarioDto usuarioDto )
    {
        UsuarioDto resultado = new UsuarioDto();
        RespuestaDto<UsuarioDto> respuesta = new RespuestaDto<>();

        try
        {
            verifyParams( usuarioDto );
            DaoUsuario dao = new DaoUsuario();
            Usuario usuario = UsuarioMapper.mapDtoToEntity( usuarioDto );
            Usuario resul = dao.insert( usuario );
            String token = JWT.createToken( String.valueOf( resul.getId()));
            resultado = UsuarioMapper.mapEntityToDto( resul );
            resultado.setToken( token );
            respuesta.setEstado( "OK" );
            respuesta.setObjeto( resultado );

        }
        catch ( Exception ex )
        {
            respuesta.setEstado( "ERROR" );
            respuesta.setMensaje( ex.getMessage() );
            respuesta.setMensajesoporte( ex.getLocalizedMessage() );
        }
        return  respuesta;
    }

    @POST
    @Path( "/consulta" )
    public RespuestaDto<UsuarioDto> consulta(UsuarioDto usuarioDto) throws PruebaExcepcion
    {
        UsuarioDto resultado = new UsuarioDto();
        RespuestaDto<UsuarioDto> respuesta = new RespuestaDto<>();
        try
        {
            verifyParams( usuarioDto );
            DaoUsuario dao = new DaoUsuario();
            Usuario usuario = UsuarioMapper.mapDtoToEntity( usuarioDto );
            Usuario resul = dao.find( usuario.getId(), Usuario.class );
            resultado = UsuarioMapper.mapEntityToDto( resul );
            respuesta.setEstado( "OK" );
            respuesta.setObjeto( resultado );
        }
        catch ( Exception ex )
        {
            respuesta.setEstado( "ERROR" );
            respuesta.setMensaje( ex.getMessage() );
            respuesta.setMensajesoporte( ex.getLocalizedMessage() );
        }
        return  respuesta;
    }


    @POST
    @Path( "/generateToken" )
    public String generateToken(UsuarioDto usuarioDto) throws PruebaExcepcion
    {
        UsuarioDto resultado = new UsuarioDto();
        String token = "";
        try
        {
            verifyParams( usuarioDto );
            token = JWT.createToken( String.valueOf( usuarioDto.getId() ));

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  token;
    }

    @POST
    @Path( "/validateToken" )
    public String validateToken(UsuarioDto usuarioDto) throws PruebaExcepcion
    {
        UsuarioDto resultado = new UsuarioDto();
        String idUsuario = "";
        try
        {
            verifyParams( usuarioDto );
            idUsuario = JWT.verifyToken( usuarioDto.getToken() );

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  idUsuario;
    }
}
