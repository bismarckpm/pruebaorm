import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.dtos.UsuarioDto;

public class pruebaUsuarioControlador {

    @Test
    public void obtenerUsuarioTest() throws Exception
    {
        ucab.dsw.servicio.UsuarioControlador servicio = new ucab.dsw.servicio.UsuarioControlador();
        UsuarioDto resultado = servicio.obtenerUsuario(  (long) 2);
        Assert.assertEquals( resultado.getId(), 2 );
    }

    @Test
    public void crearUsuarioPrueba() throws Exception
    {
        ucab.dsw.servicio.UsuarioControlador servicio = new ucab.dsw.servicio.UsuarioControlador();
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setNombre( "Yeferson");
        usuarioDto.setApellido( "Soteldo");
        usuarioDto.setCorreoelectronico( "pablo@gmail.com");
        usuarioDto.setEstatus( "A");
        TipoUsuarioDto tipoUsuario = new TipoUsuarioDto( 5);
        usuarioDto.setTipoUsuarioDto( tipoUsuario);
        UsuarioDto resultado = servicio.crearUsuario( usuarioDto);
        Assert.assertNotEquals( resultado.getId(), 0);
    }

    @Test
    public void modificarUsuarioPrueba() throws Exception
    {
        ucab.dsw.servicio.UsuarioControlador servicio = new ucab.dsw.servicio.UsuarioControlador();
        UsuarioDto usuarioDto = new UsuarioDto(7);
        usuarioDto.setNombre( "Juan");
        usuarioDto.setApellido( "Arango");
        usuarioDto.setCorreoelectronico( "arangol@gmail.com");
        usuarioDto.setEstatus( "A");
        TipoUsuarioDto tipoUsuario = new TipoUsuarioDto( 5);
        usuarioDto.setTipoUsuarioDto( tipoUsuario);
        UsuarioDto resultado = servicio.modificarUsuario( usuarioDto);
        Assert.assertNotEquals( resultado.getId(), 0);
    }

    @Test
    public void borrarUsuarioPrueba() throws Exception
    {
        ucab.dsw.servicio.UsuarioControlador servicio = new ucab.dsw.servicio.UsuarioControlador();
        UsuarioDto resultado = servicio.borrarUsuario( (long) 3);
        Assert.assertNotEquals( resultado.getId(), 0);
    }
}
