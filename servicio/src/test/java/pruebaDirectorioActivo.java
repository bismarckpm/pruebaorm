import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.directorio.DirectorioActivo;
import ucab.dsw.dtos.RespuestaDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.excepciones.PruebaExcepcion;
import ucab.dsw.servicio.pruebaJWT;

public class pruebaDirectorioActivo
{
    @Test
    public void createUserLDAP()
    {
        UsuarioDto user = new UsuarioDto();
        user.setCorreoelectronico( "gabriel@gmail.com" );
        user.setContrasena( "12345" );
        DirectorioActivo ldap = new DirectorioActivo();
        ldap.addEntryToLdap( user );
    }

    @Test
    public void deleteUserLDAP()
    {
        UsuarioDto user = new UsuarioDto();
        user.setCorreoelectronico( "gabriel@gmail.com" );
        DirectorioActivo ldap = new DirectorioActivo();
        ldap.deleteEntry( user );
    }

    @Test
    public void getUserLDAP()
    {
        UsuarioDto user = new UsuarioDto();
        user.setCorreoelectronico( "gabriel@gmail.com" );
        DirectorioActivo ldap = new DirectorioActivo();
        ldap.getEntry( user );
    }

    @Test
    public void changePassword()
    {
        UsuarioDto user = new UsuarioDto();
        user.setCorreoelectronico( "bismarckpmpruebaLDAP@gmail.com" );
        user.setContrasena( "MARIAPEPE" );
        DirectorioActivo ldap = new DirectorioActivo();
        ldap.changePassword( user );
    }

    @Test
    public void userAuthentication()
    {
        UsuarioDto user = new UsuarioDto();
        user.setCorreoelectronico( "gabriel@gmail.com" );
        user.setContrasena( "12345" );
        DirectorioActivo ldap = new DirectorioActivo();
        ldap.userAuthentication( user );
    }

    @Test
    public void AutenticarJWT() throws PruebaExcepcion {
        UsuarioDto user = new UsuarioDto();
        user.setCorreoelectronico( "gabriel@gmail.com" );
        user.setContrasena( "12345" );
        user.setId(1);
        ucab.dsw.servicio.pruebaJWT autenticar = new pruebaJWT();
        RespuestaDto<UsuarioDto> token=autenticar.autenticarUsuario(user);
        Assert.assertNotEquals(null,token.getToken());
    }

    @Test
    public void ValidateJWT() throws PruebaExcepcion {
        UsuarioDto user = new UsuarioDto();
        user.setToken("eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJ1Y2FiLmRzdyIsInN1YiI6IjEiLCJleHAiOjE2MTA3ODkzMTQsIm5iZiI6MTYxMDc4MDY3NCwiaWF0IjoxNjEwNzgwNjc0LCJqdGkiOiJiMmM0YjQ2Mi04ZjY2LTRmOTktODRkYS01MzhlMjE2NWNmNTQifQ.slDG-IalO1nYQUmcaMMPRaX0uP2xRCsknhJ-M5wXVP9yNzTQz7uAwbxpezSyIs3PnH_MKufvpNb_8kGsRN3zBQ");
        ucab.dsw.servicio.pruebaJWT autenticar = new pruebaJWT();
        RespuestaDto<UsuarioDto> token=autenticar.validateToken(user);
        Assert.assertNotEquals(null,token.getObjecto());
    }

    @Test
    public void getClaimsJWT() throws PruebaExcepcion {
        UsuarioDto user = new UsuarioDto();
        user.setToken("eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJ1Y2FiLmRzdyIsInN1YiI6IjEiLCJleHAiOjE2MTA3ODkzMTQsIm5iZiI6MTYxMDc4MDY3NCwiaWF0IjoxNjEwNzgwNjc0LCJqdGkiOiJiMmM0YjQ2Mi04ZjY2LTRmOTktODRkYS01MzhlMjE2NWNmNTQifQ.slDG-IalO1nYQUmcaMMPRaX0uP2xRCsknhJ-M5wXVP9yNzTQz7uAwbxpezSyIs3PnH_MKufvpNb_8kGsRN3zBQ");
        ucab.dsw.servicio.pruebaJWT autenticar = new pruebaJWT();
        RespuestaDto<UsuarioDto> token=autenticar.consultaDatos(user);
        Assert.assertNotEquals(null,token.getObjecto());
    }

}
