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

public class pruebaSolicitud_Test {

    @Test
    public void addSolicitudTest() throws Exception{

        ucab.dsw.servicio.pruebaSolicitud servicio = new ucab.dsw.servicio.pruebaSolicitud();
        SolicitudDto solicitudDto = new SolicitudDto();
        solicitudDto.setNombre( "nombre solicitud" );
        solicitudDto.setFecha( "fecha solicitud" );
        solicitudDto.setEstatus( "A" );
        UsuarioDto usuario = new UsuarioDto( 1);
        solicitudDto.setUsuarioDto( usuario );
        SubCategoriaDto subcategoria = new SubCategoriaDto( 1);
        solicitudDto.setSubCategoriaDto( subcategoria );
        SolicitudDto resultado = servicio.addSolicitud( solicitudDto );
        Assert.assertNotEquals( resultado.getId(), 1 );

    }

    @Test
    public void getSolicitud() throws Exception{
        ucab.dsw.servicio.pruebaSolicitud servicio = new ucab.dsw.servicio.pruebaSolicitud();
        List<Solicitud> solicitudes = servicio.getSolicitud();
        Assert.assertFalse("Consulta Solicitud", solicitudes.isEmpty());
    }

    @Test
    public void updateSolicitudTest() throws Exception{

        ucab.dsw.servicio.pruebaSolicitud servicio = new ucab.dsw.servicio.pruebaSolicitud();
        SolicitudDto solicitudDto = new SolicitudDto(1);
        solicitudDto.setNombre( "update nombre solicitud" );
        solicitudDto.setFecha( "update fecha solicitud" );
        solicitudDto.setEstatus( "A" );
        UsuarioDto usuario = new UsuarioDto( 1);
        solicitudDto.setUsuarioDto( usuario );
        SubCategoriaDto subcategoria = new SubCategoriaDto( 1);
        solicitudDto.setSubCategoriaDto( subcategoria );
        SolicitudDto resultado = servicio.updateSolicitud (solicitudDto);
        Assert.assertNotEquals( resultado.getId(), 1);

    }

    @Test
    public void deleteSolicitudTest() throws Exception{

        ucab.dsw.servicio.pruebaSolicitud servicio = new ucab.dsw.servicio.pruebaSolicitud();
        SolicitudDto solicitudDto = new SolicitudDto(1);
        SolicitudDto resultado = servicio.deleteSolicitud(solicitudDto);
        Assert.assertNotEquals( resultado.getId(), 1 );

    }
}
