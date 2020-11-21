import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.dtos.EstudioDto;
import ucab.dsw.dtos.EstudioDto;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.entidades.Estudio;
import ucab.dsw.entidades.Estudio;
import java.text.SimpleDateFormat;

import java.util.List;

public class EstudioORMWS_Test {

    @Test
    public void addEstudioTest() throws Exception {
        ucab.dsw.servicio.estudioORMWS servicio = new ucab.dsw.servicio.estudioORMWS();
        EstudioDto estudioDto = new EstudioDto();
        estudioDto.setFechaCreacion(new SimpleDateFormat("dd/MM/yyyy").parse("12/11/2020"));
        estudioDto.setEstatus( "C" );
        UsuarioDto usuario = new UsuarioDto( 1);
        estudioDto.setUsuario( usuario );
        SolicitudDto solicitud = new SolicitudDto( 1);
        estudioDto.setSolicitud( solicitud );
        EstudioDto resultado = servicio.addEstudio( estudioDto );
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void showEstudioTest() throws Exception
    {
        ucab.dsw.servicio.estudioORMWS servicio = new ucab.dsw.servicio.estudioORMWS();
        List<Estudio> estudios = servicio.showEstudio();
        Assert.assertFalse("Consulta Realizada con Exito",estudios.isEmpty());
    }

    @Test
    public void updateEstudioTest() throws Exception{

        ucab.dsw.servicio.estudioORMWS servicio = new ucab.dsw.servicio.estudioORMWS();
        EstudioDto estudioDto = new EstudioDto(1);
        estudioDto.setFechaCreacion(new SimpleDateFormat("dd/MM/yyyy").parse("15/11/2020"));
        estudioDto.setEstatus( "E" );
        UsuarioDto usuario = new UsuarioDto( 1);
        estudioDto.setUsuario( usuario );
        SolicitudDto solicitud = new SolicitudDto( 1);
        estudioDto.setSolicitud( solicitud );
        EstudioDto resultado = servicio.editEstudio (estudioDto);
        Assert.assertNotEquals( resultado.getId(), 0);
    }

    @Test
    public void deleteEstudioTest() throws Exception{

        ucab.dsw.servicio.estudioORMWS servicio = new ucab.dsw.servicio.estudioORMWS();
        EstudioDto estudioDto = new EstudioDto(1);
        EstudioDto resultado = servicio.deleteEstudio(estudioDto);
        Assert.assertNotEquals( resultado.getId(), 0 );

    }
}
