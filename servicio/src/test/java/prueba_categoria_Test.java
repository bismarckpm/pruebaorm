import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.dtos.categoriaDto;



public class prueba_categoria_Test
{

    @Test
    public void addCategoriaTest() throws Exception
    {
        ucab.dsw.servicio.prueba_Categoria servicio = new ucab.dsw.servicio.prueba_Categoria();
        categoriaDto  CategoriaDto= new categoriaDto();
        CategoriaDto.setDescripcion( "Bismarck" );
        CategoriaDto.setEstatus("A");
        categoriaDto resultado = servicio.addCategoria( CategoriaDto );
        Assert.assertNotEquals( resultado.getId(), 1 );

    }

    @Test
    public void changeCategoriaTest() throws Exception
    {
        ucab.dsw.servicio.prueba_Categoria servicio = new ucab.dsw.servicio.prueba_Categoria();
        categoriaDto  CategoriaDto= new categoriaDto( 2);
        CategoriaDto.setDescripcion( "epa" );
        CategoriaDto.setEstatus("A");
        categoriaDto resultado = servicio.changeCategoria( CategoriaDto );
        Assert.assertNotEquals( resultado.getId(), 0 );

    }

    @Test
    public void deleteCategoriaTest() throws Exception
    {
        ucab.dsw.servicio.prueba_Categoria servicio = new ucab.dsw.servicio.prueba_Categoria();
        categoriaDto  CategoriaDto= new categoriaDto( 2);
        categoriaDto resultado = servicio.deleteCategoria( CategoriaDto.getId() );
        Assert.assertNotEquals( resultado.getId(), 0 );

    }

    @Test
    public void findCategoriaTest() throws Exception
    {
        ucab.dsw.servicio.prueba_Categoria servicio = new ucab.dsw.servicio.prueba_Categoria();
        categoriaDto  CategoriaDto= new categoriaDto( 6);
        categoriaDto resultado = servicio.findCategoria( CategoriaDto.getId() );
        Assert.assertEquals( resultado.getDescripcion(), "hola");

    }


}