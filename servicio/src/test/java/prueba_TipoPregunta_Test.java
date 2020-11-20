import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.dtos.TipoPreguntaDto;

public class prueba_TipoPregunta_Test {

    @Test
    public void addTipoPreguntaTest() throws Exception {
        ucab.dsw.servicio.prueba_TipoPregunta servicio = new ucab.dsw.servicio.prueba_TipoPregunta();
        TipoPreguntaDto TipoPreguntaDto= new TipoPreguntaDto();
        TipoPreguntaDto.setDescripcion( "Larga" );
        TipoPreguntaDto.setEstatus("I");
        TipoPreguntaDto resultado = servicio.addTipoPregunta( TipoPreguntaDto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void changeTipoPreguntaTest() throws Exception {
        ucab.dsw.servicio.prueba_TipoPregunta servicio = new ucab.dsw.servicio.prueba_TipoPregunta();
        TipoPreguntaDto  TipoPreguntaDto= new TipoPreguntaDto( 3);
        TipoPreguntaDto.setDescripcion( "numerica" );
        TipoPreguntaDto.setEstatus("A");
        TipoPreguntaDto resultado = servicio.changeTipoPregunta( TipoPreguntaDto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void deleteTipoPreguntaTest() throws Exception {
        ucab.dsw.servicio.prueba_TipoPregunta servicio = new ucab.dsw.servicio.prueba_TipoPregunta();
        TipoPreguntaDto  TipoPreguntaDto= new TipoPreguntaDto( 2);
        TipoPreguntaDto resultado = servicio.deleteTipoPregunta( TipoPreguntaDto.getId() );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void findTipoPreguntaTest() throws Exception {
        ucab.dsw.servicio.prueba_TipoPregunta servicio = new ucab.dsw.servicio.prueba_TipoPregunta();
        TipoPreguntaDto  TipoPreguntaDto= new TipoPreguntaDto( 3);
        TipoPreguntaDto resultado = servicio.findTipoPregunta( TipoPreguntaDto.getId() );
        Assert.assertEquals( resultado.getDescripcion(), 1);
    }
}
