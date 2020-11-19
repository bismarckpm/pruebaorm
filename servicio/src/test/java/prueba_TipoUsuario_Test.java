import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.entidades.TipoUsuario;


public class prueba_TipoUsuario_Test
{

    @Test
    public void addTipoUsuarioTest() throws Exception
    {
        ucab.dsw.servicio.prueba_TipoUsuario servicio = new ucab.dsw.servicio.prueba_TipoUsuario();
        TipoUsuarioDto  tipoUsuarioDto= new TipoUsuarioDto();
        tipoUsuarioDto.setDescripcion( "Bismarck" );
        tipoUsuarioDto.setEstatus("A");
        TipoUsuarioDto resultado = servicio.addTipoUser( tipoUsuarioDto );
        Assert.assertNotEquals( resultado.getId(), 0 );

    }


}