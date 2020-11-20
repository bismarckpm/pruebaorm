import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.servicio.pruebaCategoriaORMWS;


public class pruebaCRUDCategoria {
    private pruebaCategoriaORMWS servicio;

    public pruebaCRUDCategoria() {
        this.servicio = new pruebaCategoriaORMWS();
    }

    @Test
    public void addCategoriaTest() throws Exception{

        CategoriaDto categoriaDto = new CategoriaDto();
        categoriaDto.setDescripcion("Higiene");
        categoriaDto.setEstatus("A");
        CategoriaDto resultado = this.servicio.addCategoria(categoriaDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void deleteCategoriaTest() throws Exception
    {
        CategoriaDto resultado = this.servicio.deleteCategoria(1);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void editCategoriaTest() throws Exception
    {
        CategoriaDto categoriaDto = new CategoriaDto();
        categoriaDto.setDescripcion("Tecnologia");
        categoriaDto.setEstatus("A");
        CategoriaDto resultado = this.servicio.editCategoria(2,categoriaDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void getCategoriaTest() throws Exception
    {
        CategoriaDto resultado = this.servicio.getCategoria(1);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }


}
