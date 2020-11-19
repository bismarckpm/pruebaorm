
import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.TipoPreguntaDto;

/**
 *
 * @author Omar David
 */
public class PruebaTipoPregunta_Test {
    @Test
    public void addTipoPregutnaTest() throws Exception{
        ucab.dsw.servicio.PruebaTipoPregunta servicio = new ucab.dsw.servicio.PruebaTipoPregunta();
        TipoPreguntaDto tipopreguntaDto = new TipoPreguntaDto();
        tipopreguntaDto.setDescripcion("Prueba tipo pregunta");
        tipopreguntaDto.setEstatus("A");
        TipoPreguntaDto resultado = servicio.addTipoPregunta(tipopreguntaDto);
        Assert.assertNotEquals( resultado.getId(), 1 );
    }
}
