import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.Usuario;

import java.util.List;


public class pruebaORMWS_Test
{

    @Test
    public void addUserTest() throws Exception
    {
        ucab.dsw.servicio.pruebaORMWS servicio = new ucab.dsw.servicio.pruebaORMWS();
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setNombre( "Bismarck" );
        usuarioDto.setApellido( "Ponce" );
        usuarioDto.setCorreoelectronico( "bismarckpm@gmail.com" );
        usuarioDto.setEstatus( "A" );
        TipoUsuarioDto tipoUsuario = new TipoUsuarioDto( 1);
        usuarioDto.setTipoUsuarioDto( tipoUsuario );
        UsuarioDto resultado = servicio.addUser( usuarioDto );
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void getUsersTest()  throws  Exception
    {
        ucab.dsw.servicio.pruebaORMWS servicio = new ucab.dsw.servicio.pruebaORMWS();
        List<Usuario> usuarios = servicio.getUsers();
        Assert.assertFalse("No hay usuarios",usuarios.isEmpty());
    }

    @Test
    public void  updateUsuarioTest() throws Exception
    {
        ucab.dsw.servicio.pruebaORMWS servicio = new ucab.dsw.servicio.pruebaORMWS();
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setNombre("PruebaUpdate");
        usuarioDto.setApellido("Update");
        usuarioDto.setCorreoelectronico("prueba@update.com");
        UsuarioDto resultado = servicio.updateUsuario(8, usuarioDto);
        Assert.assertNotEquals(resultado.getId(), 0);
    }

    @Test
    public void deleteUsuarioTest() throws Exception
    {
        ucab.dsw.servicio.pruebaORMWS servicio = new ucab.dsw.servicio.pruebaORMWS();
        UsuarioDto resultado = servicio.deleteUsuario(12);
        Assert.assertNotEquals(resultado.getId(), 0);
    }


}
