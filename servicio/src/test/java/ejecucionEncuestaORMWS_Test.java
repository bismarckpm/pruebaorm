import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.dtos.EjecucionEncuestaDto;
import ucab.dsw.entidades.Categoria;
import ucab.dsw.entidades.EjecucionEncuesta;
import java.util.List;

public class ejecucionEncuestaORMWS_Test {
    @Test
    public void addCategoriaTest() throws Exception {
        ucab.dsw.servicio.categoriaORMWS servicio = new ucab.dsw.servicio.categoriaORMWS();
        CategoriaDto categoriaDto = new CategoriaDto();
        categoriaDto.setDescripcion( "Categoria1" );
        categoriaDto.setEstatus( "A" );
        CategoriaDto resultado = servicio.addCategoria( categoriaDto );
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void showCategoriaTest() throws Exception
    {
        ucab.dsw.servicio.categoriaORMWS servicio = new ucab.dsw.servicio.categoriaORMWS();
        List<Categoria> categorias = servicio.showCategoria();
        Assert.assertFalse("Consulta Realizada con Exito",categorias.isEmpty());
    }

    @Test
    public void updateCategoriaTest() throws Exception{

        ucab.dsw.servicio.categoriaORMWS servicio = new ucab.dsw.servicio.categoriaORMWS();
        CategoriaDto categoriaDto = new CategoriaDto(1);
        categoriaDto.setDescripcion( "Categoria2" );
        categoriaDto.setEstatus( "I" );
        CategoriaDto resultado = servicio.editCategoria (categoriaDto);
        Assert.assertNotEquals( resultado.getId(), 0);
    }

    @Test
    public void deleteCategoriaTest() throws Exception{

        ucab.dsw.servicio.categoriaORMWS servicio = new ucab.dsw.servicio.categoriaORMWS();
        CategoriaDto categoriaDto = new CategoriaDto(1);
        CategoriaDto resultado = servicio.deleteCategoria(categoriaDto);
        Assert.assertNotEquals( resultado.getId(), 0 );

    }
}
