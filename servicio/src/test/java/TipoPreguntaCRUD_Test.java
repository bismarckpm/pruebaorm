import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.TipoPreguntaDto;


public class TipoPreguntaCRUD_Test {

    @Test
    public void addTipoPreguntaTest() throws Exception
    {
        ucab.dsw.servicio.TipoPreguntaCRUD servicio = new ucab.dsw.servicio.TipoPreguntaCRUD();
        TipoPreguntaDto tipoPreguntaDto = new TipoPreguntaDto();
        tipoPreguntaDto.setDescripcion( "Verdadero y Falso" );
        tipoPreguntaDto.setEstatus( "A" );
        TipoPreguntaDto resultado = servicio.addTipoPregunta( tipoPreguntaDto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

}
