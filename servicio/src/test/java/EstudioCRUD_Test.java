import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.EstudioDto;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.EstudioEnt;
import ucab.dsw.entidades.TipoUsuario;

import java.text.SimpleDateFormat;
import java.util.List;

public class EstudioCRUD_Test {

    @Test
    public void addEstudioTest() throws Exception
    {
        ucab.dsw.servicio.EstudioCrud servicio = new ucab.dsw.servicio.EstudioCrud();
        EstudioDto estudioDto = new EstudioDto();
        estudioDto.setFechacreacion(new SimpleDateFormat("dd/MM/yyyy").parse("12/12/2020"));
        estudioDto.set_estatus("E");
        UsuarioDto usuarioDto = new UsuarioDto(8);
        estudioDto.setUsuario( usuarioDto );
        SolicitudDto solicitudDto = new SolicitudDto(1);
        estudioDto.setSolicitud(solicitudDto);
        EstudioDto resultado = servicio.addEstudio( estudioDto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void getEstudiosTest()  throws  Exception
    {
        ucab.dsw.servicio.EstudioCrud servicio = new ucab.dsw.servicio.EstudioCrud();
        List<EstudioEnt> estudios = servicio.getEstudios();
        Assert.assertFalse("No hay estudios",estudios.isEmpty());
    }

    @Test
    public void  updateEstudioTest() throws Exception
    {
        ucab.dsw.servicio.EstudioCrud servicio = new ucab.dsw.servicio.EstudioCrud();
        EstudioDto estudioDto = new EstudioDto();
        estudioDto.setFechacreacion(new SimpleDateFormat("dd/MM/yyyy").parse("01/10/2020"));
        estudioDto.set_estatus("E");
        UsuarioDto usuarioDto = new UsuarioDto(10);
        estudioDto.setUsuario( usuarioDto );
        SolicitudDto solicitudDto = new SolicitudDto(2);
        estudioDto.setSolicitud(solicitudDto);
        EstudioDto resultado = servicio.updateEstudio(1, estudioDto);
        Assert.assertNotEquals(resultado.getId(), 0);
    }

    @Test
    public void deleteTipoUsuarioTest() throws Exception
    {
        ucab.dsw.servicio.EstudioCrud servicio = new ucab.dsw.servicio.EstudioCrud();
        EstudioDto resultado = servicio.deleteEstudio(2);
        Assert.assertNotEquals(resultado.getId(), 0);
    }
}
