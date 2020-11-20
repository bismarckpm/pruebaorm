import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.accesodatos.DaoSubCategoria;
import ucab.dsw.dtos.*;
import ucab.dsw.entidades.*;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;


public class pruebaEncuesta_Test {
    @Test
    public void addEncuestaTest() throws Exception{

        ucab.dsw.servicio.pruebaEncuesta servicio = new ucab.dsw.servicio.pruebaEncuesta();
        EncuestaDto encuestaDto = new EncuestaDto();
        java.util.Date fecha = new java.util.Date("20/11/2020");
        encuestaDto.setFechaCreacion(fecha);
        encuestaDto.setEstatus( "C" );
        UsuarioDto usuarioC = new UsuarioDto( 1);
        encuestaDto.setUsuarioCreadorDto( usuarioC);
        UsuarioDto usuarioA = new UsuarioDto( 1);
        encuestaDto.setUsuarioAnalistaDto( usuarioA );
        EstudioDto estudio = new EstudioDto( 1);
        encuestaDto.setEstudioDto( estudio );
        EncuestaDto resultado = servicio.addEncuesta( encuestaDto );
        Assert.assertNotEquals( resultado.getId(), 0  );

    }

    @Test
    public void updateEncuestaTest() throws Exception{

        ucab.dsw.servicio.pruebaEncuesta servicio = new ucab.dsw.servicio.pruebaEncuesta();
        EncuestaDto encuestaDto = new EncuestaDto();
        java.util.Date fecha = new java.util.Date("21/11/2020");
        encuestaDto.setFechaCreacion(fecha);
        encuestaDto.setEstatus( "C" );
        UsuarioDto usuarioC = new UsuarioDto( 1);
        encuestaDto.setUsuarioCreadorDto( usuarioC);
        UsuarioDto usuarioA = new UsuarioDto( 1);
        encuestaDto.setUsuarioAnalistaDto( usuarioA );
        EstudioDto estudio = new EstudioDto( 1);
        encuestaDto.setEstudioDto( estudio );
        EncuestaDto resultado = servicio.updateEncuesta (encuestaDto);
        Assert.assertNotEquals( resultado.getId(), 0);

    }

    @Test
    public void deleteEncuestaTest() throws Exception{

        ucab.dsw.servicio.pruebaEncuesta servicio = new ucab.dsw.servicio.pruebaEncuesta();
        EncuestaDto encuestaDto = new EncuestaDto(1);
        EncuestaDto resultado = servicio.deleteEncuesta(encuestaDto);
        Assert.assertNotEquals( resultado.getId(), 0 );

    }
}
