import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.dtos.OpcionDto;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.dtos.SubCategoriaDto;
import ucab.dsw.dtos.UsuarioDto;

public class prueba_Solicitud_Test {
    @Test
    public void addSolicitudTest() throws Exception {
        ucab.dsw.servicio.prueba_Solicitud servicio = new ucab.dsw.servicio.prueba_Solicitud();
        SolicitudDto solicituddto = new SolicitudDto();

        solicituddto.setNombre("Meradeo Zapatos XL");
        solicituddto.setFecha("2020/12/24");
        solicituddto.setEstatus("A");
        UsuarioDto idusuario = new UsuarioDto(8);
        solicituddto.setIdUsuario(idusuario);
        SubCategoriaDto idsubcategoria = new SubCategoriaDto(1);
        solicituddto.setIdSubCategoria(idsubcategoria);

        SolicitudDto resultado = servicio.addSolicitud( solicituddto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void changeSolicitudTest() throws Exception {
        ucab.dsw.servicio.prueba_Solicitud servicio = new ucab.dsw.servicio.prueba_Solicitud();
        SolicitudDto solicituddto = new SolicitudDto(1);

        solicituddto.setNombre("Franelas cabilla");
        solicituddto.setFecha("2021/01/15");
        solicituddto.setEstatus("I");
        UsuarioDto idusuario = new UsuarioDto(8);
        solicituddto.setIdUsuario(idusuario);
        SubCategoriaDto idsubcategoria = new SubCategoriaDto(1);
        solicituddto.setIdSubCategoria(idsubcategoria);

        SolicitudDto resultado = servicio.changeSolicitud( solicituddto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void deleteSolicitudTest() throws Exception {
        ucab.dsw.servicio.prueba_Solicitud servicio = new ucab.dsw.servicio.prueba_Solicitud();
        SolicitudDto solicituddto= new SolicitudDto( 2);
        SolicitudDto resultado = servicio.deleteSolicitud( solicituddto.getId() );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void findSolicitudTest() throws Exception {
        ucab.dsw.servicio.prueba_Solicitud servicio = new ucab.dsw.servicio.prueba_Solicitud();
        SolicitudDto  solicituddto = new SolicitudDto( 3);
        SolicitudDto resultado = servicio.findSolicitud( solicituddto.getId() );
        Assert.assertNotEquals( resultado.getId(), 0);
    }
}
