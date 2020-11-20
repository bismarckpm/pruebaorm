import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.PreguntaDto;
import ucab.dsw.dtos.SubCategoriaDto;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.SubCategoria;

import java.util.Date;

public class pruebaPreguntaControlador {

    @Test
    public void obtenerPreguntaPrueba() throws Exception{
        ucab.dsw.servicio.PreguntaControlador servicio = new ucab.dsw.servicio.PreguntaControlador();
        PreguntaDto resultado = servicio.obtenerPregunta( (long) 1);
        Assert.assertEquals( resultado.getId(), 1);
    }

    @Test
    public void CrearPreguntaPrueba() throws Exception{
        ucab.dsw.servicio.PreguntaControlador servicio = new ucab.dsw.servicio.PreguntaControlador();
        PreguntaDto preguntaDto = new PreguntaDto();
        preguntaDto.setPregunta( "Pregunta 2");
        preguntaDto.setEstatus( "A");
        preguntaDto.setFechaCreacion( new Date());
        UsuarioDto usuarioDto = new UsuarioDto(11);
        preguntaDto.setUsuario( usuarioDto);
        SubCategoriaDto subCategoriaDto = new SubCategoriaDto(2);
        preguntaDto.setSubCategoria( subCategoriaDto);
        TipoPreguntaDto tipoPreguntaDto = new TipoPreguntaDto(1);
        preguntaDto.setTipoPregunta( tipoPreguntaDto);
        PreguntaDto resultado = servicio.crearPregunta( preguntaDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void modificarPreguntaPrueba() throws Exception{
        ucab.dsw.servicio.PreguntaControlador servicio = new ucab.dsw.servicio.PreguntaControlador();
        PreguntaDto preguntaDto = new PreguntaDto(1);
        preguntaDto.setPregunta( "Pregunta Cambiada");
        preguntaDto.setEstatus( "A");
        preguntaDto.setFechaCreacion( new Date());
        UsuarioDto usuarioDto = new UsuarioDto(11);
        preguntaDto.setUsuario( usuarioDto);
        SubCategoriaDto subCategoriaDto = new SubCategoriaDto(2);
        preguntaDto.setSubCategoria( subCategoriaDto);
        TipoPreguntaDto tipoPreguntaDto = new TipoPreguntaDto(1);
        preguntaDto.setTipoPregunta( tipoPreguntaDto);
        PreguntaDto resultado = servicio.modificarPregunta( preguntaDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void borrarPreguntaPrueba() throws Exception{
        ucab.dsw.servicio.PreguntaControlador servicio = new ucab.dsw.servicio.PreguntaControlador();
        PreguntaDto resultado = servicio.borrarPregunta( (long) 3);
        Assert.assertEquals( resultado.getId(), 3);
    }
}
