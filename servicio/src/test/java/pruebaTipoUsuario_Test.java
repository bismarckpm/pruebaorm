import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.entidades.TipoUsuario;

import java.util.List;

public class pruebaTipoUsuario_Test {
    @Test
    public void addTipoUsuarioTest() throws Exception {
        ucab.dsw.servicio.pruebaTipoUsuario servicio = new ucab.dsw.servicio.pruebaTipoUsuario();
        TipoUsuarioDto tipoUsuarioDto = new TipoUsuarioDto();
        tipoUsuarioDto.setDescripcion("Cliente");
        tipoUsuarioDto.setEstatus("A");
        TipoUsuarioDto resultado = servicio.addTipoUsuario(tipoUsuarioDto);
        Assert.assertNotEquals(resultado.getId(), 0);
    }

    @Test
    public void getTipoUsuario() throws Exception{
        ucab.dsw.servicio.pruebaTipoUsuario servicio = new ucab.dsw.servicio.pruebaTipoUsuario();
        List<TipoUsuario> tipoUsuario = servicio.getTipoUsuario();
        Assert.assertFalse("Consulta TipoUsuario",tipoUsuario.isEmpty());
    }

    @Test
    public void updateTipoUsuarioTest() throws Exception {
        ucab.dsw.servicio.pruebaTipoUsuario servicio = new ucab.dsw.servicio.pruebaTipoUsuario();
        TipoUsuarioDto tipoUsuarioDto = new TipoUsuarioDto();
        tipoUsuarioDto.setDescripcion("Cliente");
        tipoUsuarioDto.setEstatus("A");
        TipoUsuarioDto resultado = servicio.updateTipoUsuario(1,tipoUsuarioDto);
        Assert.assertNotEquals(resultado.getId(), 0);
    }

    @Test
    public void deleteTipoUsuarioTest() throws Exception {

        ucab.dsw.servicio.pruebaTipoUsuario servicio = new ucab.dsw.servicio.pruebaTipoUsuario();
        TipoUsuarioDto resultado = servicio.deleteTipoUsuario(1);
        Assert.assertNotEquals(resultado.getId(), 0);

    }
}