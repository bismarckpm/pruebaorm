import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.OpcionDto;
import ucab.dsw.dtos.PreguntaDto;

public class pruebaOpcionControlador {

    @Test
    public void obtenerOpcionPrueba() throws Exception {
        ucab.dsw.servicio.OpcionControlador servicio = new ucab.dsw.servicio.OpcionControlador();
        OpcionDto resultado = servicio.obtenerOpcion( (long) 2);
        Assert.assertEquals( resultado.getId(), 2);
    }

    @Test
    public void crearOpcionPrueba() throws Exception {
        ucab.dsw.servicio.OpcionControlador servicio = new ucab.dsw.servicio.OpcionControlador();
        OpcionDto opcionDto = new OpcionDto();
        opcionDto.setEstatus("A");
        opcionDto.setDescricion("Soy una descripcion 3");
        PreguntaDto preguntaDto = new PreguntaDto(2);
        opcionDto.setPregunta( preguntaDto);
        OpcionDto resultado = servicio.crearOpcion( opcionDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void modificarOpcionPrueba() throws Exception {
        ucab.dsw.servicio.OpcionControlador servicio = new ucab.dsw.servicio.OpcionControlador();
        OpcionDto opcionDto = new OpcionDto(2);
        opcionDto.setEstatus("A");
        opcionDto.setDescricion("Soy una descripcion modificada");
        PreguntaDto preguntaDto = new PreguntaDto(2);
        opcionDto.setPregunta( preguntaDto);
        OpcionDto resultado = servicio.modificarOpcion( opcionDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void eliminarOpcionPrueba() throws Exception {
        ucab.dsw.servicio.OpcionControlador servicio = new ucab.dsw.servicio.OpcionControlador();
        OpcionDto resultado = servicio.borrarOpcion( (long) 3);
        Assert.assertEquals( resultado.getId(), 3);
    }
}
