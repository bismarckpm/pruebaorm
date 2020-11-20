import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.dtos.*;
import ucab.dsw.entidades.Opcion;
import ucab.dsw.entidades.Pregunta;


import ucab.dsw.entidades.Subcategoria;
import ucab.dsw.servicio.preguntasORMWS;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class PreguntaORMWS_Test {

    @Test
    public void addPreguntaTest() throws Exception
    {

        ucab.dsw.servicio.preguntasORMWS servicio = new ucab.dsw.servicio.preguntasORMWS();

        PreguntaDto preguntaDto= new PreguntaDto();

        preguntaDto.setPregunta("¿ Que dia es hoy ?");
        preguntaDto.setEstatus("A");
        DateFormat formato= new SimpleDateFormat("dd/MM/yyyy");
        preguntaDto.setFechacreacion(formato.parse("20/11/2020"));

        TipoPreguntaDto tipoPreguntaDto= new TipoPreguntaDto(1);
        preguntaDto.setTipoPreguntaDto(tipoPreguntaDto);

        SubcategoriaDto subcategoria= new SubcategoriaDto(1);
        preguntaDto.setSubCategoriaDto(subcategoria);

        UsuarioDto usuarioDto= new UsuarioDto(1);
        preguntaDto.setUsuarioDto(usuarioDto);



        PreguntaDto resultado= servicio.addPregunta(preguntaDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }


    @Test
    public void deletePreguntaTest() throws Exception
    {
        ucab.dsw.servicio.preguntasORMWS servicio = new ucab.dsw.servicio.preguntasORMWS();
        PreguntaDto resultado= servicio.deletePregunta(1);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void getPreguntaTest() throws Exception
    {
        ucab.dsw.servicio.preguntasORMWS servicio = new ucab.dsw.servicio.preguntasORMWS();
        PreguntaDto resultado= servicio.consultarPregunta(1);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void updatePreguntaTest() throws Exception
    {

        ucab.dsw.servicio.preguntasORMWS servicio = new ucab.dsw.servicio.preguntasORMWS();
        PreguntaDto preguntaDto= new PreguntaDto();

        preguntaDto.setPregunta("¿ Que dia sera el evento ?");
        preguntaDto.setEstatus("A");
        DateFormat formato= new SimpleDateFormat("dd/MM/yyyy");
        preguntaDto.setFechacreacion(formato.parse("20/12/2020"));

        TipoPreguntaDto tipoPreguntaDto= new TipoPreguntaDto(2);
        preguntaDto.setTipoPreguntaDto(tipoPreguntaDto);

        SubcategoriaDto subcategoria= new SubcategoriaDto(2);
        preguntaDto.setSubCategoriaDto(subcategoria);

        UsuarioDto usuarioDto= new UsuarioDto(1);
        preguntaDto.setUsuarioDto(usuarioDto);



        PreguntaDto resultado= servicio.updatePregunta(1,preguntaDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }



}