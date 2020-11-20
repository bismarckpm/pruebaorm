import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.EstudioDto;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.dtos.SubcategoriaDto;
import ucab.dsw.dtos.UsuarioDto;

import java.text.SimpleDateFormat;

public class EstudioCRUD_Test {

    @Test
    public void addEstudioTest() throws Exception
    {
        ucab.dsw.servicio.EstudioCrud servicio = new ucab.dsw.servicio.EstudioCrud();
        EstudioDto estudioDto = new EstudioDto();
        estudioDto.setFechacreacion(new SimpleDateFormat("dd/MM/yyyy").parse("12/12/2020"));
        estudioDto.set_estatus("E");
        UsuarioDto usuarioDto = new UsuarioDto(8);
        estudioDto.setUsuario( usuarioDto );
        SolicitudDto solicitudDto = new SolicitudDto(1);
        estudioDto.setSolicitud(solicitudDto);
        EstudioDto resultado = servicio.addEstudio( estudioDto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }
}
