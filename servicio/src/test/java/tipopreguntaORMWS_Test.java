import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.Usuario;

import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.servicio.tipopreguntaORMWS;


public class tipopreguntaORMWS_Test {
    @Test
    public  void addTipoPreguntaTest() throws  Exception{
        ucab.dsw.servicio.tipopreguntaORMWS servicio= new ucab.dsw.servicio.tipopreguntaORMWS();
        TipoPreguntaDto preguntaDto= new TipoPreguntaDto();
        preguntaDto.setDescripcion("Desarrollo");
        preguntaDto.setEstatus("A");
        TipoPreguntaDto resultado = servicio.addTipoPregunta(preguntaDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public  void deleteTipoPreguntaTest() throws  Exception{
        ucab.dsw.servicio.tipopreguntaORMWS servicio= new ucab.dsw.servicio.tipopreguntaORMWS();
        long _id=1;
        TipoPreguntaDto resultado = servicio.deleteTipoPregunta(_id);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public  void consultarTipoPreguntaTest() throws  Exception{
        ucab.dsw.servicio.tipopreguntaORMWS servicio= new ucab.dsw.servicio.tipopreguntaORMWS();
        long _id=1;
        TipoPreguntaDto resultado = servicio.consultarTipoPregunta(_id);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public  void updateTipoPreguntaTest() throws  Exception{
        ucab.dsw.servicio.tipopreguntaORMWS servicio= new ucab.dsw.servicio.tipopreguntaORMWS();
        TipoPreguntaDto preguntaDto= new TipoPreguntaDto();
        preguntaDto.setId(2);
        preguntaDto.setDescripcion("VyF");
        preguntaDto.setEstatus("A");
        TipoPreguntaDto resultado = servicio.updateTipoPregunta(preguntaDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }



}
