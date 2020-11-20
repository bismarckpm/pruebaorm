import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.dtos.*;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.entidades.Categoria;
import ucab.dsw.entidades.Subcategoria;
import ucab.dsw.servicio.CategoriaCrud;
import ucab.dsw.servicio.SubcategoriaCrud;

import java.util.List;

public class SubcategoriaCrud_Test {

    @Test
    public void addSubCategoryTest() throws Exception{

        SubcategoriaCrud servicio = new SubcategoriaCrud();
        SubcategoriaDto subcategoriaDto = new SubcategoriaDto();
        subcategoriaDto.setDescripcion("Categoria S");
        subcategoriaDto.setEstatus( "A" );
        CategoriaDto categoria = new CategoriaDto( 1);
        subcategoriaDto.setCategoriaDto(categoria);
        SubcategoriaDto resultado = servicio.addSubCategory( subcategoriaDto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }


    @Test //Revisar update
    public void updateSubCategoryTest() throws Exception{
        SubcategoriaCrud servicio = new SubcategoriaCrud();
        SubcategoriaDto subcategoriaDto = new SubcategoriaDto();
        subcategoriaDto.setDescripcion("Descripción Z");
        subcategoriaDto.setEstatus("I");
        SubcategoriaDto resultado = servicio.updateSubCategory(3,subcategoriaDto);
        Assert.assertNotEquals(resultado.getId(),0);
    }

    @Test
    public void deleteSubCategoryTest() throws Exception{
        SubcategoriaCrud servicio = new SubcategoriaCrud();
        SubcategoriaDto resultado = servicio.deleteSubCategory(1);
        Assert.assertNotEquals(resultado.getId(),0);
    }

    @Test
    public void showCategoriesTest() throws Exception{
        SubcategoriaCrud servicio = new SubcategoriaCrud();
        List<Subcategoria> subcategorias = servicio.showSubCategories();
        Assert.assertFalse("Consulta de Categorias completo",subcategorias.isEmpty());

    }
}
