import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.dtos.SubcategoriaDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.SolicitudEnt;

import java.util.List;

public class SolicitudCRUD_Test {

    @Test
    public void addSolicitudTest() throws Exception
    {
        ucab.dsw.servicio.SolicitudCRUD servicio = new ucab.dsw.servicio.SolicitudCRUD();
        SolicitudDto solicitudDto = new SolicitudDto();
        solicitudDto.setNombre("prueba");
        solicitudDto.setEstatus("A");
        solicitudDto.setFecha("01/01/2000");
        SubcategoriaDto subcategoriaDto = new SubcategoriaDto(1);
        solicitudDto.setSubcategoria(subcategoriaDto);
        UsuarioDto usuarioDto = new UsuarioDto();
        solicitudDto.setUsuario( usuarioDto );
        SolicitudDto resultado = servicio.addSolicitud( solicitudDto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void getSolicitudesTest()  throws  Exception
    {
        ucab.dsw.servicio.SolicitudCRUD servicio = new ucab.dsw.servicio.SolicitudCRUD();
        List<SolicitudEnt> solicitudes = servicio.getSolicitudes();
        Assert.assertFalse("No hay solicitudes",solicitudes.isEmpty());
    }

    @Test
    public void  updateSolicitudTest() throws Exception
    {
        ucab.dsw.servicio.SolicitudCRUD servicio = new ucab.dsw.servicio.SolicitudCRUD();
        SolicitudDto solicitudDto = new SolicitudDto();
        solicitudDto.setNombre("PruebaUpdate");
        solicitudDto.setEstatus("A");
        solicitudDto.setFecha("01/01/2001");
        SubcategoriaDto subcategoriaDto = new SubcategoriaDto(2);
        solicitudDto.setSubcategoria(subcategoriaDto);
        UsuarioDto usuarioDto = new UsuarioDto(9);
        solicitudDto.setUsuario( usuarioDto );
        SolicitudDto resultado = servicio.updateSolicitud(5, solicitudDto);
        Assert.assertNotEquals(resultado.getId(), 0);
    }

    @Test
    public void deleteSolicitudTest() throws Exception
    {
        ucab.dsw.servicio.SolicitudCRUD servicio = new ucab.dsw.servicio.SolicitudCRUD();
        SolicitudDto resultado = servicio.deleteSolicitud(6);
        Assert.assertNotEquals(resultado.getId(), 0);
    }
}
