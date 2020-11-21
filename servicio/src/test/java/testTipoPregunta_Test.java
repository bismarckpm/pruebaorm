import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.TipoPreguntaDto;

public class testTipoPregunta_Test {

    @Test
    public void addTipoPreguntaTest() throws Exception
    {
        ucab.dsw.servicio.testTipoPregunta servicio = new ucab.dsw.servicio.testTipoPregunta();
        TipoPreguntaDto tipoPreguntaDto = new TipoPreguntaDto();
        tipoPreguntaDto.setDescripcion( "test7" );
        tipoPreguntaDto.setEstatus( "A" );
        TipoPreguntaDto resultado = servicio.addTipoPregunta( tipoPreguntaDto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }


    @Test
    public void changeTipoPreguntaTest() throws Exception
    {
        ucab.dsw.servicio.testTipoPregunta servicio = new ucab.dsw.servicio.testTipoPregunta();
        TipoPreguntaDto tipoPreguntaDto = new TipoPreguntaDto(1);
        tipoPreguntaDto.setDescripcion( "testChangePath" );
        tipoPreguntaDto.setEstatus( "I" );
        TipoPreguntaDto resultado = servicio.changeTipoPregunta(tipoPreguntaDto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void deleteTipoPregunta() throws Exception
    {
        ucab.dsw.servicio.testTipoPregunta servicio = new ucab.dsw.servicio.testTipoPregunta();
        TipoPreguntaDto tipoPreguntaDto = new TipoPreguntaDto(11);
        TipoPreguntaDto resultado = servicio.deleteTipoPregunta(tipoPreguntaDto.getId());
        Assert.assertNotEquals( resultado.getId(), 0);
    }

    @Test
    public void findTipoPregunta() throws Exception
    {
        ucab.dsw.servicio.testTipoPregunta servicio = new ucab.dsw.servicio.testTipoPregunta();
        TipoPreguntaDto tipoPreguntaDto = new TipoPreguntaDto(1);
        TipoPreguntaDto resultado = servicio.findTipoPregunta(tipoPreguntaDto.getId());
        System.out.println("Resultado = ");
        System.out.print(resultado);
        Assert.assertNotEquals( resultado.getId(), 0);
    }

}
