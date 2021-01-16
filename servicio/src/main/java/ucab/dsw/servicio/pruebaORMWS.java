package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoUsuario;
import ucab.dsw.dtos.RespuestaDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.Usuario;
import ucab.dsw.excepciones.PruebaExcepcion;
import ucab.dsw.mappers.UsuarioMapper;
import ucab.dsw.utilidades.JWT;
import ucab.dsw.directorioactivo.DirectorioActivo;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path( "/prueba" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class pruebaORMWS extends AplicacionBase
{
    @PUT
    @Path( "/adduser" )
    public Response addUser(UsuarioDto usuarioDto )
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

            return Response.ok(respuesta).build();

        }
        catch ( Exception ex )
        {
            respuesta.setEstado( "ERROR" );
            respuesta.setMensaje( ex.getMessage() );
            respuesta.setMensajesoporte( ex.getLocalizedMessage() );
            return Response.status(500).entity(respuesta).build();
        }
    }

    @POST
    @Path( "/consulta" )
    public Response consulta(UsuarioDto usuarioDto) throws PruebaExcepcion
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
            return Response.ok(respuesta).build();
        }
        catch ( Exception ex )
        {
            respuesta.setEstado( "ERROR" );
            respuesta.setMensaje( ex.getMessage() );
            respuesta.setMensajesoporte( ex.getLocalizedMessage() );
            return Response.status(500).entity(respuesta).build();
        }
    }

    @POST
    @Path( "/autenticacion" )
    public Response autenticarUsuario (UsuarioDto usuarioDto){

        RespuestaDto<UsuarioDto> respuesta = new RespuestaDto<>();
        try {
            boolean registrado;
            UsuarioDto resultado;

            DaoUsuario daoUsuario = new DaoUsuario();
            DirectorioActivo directorioActivo = new DirectorioActivo();
            Usuario usuario;
            JsonObject res;

            registrado = directorioActivo.userAuthentication(usuarioDto);

            if (registrado) {

                usuario = daoUsuario.getUsuarioByUsername(usuarioDto.getUsername());
                String token = generateToken(usuarioDto);
                usuario.setToken(token);   // le seteo el token al usuario
                resultado = UsuarioMapper.mapEntityToDto(usuario);
                daoUsuario.update(usuario); //hago update del usuario
                respuesta.setEstado("OK");
                respuesta.setObjeto( resultado );
                respuesta.setToken( token );
                return Response.ok(respuesta).build();

            }else{
                respuesta.setEstado( "ERROR" );
                respuesta.setMensaje( "AUTENTICACION INVALIDA" );
                return Response.status(500).entity(respuesta).build();
            }
        }
        catch ( Exception ex )
        {
            respuesta.setEstado( "ERROR" );
            respuesta.setMensaje( ex.getMessage() );
            respuesta.setMensajesoporte( ex.getLocalizedMessage() );
            return Response.status(500).entity(respuesta).build();
        }
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
