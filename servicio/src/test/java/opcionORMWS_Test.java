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


public class opcionORMWS_Test {

    @Test
    public void addOpcionTest() throws Exception
    {
        ucab.dsw.servicio.opcionORMWS servicio = new ucab.dsw.servicio.opcionORMWS();
        OpcionDto opcionDto= new OpcionDto();
        opcionDto.setEstatus("A");
        opcionDto.setDescripcion("opcion1");
        PreguntaDto preguntaDto= new PreguntaDto(1);

        opcionDto.setPreguntaDto(preguntaDto);
        OpcionDto resultado= servicio.addopcion(opcionDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void deleteOpcionTest() throws Exception
    {
        ucab.dsw.servicio.opcionORMWS servicio = new ucab.dsw.servicio.opcionORMWS();
        OpcionDto resultado= servicio.deleteOpcion(1);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void getOpcionTest() throws Exception
    {
        ucab.dsw.servicio.opcionORMWS servicio = new ucab.dsw.servicio.opcionORMWS();
        OpcionDto resultado= servicio.consultarTipoPregunta(1);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void updateOpcionTest() throws Exception
    {
        ucab.dsw.servicio.opcionORMWS servicio = new ucab.dsw.servicio.opcionORMWS();
        OpcionDto opcionDto= new OpcionDto();
        opcionDto.setEstatus("A");
        opcionDto.setDescripcion("opcion2");
        PreguntaDto preguntaDto= new PreguntaDto(1);

        opcionDto.setPreguntaDto(preguntaDto);
        OpcionDto resultado= servicio.updateOpcion(1,opcionDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }





}

