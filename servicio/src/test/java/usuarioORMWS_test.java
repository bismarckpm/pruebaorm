import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.dtos.UsuarioDto;

public class usuarioORMWS_test {

    @Test
    public void addUserTest() throws Exception {
        ucab.dsw.servicio.UsuarioORMWS servicio = new ucab.dsw.servicio.UsuarioORMWS();
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setNombre( "Bismarck" );
        usuarioDto.setApellido( "Ponce" );
        usuarioDto.setCorreoelectronico( "bismarckpm@gmail.com" );
        usuarioDto.setEstatus( "A" );
        TipoUsuarioDto tipoUsuario = new TipoUsuarioDto( 1);
        usuarioDto.setTipoUsuarioDto( tipoUsuario );
        UsuarioDto resultado = servicio.add( usuarioDto );
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void deleteUserTest() throws Exception{
        ucab.dsw.servicio.UsuarioORMWS servicio = new ucab.dsw.servicio.UsuarioORMWS();

        UsuarioDto resultado = servicio.delete( 10 );
        Assert.assertEquals( resultado.getId(), 0  );
    }

    @Test
    public void updateUserTest() throws Exception{
        ucab.dsw.servicio.UsuarioORMWS servicio = new ucab.dsw.servicio.UsuarioORMWS();
        UsuarioDto usuarioDummy = new UsuarioDto();

        usuarioDummy.setCorreoelectronico("prueba1@gmail.com");
        usuarioDummy.setNombre("Victor");
        usuarioDummy.setApellido("Gonzalez");
        usuarioDummy.setEstatus("I");
        usuarioDummy.setId(14);

        UsuarioDto resultado = servicio.update( usuarioDummy );

        Assert.assertNotEquals( resultado.getId(), 0  );

    }

    @Test
    public void firstOneUserTest(){
        ucab.dsw.servicio.UsuarioORMWS servicio = new ucab.dsw.servicio.UsuarioORMWS();
        UsuarioDto resultado = servicio.getFirstOne(14);

        Assert.assertNotEquals( resultado.getId(), 0  );
    }





}
