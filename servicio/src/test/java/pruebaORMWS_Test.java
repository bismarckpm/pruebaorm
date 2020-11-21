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
    public void addUserTest() throws Exception {
        ucab.dsw.servicio.pruebaORMWS servicio = new ucab.dsw.servicio.pruebaORMWS();
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setNombre( "Bismarck" );
        usuarioDto.setApellido( "Ponce" );
        usuarioDto.setCorreoelectronico( "bismarckpm@gmail.com" );
        usuarioDto.setEstatus( "A" );
        TipoUsuarioDto tipoUsuario = new TipoUsuarioDto( 1);
        usuarioDto.setTipoUsuarioDto( tipoUsuario );
        UsuarioDto resultado = servicio.addUser( usuarioDto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void getUsersTest()  throws  Exception
    {
        ucab.dsw.servicio.pruebaORMWS servicio = new ucab.dsw.servicio.pruebaORMWS();
        List<Usuario> usuarios = servicio.getUsers();
        Assert.assertFalse("Consulta Usuario",usuarios.isEmpty());
    }

    @Test
    public void updateUserTest() throws Exception {
        ucab.dsw.servicio.pruebaORMWS servicio = new ucab.dsw.servicio.pruebaORMWS();
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setNombre( "Gregg" );
        usuarioDto.setApellido( "Spinetti" );
        usuarioDto.setCorreoelectronico( "greggspinetti@gmail.com" );
        usuarioDto.setEstatus( "A" );
        UsuarioDto resultado = servicio.updateUsuario(8,usuarioDto );
        Assert.assertNotEquals( resultado.getId(), 0);
    }

    @Test
    public void deleteUsuarioTest() throws Exception{

        ucab.dsw.servicio.pruebaORMWS servicio = new ucab.dsw.servicio.pruebaORMWS();
        UsuarioDto resultado = servicio.deleteUser(8);
        Assert.assertNotEquals( resultado.getId(), 0);

    }


}
