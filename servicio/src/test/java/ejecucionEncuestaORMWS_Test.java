import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.dtos.EjecucionEncuestaDto;
import ucab.dsw.entidades.*;
import ucab.dsw.dtos.EncuestaDto;
import ucab.dsw.dtos.PreguntaDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.dtos.OpcionDto;

import java.util.List;

public class ejecucionEncuestaORMWS_Test {

    @Test
    public void addEjecucionEncuestaTest() throws Exception {
        ucab.dsw.servicio.ejecucionEncuestaORMWS servicio = new ucab.dsw.servicio.ejecucionEncuestaORMWS();
        EjecucionEncuestaDto ejecucionEncuestaDto = new EjecucionEncuestaDto();
        ejecucionEncuestaDto.setRespuesta("Respuesta 1");
        ejecucionEncuestaDto.setEstatus( "P");
        EncuestaDto encuesta = new EncuestaDto(1);
        ejecucionEncuestaDto.setEncuesta( encuesta );
        PreguntaDto pregunta = new PreguntaDto(1);
        ejecucionEncuestaDto.setPregunta( pregunta );
        UsuarioDto usuarioEncuestado = new UsuarioDto(1);
        ejecucionEncuestaDto.setUsuarioEncuestado( usuarioEncuestado );
        OpcionDto opcion = new OpcionDto(1);
        ejecucionEncuestaDto.setOpcion( opcion );
        EjecucionEncuestaDto resultado = servicio.addEjecucionEncuesta( ejecucionEncuestaDto );
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void showEjecucionEncuestaTest() throws Exception
    {
        ucab.dsw.servicio.ejecucionEncuestaORMWS servicio = new ucab.dsw.servicio.ejecucionEncuestaORMWS();
        List<EjecucionEncuesta> ejecucionEncuestas = servicio.showEjecucionEncuesta();
        Assert.assertFalse("Consulta Realizada con Exito",ejecucionEncuestas.isEmpty());
    }

    @Test
    public void updateEjecucionEncuestaTest() throws Exception{

        ucab.dsw.servicio.ejecucionEncuestaORMWS servicio = new ucab.dsw.servicio.ejecucionEncuestaORMWS();
        EjecucionEncuestaDto ejecucionEncuestaDto = new EjecucionEncuestaDto(1);
        ejecucionEncuestaDto.setRespuesta( "Respuesta 2");
        ejecucionEncuestaDto.setEstatus( "C");
        EncuestaDto encuesta = new EncuestaDto(1);
        ejecucionEncuestaDto.setEncuesta( encuesta );
        PreguntaDto pregunta = new PreguntaDto(1);
        ejecucionEncuestaDto.setPregunta( pregunta );
        UsuarioDto usuarioEncuestado = new UsuarioDto(1);
        ejecucionEncuestaDto.setUsuarioEncuestado( usuarioEncuestado );
        OpcionDto opcion = new OpcionDto(1);
        ejecucionEncuestaDto.setOpcion( opcion );
        EjecucionEncuestaDto resultado = servicio.editEjecucionEncuesta (ejecucionEncuestaDto);
        Assert.assertNotEquals( resultado.getId(), 0);
    }

    @Test
    public void deleteEjecucionEncuestaTest() throws Exception{

        ucab.dsw.servicio.ejecucionEncuestaORMWS servicio = new ucab.dsw.servicio.ejecucionEncuestaORMWS();
        EjecucionEncuestaDto ejecucionEncuestaDto = new EjecucionEncuestaDto(1);
        EjecucionEncuestaDto resultado = servicio.deleteEjecucionEncuesta(ejecucionEncuestaDto);
        Assert.assertNotEquals( resultado.getId(), 0 );

    }
}
