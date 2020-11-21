import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.dtos.*;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.entidades.Categoria;
import ucab.dsw.entidades.Solicitud;
import ucab.dsw.entidades.Subcategoria;
import ucab.dsw.servicio.CategoriaCrud;
import ucab.dsw.servicio.SolicitudCrud;
import ucab.dsw.servicio.SubcategoriaCrud;

import java.util.List;


public class SolicitudCrud_Test {

    @Test
    public void addSolicitudTest() throws Exception{

        SolicitudCrud servicio = new SolicitudCrud();
        SolicitudDto solicitudDto = new SolicitudDto();
        solicitudDto.setNombre("Solicitud: Compra de calcetines");
        solicitudDto.setFecha( "11-02-2021" );
        solicitudDto.setEstatus("A");

        UsuarioDto usuario = new UsuarioDto( 1);
        solicitudDto.setUsuario(usuario);
        SubcategoriaDto subcategoria = new SubcategoriaDto(1);
        solicitudDto.setSubcategoria(subcategoria);
        SolicitudDto resultado = servicio.addSolicitud( solicitudDto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void updateSolicitudTest() throws Exception{
        SolicitudCrud servicio = new SolicitudCrud();
        SolicitudDto solicitudDto = new SolicitudDto();
        solicitudDto.setNombre("Solicitud actualizada: Interiores blancos");
        solicitudDto.setEstatus("I");
        solicitudDto.setFecha("19-11-2021");
        UsuarioDto usuario = new UsuarioDto(1);
        SubcategoriaDto subcategoria = new SubcategoriaDto(1);
        solicitudDto.setUsuario(usuario);
        solicitudDto.setSubcategoria(subcategoria);

        SolicitudDto resultado = servicio.updateSolicitud(2,solicitudDto);
        Assert.assertNotEquals(resultado.getId(),0);
    }

    @Test
    public void deleteSolicitudTest() throws Exception{
        SolicitudCrud servicio = new SolicitudCrud();
        SolicitudDto resultado = servicio.deleteSolicitud(2);
        Assert.assertNotEquals(resultado.getId(),0);
    }

    @Test
    public void showSolicitudTest() throws Exception{
        SolicitudCrud servicio = new SolicitudCrud();
        List<Solicitud> solicitud = servicio.showSolicitudes();
        Assert.assertFalse("No existen solicitudes",solicitud.isEmpty());

    }



}
