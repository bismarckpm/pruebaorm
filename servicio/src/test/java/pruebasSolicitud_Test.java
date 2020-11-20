import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.dtos.*;
import ucab.dsw.entidades.*;


public class pruebasSolicitud_Test {

    @Test
    public void addSolicitudTest() throws Exception
    {
        ucab.dsw.servicio.pruebaSolicitud servicio = new ucab.dsw.servicio.pruebaSolicitud();
        SolicitudDto solicitudDto = new SolicitudDto();
        solicitudDto.setNombre( "Bismarck" );
        solicitudDto.setFecha( "22/3/1997" );
        solicitudDto.setEstatu("A");
        UsuarioDto usuario=new UsuarioDto();
        usuario.setSuperId(2);
        solicitudDto.setIdusuario(usuario);
        SubCategoriaDto subcategoriaDTO =new SubCategoriaDto(1);
        solicitudDto.setIdsubcategoria(subcategoriaDTO);
        SolicitudDto resultado = servicio.addSolicitud( solicitudDto );
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void deleateSolicitudTest() throws Exception
    {
        ucab.dsw.servicio.pruebaSolicitud servicio = new ucab.dsw.servicio.pruebaSolicitud();
        SolicitudDto Sdto = new SolicitudDto();
        Sdto.setId(3);
        servicio.eliminarSolicitud( Sdto );
    }

    @Test
    public void updateSolicitudTest() throws Exception
    {
        ucab.dsw.servicio.pruebaSolicitud servicio = new ucab.dsw.servicio.pruebaSolicitud();
        SolicitudDto Sdto = new SolicitudDto();
        Sdto.setEstatu("A");
        Sdto.setFecha("30/4/2019");
        servicio.actualizarolicitud( Sdto );
    }

    @Test
    public void leerSolicitudTest() throws Exception
    {
        ucab.dsw.servicio.pruebaSolicitud servicio = new ucab.dsw.servicio.pruebaSolicitud();
        SolicitudDto Sdto = new SolicitudDto();
        Sdto.setId(1);
        servicio.leerSolicitud( Sdto );

    }

}
