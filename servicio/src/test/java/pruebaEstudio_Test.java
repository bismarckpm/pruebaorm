import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.dtos.*;
import ucab.dsw.entidades.*;

import java.util.Date;

public class pruebaEstudio_Test {
    private Date fechaTest=new Date(119,6,2);
    @Test
    public void addEstudioTest() throws Exception
    {
        ucab.dsw.servicio.pruebaEstudio servicio = new ucab.dsw.servicio.pruebaEstudio();
        EstudioDto estudioDto = new EstudioDto();
        estudioDto.setFechaCreacion(fechaTest);
        estudioDto.setEstatus("EP");
        UsuarioDto usuarioDto=new UsuarioDto();
        usuarioDto.setSuperId(2);
        estudioDto.setUsuarioDto(usuarioDto);
        SolicitudDto solicitudDto=new SolicitudDto(1);
        estudioDto.setSolicitudDto(solicitudDto);
        EstudioDto resultado = servicio.addEstudio(estudioDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void deleateEstudioTest() throws Exception
    {
        ucab.dsw.servicio.pruebaEstudio servicio = new ucab.dsw.servicio.pruebaEstudio();
        EstudioDto Edto = new EstudioDto();
        Edto.setId(3);
       servicio.eliminarEstudio( Edto );
    }

    @Test
    public void updateEstudioTest() throws Exception
    {
        ucab.dsw.servicio.pruebaEstudio servicio = new ucab.dsw.servicio.pruebaEstudio();
        EstudioDto ESTdto = new EstudioDto();
        ESTdto.setEstatus("F");
        ESTdto.setId(2);
        servicio.actualizarEstudio( ESTdto );
    }

    @Test
    public void leerEestudioTest() throws Exception
    {
        ucab.dsw.servicio.pruebaEstudio servicio = new ucab.dsw.servicio.pruebaEstudio();
        EstudioDto ENC = new EstudioDto();
        ENC.setId(1);
        servicio.leerCategoria( ENC );

    }
}
