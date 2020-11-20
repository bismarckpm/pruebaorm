import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.EstudioDto;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.dtos.UsuarioDto;

import java.util.Date;

public class pruebaEstudioControlador {

    @Test
    public void obtenerEstudioPrueba() throws Exception{
        ucab.dsw.servicio.EstudioControlador servicio = new ucab.dsw.servicio.EstudioControlador();
        EstudioDto resultado = servicio.obtenerEstudio( (long) 6);
        Assert.assertEquals( resultado.getId(), 6);
    }

    @Test
    public void crearEstudioPrueba() throws Exception
    {
        ucab.dsw.servicio.EstudioControlador servicio = new ucab.dsw.servicio.EstudioControlador();
        EstudioDto estudioDto = new EstudioDto();
        estudioDto.setEstatus("C");
        estudioDto.setFechaCreacion( new Date());
        UsuarioDto usuarioDto = new UsuarioDto(11);
        estudioDto.setUsuario( usuarioDto);
        // Agregar solicitud cuando se unan las ramas
        SolicitudDto solicitudDto = new SolicitudDto(2);
        estudioDto.setSolicitud( solicitudDto);
        EstudioDto resultado = servicio.crearEstudio( estudioDto );
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void modificarEstudioPrueba() throws Exception
    {
        ucab.dsw.servicio.EstudioControlador servicio = new ucab.dsw.servicio.EstudioControlador();
        EstudioDto estudioDto = new EstudioDto(2);
        estudioDto.setEstatus("EP");
        estudioDto.setFechaCreacion( new Date());
        UsuarioDto usuarioDto = new UsuarioDto(11);
        estudioDto.setUsuario( usuarioDto);
        // Agregar solicitud cuando se unan las ramas
        SolicitudDto solicitudDto = new SolicitudDto(2);
        estudioDto.setSolicitud( solicitudDto);
        EstudioDto resultado = servicio.modificarEstudio( estudioDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void borrarEstudioPrueba() throws Exception{
        ucab.dsw.servicio.EstudioControlador servicio = new ucab.dsw.servicio.EstudioControlador();
        EstudioDto resultado = servicio.borrarEstudio((long) 12);
        Assert.assertEquals( resultado.getId(), 12);
    }
}
