import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.dtos.SubcategoriaDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.servicio.PruebaSolicitud;

import java.time.Instant;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Omar David
 * Date: 20/11/20
 * Time: 11:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class PruebaSolicitud_Test{

    @Test
    public void addSolicitudTest() throws Exception
    {
        PruebaSolicitud servicio = new PruebaSolicitud();
        SolicitudDto solicitudDto = new SolicitudDto();
        solicitudDto.setNombre("Prueba solicitud");
        solicitudDto.setFecha(Date.from(Instant.now()).toString());
        solicitudDto .setEstatus("A");
        UsuarioDto usuario = new UsuarioDto();
        SubcategoriaDto subcategoria = new SubcategoriaDto();
        solicitudDto.setUsuario(usuario);
        solicitudDto.setSubcategoria(subcategoria);
        SolicitudDto resultado = servicio.addSolicitud(solicitudDto);
        Assert.assertNotEquals(resultado.getId(), 1);

    }

    @Test
    public void changeSolicitudTest() throws Exception
    {
        PruebaSolicitud servicio = new PruebaSolicitud();
        SolicitudDto solicitudDto = new SolicitudDto(10);
        solicitudDto.setNombre("Prueba solicitud update");
        solicitudDto.setFecha(Date.from(Instant.now()).toString());
        solicitudDto.setEstatus("I");
        UsuarioDto usuario = new UsuarioDto();
        SubcategoriaDto subcategoria = new SubcategoriaDto();
        solicitudDto.setUsuario(usuario);
        solicitudDto.setSubcategoria(subcategoria);
        SolicitudDto resultado = servicio.changeSolicitud(solicitudDto);
        Assert.assertNotEquals( resultado.getId(), 0 );

    }

    @Test
    public void deleteSolicitudTest() throws Exception
    {
        PruebaSolicitud servicio = new PruebaSolicitud();
        SolicitudDto resultado = servicio.deleteSolicitud(10);
        Assert.assertNotEquals( resultado.getId(), 0 );

    }

    @Test
    public void showSolicitudTest() throws Exception
    {
        PruebaSolicitud servicio = new PruebaSolicitud();
        SolicitudDto solicitudDto= new SolicitudDto(6);
        SolicitudDto resultado = servicio.showSolicitud(solicitudDto.getId());
        Assert.assertEquals( resultado.getId(), 0);

    }

}

