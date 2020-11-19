import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.dtos.*;
import ucab.dsw.entidades.*;

import java.util.Date;

public class pruebaEncuesta_Test {
    private Date fechaTest=new Date(119,6,2);
    @Test
    public void addEncuestaTest() throws Exception
    {
        ucab.dsw.servicio.pruebaEncuesta servicio = new ucab.dsw.servicio.pruebaEncuesta();
        EncuestaDto encuestaDto = new EncuestaDto();
        encuestaDto.setEstatus("C");
        encuestaDto.setFechaCreacion(fechaTest);
        EstudioDto estudio=new EstudioDto(1);
        encuestaDto.setEstudio(estudio);
        UsuarioDto usuarioAnalista=new UsuarioDto();
        usuarioAnalista.setId(1);
        encuestaDto.setUsuarioDtoAnalista(usuarioAnalista);
        UsuarioDto usuarioCreador=new UsuarioDto();
        usuarioCreador.setId(2);
        encuestaDto.setUsuarioDtoCreador(usuarioCreador);
        EncuestaDto resultado = servicio.addEncuesta(encuestaDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }
}
