import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.*;
import ucab.dsw.entidades.Encuesta;
import ucab.dsw.servicio.CategoriaController;
import ucab.dsw.servicio.EjecutaEncuestaController;

public class EjecutaEncuestaController_test {
    @Test
    public void addEjecutaEncuestaTest() throws Exception
    {
        EjecutaEncuestaController servicio = new EjecutaEncuestaController();
        EjecutaEncuestaDto ejecutaEncuestaDto = new EjecutaEncuestaDto();
        ejecutaEncuestaDto.setEstatus("P");
        ejecutaEncuestaDto.setRespuesta("TEST");
        ejecutaEncuestaDto.setIdEncuesta(new EncuestaDto(1));
        ejecutaEncuestaDto.setIdOpcion(new OpcionDto(1));
        ejecutaEncuestaDto.setIdPregunta(new PreguntaDto(1));
        ejecutaEncuestaDto.setIdUsuario_Encuestado(new UsuarioDto(9));
        EjecutaEncuestaDto resultado = servicio.addEjecutaEncuesta(ejecutaEncuestaDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }
    @Test
    public void modifyEjecutaEncuestaTest() throws Exception
    {
        EjecutaEncuestaController servicio = new EjecutaEncuestaController();
        EjecutaEncuestaDto ejecutaEncuestaDto = new EjecutaEncuestaDto(1);
        ejecutaEncuestaDto.setEstatus("P");
        ejecutaEncuestaDto.setRespuesta("TEST MODIFICADO");
        ejecutaEncuestaDto.setIdEncuesta(new EncuestaDto(1));
        ejecutaEncuestaDto.setIdOpcion(new OpcionDto(1));
        ejecutaEncuestaDto.setIdPregunta(new PreguntaDto(1));
        ejecutaEncuestaDto.setIdUsuario_Encuestado(new UsuarioDto(9));
        EjecutaEncuestaDto resultado = servicio.addEjecutaEncuesta(ejecutaEncuestaDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }
}
