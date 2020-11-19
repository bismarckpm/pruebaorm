import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.dtos.EstudioDto;
import ucab.dsw.dtos.EstudioDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.Estudio;
import ucab.dsw.entidades.Estudio;
import java.util.List;

public class EstudioORMWS_Test {

    @Test
    public void addEstudioTest() throws Exception {
        ucab.dsw.servicio.estudioORMWS servicio = new ucab.dsw.servicio.estudioORMWS();
        EstudioDto estudioDto = new EstudioDto();
        java.util.Date fecha = new java.util.Date("21/11/2020");
        estudioDto.setFechaCreacion(fecha);
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
        java.util.Date fecha = new java.util.Date("22/11/2020");
        estudioDto.setFechaCreacion(fecha);
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
