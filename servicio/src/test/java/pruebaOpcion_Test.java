import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.accesodatos.DaoSubCategoria;
import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.dtos.SubCategoriaDto;
import ucab.dsw.dtos.OpcionDto;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.entidades.*;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import java.util.List;

public class pruebaOpcion_Test {

    @Test
    public void addOpcionTest() throws Exception{

        ucab.dsw.servicio.pruebaOpcion servicio = new ucab.dsw.servicio.pruebaOpcion();
        OpcionDto opcionDto = new OpcionDto();
        opcionDto.setDescripcion( "descripcion opcion" );
        opcionDto.setEstatus( "A" );
        //PreguntaDto pregunta = new PreguntaDto( 1);
        //opcionDto.setPreguntaDto( pregunta );
        OpcionDto resultado = servicio.addOpcion( opcionDto );
        Assert.assertNotEquals( resultado.getId(), 1 );

    }

    @Test
    public void getOpcionTest() throws Exception{
        ucab.dsw.servicio.pruebaOpcion servicio = new ucab.dsw.servicio.pruebaOpcion();
        List<Opcion> opciones = servicio.getOpcion();
        Assert.assertFalse("Consulta Opcion", opciones.isEmpty());
    }

    @Test
    public void updateOpcionTest() throws Exception{

        ucab.dsw.servicio.pruebaOpcion servicio = new ucab.dsw.servicio.pruebaOpcion();
        OpcionDto opcionDto = new OpcionDto(1);
        opcionDto.setDescripcion( "update opcion" );
        opcionDto.setEstatus( "A" );
        //PreguntaDto pregunta = new PreguntaDto( 1);
        //OpcionDto.setPreguntaDto( pregunta );
        OpcionDto resultado = servicio.updateOpcion (opcionDto);
        Assert.assertNotEquals( resultado.getId(), 1);

    }

    @Test
    public void deleteOpcionTest() throws Exception{

        ucab.dsw.servicio.pruebaOpcion servicio = new ucab.dsw.servicio.pruebaOpcion();
        OpcionDto opcionDto = new OpcionDto(1);
        OpcionDto resultado = servicio.deleteOpcion(opcionDto);
        Assert.assertNotEquals( resultado.getId(), 1 );

    }
}
