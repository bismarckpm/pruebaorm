import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.OpcionDto;
import ucab.dsw.dtos.PreguntaDto;
import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.entidades.TipoUsuario;

public class testTipoUsuario_Test {

    @Test
    public void addTipoUsuarioTest() throws Exception
    {
        ucab.dsw.servicio.testTipoUsuario servicio = new ucab.dsw.servicio.testTipoUsuario();
        TipoUsuarioDto tipoUsuarioDto = new TipoUsuarioDto();
        tipoUsuarioDto.setDescripcion( "tipo 1" );
        tipoUsuarioDto.setEstatus( "A" );
        TipoUsuarioDto resultado = servicio.addTipoUsuario( tipoUsuarioDto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void modifyTipoUsuarioTest() throws Exception
    {
        ucab.dsw.servicio.testTipoUsuario servicio = new ucab.dsw.servicio.testTipoUsuario();
        TipoUsuarioDto tipousuarioDto = new TipoUsuarioDto(5);
        tipousuarioDto.setDescripcion( "tipo 2" );
        tipousuarioDto.setEstatus( "I" );
        TipoUsuarioDto resultado = servicio.modifyTipoUsuario(tipousuarioDto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void deleteTipoUsuarioTest() throws Exception
    {
        ucab.dsw.servicio.testTipoUsuario servicio = new ucab.dsw.servicio.testTipoUsuario();
        TipoUsuarioDto tipoUsuarioDto = new TipoUsuarioDto(1);
        TipoUsuarioDto resultado = servicio.deleteTipoUsuario(tipoUsuarioDto.getId());
        Assert.assertNotEquals( resultado.getId(), 0);
    }

    @Test
    public void consultarTipoUsuarioTest() throws Exception
    {
        ucab.dsw.servicio.testTipoUsuario servicio = new ucab.dsw.servicio.testTipoUsuario();
        TipoUsuarioDto tipoUsuarioDto = new TipoUsuarioDto(5);
        TipoUsuarioDto resultado = servicio.consultarTiposUsuario(tipoUsuarioDto.getId());
        System.out.println("Resultado = ");
        System.out.print(resultado);
        Assert.assertNotEquals( resultado.getId(), 0);
    }
}
