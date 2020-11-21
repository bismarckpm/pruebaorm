import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.EncuestaDto;
import ucab.dsw.dtos.EstudioDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.servicio.PruebaEncuesta;

import java.time.Instant;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Omar David
 * Date: 20/11/20
 * Time: 11:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class PruebaEncuesta_Test{

    @Test
    public void addEncuestaTest() throws Exception
    {
        PruebaEncuesta servicio = new PruebaEncuesta();
        EncuestaDto encuestaDto = new EncuestaDto();
        encuestaDto .setFechaCreacion(Date.from(Instant.now()));
        encuestaDto .setEstatus("A");
        UsuarioDto usuarioCreador = new UsuarioDto();
        UsuarioDto usuarioAnalista = new UsuarioDto();
        EstudioDto estudio = new EstudioDto();
        encuestaDto.setUsuarioCreador(usuarioCreador);
        encuestaDto.setUsuarioAnalista(usuarioAnalista);
        encuestaDto.setEstudio(estudio);
        EncuestaDto resultado = servicio.addEncuesta(encuestaDto );
        Assert.assertNotEquals(resultado.getId(), 1);

    }

    @Test
    public void changeEncuestaTest() throws Exception
    {
        PruebaEncuesta servicio = new PruebaEncuesta();
        EncuestaDto encuestaDto = new EncuestaDto(10);
        encuestaDto .setFechaCreacion(Date.from(Instant.now()));
        encuestaDto .setEstatus("I");
        UsuarioDto usuarioCreador = new UsuarioDto();
        UsuarioDto usuarioAnalista = new UsuarioDto();
        EstudioDto estudio = new EstudioDto();
        encuestaDto.setUsuarioCreador(usuarioCreador);
        encuestaDto.setUsuarioAnalista(usuarioAnalista);
        encuestaDto.setEstudio(estudio);
        EncuestaDto resultado = servicio.changeEncuesta(encuestaDto);
        Assert.assertNotEquals( resultado.getId(), 0 );

    }

    @Test
    public void deleteEncuestaTest() throws Exception
    {
        PruebaEncuesta servicio = new PruebaEncuesta();
        EncuestaDto resultado = servicio.deleteEncuesta(10);
        Assert.assertNotEquals( resultado.getId(), 0 );

    }

    @Test
    public void showEncuestaTest() throws Exception
    {
        PruebaEncuesta servicio = new PruebaEncuesta();
        EncuestaDto encuestaDto= new EncuestaDto(6);
        EncuestaDto resultado = servicio.showEncuesta(encuestaDto.getId());
        Assert.assertEquals( resultado.getId(), 0);

    }

}
