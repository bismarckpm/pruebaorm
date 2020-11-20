import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.dtos.OpcionDto;
import ucab.dsw.dtos.PreguntaDto;
import ucab.dsw.dtos.SubCategoriaDto;
import ucab.dsw.entidades.Opcion;
import ucab.dsw.entidades.Pregunta;

public class prueba_Opcion_Test {
    @Test
    public void addOpcionTest() throws Exception {
        ucab.dsw.servicio.prueba_Opcion servicio = new ucab.dsw.servicio.prueba_Opcion();
        OpcionDto opciondto = new OpcionDto();

        opciondto.setDescripcion("Talla M");
        opciondto.setEstatus("I");
        PreguntaDto idpregunta = new PreguntaDto(1);
        opciondto.setIdPregunta(idpregunta);

        OpcionDto resultado = servicio.addOpcion( opciondto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void changeOpcionTest() throws Exception {
        ucab.dsw.servicio.prueba_Opcion servicio = new ucab.dsw.servicio.prueba_Opcion();
        OpcionDto opciondto = new OpcionDto(1);

        opciondto.setDescripcion("Talla XL");
        opciondto.setEstatus("A");
        PreguntaDto idpregunta = new PreguntaDto(1);
        opciondto.setIdPregunta(idpregunta);

        OpcionDto resultado = servicio.changeOpcion( opciondto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void deleteOpcionTest() throws Exception {
        ucab.dsw.servicio.prueba_Opcion servicio = new ucab.dsw.servicio.prueba_Opcion();
        OpcionDto  opciondto= new OpcionDto( 2);
        OpcionDto resultado = servicio.deleteOpcion( opciondto.getId() );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void findOpcionTest() throws Exception {
        ucab.dsw.servicio.prueba_Opcion servicio = new ucab.dsw.servicio.prueba_Opcion();
        OpcionDto  opciondto = new OpcionDto( 2);
        OpcionDto resultado = servicio.findOpcion( opciondto.getId() );
        Assert.assertNotEquals( resultado.getId(), 0);
    }
}
