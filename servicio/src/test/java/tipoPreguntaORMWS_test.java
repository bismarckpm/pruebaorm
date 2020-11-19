import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.entidades.TipoPregunta;

public class tipoPreguntaORMWS_test {

    @Test
    public void addTipoPreguntaTest() throws Exception {
        ucab.dsw.servicio.TipoPreguntaORMWS servicio = new ucab.dsw.servicio.TipoPreguntaORMWS();
        TipoPreguntaDto tipoPreguntaDto = new TipoPreguntaDto();
        tipoPreguntaDto.setDescripcion( "PruebaA" );
        tipoPreguntaDto.setStatus( "A" );

        TipoPreguntaDto resultado = servicio.add( tipoPreguntaDto );
        Assert.assertNotEquals( resultado.getId(), 0  );
    }
/*
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
    }*/
}
