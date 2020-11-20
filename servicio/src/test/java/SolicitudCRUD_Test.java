import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.dtos.SubcategoriaDto;
import ucab.dsw.dtos.UsuarioDto;

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
        UsuarioDto usuarioDto = new UsuarioDto(8);
        solicitudDto.setUsuario( usuarioDto );
        SolicitudDto resultado = servicio.addSolicitud( solicitudDto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }
}
