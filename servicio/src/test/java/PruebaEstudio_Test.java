import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.EstudioDto;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.servicio.PruebaEstudio;

import java.time.Instant;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Omar David
 * Date: 20/11/20
 * Time: 11:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class PruebaEstudio_Test{

    @Test
    public void addEstudioTest() throws Exception
    {
        PruebaEstudio servicio = new PruebaEstudio();
        EstudioDto estudioDto= new EstudioDto();
        estudioDto.setFechaCreacion(Date.from(Instant.now()));
        estudioDto.setEstatus("A");
        UsuarioDto usuario = new UsuarioDto();
        SolicitudDto solicitud = new SolicitudDto();
        estudioDto.setUsuario(usuario);
        estudioDto.setSolicitud(solicitud);
        EstudioDto resultado = servicio.addEstudio(estudioDto);
        Assert.assertNotEquals(resultado.getId(), 1);

    }

    @Test
    public void changeEstudioTest() throws Exception
    {
        PruebaEstudio servicio = new PruebaEstudio();
        EstudioDto  estudioDto= new EstudioDto(100);
        estudioDto.setFechaCreacion(Date.from(Instant.now()));
        estudioDto.setEstatus("I");
        UsuarioDto usuario = new UsuarioDto();
        SolicitudDto solicitud = new SolicitudDto();
        estudioDto.setUsuario(usuario);
        estudioDto.setSolicitud(solicitud);;
        EstudioDto resultado = servicio.changeEstudio(estudioDto);
        Assert.assertNotEquals( resultado.getId(), 0 );

    }

    @Test
    public void deleteEstudioTest() throws Exception
    {
        PruebaEstudio servicio = new PruebaEstudio();
        EstudioDto resultado = servicio.deleteEstudio(10);
        Assert.assertNotEquals( resultado.getId(), 0 );

    }

    @Test
    public void showEstudioTest() throws Exception
    {
        PruebaEstudio servicio = new PruebaEstudio();
        EstudioDto EstudioDto= new EstudioDto( 6);
        EstudioDto resultado = servicio.showEstudio(EstudioDto.getId());
        Assert.assertEquals( resultado.getId(), 0);

    }

}
