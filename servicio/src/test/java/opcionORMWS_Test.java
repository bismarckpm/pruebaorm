import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.dtos.*;
import ucab.dsw.entidades.TipoPregunta;
import ucab.dsw.entidades.Usuario;
import ucab.dsw.entidades.Solicitud;
import ucab.dsw.entidades.Opcion;
import ucab.dsw.entidades.Pregunta;

import java.text.SimpleDateFormat;
import java.util.List;

public class opcionORMWS_Test {

    @Test
    public void addOpcionTest() throws Exception
    {
        ucab.dsw.servicio.opcionORMWS servicio = new ucab.dsw.servicio.opcionORMWS();
        OpcionDto opcionDto = new OpcionDto();
        opcionDto.setDescripcion( "Ejemplo desc" );
        opcionDto.setEstatus( "A" );
        PreguntaDto pregunta = new PreguntaDto( 1);
        opcionDto.setPreguntaDto( pregunta );
        OpcionDto resultado = servicio.addOpcion( opcionDto );
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void deleteOpcionTest() throws Exception{
        ucab.dsw.servicio.opcionORMWS servicio = new ucab.dsw.servicio.opcionORMWS();
        OpcionDto resultado = servicio.deleteOpcion(2);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void showOpcionTest() throws Exception{
        ucab.dsw.servicio.opcionORMWS servicio = new ucab.dsw.servicio.opcionORMWS();
        List<Opcion> resultado = servicio.showOpciones();

    }

    @Test
    public void updateOpcionTest() throws Exception
    {
        ucab.dsw.servicio.opcionORMWS servicio = new ucab.dsw.servicio.opcionORMWS();
        OpcionDto opcionDto = new OpcionDto();
        opcionDto.setDescripcion( "Nueva desc" );
        opcionDto.setEstatus( "I" );
        PreguntaDto pregunta = new PreguntaDto( 4);
        opcionDto.setPreguntaDto( pregunta );
        OpcionDto resultado = servicio.updateOpcion( 3, opcionDto );
        Assert.assertNotEquals( resultado.getId(), 0  );
    }
}
