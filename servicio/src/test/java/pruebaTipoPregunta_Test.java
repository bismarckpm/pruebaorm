import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.TipoPreguntaDto;

public class pruebaTipoPregunta_Test {
    @Test
    public void addTipoPreguntaTest() throws Exception {
        ucab.dsw.servicio.pruebaTipoPregunta servicio = new ucab.dsw.servicio.pruebaTipoPregunta();
        TipoPreguntaDto tipoPreguntaDto = new TipoPreguntaDto();
        tipoPreguntaDto.setDescripcion( "Desarrollo" );
        tipoPreguntaDto.setEstatus("A");
        TipoPreguntaDto resultado = servicio.addTipoPregunta( tipoPreguntaDto );
        Assert.assertNotEquals( resultado.getId(), 1);
    }

}
