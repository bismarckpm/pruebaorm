import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.TipoPreguntaDto;

public class pruebaTipoPreguntaControlador {


    @Test
    public void createTipoPreguntaTest() throws Exception
    {

            ucab.dsw.servicio.TipoPreguntaControlador servicio = new ucab.dsw.servicio.TipoPreguntaControlador();
            TipoPreguntaDto tipoPreguntaDto = new TipoPreguntaDto();
            tipoPreguntaDto.setDescripcion("prueba");
            tipoPreguntaDto.setEstatus("A");
            TipoPreguntaDto resultado = servicio.addTipoPregunta( tipoPreguntaDto );
            Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void updateTipoPreguntaTest() throws Exception
    {
        ucab.dsw.servicio.TipoPreguntaControlador servicio = new ucab.dsw.servicio.TipoPreguntaControlador();
        TipoPreguntaDto tipoPregDto = new TipoPreguntaDto(1);
        tipoPregDto.setEstatus("A");
        tipoPregDto.setDescripcion("upd_desc");
        TipoPreguntaDto resultado = servicio.updateTipoPregunta(tipoPregDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void getTipoPreguntaTest() throws Exception
    {
        ucab.dsw.servicio.TipoPreguntaControlador servicio = new ucab.dsw.servicio.TipoPreguntaControlador();
        TipoPreguntaDto resultado = servicio.obtenerTipoPregunta( 1);
        Assert.assertEquals( resultado.getId(),1);
    }

    @Test
    public void deleteTipoPreguntaTest() throws Exception
    {
        ucab.dsw.servicio.TipoPreguntaControlador servicio = new ucab.dsw.servicio.TipoPreguntaControlador();
        TipoPreguntaDto resultado = servicio.deleteTipoPregunta((long) 1);
        Assert.assertEquals( resultado.getId(), 1);
    }
}
