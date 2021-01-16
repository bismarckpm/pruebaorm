package ucab.dsw.servicio;

import ucab.dsw.directorio.DirectorioActivo;
import ucab.dsw.dtos.RespuestaDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.excepciones.PruebaExcepcion;
import ucab.dsw.utilidades.JWT;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path( "/prueba-jwt" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class pruebaJWT extends AplicacionBase{


    @POST
    @Path( "/autenticar-usuario" )
    public RespuestaDto<UsuarioDto> autenticarUsuario(UsuarioDto usuarioDto)
    {
        RespuestaDto respuestaDto=new RespuestaDto();
        DirectorioActivo dir=new DirectorioActivo();
        String token = "";
        try
        {
            verifyParams( usuarioDto );

            if(dir.userAuthentication(usuarioDto)){
                token = JWT.createToken( String.valueOf( usuarioDto.getId() ));
                respuestaDto.setEstado("OK");
                respuestaDto.setMensaje("Bienvenido al sistema");
                respuestaDto.setToken(token);
            }
            else{
                respuestaDto.setEstado("BAD REQUEST");
                respuestaDto.setMensaje("Credenciales incorrectas");
                respuestaDto.setToken(null);
            }

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
            respuestaDto.setEstado("INTERNAL ERROR SERVER");
            respuestaDto.setMensaje("Error en el servidor");
            respuestaDto.setMensaje_soporte(problema);
        }
        System.out.println(respuestaDto.toString());
        return  respuestaDto;
    }

    @POST
    @Path( "/generateToken" )
    public RespuestaDto<UsuarioDto> generateToken(UsuarioDto usuarioDto) throws PruebaExcepcion
    {
        RespuestaDto respuestaDto=new RespuestaDto();
        String token = "";
        try
        {
            verifyParams( usuarioDto );
            token = JWT.createToken( String.valueOf( usuarioDto.getId() ));
            respuestaDto.setEstado("OK");
            respuestaDto.setMensaje("Token generado");
            respuestaDto.setToken(token);

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
            respuestaDto.setEstado("INTERNAL ERROR SERVER");
            respuestaDto.setMensaje("Error en el servidor");
            respuestaDto.setMensaje_soporte(problema);
        }
        System.out.println(respuestaDto);
        return  respuestaDto;
    }

    @POST
    @Path( "/validateToken" )
    public RespuestaDto<UsuarioDto> validateToken(UsuarioDto usuarioDto) throws PruebaExcepcion
    {
        RespuestaDto respuestaDto=new RespuestaDto();
        UsuarioDto resultado = new UsuarioDto();
        String idUsuario = "";
        try
        {
            verifyParams( usuarioDto );
            idUsuario = JWT.verifyToken( usuarioDto.getToken() );

            respuestaDto.setEstado("OK");
            respuestaDto.setMensaje("Validar token");
            respuestaDto.setObjecto(idUsuario);

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
            respuestaDto.setEstado("INTERNAL ERROR SERVER");
            respuestaDto.setMensaje("Error en el servidor");
            respuestaDto.setMensaje_soporte(problema);
        }
        return  respuestaDto;
    }

    @POST
    @Path( "/consulta-datos" )
    public RespuestaDto<UsuarioDto> consultaDatos(UsuarioDto usuarioDto)
    {
        RespuestaDto respuestaDto=new RespuestaDto();
        UsuarioDto resultado = new UsuarioDto();
        Object dataClaims;
        try
        {
            verifyParams( usuarioDto );
            dataClaims = JWT.getClaims( usuarioDto.getToken() );

            respuestaDto.setEstado("OK");
            respuestaDto.setMensaje("Validar token");
            respuestaDto.setObjecto(dataClaims);

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
            respuestaDto.setEstado("INTERNAL ERROR SERVER");
            respuestaDto.setMensaje("Error en el servidor");
            respuestaDto.setMensaje_soporte(problema);
        }
        return  respuestaDto;
    }
}
