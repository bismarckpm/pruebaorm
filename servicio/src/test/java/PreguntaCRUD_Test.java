import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.PreguntaDto;
import ucab.dsw.dtos.SubcategoriaDto;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.Pregunta;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PreguntaCRUD_Test {

    @Test
    public void addPreguntaTest() throws Exception
    {
        ucab.dsw.servicio.PreguntaCRUD servicio = new ucab.dsw.servicio.PreguntaCRUD();
        PreguntaDto preguntaDto = new PreguntaDto();
        preguntaDto.setPregunta( "Pregunta Prueba" );
        SimpleDateFormat fecha = new SimpleDateFormat("dd/mm/yyyy");
        Date fechaCreacion = fecha.parse("18/11/2020") ;
        preguntaDto.setFechacreacion(fechaCreacion);
        preguntaDto.setEstatus( "A" );
        TipoPreguntaDto tipoPregunta = new TipoPreguntaDto(2);
        preguntaDto.setTipoPreguntaDto( tipoPregunta );
        UsuarioDto usuario = new UsuarioDto( 9);
        preguntaDto.setUsuarioDto( usuario );
        SubcategoriaDto subcategoria = new SubcategoriaDto( 1);
        preguntaDto.setSubcategoriaDto( subcategoria );
        PreguntaDto resultado = servicio.addPregunta( preguntaDto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }


    @Test
    public void getPreguntaTest() throws Exception{
        ucab.dsw.servicio.PreguntaCRUD servicio = new ucab.dsw.servicio.PreguntaCRUD();
        List<Pregunta> pregunta = servicio.getPregunta();
        Assert.assertFalse("Error en la consulta  de pregunta ",pregunta.isEmpty());
    }


    @Test
    public void updatePreguntaTest() throws Exception{
        ucab.dsw.servicio.PreguntaCRUD servicio = new ucab.dsw.servicio.PreguntaCRUD();
        PreguntaDto preguntaDto = new PreguntaDto();
        preguntaDto.setPregunta( "PruebaUpdate" );
        SimpleDateFormat fecha = new SimpleDateFormat("dd/mm/yyyy");
        Date fechaCreacion = fecha.parse("20/11/2020") ;
        preguntaDto.setFechacreacion(fechaCreacion);
        preguntaDto.setEstatus( "A" );
        TipoPreguntaDto tipoPregunta = new TipoPreguntaDto( 2);
        preguntaDto.setTipoPreguntaDto( tipoPregunta );
        UsuarioDto usuario = new UsuarioDto( 9);
        preguntaDto.setUsuarioDto( usuario );
        SubcategoriaDto subcategoria = new SubcategoriaDto( 1);
        preguntaDto.setSubcategoriaDto( subcategoria );
        PreguntaDto resultado = servicio.updatePregunta(1, preguntaDto);
        Assert.assertNotEquals(resultado.getId(), 0);
    }


    @Test
    public void deletePreguntaTest() throws Exception{
        ucab.dsw.servicio.PreguntaCRUD servicio = new ucab.dsw.servicio.PreguntaCRUD();
        PreguntaDto resultado = servicio.deletePregunta(1);
        Assert.assertNotEquals(resultado.getId(), 0);
    }
}
