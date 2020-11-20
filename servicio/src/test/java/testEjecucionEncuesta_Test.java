import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.*;
import ucab.dsw.entidades.EjecucionEncuesta;

public class testEjecucionEncuesta_Test {

    @Test
    public void addEjecucionEncuestaTest() throws Exception
    {
        ucab.dsw.servicio.testEjecucionEncuesta servicio = new ucab.dsw.servicio.testEjecucionEncuesta();
        EjecucionEncuestaDto ejecucionEncuestaDto = new EjecucionEncuestaDto();
        EncuestaDto encuesta = new EncuestaDto( 1 );
        ejecucionEncuestaDto.setEncuestaDto(encuesta);
        PreguntaDto pregunta = new PreguntaDto( 1 );
        ejecucionEncuestaDto.setPreguntaDto( pregunta );
        UsuarioDto usuario = new UsuarioDto( 1 );
        ejecucionEncuestaDto.setUsuarioDto( usuario );
        OpcionDto opcion = new OpcionDto( 1 );
        ejecucionEncuestaDto.setOpcionDto( opcion );
        ejecucionEncuestaDto.setRespuesta( "ejec1" );
        ejecucionEncuestaDto.setEstatus( "P" );
        EjecucionEncuestaDto resultado = servicio.addEjecucionEncuesta( ejecucionEncuestaDto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void modifyEjecucionEncuestaTest() throws Exception
    {
        ucab.dsw.servicio.testEjecucionEncuesta servicio = new ucab.dsw.servicio.testEjecucionEncuesta();
        EjecucionEncuestaDto ejecucionEncuestaDto = new EjecucionEncuestaDto(2);
        EncuestaDto encuesta = new EncuestaDto( 1 );
        ejecucionEncuestaDto.setEncuestaDto(encuesta);
        PreguntaDto pregunta = new PreguntaDto( 1 );
        ejecucionEncuestaDto.setPreguntaDto(pregunta);
        UsuarioDto usuario = new UsuarioDto( 1 );
        ejecucionEncuestaDto.setUsuarioDto( usuario );
        OpcionDto opcion = new OpcionDto( 1 );
        ejecucionEncuestaDto.setOpcionDto( opcion );
        ejecucionEncuestaDto.setRespuesta( "opcion chuki" );
        ejecucionEncuestaDto.setEstatus( "C" );
        EjecucionEncuestaDto resultado = servicio.modifyEjecucionEncuesta(ejecucionEncuestaDto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void deleteEjecucionEncuestaTest() throws Exception
    {
        ucab.dsw.servicio.testEjecucionEncuesta servicio = new ucab.dsw.servicio.testEjecucionEncuesta();
        EjecucionEncuestaDto ejecucionEncuestaDto = new EjecucionEncuestaDto(1);
        EjecucionEncuestaDto resultado = servicio.deleteEjecucionEncuesta(ejecucionEncuestaDto.getId());
        Assert.assertNotEquals( resultado.getId(), 0);
    }

    @Test
    public void consultarEjecucionEncuestaTest() throws Exception
    {
        ucab.dsw.servicio.testEjecucionEncuesta servicio = new ucab.dsw.servicio.testEjecucionEncuesta();
        EjecucionEncuestaDto ejecucionEncuestaDto = new EjecucionEncuestaDto(2);
        EjecucionEncuestaDto resultado = servicio.consultarEjecucionEncuesta(ejecucionEncuestaDto.getId());
        System.out.println("Resultado = ");
        System.out.print(resultado);
        Assert.assertNotEquals( resultado.getId(), 0);
    }
}
