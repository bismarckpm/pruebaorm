import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.entidades.TipoUsuario;

public class pruebaTipoUsuarioTest {

    @Test
    public void addTipoUsuarioTest() throws Exception {
        ucab.dsw.servicio.pruebaTipoUsuario servicio = new ucab.dsw.servicio.pruebaTipoUsuario();
        TipoUsuarioDto tipoUsuarioDto = new TipoUsuarioDto();
        tipoUsuarioDto.setDescripcion("Jose");
        tipoUsuarioDto.setEstatus("I");
        TipoUsuarioDto resultado = servicio.addTipoUsuario(tipoUsuarioDto);
        Assert.assertNotEquals(resultado.getId(), 1);
    }

    @Test
    public void changeTipoUsuarioTest() throws Exception{
        ucab.dsw.servicio.pruebaTipoUsuario servicio = new ucab.dsw.servicio.pruebaTipoUsuario();
        TipoUsuarioDto  tipoUsuarioDto = new TipoUsuarioDto( 4);
        tipoUsuarioDto.setDescripcion( "Juan" );
        tipoUsuarioDto.setEstatus("A");
        TipoUsuarioDto resultado = servicio.changeTipoUsuario( tipoUsuarioDto );
        Assert.assertNotEquals( resultado.getId(), 1 );
    }

    @Test
    public void deleteTipoUserTest() throws Exception
    {
        ucab.dsw.servicio.pruebaTipoUsuario servicio = new ucab.dsw.servicio.pruebaTipoUsuario();
        TipoUsuarioDto resultado = servicio.deleteTipoUsuario(2);
        Assert.assertNotEquals( resultado.getId(), 1);

    }
    @Test
    public void findTipoUserTest() throws Exception
    {
        ucab.dsw.servicio.pruebaTipoUsuario servicio = new ucab.dsw.servicio.pruebaTipoUsuario();
        TipoUsuarioDto  tipoUsuarioDto= new TipoUsuarioDto(1);
        TipoUsuarioDto resultado = servicio.showTipoUsuario( tipoUsuarioDto.getId() );
        Assert.assertNotEquals( resultado.getId(), 1);

    }

}
