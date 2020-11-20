import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.dtos.PreguntaDto;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.dtos.SubCategoriaDto;
import ucab.dsw.dtos.UsuarioDto;

public class pueba_Pregunta_Test {
    @Test
    public void addPreguntaTest() throws Exception {
        ucab.dsw.servicio.prueba_Pregunta servicio = new ucab.dsw.servicio.prueba_Pregunta();
        PreguntaDto preguntadto= new PreguntaDto();

        preguntadto.setPregunta("Cual es su talla de calzado?");
        preguntadto.setFechacreacion("2020/11/20");
        preguntadto.setEstatus("A");
        TipoPreguntaDto idtipopregunta = new TipoPreguntaDto(1);
        preguntadto.setIdTipoPregunta(idtipopregunta);
        SubCategoriaDto idsubcategoria = new SubCategoriaDto(1);
        preguntadto.setIdSubCategoria(idsubcategoria);
        UsuarioDto idusuario = new UsuarioDto(8);
        preguntadto.setIdUsuario(idusuario);

        PreguntaDto resultado = servicio.addPregunta( preguntadto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void changePreguntaTest() throws Exception {
        ucab.dsw.servicio.prueba_Pregunta servicio = new ucab.dsw.servicio.prueba_Pregunta();
        PreguntaDto  preguntadto= new PreguntaDto( 3);

        preguntadto.setPregunta("Cual es su talla de franela?");
        preguntadto.setFechacreacion("2020/11/23");
        preguntadto.setEstatus("A");
        TipoPreguntaDto idtipopregunta = new TipoPreguntaDto(1);
        preguntadto.setIdTipoPregunta(idtipopregunta);
        SubCategoriaDto idsubcategoria = new SubCategoriaDto(1);
        preguntadto.setIdSubCategoria(idsubcategoria);
        UsuarioDto idusuario = new UsuarioDto(8);
        preguntadto.setIdUsuario(idusuario);

        PreguntaDto resultado = servicio.changePregunta( preguntadto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void deletePreguntaTest() throws Exception {
        ucab.dsw.servicio.prueba_Pregunta servicio = new ucab.dsw.servicio.prueba_Pregunta();
        PreguntaDto  preguntadto= new PreguntaDto( 2);
        PreguntaDto resultado = servicio.deletePregunta( preguntadto.getId() );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void findPreguntaTest() throws Exception {
        ucab.dsw.servicio.prueba_Pregunta servicio = new ucab.dsw.servicio.prueba_Pregunta();
        PreguntaDto  preguntadto = new PreguntaDto( 2);
        PreguntaDto resultado = servicio.findPregunta( preguntadto.getId() );
        Assert.assertNotEquals( resultado.getId(), 0);
    }
}
