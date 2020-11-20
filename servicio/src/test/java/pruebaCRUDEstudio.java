import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.dtos.EstudioDto;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.servicio.pruebaEstudioORMWS;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class pruebaCRUDEstudio{
    private pruebaEstudioORMWS servicio;

    public pruebaCRUDEstudio() {
        this.servicio = new pruebaEstudioORMWS();
    }

    @Test
    public void addEstudioTest() throws Exception{

        EstudioDto estudioDto = new EstudioDto();

        DateFormat formato= new SimpleDateFormat("yyyy-MM-dd");
        estudioDto.setFechacreacion(formato.parse("2020-12-25"));
        UsuarioDto usuarioDto = new UsuarioDto(3);
        estudioDto.setUsuarioDto(usuarioDto);
        SolicitudDto solicitudDto=new SolicitudDto(1);
        estudioDto.setSolicitudDto(solicitudDto);
        estudioDto.setEstatus("C");
        EstudioDto resultado = this.servicio.addEstudio(estudioDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void editEstudioTest() throws Exception
    {
        EstudioDto estudioDto = new EstudioDto();
        estudioDto.setEstatus("EP");
        DateFormat formato= new SimpleDateFormat("yyyy-MM-dd");
        estudioDto.setFechacreacion(formato.parse("2020-11-25"));
        UsuarioDto usuarioDto = new UsuarioDto(3);
        estudioDto.setUsuarioDto(usuarioDto);
        SolicitudDto solicitudDto=new SolicitudDto(2);
        estudioDto.setSolicitudDto(solicitudDto);
        EstudioDto resultado = this.servicio.editEstudio(2,estudioDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void getEstudioTest() throws Exception
    {
        EstudioDto resultado = this.servicio.getEstudio(1);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void deleteEstudioTest() throws Exception
    {
        EstudioDto resultado = this.servicio.deleteEstudio(1);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }
}
