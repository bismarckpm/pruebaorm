import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.entidades.Categoria;
import ucab.dsw.servicio.CategoriaCRUD;

import java.util.List;

public class CategoriaCRUD_Test {

    @Test
    public void addCategoriaTest() throws Exception
    {
        CategoriaCRUD servicio = new CategoriaCRUD();
        CategoriaDto categoriaDto = new CategoriaDto();
        categoriaDto.setDescripcion( "Cuidado Personal" );
        categoriaDto.setEstatus( "A" );
        CategoriaDto resultado = servicio.addCategoria( categoriaDto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void getCategoriasTest()  throws  Exception
    {
        CategoriaCRUD servicio = new CategoriaCRUD();
        List<Categoria> categorias = servicio.getCategoria();
        Assert.assertFalse("No hay categorias",categorias.isEmpty());
    }

    @Test
    public void  updateTipoUsuarioTest() throws Exception
    {
        CategoriaCRUD servicio = new CategoriaCRUD();
        CategoriaDto categoriaDto = new CategoriaDto();
        categoriaDto.setDescripcion("PruebaUpdate");
        categoriaDto.setEstatus("A");
        CategoriaDto resultado = servicio.updateCategoria(1, categoriaDto);
        Assert.assertNotEquals(resultado.getId(), 0);
    }

    @Test
    public void deleteTipoUsuarioTest() throws Exception
    {
        CategoriaCRUD servicio = new CategoriaCRUD();
        CategoriaDto resultado = servicio.deleteCategoria(1);
        Assert.assertNotEquals(resultado.getId(), 0);
    }

}
