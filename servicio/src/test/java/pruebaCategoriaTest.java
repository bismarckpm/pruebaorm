import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.dtos.CategoriaDto;



public class pruebaCategoriaTest
{

    @Test
    public void addCategoriaTest() throws Exception
    {
        ucab.dsw.servicio.pruebaCategoria servicio = new ucab.dsw.servicio.pruebaCategoria();
        CategoriaDto CategoriaDto= new CategoriaDto();
        CategoriaDto.setDescripcion( "Bismarck" );
        CategoriaDto.setEstatus("A");
        CategoriaDto resultado = servicio.addCategoria( CategoriaDto );
        Assert.assertNotEquals( resultado.getId(), 1 );

    }

    @Test
    public void changeCategoriaTest() throws Exception
    {
        ucab.dsw.servicio.pruebaCategoria servicio = new ucab.dsw.servicio.pruebaCategoria();
        CategoriaDto  CategoriaDto= new CategoriaDto( 4);
        CategoriaDto.setDescripcion( "Pedro" );
        CategoriaDto.setEstatus("A");
        CategoriaDto resultado = servicio.changeCategoria( CategoriaDto );
        Assert.assertNotEquals( resultado.getId(), 0 );

    }

    @Test
    public void deleteCategoriaTest() throws Exception
    {
        ucab.dsw.servicio.pruebaCategoria servicio = new ucab.dsw.servicio.pruebaCategoria();
        CategoriaDto resultado = servicio.deleteCategoria( 2 );
        Assert.assertNotEquals( resultado.getId(), 0 );

    }

    @Test
    public void showCategoriaTest() throws Exception
    {
        ucab.dsw.servicio.pruebaCategoria servicio = new ucab.dsw.servicio.pruebaCategoria();
        CategoriaDto  CategoriaDto= new CategoriaDto( 6);
        CategoriaDto resultado = servicio.showCategoria( CategoriaDto.getId() );
        Assert.assertEquals( resultado.getDescripcion(), "hola");

    }


}