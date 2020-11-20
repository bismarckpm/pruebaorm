import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.dtos.SubCategoriaDto;
import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.dtos.categoriaDto;



public class prueba_SubCategoria_Test
{

    @Test
    public void addSubCategoriaTest() throws Exception
    {
        ucab.dsw.servicio.prueba_SubCategoria servicio = new ucab.dsw.servicio.prueba_SubCategoria();
        SubCategoriaDto  subCategoriaDto= new SubCategoriaDto();
        subCategoriaDto.setDescripcion( "Bismarck" );
        subCategoriaDto.setEstatus("A");
        categoriaDto CategoriaDto = new categoriaDto( 5);
        subCategoriaDto.setcategoriaDto( CategoriaDto );
        SubCategoriaDto resultado = servicio.addSubCategoria( subCategoriaDto );
        Assert.assertNotEquals( resultado.getId(), 0 );

    }

    @Test
    public void changeSubCategoriaTest() throws Exception
    {
        ucab.dsw.servicio.prueba_SubCategoria servicio = new ucab.dsw.servicio.prueba_SubCategoria();
        SubCategoriaDto  subCategoriaDto= new SubCategoriaDto(2);
        subCategoriaDto.setDescripcion( "Hola" );
        subCategoriaDto.setEstatus("I");
        categoriaDto CategoriaDto = new categoriaDto( 5);
        subCategoriaDto.setcategoriaDto( CategoriaDto );
        SubCategoriaDto resultado = servicio.changeSubCategoria( subCategoriaDto );
        Assert.assertNotEquals( resultado.getId(), 1 );

    }

    @Test
    public void deleteSubCategoriaTest() throws Exception
    {
        ucab.dsw.servicio.prueba_SubCategoria servicio = new ucab.dsw.servicio.prueba_SubCategoria();
        SubCategoriaDto  subCategoriaDto= new SubCategoriaDto(2);
        SubCategoriaDto resultado = servicio.deleteSubCategoria( subCategoriaDto.getId() );
        Assert.assertNotEquals( resultado.getId(), 1 );

    }

    @Test
    public void findSubCategoriaTest() throws Exception
    {
        ucab.dsw.servicio.prueba_SubCategoria servicio = new ucab.dsw.servicio.prueba_SubCategoria();
        SubCategoriaDto  subCategoriaDto= new SubCategoriaDto(2);
        SubCategoriaDto resultado = servicio.findSubCategoria( subCategoriaDto.getId() );
        Assert.assertNotEquals( resultado.getId(), 1 );

    }


}