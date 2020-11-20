import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.Usuario;


import ucab.dsw.servicio.tipousuarioORMWS;


public class tipousuarioORMWS_Test {


    @Test
    public void addTipoUserTest() throws Exception
    {
        ucab.dsw.servicio.tipousuarioORMWS servicio= new ucab.dsw.servicio.tipousuarioORMWS();

        TipoUsuarioDto tipoUsuarioDto= new TipoUsuarioDto();
        tipoUsuarioDto.setDescripcion("Tipo usuario nuevo");
        tipoUsuarioDto.setEstatus("A");

        TipoUsuarioDto resultado= servicio.addTipoUsuario(tipoUsuarioDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void deleteTipoUserTest() throws Exception
    {
        ucab.dsw.servicio.tipousuarioORMWS servicio= new ucab.dsw.servicio.tipousuarioORMWS();

        TipoUsuarioDto resultado= servicio.deleteTipoUsuario(1);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void updateTipoUserTest() throws Exception
    {
        ucab.dsw.servicio.tipousuarioORMWS servicio= new ucab.dsw.servicio.tipousuarioORMWS();

        TipoUsuarioDto tipoUsuarioDto= new TipoUsuarioDto();
        tipoUsuarioDto.setDescripcion("Tipo usuario modificado");
        tipoUsuarioDto.setEstatus("A");

        TipoUsuarioDto resultado= servicio.updateTipoUsuario(3,tipoUsuarioDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void getTipoUserTest() throws Exception
    {
        ucab.dsw.servicio.tipousuarioORMWS servicio= new ucab.dsw.servicio.tipousuarioORMWS();
        TipoUsuarioDto resultado= servicio.consultarTipoUsuario(1);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }




}

