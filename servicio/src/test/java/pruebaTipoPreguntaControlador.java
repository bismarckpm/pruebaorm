import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.TipoPreguntaDto;

public class pruebaTipoPreguntaControlador {

    public long test_id = 10;

    @Test
    public void acreateTipoPreguntaTest() throws Exception
    {
            ucab.dsw.servicio.TipoPreguntaControlador servicio = new ucab.dsw.servicio.TipoPreguntaControlador();
            TipoPreguntaDto tipoPreguntaDto = new TipoPreguntaDto();
            tipoPreguntaDto.setDescripcion("prueba");
            tipoPreguntaDto.setEstatus("A");
            TipoPreguntaDto resultado = servicio.addTipoPregunta( tipoPreguntaDto );
            Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void bupdateTipoPreguntaTest() throws Exception
    {
        ucab.dsw.servicio.TipoPreguntaControlador servicio = new ucab.dsw.servicio.TipoPreguntaControlador();
        TipoPreguntaDto tipoPregDto = new TipoPreguntaDto(test_id+1);
        tipoPregDto.setEstatus("A");
        tipoPregDto.setDescripcion("upd_desc");
        TipoPreguntaDto resultado = servicio.updateTipoPregunta(tipoPregDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void cgetTipoPreguntaTest() throws Exception
    {

        ucab.dsw.servicio.TipoPreguntaControlador servicio = new ucab.dsw.servicio.TipoPreguntaControlador();
        TipoPreguntaDto resultado = servicio.obtenerTipoPregunta(test_id);
        Assert.assertEquals( resultado.getId(),test_id);
    }

    @Test
    public void ddeleteTipoPreguntaTest() throws Exception
    {
        ucab.dsw.servicio.TipoPreguntaControlador servicio = new ucab.dsw.servicio.TipoPreguntaControlador();
        TipoPreguntaDto resultado = servicio.deleteTipoPregunta(test_id );
        Assert.assertEquals( resultado.getId(), test_id );
    }
}
