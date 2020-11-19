import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.servicio.CategoriaController;

public class CategoriaController_test {
    @Test
    public void addCategoryTest() throws Exception
    {
        CategoriaController servicio = new CategoriaController();
        CategoriaDto categoriaDto = new CategoriaDto();
        categoriaDto.setDescripcion("TESTING");
        categoriaDto.setStatus("A");
        CategoriaDto resultado = servicio.addCategory(categoriaDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }
}
