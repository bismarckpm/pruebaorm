import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.TipoUsuarioDto;

public class tipoUsuarioORMWS_test {

    @Test
    public void addUserTest() throws Exception {
        ucab.dsw.servicio.TipoUsuarioORMWS servicio = new ucab.dsw.servicio.TipoUsuarioORMWS();

        TipoUsuarioDto tipoUsuarioDto = new TipoUsuarioDto();
        tipoUsuarioDto.setDescripcion( "Prueba" );
        tipoUsuarioDto.setEstatus( "A" );

        TipoUsuarioDto resultado = servicio.add( tipoUsuarioDto );
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void deleteUserTest() throws Exception{
        ucab.dsw.servicio.TipoUsuarioORMWS servicio = new ucab.dsw.servicio.TipoUsuarioORMWS();

        TipoUsuarioDto resultado = servicio.delete((long) 1);
        Assert.assertEquals( resultado.getId(), 0  );
    }

    @Test
    public void updateUserTest() throws Exception{
        ucab.dsw.servicio.TipoUsuarioORMWS servicio = new ucab.dsw.servicio.TipoUsuarioORMWS();
        TipoUsuarioDto tipoUsuarioDummy = new TipoUsuarioDto();

        tipoUsuarioDummy.setEstatus("A");
        tipoUsuarioDummy.setDescripcion("PruebaA");
        tipoUsuarioDummy.setId(1);

        TipoUsuarioDto resultado = servicio.update( tipoUsuarioDummy );

        Assert.assertNotEquals( resultado.getId(), 0  );

    }


    @Test
    public void firstOneTipoUsuarioTest(){
        ucab.dsw.servicio.TipoUsuarioORMWS servicio = new ucab.dsw.servicio.TipoUsuarioORMWS();
        TipoUsuarioDto resultado = servicio.getFirstOne(1);

        Assert.assertNotEquals( resultado.getId(), 0  );
    }


}
