import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.*;
import ucab.dsw.servicio.EjecucionencuestaCRUD;
import ucab.dsw.entidades.Ejecucionencuesta;

import java.text.SimpleDateFormat;
import java.util.List;

public class EjecucionencuestaCRUD_Test {

    @Test
    public void addEjecucionencuestaTest() throws Exception
    {
        EjecucionencuestaCRUD servicio = new EjecucionencuestaCRUD();
        EjecucionencuestaDto ejecucionencuestaDto = new EjecucionencuestaDto();
        ejecucionencuestaDto.setRespuesta("ejecucionencuesta prueba");
        ejecucionencuestaDto.setEstatus("P");
        EncuestaDto encuesta = new EncuestaDto(1);
        ejecucionencuestaDto.setEncuesta(encuesta);
        PreguntaDto pregunta = new PreguntaDto(1);
        ejecucionencuestaDto.setPregunta(pregunta);
        UsuarioDto usuario = new UsuarioDto();
        ejecucionencuestaDto.setUsuario(usuario);
        OpcionDto opcion = new OpcionDto(1);
        ejecucionencuestaDto.setOpcion(opcion);
        EjecucionencuestaDto resultado = servicio.addEjecucionencuesta( ejecucionencuestaDto );
        Assert.assertNotEquals( resultado.getId(), 0);
    }

    @Test
    public void getEjecucionencuestaTest()  throws  Exception
    {
        EjecucionencuestaCRUD servicio = new EjecucionencuestaCRUD();
        List<Ejecucionencuesta> ejecucionencuestas = servicio.getEjecucionencuesta();
        Assert.assertFalse("No hay ejecuciones de encuestas",ejecucionencuestas.isEmpty());
    }

    @Test
    public void  updateEjecucionencuestaTest() throws Exception
    {
        EjecucionencuestaCRUD servicio = new EjecucionencuestaCRUD();
        EjecucionencuestaDto ejecucionencuestaDto = new EjecucionencuestaDto();
        ejecucionencuestaDto.setRespuesta("hola que tal");
        EjecucionencuestaDto resultado = servicio.UpdateEjecucionencuesta(1, ejecucionencuestaDto);
        Assert.assertNotEquals(resultado.getId(), 0);
    }

    @Test
    public void deleteEjecucionencuestaTest() throws Exception
    {
        EjecucionencuestaCRUD servicio = new EjecucionencuestaCRUD();
        EjecucionencuestaDto resultado = servicio.deleteejecucionencuesta(1);
        Assert.assertNotEquals(resultado.getId(), 0);
    }


}
