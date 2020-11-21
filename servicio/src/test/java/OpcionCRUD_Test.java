import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.OpcionDto;
import ucab.dsw.dtos.PreguntaDto;
import ucab.dsw.entidades.Opcion;
import java.util.List;

public class OpcionCRUD_Test {

    @Test
    public void addOpcionTest() throws Exception
    {
        ucab.dsw.servicio.OpcionCRUD servicio = new ucab.dsw.servicio.OpcionCRUD();
        OpcionDto opcionDto = new OpcionDto();
        opcionDto.setDescripcion( "Opcion 1: Verdadero" );
        opcionDto.setEstatus( "A" );
        PreguntaDto pregunta = new PreguntaDto(2);
        opcionDto.setPreguntaDto( pregunta );
        OpcionDto resultado = servicio.addOpcion( opcionDto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void getOpcionTest() throws Exception{
        ucab.dsw.servicio.OpcionCRUD servicio = new ucab.dsw.servicio.OpcionCRUD();
        List<Opcion> opcion = servicio.getOpcion();
        Assert.assertFalse("Error en la consulta  de la opcion ",opcion.isEmpty());
    }

    @Test
    public void updateOpcionTest() throws Exception{
        ucab.dsw.servicio.OpcionCRUD servicio = new ucab.dsw.servicio.OpcionCRUD();
        OpcionDto opcionDto = new OpcionDto();
        opcionDto.setDescripcion( "Opcion 1: Falso" );
        opcionDto.setEstatus( "A" );
        PreguntaDto pregunta = new PreguntaDto(2);
        opcionDto.setPreguntaDto( pregunta );
        OpcionDto resultado = servicio.updateOpcion(1, opcionDto);
        Assert.assertNotEquals(resultado.getId(), 0);
    }

    @Test
    public void deleteOpcionTest() throws Exception{
        ucab.dsw.servicio.OpcionCRUD servicio = new ucab.dsw.servicio.OpcionCRUD();
        OpcionDto resultado = servicio.deleteOpcion(2);
        Assert.assertNotEquals(resultado.getId(), 0);
    }
}
