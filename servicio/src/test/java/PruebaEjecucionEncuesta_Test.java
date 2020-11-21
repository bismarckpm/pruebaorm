import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.*;
import ucab.dsw.servicio.PruebaEjecucionEncuesta;

/**
 * Created with IntelliJ IDEA.
 * User: Omar David
 * Date: 20/11/20
 * Time: 11:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class PruebaEjecucionEncuesta_Test{

    @Test
    public void addEjecucionEncuestaTest() throws Exception
    {
        PruebaEjecucionEncuesta servicio = new PruebaEjecucionEncuesta();
        EjecucionEncuestaDto ejecucionDto = new EjecucionEncuestaDto();
        ejecucionDto.setRespuesta("Prueba ejecucion");
        ejecucionDto.setEstatus("A");
        EncuestaDto encuesta = new EncuestaDto(10);
        PreguntaDto pregunta = new PreguntaDto(10);
        UsuarioDto usuarioEncuestado = new UsuarioDto(10);
        OpcionDto opcion = new OpcionDto(10);
        ejecucionDto.setEncuesta(encuesta);
        ejecucionDto.setPregunta(pregunta);
        ejecucionDto.setUsuarioEncuestado(usuarioEncuestado);
        ejecucionDto.setOpcion(opcion);
        EjecucionEncuestaDto resultado = servicio.addEjecucionEncuesta(ejecucionDto);
        Assert.assertNotEquals(resultado.getId(), 1);

    }

    @Test
    public void changeEjecucionEncuestaTest() throws Exception
    {
        PruebaEjecucionEncuesta servicio = new PruebaEjecucionEncuesta();
        EjecucionEncuestaDto ejecucionDto = new EjecucionEncuestaDto(10);
        ejecucionDto.setRespuesta("Prueba ejecucion update");
        ejecucionDto.setEstatus("A");
        EncuestaDto encuesta = new EncuestaDto(100);
        PreguntaDto pregunta = new PreguntaDto(100);
        UsuarioDto usuarioEncuestado = new UsuarioDto(100);
        OpcionDto opcion = new OpcionDto(100);
        ejecucionDto.setEncuesta(encuesta);
        ejecucionDto.setPregunta(pregunta);
        ejecucionDto.setUsuarioEncuestado(usuarioEncuestado);
        ejecucionDto.setOpcion(opcion);
        EjecucionEncuestaDto resultado = servicio.changeEjecucionEncuesta(ejecucionDto);
        Assert.assertNotEquals( resultado.getId(), 0 );

    }

    @Test
    public void deleteEjecucionEncuestaTest() throws Exception
    {
        PruebaEjecucionEncuesta servicio = new PruebaEjecucionEncuesta();
        EjecucionEncuestaDto resultado = servicio.deleteEjecucionEncuesta(10);
        Assert.assertNotEquals( resultado.getId(), 0 );

    }

    @Test
    public void showEjecucionEncuestaTest() throws Exception
    {
        PruebaEjecucionEncuesta servicio = new PruebaEjecucionEncuesta();
        EjecucionEncuestaDto ejecucionDto= new EjecucionEncuestaDto(6);
        EjecucionEncuestaDto resultado = servicio.showEjecucionEncuesta(ejecucionDto.getId());
        Assert.assertEquals( resultado.getId(), 0);

    }

}

