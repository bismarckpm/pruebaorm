import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.dtos.EncuestaDto;
import ucab.dsw.dtos.EncuestaDto;
import ucab.dsw.dtos.EstudioDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.Encuesta;

import java.text.SimpleDateFormat;
import java.util.List;

public class encuestaORMWS_Test {

    @Test
    public void addEncuestaTest() throws Exception {
        ucab.dsw.servicio.encuestaORMWS servicio = new ucab.dsw.servicio.encuestaORMWS();
        EncuestaDto encuestaDto = new EncuestaDto();
        encuestaDto.setFechaCreacion(new SimpleDateFormat("dd/MM/yyyy").parse("12/11/2020"));
        encuestaDto.setEstatus( "C" );
        UsuarioDto usuarioCreador = new UsuarioDto( 1);
        encuestaDto.setUsuarioCreadorDto( usuarioCreador );
        UsuarioDto usuarioAnalista = new UsuarioDto( 1);
        encuestaDto.setUsuarioAnalistaDto( usuarioAnalista );
        EstudioDto estudio = new EstudioDto( 1);
        encuestaDto.setEstudioDto( estudio );
        EncuestaDto resultado = servicio.addEncuesta( encuestaDto );
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void showEncuestaTest() throws Exception
    {
        ucab.dsw.servicio.encuestaORMWS servicio = new ucab.dsw.servicio.encuestaORMWS();
        List<Encuesta> encuestas = servicio.showEncuesta();
        Assert.assertFalse("Consulta Realizada con Exito",encuestas.isEmpty());
    }

    @Test
    public void updateEncuestaTest() throws Exception{
        ucab.dsw.servicio.encuestaORMWS servicio = new ucab.dsw.servicio.encuestaORMWS();
        EncuestaDto encuestaDto = new EncuestaDto(1);
        encuestaDto.setFechaCreacion(new SimpleDateFormat("dd/MM/yyyy").parse("15/11/2020"));
        encuestaDto.setEstatus( "F" );
        UsuarioDto usuarioCreador = new UsuarioDto( 1);
        encuestaDto.setUsuarioCreadorDto( usuarioCreador );
        UsuarioDto usuarioAnalista = new UsuarioDto( 1);
        encuestaDto.setUsuarioAnalistaDto( usuarioAnalista );
        EstudioDto estudio = new EstudioDto( 1);
        encuestaDto.setEstudioDto( estudio );
        EncuestaDto resultado = servicio.editEncuesta(encuestaDto);
        Assert.assertNotEquals( resultado.getId(), 0);
    }

    @Test
    public void deleteEncuestaTest() throws Exception{

        ucab.dsw.servicio.encuestaORMWS servicio = new ucab.dsw.servicio.encuestaORMWS();
        EncuestaDto encuestaDto = new EncuestaDto(1);
        EncuestaDto resultado = servicio.deleteEncuesta(encuestaDto);
        Assert.assertNotEquals( resultado.getId(), 0 );

    }
}
