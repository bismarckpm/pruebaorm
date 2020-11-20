import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.dtos.SubcategoriaDto;
import ucab.dsw.entidades.SubcategoriaEnt;
import ucab.dsw.servicio.SubcategoriaCRUD;

import java.util.List;

public class SubcategoriaCRUD_Test {

    @Test
    public void addSubcategoriaTest() throws Exception
    {
        SubcategoriaCRUD servicio = new SubcategoriaCRUD();
        SubcategoriaDto subcategoriaDto = new SubcategoriaDto();
        subcategoriaDto.setDescripcion( "subcategoria prueba" );
        subcategoriaDto.setEstatus( "A" );
        CategoriaDto categoria = new CategoriaDto(1);
        subcategoriaDto.setCategorias(categoria);
        SubcategoriaDto resultado = servicio.addSubcategoria(subcategoriaDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void getSubcategoriaTest()  throws  Exception
    {
        SubcategoriaCRUD servicio = new SubcategoriaCRUD();
        List<SubcategoriaEnt> subcategorias = servicio.getSubcategorias();
        Assert.assertFalse("No hay subcategorias",subcategorias.isEmpty());
    }

    @Test
    public void  updatesubcategoriaTest() throws Exception
    {
        SubcategoriaCRUD servicio = new SubcategoriaCRUD();
        SubcategoriaDto subcategoriaDto = new SubcategoriaDto(1);
        subcategoriaDto.setDescripcion("PruebaUpdate");
        subcategoriaDto.setEstatus("I");
        SubcategoriaDto resultado = servicio.updateSubcategoria(1, subcategoriaDto);
        Assert.assertNotEquals(resultado.getId(), 0);
    }

    @Test
    public void deleteUsuarioTest() throws Exception
    {
        SubcategoriaCRUD servicio = new SubcategoriaCRUD();
        SubcategoriaDto resultado = servicio.deleteSubcategoria(2);
        Assert.assertNotEquals(resultado.getId(), 0);
    }

}
