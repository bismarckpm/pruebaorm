import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.TipoUsuarioDto;

public class pruebaTipoUsuarioControlador {

    @Test
    public void obtenerTipoUsuarioPrueba() throws Exception
    {
        ucab.dsw.servicio.TipoUsuarioControlador servicio = new ucab.dsw.servicio.TipoUsuarioControlador();
        TipoUsuarioDto resultado = servicio.obtenerTipoUsuario( (long) 3);
        Assert.assertEquals( resultado.getId(), 3);
    }

    @Test
    public void crearTipoUsuarioPrueba() throws Exception
    {
        ucab.dsw.servicio.TipoUsuarioControlador servicio = new ucab.dsw.servicio.TipoUsuarioControlador();
        TipoUsuarioDto  tipoUsuarioDto= new TipoUsuarioDto();
        tipoUsuarioDto.setDescripcion( "Soy una Descripcion");
        tipoUsuarioDto.setEstatus("A");
        TipoUsuarioDto resultado = servicio.crearTipoUsuario( tipoUsuarioDto);
        Assert.assertNotEquals( resultado.getId(), 0);

    }

    @Test
    public void modificarTipoUsuarioPrueba() throws Exception
    {
        ucab.dsw.servicio.TipoUsuarioControlador servicio = new ucab.dsw.servicio.TipoUsuarioControlador();
        TipoUsuarioDto tipoUsuarioDto= new TipoUsuarioDto(2);
        tipoUsuarioDto.setDescripcion( "Una Descripcion Modificada");
        tipoUsuarioDto.setEstatus("A");
        TipoUsuarioDto resultado = servicio.modificarTipoUsuario( tipoUsuarioDto );
        Assert.assertNotEquals( resultado.getId(), 0 );

    }
    @Test
    public void borrarTipoUsuarioPrueba() throws Exception
    {
        ucab.dsw.servicio.TipoUsuarioControlador servicio = new ucab.dsw.servicio.TipoUsuarioControlador();
        TipoUsuarioDto resultado = servicio.borrarTipoUsuario( (long) 3);
        Assert.assertNotEquals( resultado.getId(), 0);

    }
}
