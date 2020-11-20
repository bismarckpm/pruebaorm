import org.junit.Assert;
import org.junit.Test;

import ucab.dsw.accesodatos.Dao;
import ucab.dsw.dtos.PreguntaDto;
import ucab.dsw.dtos.SubcategoriaDto;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.Pregunta;
import ucab.dsw.entidades.TipoPregunta;
import ucab.dsw.entidades.Usuario;

import java.util.Date;

public class testPregunta_Test {

    @Test
    public void addUserTest() throws Exception
    {
        Date date = new Date();
        ucab.dsw.servicio.testPregunta servicio = new ucab.dsw.servicio.testPregunta();
        PreguntaDto preguntaDto = new PreguntaDto();

        preguntaDto.setPregunta("test1");
        preguntaDto.setFechacreacion(date);
        preguntaDto.setEstatus("A");
        TipoPreguntaDto tipoPregunta = new TipoPreguntaDto(1);
        preguntaDto.setTipoPreguntaDto(tipoPregunta);
        SubcategoriaDto subcategoriaDto = new SubcategoriaDto(1);
        preguntaDto.setSubCategoriaDto(subcategoriaDto);
        UsuarioDto usuarioDto = new UsuarioDto(17);
        preguntaDto.setUsuarioDto(usuarioDto);

        PreguntaDto resultado = servicio.addPregunta(preguntaDto);
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void updatePreguntaTest() throws Exception
    {
        Date date = new Date();
        ucab.dsw.servicio.testPregunta servicio = new ucab.dsw.servicio.testPregunta();
        PreguntaDto preguntaDto = new PreguntaDto(1);

        preguntaDto.setPregunta("testUpdate");
        preguntaDto.setFechacreacion(date);
        preguntaDto.setEstatus("I");
        TipoPreguntaDto tipoPregunta = new TipoPreguntaDto(1);
        preguntaDto.setTipoPreguntaDto(tipoPregunta);
        SubcategoriaDto subcategoriaDto = new SubcategoriaDto(1);
        preguntaDto.setSubCategoriaDto(subcategoriaDto);
        UsuarioDto usuarioDto = new UsuarioDto(17);
        preguntaDto.setUsuarioDto(usuarioDto);

        PreguntaDto resultado = servicio.updatePregunta(1,preguntaDto);
        Assert.assertNotEquals( resultado.getId(), 0 );
    }


    @Test
    public void deletePreguntaTest() throws Exception
    {
        ucab.dsw.servicio.testPregunta servicio = new ucab.dsw.servicio.testPregunta();
        PreguntaDto resultado = servicio.deletePregunta(2);
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void getPreguntaTest() throws Exception
    {
        ucab.dsw.servicio.testPregunta servicio = new ucab.dsw.servicio.testPregunta();
        PreguntaDto resultado = servicio.findPregunta(1);
        Assert.assertNotEquals( resultado.getId(), 0 );
    }


}
