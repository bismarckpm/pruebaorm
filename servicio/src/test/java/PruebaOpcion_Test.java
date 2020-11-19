
import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.OpcionDto;

/**
 *
 * @author Omar David
 */
public class PruebaOpcion_Test {
    @Test
    public void addOpcionTest() throws Exception
    {
        ucab.dsw.servicio.PruebaOpcion servicio = new ucab.dsw.servicio.PruebaOpcion();
        OpcionDto opcionDto = new OpcionDto();
        opcionDto.setDescripcion("Prueba opcion");
        opcionDto.setEstatus("A");
        OpcionDto resultado = servicio.addOpcion(opcionDto);
        Assert.assertNotEquals( resultado.getId(), 1 );
    }
}
