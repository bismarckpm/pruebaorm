import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.Opcion;
import ucab.dsw.entidades.Pregunta;


import ucab.dsw.dtos.OpcionDto;
import ucab.dsw.dtos.PreguntaDto;
import ucab.dsw.dtos.EncuestaDto;
import ucab.dsw.dtos.EjecucionencuestaDto;
import ucab.dsw.servicio.ejecucionencuestaORMWS;

public class ejecucionencuestaORMWS_Test {

    @Test
    public void addEjecucionTest() throws Exception
    {


        ucab.dsw.servicio.ejecucionencuestaORMWS servicio = new ucab.dsw.servicio.ejecucionencuestaORMWS();
        EjecucionencuestaDto ejecucionencuestaDto= new EjecucionencuestaDto();
        ejecucionencuestaDto.setEstatus("P");
        ejecucionencuestaDto.setRespuesta("Hola");

        EncuestaDto encuestaDto= new EncuestaDto(1);
        PreguntaDto preguntaDto= new PreguntaDto(1);
        OpcionDto opcionDto= new OpcionDto(1);

        ejecucionencuestaDto.setOpcionDto(opcionDto);
        ejecucionencuestaDto.setEncuestaDto(encuestaDto);
        ejecucionencuestaDto.setPreguntaDto(preguntaDto);


        EjecucionencuestaDto resultado= servicio.addejecucion(ejecucionencuestaDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }


    @Test
    public void deleteEjecucionTest() throws Exception
    {
        ucab.dsw.servicio.ejecucionencuestaORMWS servicio = new ucab.dsw.servicio.ejecucionencuestaORMWS();
        EjecucionencuestaDto resultado= servicio.deleteejecucion(1);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void getEjecucionTest() throws Exception
    {
        ucab.dsw.servicio.ejecucionencuestaORMWS servicio = new ucab.dsw.servicio.ejecucionencuestaORMWS();
        EjecucionencuestaDto resultado= servicio.consultarEjecucion(1);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void updateEjecucionTest() throws Exception
    {

        ucab.dsw.servicio.ejecucionencuestaORMWS servicio = new ucab.dsw.servicio.ejecucionencuestaORMWS();
        EjecucionencuestaDto ejecucionencuestaDto= new EjecucionencuestaDto();
        ejecucionencuestaDto.setEstatus("P");
        ejecucionencuestaDto.setRespuesta("Hola");

        EncuestaDto encuestaDto= new EncuestaDto(1);
        PreguntaDto preguntaDto= new PreguntaDto(1);
        OpcionDto opcionDto= new OpcionDto(1);

        ejecucionencuestaDto.setOpcionDto(opcionDto);
        ejecucionencuestaDto.setEncuestaDto(encuestaDto);
        ejecucionencuestaDto.setPreguntaDto(preguntaDto);


        EjecucionencuestaDto resultado= servicio.actualizarejecucion(1,ejecucionencuestaDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }




}
