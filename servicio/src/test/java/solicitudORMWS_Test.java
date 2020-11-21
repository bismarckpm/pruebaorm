import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.dtos.*;
import ucab.dsw.entidades.TipoPregunta;
import ucab.dsw.entidades.Usuario;
import ucab.dsw.entidades.Solicitud;
import ucab.dsw.entidades.Opcion;
import ucab.dsw.entidades.Pregunta;

import java.text.SimpleDateFormat;
import java.util.List;

public class solicitudORMWS_Test {

    @Test
    public void addSolicitudTest() throws Exception
    {
        ucab.dsw.servicio.solicitudORMWS servicio = new ucab.dsw.servicio.solicitudORMWS();
        SolicitudDto solicitudDto = new SolicitudDto();
        solicitudDto.setNombre( "Ejemplo nomb" );
        solicitudDto.setEstatus( "A" );
        solicitudDto.setFecha( "12/12/2020");
        SubCategoriaDto subCategoria = new SubCategoriaDto( 1);
        UsuarioDto usuario = new UsuarioDto( 1);
        solicitudDto.setUsuarioDto( usuario );
        solicitudDto.setSubCategoriaDto( subCategoria );
        SolicitudDto resultado = servicio.addSolicitud( solicitudDto );
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void deleteSolicitudTest() throws Exception{
        ucab.dsw.servicio.solicitudORMWS servicio = new ucab.dsw.servicio.solicitudORMWS();
        SolicitudDto resultado = servicio.deleteSolicitud(3);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void showSolicitudTest() throws Exception{
        ucab.dsw.servicio.solicitudORMWS servicio = new ucab.dsw.servicio.solicitudORMWS();
        List<Solicitud> resultado = servicio.showSolicitudes();

    }

    @Test
    public void updateSolicitudTest() throws Exception
    {
        ucab.dsw.servicio.solicitudORMWS servicio = new ucab.dsw.servicio.solicitudORMWS();
        SolicitudDto solicitudDto = new SolicitudDto();
        solicitudDto.setNombre( "Nuevo nomb" );
        solicitudDto.setEstatus( "I" );
        solicitudDto.setFecha( "01/01//2021");
        SubCategoriaDto subCategoria = new SubCategoriaDto( 1);
        UsuarioDto usuario = new UsuarioDto( 14);
        solicitudDto.setUsuarioDto( usuario );
        solicitudDto.setSubCategoriaDto( subCategoria );
        SolicitudDto resultado = servicio.updateSolicitud( 2, solicitudDto );
        Assert.assertNotEquals( resultado.getId(), 0  );
    }
}
