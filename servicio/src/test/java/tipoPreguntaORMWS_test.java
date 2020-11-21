import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.entidades.TipoPregunta;

public class tipoPreguntaORMWS_test {

    @Test
    public void addTipoPreguntaTest() throws Exception {
        ucab.dsw.servicio.TipoPreguntaORMWS servicio = new ucab.dsw.servicio.TipoPreguntaORMWS();
        TipoPreguntaDto tipoPreguntaDto = new TipoPreguntaDto();
        tipoPreguntaDto.setDescripcion("PruebaA");
        tipoPreguntaDto.setEstatus("A");

        TipoPreguntaDto resultado = servicio.add(tipoPreguntaDto);
        Assert.assertNotEquals(resultado.getId(), 0);
    }

    @Test
    public void deleteTipoPreguntaTest() throws Exception{
        ucab.dsw.servicio.TipoPreguntaORMWS servicio = new ucab.dsw.servicio.TipoPreguntaORMWS();

        TipoPreguntaDto resultado = servicio.delete(10);
        Assert.assertEquals( resultado.getId(), 0  );
    }

    @Test
    public void getTipoPreguntaTest() throws Exception{
        ucab.dsw.servicio.TipoPreguntaORMWS servicio = new ucab.dsw.servicio.TipoPreguntaORMWS();

        TipoPreguntaDto resultado = servicio.getFirstOne(1);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

}
