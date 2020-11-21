import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.accesodatos.DaoSubCategoria;
import ucab.dsw.dtos.*;
import ucab.dsw.entidades.*;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import java.util.List;


public class pruebaEstudio_Test {
    @Test
    public void addEstudioTest() throws Exception{

        ucab.dsw.servicio.pruebaEstudio servicio = new ucab.dsw.servicio.pruebaEstudio();
        EstudioDto estudioDto = new EstudioDto();
        java.util.Date fecha = new java.util.Date("20/11/2020");
        estudioDto.setFechaCreacion(fecha);
        UsuarioDto usuario = new UsuarioDto(1);
        estudioDto.setUsuario(usuario);
        SolicitudDto solicitud = new SolicitudDto(1);
        estudioDto.setSolicitud(solicitud);
        estudioDto.setEstatus("C");
        EstudioDto resultado = servicio.addEstudio( estudioDto );
        Assert.assertNotEquals( resultado.getId(), 0 );

    }
    @Test
    public void getEstudioTest() throws Exception{
        ucab.dsw.servicio.pruebaEstudio estudio = new ucab.dsw.servicio.pruebaEstudio();
        List<Estudio> estudios = estudio.getEstudio();
        Assert.assertFalse("Consulta Encuesta", estudios.isEmpty());
    }

    @Test
    public void updateEstudioTest() throws Exception{

        ucab.dsw.servicio.pruebaEstudio servicio = new ucab.dsw.servicio.pruebaEstudio();
        EstudioDto estudioDto = new EstudioDto(1);
        java.util.Date fecha = new java.util.Date("21/11/2020");
        estudioDto.setFechaCreacion(fecha);
        UsuarioDto usuario = new UsuarioDto(1);
        estudioDto.setUsuario(usuario);
        SolicitudDto solicitud = new SolicitudDto(1);
        estudioDto.setSolicitud(solicitud);
        estudioDto.setEstatus("EP");
        EstudioDto resultado = servicio.updateEstudio (estudioDto);
        Assert.assertNotEquals( resultado.getId(), 0);

    }

    @Test
    public void deleteEstudioTest() throws Exception{

        ucab.dsw.servicio.pruebaEstudio servicio = new ucab.dsw.servicio.pruebaEstudio();
        EstudioDto estudioDto = new EstudioDto(1);
        EstudioDto resultado = servicio.deleteEstudio(estudioDto);
        Assert.assertNotEquals( resultado.getId(), 0 );

    }
}
