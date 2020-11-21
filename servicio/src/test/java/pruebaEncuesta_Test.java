import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.accesodatos.DaoSubCategoria;
import ucab.dsw.dtos.*;
import ucab.dsw.entidades.*;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import java.text.SimpleDateFormat;
import java.util.List;


public class pruebaEncuesta_Test {
    @Test
    public void addEncuestaTest() throws Exception{

        ucab.dsw.servicio.pruebaEncuesta servicio = new ucab.dsw.servicio.pruebaEncuesta();
        EncuestaDto encuestaDto = new EncuestaDto();
        encuestaDto.setFechaCreacion(new SimpleDateFormat("dd/MM/yyyy").parse("15/11/2020"));
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
    public void listEncuestaTest() throws Exception{

        ucab.dsw.servicio.pruebaEncuesta servicio = new ucab.dsw.servicio.pruebaEncuesta();
        List<Encuesta> encuesta = servicio.listEncuesta();
        Assert.assertNotEquals( "Encuesta listadas", encuesta.isEmpty() );

    }

    @Test
    public void updateEncuestaTest() throws Exception{

        ucab.dsw.servicio.pruebaEncuesta servicio = new ucab.dsw.servicio.pruebaEncuesta();
        EncuestaDto encuestaDto = new EncuestaDto(1);
        encuestaDto.setFechaCreacion(new SimpleDateFormat("dd/MM/yyyy").parse("15/11/2020"));
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
