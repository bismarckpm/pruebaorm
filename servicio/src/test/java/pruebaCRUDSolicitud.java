import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.SubcategoriaDto;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.servicio.pruebaSolicitudORMWS;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class pruebaCRUDSolicitud {
    private pruebaSolicitudORMWS servicio;

    public pruebaCRUDSolicitud() {
        this.servicio = new pruebaSolicitudORMWS();
    }

    @Test
    public void addSolicitudTest() throws Exception{

        SolicitudDto solicitudDto = new SolicitudDto();
        solicitudDto.setNombre("Solicitud C");
        DateFormat  formato= new SimpleDateFormat("dd/MM/yyyy");
        solicitudDto.setFecha(formato.parse("20/11/2020"));
        solicitudDto.setEstatus("A");

        SubcategoriaDto subcategoriaDto=new SubcategoriaDto(2);
        solicitudDto.setSubcategoriaDto(subcategoriaDto);

        UsuarioDto usuarioDto = new UsuarioDto(5);
        solicitudDto.setUsuarioDto(usuarioDto);

        SolicitudDto resultado = this.servicio.addSolicitud(solicitudDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void editSolicitudTest() throws Exception
    {
        SolicitudDto solicitudDto = new SolicitudDto();
        solicitudDto.setNombre("Solicitud B");
        DateFormat  formato= new SimpleDateFormat("yyyy-MM-dd");
        solicitudDto.setFecha(formato.parse("2020-12-25"));
        solicitudDto.setEstatus("A");

        SubcategoriaDto subcategoriaDto=new SubcategoriaDto(2);
        solicitudDto.setSubcategoriaDto(subcategoriaDto);

        UsuarioDto usuarioDto = new UsuarioDto(10);
        solicitudDto.setUsuarioDto(usuarioDto);


        SolicitudDto resultado = this.servicio.editSolicitud(3,solicitudDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void getSolicitudTest() throws Exception
    {
        SolicitudDto resultado = this.servicio.getSolicitud(3);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void deleteSolicitudTest() throws Exception
    {
        SolicitudDto resultado = this.servicio.deleteSolicitud(3);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }
}
