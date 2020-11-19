import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.dtos.EncuestaDto;
import ucab.dsw.dtos.EstudioDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.servicio.CategoriaController;
import ucab.dsw.servicio.EncuestaController;


public class EncuestaController_test {
    @Test
    public void addEncuestaTest() throws Exception
    {
        EncuestaController servicio = new EncuestaController();
        EncuestaDto encuestaDto = new EncuestaDto();
        encuestaDto.setStatus("C");
        encuestaDto.setFechaCreacion(java.sql.Date.valueOf("2020-11-18"));
        UsuarioDto usuarioDtoCreador = new UsuarioDto(8);
        UsuarioDto usuarioDtoAnalista = new UsuarioDto(9);
        encuestaDto.setIdUsuario_Creador(usuarioDtoCreador);
        encuestaDto.setIdUsuario_Analista(usuarioDtoAnalista);
        EstudioDto estudio = new EstudioDto(3);
        encuestaDto.setIdEstudio(estudio);
        EncuestaDto resultado = servicio.addEncuesta(encuestaDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }
    @Test
    public void modifyEncuestaTest() throws Exception
    {
        EncuestaController servicio = new EncuestaController();
        EncuestaDto encuestaDto = new EncuestaDto(8);
        encuestaDto.setStatus("C");
        encuestaDto.setFechaCreacion(java.sql.Date.valueOf("2019-11-17"));
        encuestaDto.setIdUsuario_Creador(new UsuarioDto(9));
        encuestaDto.setIdUsuario_Analista(new UsuarioDto(8));
        encuestaDto.setIdEstudio(new EstudioDto(3));
        EncuestaDto resultado = servicio.modificarEncuesta(encuestaDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void getEncuestaTest() throws Exception {
        EncuestaController servicio = new EncuestaController();
        EncuestaDto encuestaDto = new EncuestaDto(3);
        EncuestaDto resultado = servicio.obtenerEncuesta( encuestaDto );
        Assert.assertEquals( resultado.getId(), 3 );
    }


}
