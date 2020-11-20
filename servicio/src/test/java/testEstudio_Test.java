import org.junit.Assert;
import org.junit.Test;

import ucab.dsw.dtos.EstudioDto;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.dtos.UsuarioDto;

import java.util.Date;

public class testEstudio_Test {

    @Test
    public void addEstudioTest() throws Exception
    {
        Date date = new Date();
        ucab.dsw.servicio.testEstudio servicio = new ucab.dsw.servicio.testEstudio();
        EstudioDto estudioDto = new EstudioDto();
        estudioDto.setFechacreacion( date );
        UsuarioDto usuarioDto = new UsuarioDto(20);
        estudioDto.setUsuarioDto(usuarioDto);
        SolicitudDto solicitudDto=new SolicitudDto(1);
        estudioDto.setSolicitudDto(solicitudDto);
        estudioDto.setEstatus("C");
        EstudioDto resultado = servicio.addEstudio( estudioDto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }


    @Test
    public void updateEstudioTest() throws Exception
    {
        Date date = new Date();
        ucab.dsw.servicio.testEstudio servicio = new ucab.dsw.servicio.testEstudio();
        EstudioDto estudioDto = new EstudioDto(2);
        estudioDto.setFechacreacion( date );
        estudioDto.setEstatus("C");
        SolicitudDto solicitudDto = new SolicitudDto(1);
        estudioDto.setSolicitudDto(solicitudDto);
        UsuarioDto usuarioDto = new UsuarioDto(18);
        estudioDto.setUsuarioDto(usuarioDto);
        EstudioDto resultado = servicio.updateEstudio(2, estudioDto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void deleteEstudioTest() throws Exception
    {
        ucab.dsw.servicio.testEstudio servicio = new ucab.dsw.servicio.testEstudio();
        EstudioDto resultado = servicio.deleteEstudio(2);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }


    @Test
    public void findEstudioTest() throws Exception
    {
        ucab.dsw.servicio.testEstudio servicio = new ucab.dsw.servicio.testEstudio();
        EstudioDto resultado = servicio.findEstudio(2);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

}
