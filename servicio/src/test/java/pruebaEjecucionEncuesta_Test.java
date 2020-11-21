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


public class pruebaEjecucionEncuesta_Test {
    @Test
    public void addEjecucionEncuestaTest() throws Exception{

        ucab.dsw.servicio.pruebaEjecucionEncuesta servicio = new ucab.dsw.servicio.pruebaEjecucionEncuesta();
        EjecucionEncuestaDto ejecucionEncuestaDto = new EjecucionEncuestaDto();
        ejecucionEncuestaDto.setRespuesta("Excelente");
        ejecucionEncuestaDto.setEstatus("P");
        EncuestaDto encuesta = new EncuestaDto(1);
        ejecucionEncuestaDto.setEncuesta(encuesta);
        OpcionDto opcion = new OpcionDto(1);
        ejecucionEncuestaDto.setOpcion(opcion);
        UsuarioDto usuario = new UsuarioDto(1);
        ejecucionEncuestaDto.setUsuarioEncuestado(usuario);
        PreguntaDto pregunta = new PreguntaDto(1);
        ejecucionEncuestaDto.setPregunta(pregunta);
        EjecucionEncuestaDto resultado = servicio.addEjecucionEncuesta( ejecucionEncuestaDto );
        Assert.assertNotEquals( resultado.getId(), 0 );

    }


    @Test
    public void getEjecuionEncuestaTest() throws Exception{
        ucab.dsw.servicio.pruebaEjecucionEncuesta servicio = new ucab.dsw.servicio.pruebaEjecucionEncuesta();
        List<EjecucionEncuesta> ejecucionEncuestas = servicio.listEjecucionEncuesta();
        Assert.assertFalse("Consulta EjecucionEncuesta", ejecucionEncuestas.isEmpty());
    }

    @Test
    public void listEjecucionEncuestaTest() throws Exception{

        ucab.dsw.servicio.pruebaEjecucionEncuesta servicio = new ucab.dsw.servicio.pruebaEjecucionEncuesta();
        List<EjecucionEncuesta> ejecucionEncuesta = servicio.listEjecucionEncuesta();
        Assert.assertNotEquals( "Ejecucion Encuesta listadas", ejecucionEncuesta.isEmpty() );

    }


    @Test
    public void updateEjecucionEncuestaTest() throws Exception{

        ucab.dsw.servicio.pruebaEjecucionEncuesta servicio = new ucab.dsw.servicio.pruebaEjecucionEncuesta();
        EjecucionEncuestaDto ejecucionEncuestaDto = new EjecucionEncuestaDto();
        ejecucionEncuestaDto.setRespuesta("Deficiente");
        ejecucionEncuestaDto.setEstatus("P");
        EncuestaDto encuesta = new EncuestaDto(1);
        ejecucionEncuestaDto.setEncuesta(encuesta);
        OpcionDto opcion = new OpcionDto(1);
        ejecucionEncuestaDto.setOpcion(opcion);
        UsuarioDto usuario = new UsuarioDto(1);
        ejecucionEncuestaDto.setUsuarioEncuestado(usuario);
        //PreguntaDto pregunta = new PreguntaDto(1)
        //ejecucionEncuestaDto.setPregunta(pregunta);
        EjecucionEncuestaDto resultado = servicio.updateEjecucionEncuesta(ejecucionEncuestaDto);
        Assert.assertNotEquals( resultado.getId(), 0);

    }

    @Test
    public void deleteEjecucionEncuestaTest() throws Exception{

        ucab.dsw.servicio.pruebaEjecucionEncuesta servicio = new ucab.dsw.servicio.pruebaEjecucionEncuesta();
        EjecucionEncuestaDto ejecucionEncuestaDto = new EjecucionEncuestaDto(1);
        EjecucionEncuestaDto resultado = servicio.deleteEjecucionEncuesta(ejecucionEncuestaDto);
        Assert.assertNotEquals( resultado.getId(), 0 );

    }
}
