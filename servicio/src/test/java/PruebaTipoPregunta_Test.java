
import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.servicio.PruebaTipoPregunta;

/**
 *
 * @author Omar David
 */
public class PruebaTipoPregunta_Test {
    @Test
    public void addTipoPreguntaTest() throws Exception{
        PruebaTipoPregunta servicio = new ucab.dsw.servicio.PruebaTipoPregunta();
        TipoPreguntaDto tipopreguntaDto = new TipoPreguntaDto();
        tipopreguntaDto.setDescripcion("Prueba tipo pregunta");
        tipopreguntaDto.setEstatus("A");
        TipoPreguntaDto resultado = servicio.addTipoPregunta(tipopreguntaDto);
        Assert.assertNotEquals( resultado.getId(), 1 );
    }

    @Test
    public void changeTipoPreguntaTest() throws Exception
    {
        PruebaTipoPregunta servicio = new PruebaTipoPregunta();
        TipoPreguntaDto tipopreguntaDto = new TipoPreguntaDto(4);
        tipopreguntaDto.setDescripcion("Prueba tipo pregunta update");
        tipopreguntaDto.setEstatus("I");
        TipoPreguntaDto resultado = servicio.changeTipoPregunta( tipopreguntaDto );
        Assert.assertNotEquals( resultado.getId(), 0 );

    }

    @Test
    public void deleteTipoPreguntaTest() throws Exception
    {
        PruebaTipoPregunta servicio = new PruebaTipoPregunta();
        TipoPreguntaDto resultado = servicio.deleteTipoPregunta( 10 );
        Assert.assertNotEquals( resultado.getId(), 0 );

    }

    @Test
    public void showTipoPreguntaTest() throws Exception
    {
        PruebaTipoPregunta servicio = new PruebaTipoPregunta();
        TipoPreguntaDto  TipoPreguntaDto= new TipoPreguntaDto( 6);
        TipoPreguntaDto resultado = servicio.showTipoPregunta( TipoPreguntaDto.getId() );
        Assert.assertEquals( resultado.getDescripcion(), "TipoPregunta");

    }
}
