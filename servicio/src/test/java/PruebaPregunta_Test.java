import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.PreguntaDto;
import ucab.dsw.dtos.SubcategoriaDto;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.Subcategoria;
import ucab.dsw.entidades.Usuario;
import ucab.dsw.servicio.PruebaPregunta;

import java.time.Instant;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Omar David
 * Date: 20/11/20
 * Time: 11:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class PruebaPregunta_Test {
    @Test
    public void addPreguntaTest() throws Exception{
        PruebaPregunta servicio = new PruebaPregunta();
        PreguntaDto preguntaDto = new PreguntaDto();
        preguntaDto.setPregunta("Pregunta numero 1");
        preguntaDto.setFechacreacion(Date.from(Instant.now()));
        preguntaDto.setStatus("A");
        TipoPreguntaDto tipoPregunta = new TipoPreguntaDto(1);
        SubcategoriaDto subactegoria = new SubcategoriaDto(1);
        UsuarioDto usuario = new UsuarioDto();
        preguntaDto.setTipopregunta(tipoPregunta);
        preguntaDto.setSubcategoria(subactegoria);
        preguntaDto.setIdusuario(usuario);
        PreguntaDto resultado = servicio.addPregunta(preguntaDto);
        Assert.assertNotEquals(resultado.getId(), 1);
    }

    @Test
    public void changePreguntaTest() throws Exception
    {
        PruebaPregunta servicio = new PruebaPregunta();
        PreguntaDto preguntaDto = new PreguntaDto();
        preguntaDto.setPregunta("Pregunta numero 1 actualizada");
        preguntaDto.setFechacreacion(Date.from(Instant.now()));
        preguntaDto.setStatus("I");
        TipoPreguntaDto tipoPregunta = new TipoPreguntaDto(1);
        SubcategoriaDto subactegoria = new SubcategoriaDto(1);
        UsuarioDto usuario = new UsuarioDto();
        preguntaDto.setTipopregunta(tipoPregunta);
        preguntaDto.setSubcategoria(subactegoria);
        preguntaDto.setIdusuario(usuario);
        PreguntaDto resultado = servicio.changePregunta(preguntaDto);
        Assert.assertNotEquals( resultado.getId(), 0 );

    }

    @Test
    public void deletePreguntaTest() throws Exception
    {
        PruebaPregunta servicio = new PruebaPregunta();
        PreguntaDto resultado = servicio.deletePregunta(10);
        Assert.assertNotEquals( resultado.getId(), 0 );

    }

    @Test
    public void showPreguntaTest() throws Exception
    {
        PruebaPregunta servicio = new PruebaPregunta();
        PreguntaDto  PreguntaDto= new PreguntaDto(1);
        PreguntaDto resultado = servicio.showPregunta(PreguntaDto.getId());
        Assert.assertEquals( resultado.getId(), 0);

    }
}

