import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.OpcionDto;
import ucab.dsw.dtos.PreguntaDto;

public class testOpcion_Test {

    @Test
    public void addOpcionTest() throws Exception
    {
        ucab.dsw.servicio.testOpcion servicio = new ucab.dsw.servicio.testOpcion();
        OpcionDto opcionDto = new OpcionDto();
        opcionDto.setDescripcion( "opcion1" );
        opcionDto.setEstatus( "A" );
        PreguntaDto pregunta = new PreguntaDto( 2 );
        opcionDto.setPreguntaDto( pregunta );
        OpcionDto resultado = servicio.addOpcion( opcionDto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void modifyOpcionTest() throws Exception
    {
        ucab.dsw.servicio.testOpcion servicio = new ucab.dsw.servicio.testOpcion();
        OpcionDto opcionDto = new OpcionDto(10);
        opcionDto.setDescripcion( "opc" );
        opcionDto.setEstatus( "I" );
        PreguntaDto pregunta = new PreguntaDto( 2 );
        opcionDto.setPreguntaDto(pregunta);
        OpcionDto resultado = servicio.modifyOpcion(opcionDto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void deleteOpcionTest() throws Exception
    {
        ucab.dsw.servicio.testOpcion servicio = new ucab.dsw.servicio.testOpcion();
        OpcionDto opcionDto = new OpcionDto(1);
        OpcionDto resultado = servicio.deleteOpcion(opcionDto.getId());
        Assert.assertNotEquals( resultado.getId(), 0);
    }

    @Test
    public void consultarOpcionTest() throws Exception
    {
        ucab.dsw.servicio.testOpcion servicio = new ucab.dsw.servicio.testOpcion();
        OpcionDto opcionDto = new OpcionDto(2);
        OpcionDto resultado = servicio.consultarOpcion(opcionDto.getId());
        System.out.println("Resultado = ");
        System.out.print(resultado);
        Assert.assertNotEquals( resultado.getId(), 0);
    }


}
