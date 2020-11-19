import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.dtos.SubCategoriaDto;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.entidades.subCategoria;

public class pruebasSubCategoria_Test {

    @Test
    public void addSubCcategoriaTest() throws Exception
    {
        ucab.dsw.servicio.PruebasSubcategoria servicio = new ucab.dsw.servicio.PruebasSubcategoria();
        SubCategoriaDto subCategoriaDto = new SubCategoriaDto();
        subCategoriaDto.setDescripcion( "Auto" );
        subCategoriaDto.setEstatus("A");
        CategoriaDto subcategoria = new CategoriaDto( 1);
        subCategoriaDto.setCategoriaDto( subcategoria );
        SubCategoriaDto resultado = servicio.addSubCategoria(subCategoriaDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void deleateSubCategoriaTest() throws Exception
    {
        ucab.dsw.servicio.PruebasSubcategoria servicio = new ucab.dsw.servicio.PruebasSubcategoria();
        SubCategoriaDto subcategoriaDto = new SubCategoriaDto();
        subcategoriaDto.setEstatus("A");
        subcategoriaDto.setDescripcion("Auto");
        subcategoriaDto.setId(1);
        servicio.eliminarSubCategoria(subcategoriaDto);
    }
/*
    @Test
    public void updateCategoriaTest() throws Exception
    {
        ucab.dsw.servicio.PruebasCategoria servicio = new ucab.dsw.servicio.PruebasCategoria();
        CategoriaDto categoriaDto = new CategoriaDto();
        categoriaDto.setDescripcion( "Amarillos" );
        categoriaDto.setId(1);
        servicio.actualizarCategoria( categoriaDto );
    }

    @Test
    public void leerCategoriaTest() throws Exception
    {
        ucab.dsw.servicio.PruebasCategoria servicio = new ucab.dsw.servicio.PruebasCategoria();
        CategoriaDto categoriaDto = new CategoriaDto();
        categoriaDto.setId(4);
        CategoriaDto resultado = servicio.leerCategoria( categoriaDto );
        System.out.println("Datos de la categoria:\n");
        System.out.println("Id="+resultado.getId()+"\n");
        System.out.println("Descripcion="+resultado.getDescripcion()+"\n");
        System.out.println("Estatus="+resultado.getEstatus()+"\n");
    }


*/
}
