import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.Usuario;
import ucab.dsw.servicio.pruebaORMWS;

import java.util.List;


public class pruebaORMWS_Test
{

    @Test
    public void addUserTest() throws Exception {
    pruebaORMWS servicio = new ucab.dsw.servicio.pruebaORMWS();
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
    public void updateUserTests() throws Exception {
        pruebaORMWS servicio = new pruebaORMWS();
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setNombre( "José Manuel" );
        usuarioDto.setApellido( "Teixeira" );
        usuarioDto.setCorreoelectronico( "jteixeira1102@gmail.com" );
        usuarioDto.setEstatus( "I" );
        TipoUsuarioDto tipoUsuario = new TipoUsuarioDto( 1);
        usuarioDto.setTipoUsuarioDto( tipoUsuario );
        UsuarioDto resultado = servicio.updateUser(1, usuarioDto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }


    @Test
    public void deleteUserTests() throws Exception{
        pruebaORMWS servicio = new pruebaORMWS();
        UsuarioDto resultado = servicio.deleteUser(11);
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void showUsersTest() throws Exception{
        pruebaORMWS servicio = new pruebaORMWS();
        List<Usuario> usuarios = servicio.showUsers();
        Assert.assertFalse("No existen usuarios",usuarios.isEmpty());
}


}
