import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.entidades.TipoPregunta;
import java.util.List;

public class pruebaTipoPregunta_Test {
    @Test
    public void addTipoPregunta() throws Exception{
        ucab.dsw.servicio.pruebaTipoPregunta servicio = new ucab.dsw.servicio.pruebaTipoPregunta();
        TipoPreguntaDto tipoPreguntaDto = new TipoPreguntaDto();
        tipoPreguntaDto.setDescripcion( "Desarrollo");
        tipoPreguntaDto.setEstatus("A");
        TipoPreguntaDto resultado = servicio.addTipoPregunta( tipoPreguntaDto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void getTipoPregunta() throws Exception{
        ucab.dsw.servicio.pruebaTipoPregunta servicio = new ucab.dsw.servicio.pruebaTipoPregunta();
        List<TipoPregunta> tipoPregunta = servicio.getTipoPregunta();
        Assert.assertFalse("Consulta TipoPregunta",tipoPregunta.isEmpty());
    }

    @Test
    public void  updateTipoPregunta() throws Exception
    {
        ucab.dsw.servicio.pruebaTipoPregunta servicio = new ucab.dsw.servicio.pruebaTipoPregunta();
        TipoPreguntaDto tipoPreguntaDto = new TipoPreguntaDto();
        tipoPreguntaDto.setDescripcion("Selección simple");
        TipoPreguntaDto resultado = servicio.updateTipoPregunta(1, tipoPreguntaDto);
        Assert.assertNotEquals(resultado.getId(), 0);
    }

    @Test
    public void deleteTipoPregunta() throws Exception
    {
        ucab.dsw.servicio.pruebaTipoPregunta servicio = new ucab.dsw.servicio.pruebaTipoPregunta();
        TipoPreguntaDto resultado = servicio.deleteTipoPregunta(1);
        Assert.assertNotEquals(resultado.getId(), 0);
    }

}
