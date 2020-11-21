import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.*;
import ucab.dsw.entidades.Encuesta;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EncuestaCRUD_Test {

    @Test
    public void addEncuestaTest() throws Exception
    {
        ucab.dsw.servicio.EncuestaCRUD servicio = new ucab.dsw.servicio.EncuestaCRUD();
        EncuestaDto encuestaDto = new EncuestaDto();
        SimpleDateFormat fecha = new SimpleDateFormat("dd/mm/yyyy");
        Date fechaCreacion = fecha.parse("18/11/2020") ;
        encuestaDto.setFechacreacion(fechaCreacion);
        encuestaDto.setEstatus( "C" );
        UsuarioDto usuarioAnalista = new UsuarioDto( 10);
        encuestaDto.setUsuarioAnalistaDto( usuarioAnalista );
        UsuarioDto usuarioCreador = new UsuarioDto( 9);
        encuestaDto.setUsuarioCreadorDto( usuarioCreador );
        EstudioDto estudio = new EstudioDto(1);
        encuestaDto.setEstudioDto( estudio );
        EncuestaDto resultado = servicio.addEncuesta( encuestaDto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void getEncuestaTest() throws Exception{
        ucab.dsw.servicio.EncuestaCRUD servicio = new ucab.dsw.servicio.EncuestaCRUD();
        List<Encuesta> encuesta = servicio.getEncuesta();
        Assert.assertFalse("Error en la consulta  de encuesta ",encuesta.isEmpty());
    }

    @Test
    public void updateEncuestaTest() throws Exception{
        ucab.dsw.servicio.EncuestaCRUD servicio = new ucab.dsw.servicio.EncuestaCRUD();
        EncuestaDto encuestaDto = new EncuestaDto();
        SimpleDateFormat fecha = new SimpleDateFormat("dd/mm/yyyy");
        Date fechaCreacion = fecha.parse("18/11/2020") ;
        encuestaDto.setFechacreacion(fechaCreacion);
        encuestaDto.setEstatus( "C" );
        UsuarioDto usuarioAnalista = new UsuarioDto( 12);
        encuestaDto.setUsuarioAnalistaDto( usuarioAnalista );
        UsuarioDto usuarioCreador = new UsuarioDto( 11);
        encuestaDto.setUsuarioCreadorDto( usuarioCreador );
        EstudioDto estudio = new EstudioDto(1);
        encuestaDto.setEstudioDto( estudio );
        EncuestaDto resultado = servicio.updateEncuesta(1, encuestaDto);
        Assert.assertNotEquals(resultado.getId(), 0);
    }

    @Test
    public void deleteEncuestaTest() throws Exception{
        ucab.dsw.servicio.EncuestaCRUD servicio = new ucab.dsw.servicio.EncuestaCRUD();
        EncuestaDto resultado = servicio.deleteEncuesta(2);
        Assert.assertNotEquals(resultado.getId(), 0);
    }
}
