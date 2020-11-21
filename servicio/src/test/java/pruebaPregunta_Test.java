import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.PreguntaDto;
import ucab.dsw.dtos.SubCategoriaDto;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.Pregunta;

import java.util.List;

public class pruebaPregunta_Test{

    @Test
    public void addPregunta() throws Exception{
        ucab.dsw.servicio.pruebaPregunta servicio = new ucab.dsw.servicio.pruebaPregunta();
        PreguntaDto preguntaDto = new PreguntaDto();
        preguntaDto.setPregunta( "¿Con cuántas personas convive?" );
        preguntaDto.setFechacreacion( "20/11/2020" );
        preguntaDto.setEstatus( "A" );
        TipoPreguntaDto tipoPregunta = new TipoPreguntaDto( 1);
        preguntaDto.setTipoPreguntaDto( tipoPregunta );
        SubCategoriaDto subcategoriaDto = new SubCategoriaDto( 1);
        preguntaDto.setSubCategoriaDto(subcategoriaDto);
        UsuarioDto usuarioDto = new UsuarioDto(5);
        preguntaDto.setUsuarioDto( usuarioDto );
        PreguntaDto resultado = servicio.addPregunta( preguntaDto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }
    @Test
    public void updatePregunta() throws Exception{
        ucab.dsw.servicio.pruebaPregunta servicio = new ucab.dsw.servicio.pruebaPregunta();
        PreguntaDto preguntaDto = new PreguntaDto();
        preguntaDto.setPregunta("¿Cantidad de televisores en su casa?");
        preguntaDto.setFechacreacion("21/11/2020");
        preguntaDto.setEstatus("A");
        PreguntaDto resultado = servicio.updatePregunta(1,preguntaDto);
        Assert.assertNotEquals(resultado.getId(),0);
    }

    @Test
    public void deletePregunta() throws Exception{
        ucab.dsw.servicio.pruebaPregunta servicio = new ucab.dsw.servicio.pruebaPregunta();
        PreguntaDto resultado = servicio.deletePregunta(3);
        Assert.assertNotEquals(resultado.getId(),0);
    }

    @Test
    public void getPregunta() throws Exception{
        ucab.dsw.servicio.pruebaPregunta servicio = new ucab.dsw.servicio.pruebaPregunta();
        List<Pregunta> preguntas = servicio.getPregunta();
        Assert.assertFalse("Consulta Pregunta",preguntas.isEmpty());

    }
}