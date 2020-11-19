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

public class preguntaORMWS_Test {

    @Test
    public void addPreguntaTest() throws Exception
    {
        ucab.dsw.servicio.preguntaORMWS servicio = new ucab.dsw.servicio.preguntaORMWS();
        PreguntaDto preguntaDto = new PreguntaDto();
        preguntaDto.setPregunta( "Ejemplo preg" );
        preguntaDto.setEstatus( "A" );
        preguntaDto.setFechacreacion( new SimpleDateFormat("dd/MM/yyyy").parse("12/12/2020"));
        SubCategoriaDto subCategoria = new SubCategoriaDto( 1);
        UsuarioDto usuario = new UsuarioDto( 12);
        TipoPreguntaDto tipoPregunta = new TipoPreguntaDto( 1);
        preguntaDto.setUsuarioDto( usuario );
        preguntaDto.setSubCategoriaDto( subCategoria );
        preguntaDto.setTipoPreguntaDto( tipoPregunta );
        PreguntaDto resultado = servicio.addPregunta( preguntaDto );
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void deletePreguntaTest() throws Exception{
        ucab.dsw.servicio.preguntaORMWS servicio = new ucab.dsw.servicio.preguntaORMWS();
        PreguntaDto resultado = servicio.deletePregunta(3);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void showPreguntaTest() throws Exception{
        ucab.dsw.servicio.preguntaORMWS servicio = new ucab.dsw.servicio.preguntaORMWS();
        List<Pregunta> resultado = servicio.showPreguntas();

    }

    @Test
    public void updatePreguntaTest() throws Exception
    {
        ucab.dsw.servicio.preguntaORMWS servicio = new ucab.dsw.servicio.preguntaORMWS();
        PreguntaDto preguntaDto = new PreguntaDto();
        preguntaDto.setPregunta( "Nueva preg" );
        preguntaDto.setEstatus( "I" );
        preguntaDto.setFechacreacion( new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2021"));
        SubCategoriaDto subCategoria = new SubCategoriaDto( 1);
        UsuarioDto usuario = new UsuarioDto( 14);
        TipoPreguntaDto tipoPregunta = new TipoPreguntaDto( 1);
        preguntaDto.setUsuarioDto( usuario );
        preguntaDto.setSubCategoriaDto( subCategoria );
        preguntaDto.setTipoPreguntaDto( tipoPregunta );
        PreguntaDto resultado = servicio.updatePregunta( 4, preguntaDto );
        Assert.assertNotEquals( resultado.getId(), 0  );
    }
}
