import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.TipoUsuarioDto;

public class TipoUsuarioCRUD_Test {

    @Test
    public void addTipoUsuarioTest() throws Exception
    {
        ucab.dsw.servicio.TipoUsuarioCRUD servicio = new ucab.dsw.servicio.TipoUsuarioCRUD();
        TipoUsuarioDto tipousuarioDto = new TipoUsuarioDto();
        tipousuarioDto.setDescripcion("prueba");
        tipousuarioDto.setEstatus("A");
        TipoUsuarioDto resultado = servicio.addTipoUsuario( tipousuarioDto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }
}
