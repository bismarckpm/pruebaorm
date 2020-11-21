
import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.OpcionDto;
import ucab.dsw.dtos.PreguntaDto;
import ucab.dsw.servicio.PruebaOpcion;

/**
 *
 * @author Omar David
 */
public class PruebaOpcion_Test {
    @Test
    public void addOpcionTest() throws Exception
    {
        PruebaOpcion servicio = new ucab.dsw.servicio.PruebaOpcion();
        OpcionDto opcionDto = new OpcionDto();
        opcionDto.setDescripcion("Prueba opcion");
        opcionDto.setEstatus("A");
        PreguntaDto preguntaDto = new PreguntaDto();
        opcionDto.setPreguntaDto(preguntaDto);
        OpcionDto resultado = servicio.addOpcion(opcionDto);
        Assert.assertNotEquals( resultado.getId(), 1 );
    }

    @Test
    public void changeOpcionTest() throws Exception
    {
        PruebaOpcion servicio = new PruebaOpcion();
        OpcionDto opcionDto = new OpcionDto();
        opcionDto.setDescripcion("Prueba opcion update");
        opcionDto.setEstatus("I");
        PreguntaDto preguntaDto = new PreguntaDto(100);
        opcionDto.setPreguntaDto(preguntaDto);
        OpcionDto resultado = servicio.changeOpcion(opcionDto);
        Assert.assertNotEquals( resultado.getId(), 0  );

    }
    @Test
    public void deleteOpcionTest() throws Exception
    {
        PruebaOpcion servicio = new PruebaOpcion();
        OpcionDto resultado = servicio.deleteOpcion(1);
        Assert.assertNotEquals( resultado.getId(), 0 );

    }

    @Test
    public void findOpcionTest() throws Exception
    {
        PruebaOpcion servicio = new PruebaOpcion();
        OpcionDto OpcionDto = new OpcionDto();
        OpcionDto resultado = servicio.showOpcion(OpcionDto.getId());
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

}
