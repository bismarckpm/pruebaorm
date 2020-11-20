import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.dtos.SubCategoriaDto;
import ucab.dsw.dtos.UsuarioDto;

public class pruebaSolicitudControlador {
    @Test
    public void createSolicitudTest() throws Exception {

        ucab.dsw.servicio.SolicitudControlador servicio = new ucab.dsw.servicio.SolicitudControlador();
        SolicitudDto solicitudDto = new SolicitudDto();
        solicitudDto.setFecha("2020-11-20");
        solicitudDto.setEstatus("A");
        solicitudDto.setNombre("Solictud_test");
        solicitudDto.set_SubCategoria(new SubCategoriaDto(28));
        solicitudDto.set_Usuario(new UsuarioDto(89));
        SolicitudDto resultado = servicio.addSolicitud(solicitudDto);

        Assert.assertNotEquals(resultado.getId(), 0);
    }
    @Test
    public void updateSolicitudTest() throws Exception
    {
        ucab.dsw.servicio.SolicitudControlador servicio = new ucab.dsw.servicio.SolicitudControlador();
        SolicitudDto solicitudDto = new SolicitudDto(1);
        solicitudDto.setFecha("2020-11-20");
        solicitudDto.setEstatus("A");
        solicitudDto.setNombre("upd_Solictud_test");
        solicitudDto.set_SubCategoria(new SubCategoriaDto(28));
        solicitudDto.set_Usuario(new UsuarioDto(89));
        SolicitudDto resultado = servicio.updateSolicitud(solicitudDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void getSolicitudTest() throws Exception
    {
        ucab.dsw.servicio.SolicitudControlador servicio = new ucab.dsw.servicio.SolicitudControlador();
        SolicitudDto resultado = servicio.obtenerSolicitud( 5);
        Assert.assertEquals( resultado.getId(),5);
    }
    @Test
    public void ddeleteSolicitudTest() throws Exception
    {
        ucab.dsw.servicio.SolicitudControlador servicio = new ucab.dsw.servicio.SolicitudControlador();
        SolicitudDto resultado = servicio.deleteSolicitud((long) 2);
        Assert.assertEquals( resultado.getId(), 2);
    }
}
