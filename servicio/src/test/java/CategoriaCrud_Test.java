import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.Categoria;
import ucab.dsw.servicio.CategoriaCrud;



public class CategoriaCrud_Test {

    @Test
    public void addCategoryTest() throws Exception{

        CategoriaCrud servicio = new CategoriaCrud();
        CategoriaDto categoriaDto = new CategoriaDto();
        categoriaDto.setDescripcion("Esto es una descripción");
        categoriaDto.setEstatus( "A" );
        CategoriaDto resultado = servicio.addCategory( categoriaDto );
        Assert.assertNotEquals( resultado.getId(), 0 );

    }
}
