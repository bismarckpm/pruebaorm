import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.dtos.UsuarioDto;


public class pruebaORMWS_Test
{
    private ucab.dsw.servicio.pruebaORMWS servicio;

    public pruebaORMWS_Test() {
        this.servicio = new ucab.dsw.servicio.pruebaORMWS();
    }

    @Test
    public void addUserTest() throws Exception
    {
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setNombre( "Bismarck" );
        usuarioDto.setApellido( "Ponce" );
        usuarioDto.setCorreoelectronico( "bismarckpm@gmail.com" );
        usuarioDto.setEstatus( "A" );
        TipoUsuarioDto tipoUsuario = new TipoUsuarioDto( 1);
        usuarioDto.setTipoUsuarioDto( tipoUsuario );
        UsuarioDto resultado = this.servicio.addUser( usuarioDto );
        Assert.assertNotEquals( resultado.getId(), 0  );
    }
    @Test
    public void deleteUsuarioTest() throws Exception
    {
        UsuarioDto resultado = this.servicio.deleteUsuario(5);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void editUsuarioTest() throws Exception
    {
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setNombre( "Gabriel" );
        usuarioDto.setApellido( "Romero" );
        usuarioDto.setCorreoelectronico( "gabriel@gmail.com" );
        usuarioDto.setEstatus( "A" );
        TipoUsuarioDto tipoUsuario = new TipoUsuarioDto( 1);
        usuarioDto.setTipoUsuarioDto( tipoUsuario );
        UsuarioDto resultado = this.servicio.editUsuario(6,usuarioDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void getUsuarioTest() throws Exception
    {
        UsuarioDto resultado = this.servicio.getUsuario(6);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }








}
