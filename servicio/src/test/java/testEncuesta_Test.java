import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.EncuestaDto;
import ucab.dsw.dtos.EstudioDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.Encuesta;


import java.util.Date;
import java.util.List;

public class testEncuesta_Test {

    @Test
    public void addEncuestaTest() throws Exception
    {
        Date date = new Date();
        ucab.dsw.servicio.testEncuesta servicio = new ucab.dsw.servicio.testEncuesta();
        EncuestaDto encuestaDto = new EncuestaDto();
        encuestaDto.setFechacreacion( date );
        encuestaDto.setEstatus("E");
        UsuarioDto usuarioDtoCreador = new UsuarioDto(21);
        encuestaDto.setUsuarioCreadorDto(usuarioDtoCreador);
        UsuarioDto usuarioDtoAnalista = new UsuarioDto(20);
        encuestaDto.setUsuarioAnalistaDto(usuarioDtoAnalista);
        EstudioDto estudioDto = new EstudioDto(1);
        encuestaDto.setEstudioDto(estudioDto);
        EncuestaDto resultado = servicio.addEncuesta( encuestaDto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void changeEncuestaTest() throws Exception
    {
        Date date = new Date();
        ucab.dsw.servicio.testEncuesta servicio = new ucab.dsw.servicio.testEncuesta();
        EncuestaDto encuestaDto = new EncuestaDto(10);

        encuestaDto.setFechacreacion( date );
        encuestaDto.setEstatus("C");

        UsuarioDto usuarioDtoCreador = new UsuarioDto(17);
        encuestaDto.setUsuarioCreadorDto(usuarioDtoCreador);

        UsuarioDto usuarioDtoAnalista = new UsuarioDto(15);
        encuestaDto.setUsuarioAnalistaDto(usuarioDtoAnalista);

        EstudioDto estudioDto = new EstudioDto(1);
        encuestaDto.setEstudioDto(estudioDto);
        EncuestaDto resultado = servicio.changeEncuesta(10, encuestaDto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void deleteEncuesta() throws Exception
    {
        ucab.dsw.servicio.testEncuesta servicio = new ucab.dsw.servicio.testEncuesta();
        EncuestaDto encuestaDto = new EncuestaDto(11);
        EncuestaDto resultado = servicio.deleteEncuesta(encuestaDto.getId());
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void getEncuesta() throws Exception
    {
        ucab.dsw.servicio.testEncuesta servicio = new ucab.dsw.servicio.testEncuesta();
        EncuestaDto encuestaDto = new EncuestaDto(2);
        EncuestaDto resultado = servicio.getEncuesta(encuestaDto.getId());

        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void findAllEncuesta() throws Exception
    {
        ucab.dsw.servicio.testEncuesta servicio = new ucab.dsw.servicio.testEncuesta();
        List<Encuesta> resultado = servicio.findAllEncuesta();
        Assert.assertNotEquals( resultado, 0 );
    }



}
