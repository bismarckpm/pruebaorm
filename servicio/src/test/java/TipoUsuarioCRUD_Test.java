import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.TipoUsuario;
import ucab.dsw.entidades.Usuario;

import java.util.List;

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

    @Test
    public void getUsersTest()  throws  Exception
    {
        ucab.dsw.servicio.TipoUsuarioCRUD servicio = new ucab.dsw.servicio.TipoUsuarioCRUD();
        List<TipoUsuario> tipousuarios = servicio.getTipoUsers();
        Assert.assertFalse("No hay tipo usuarios",tipousuarios.isEmpty());
    }

    @Test
    public void  updateTipoUsuarioTest() throws Exception
    {
        ucab.dsw.servicio.TipoUsuarioCRUD servicio = new ucab.dsw.servicio.TipoUsuarioCRUD();
        TipoUsuarioDto tipousuarioDto = new TipoUsuarioDto();
        tipousuarioDto.setDescripcion("PruebaUpdate");
        tipousuarioDto.setEstatus("A");
        TipoUsuarioDto resultado = servicio.updateTipoUsuario(11, tipousuarioDto);
        Assert.assertNotEquals(resultado.getId(), 0);
    }

    @Test
    public void deleteTipoUsuarioTest() throws Exception
    {
        ucab.dsw.servicio.TipoUsuarioCRUD servicio = new ucab.dsw.servicio.TipoUsuarioCRUD();
        TipoUsuarioDto resultado = servicio.deleteTipoUsuario(12);
        Assert.assertNotEquals(resultado.getId(), 0);
    }
}
