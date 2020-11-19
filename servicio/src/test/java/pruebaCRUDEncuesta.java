import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.EncuestaDto;
import ucab.dsw.dtos.EstudioDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.servicio.pruebaEncuestaORMWS;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class pruebaCRUDEncuesta {
    private pruebaEncuestaORMWS servicio;

    public pruebaCRUDEncuesta() {
        this.servicio = new pruebaEncuestaORMWS();
    }

    @Test
    public void addEncuestaTest() throws Exception{

        EncuestaDto encuestaDto = new EncuestaDto();

        DateFormat formato= new SimpleDateFormat("yyyy-MM-dd");
        encuestaDto.setFechacreacion(formato.parse("2020-12-25"));

        UsuarioDto usuarioAnalistaDto = new UsuarioDto(5);
        encuestaDto.setUsuarioAnalistaDto(usuarioAnalistaDto);

        UsuarioDto usuarioCreadorDto = new UsuarioDto(10);
        encuestaDto.setUsuarioCreadorDto(usuarioCreadorDto);

        EstudioDto estudioDto=new EstudioDto(1);
        encuestaDto.setEstudioDto(estudioDto);

        encuestaDto.setEstatus("C");

        EncuestaDto resultado = this.servicio.addEncuesta(encuestaDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void editEncuestaTest() throws Exception
    {
        EncuestaDto encuestaDto = new EncuestaDto();
        encuestaDto.setEstatus("EP");
        DateFormat formato= new SimpleDateFormat("yyyy-MM-dd");
        encuestaDto.setFechacreacion(formato.parse("2020-11-25"));

        UsuarioDto usuarioAnalistaDto = new UsuarioDto(6);
        encuestaDto.setUsuarioAnalistaDto(usuarioAnalistaDto);

        UsuarioDto usuarioCreadorDto = new UsuarioDto(11);
        encuestaDto.setUsuarioCreadorDto(usuarioCreadorDto);

        EstudioDto estudioDto=new EstudioDto(1);
        encuestaDto.setEstudioDto(estudioDto);

        EncuestaDto resultado = this.servicio.editEncuesta(1,encuestaDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void getEncuestaTest() throws Exception
    {
        EncuestaDto resultado = this.servicio.getEncuesta(1);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void deleteEncuestaTest() throws Exception
    {
        EncuestaDto resultado = this.servicio.deleteEncuesta(1);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }
}
