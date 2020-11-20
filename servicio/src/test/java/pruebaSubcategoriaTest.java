import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.dtos.SubcategoriaDto;
import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.dtos.CategoriaDto;



public class pruebaSubcategoriaTest
{

    @Test
    public void addSubcategoriaTest() throws Exception
    {
        ucab.dsw.servicio.pruebaSubcategoria servicio = new ucab.dsw.servicio.pruebaSubcategoria();
        SubcategoriaDto  subCategoriaDto= new SubcategoriaDto();
        subCategoriaDto.setDescripcion( "Bismarck" );
        subCategoriaDto.setEstatus("A");
        CategoriaDto CategoriaDto = new CategoriaDto( 5);
        subCategoriaDto.setCategoriaDto( CategoriaDto );
        SubcategoriaDto resultado = servicio.addSubcategoria( subCategoriaDto );
        Assert.assertNotEquals( resultado.getId(), 1 );
    }

    @Test
    public void changeSubcategoriaTest() throws Exception
    {
        ucab.dsw.servicio.pruebaSubcategoria servicio = new ucab.dsw.servicio.pruebaSubcategoria();
        SubcategoriaDto  subCategoriaDto= new SubcategoriaDto(2);
        subCategoriaDto.setDescripcion( "Hola" );
        subCategoriaDto.setEstatus("I");
        CategoriaDto CategoriaDto = new CategoriaDto( 5);
        subCategoriaDto.setCategoriaDto( CategoriaDto );
        SubcategoriaDto resultado = servicio.changeSubcategoria( subCategoriaDto );
        Assert.assertNotEquals( resultado.getId(), 1 );

    }

    @Test
    public void deleteSubcategoriaTest() throws Exception
    {
        ucab.dsw.servicio.pruebaSubcategoria servicio = new ucab.dsw.servicio.pruebaSubcategoria();
        SubcategoriaDto  subCategoriaDto= new SubcategoriaDto(2);
        SubcategoriaDto resultado = servicio.deleteSubcategoria( subCategoriaDto.getId() );
        Assert.assertNotEquals( resultado.getId(), 1 );

    }

    @Test
    public void findSubcategoriaTest() throws Exception
    {
        ucab.dsw.servicio.pruebaSubcategoria servicio = new ucab.dsw.servicio.pruebaSubcategoria();
        SubcategoriaDto  subCategoriaDto= new SubcategoriaDto(2);
        SubcategoriaDto resultado = servicio.showSubcategoria( subCategoriaDto.getId() );
        Assert.assertNotEquals( resultado.getId(), 1 );

    }


}