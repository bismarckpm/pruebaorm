import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.dtos.SubcategoriaDto;
import ucab.dsw.servicio.pruebaSubcategoriaORMWS;

public class pruebaCRUDSubcategoria {
    private pruebaSubcategoriaORMWS servicio;

    public pruebaCRUDSubcategoria() {
        this.servicio = new pruebaSubcategoriaORMWS();
    }

    @Test
    public void addSubcategoriaTest() throws Exception{

        SubcategoriaDto subcategoriaDto = new SubcategoriaDto();
        subcategoriaDto.setDescripcion("Leches");
        subcategoriaDto.setEstatus("A");
        CategoriaDto categoriaDto=new CategoriaDto(3);
        subcategoriaDto.setCategoriaDto(categoriaDto);
        SubcategoriaDto resultado = this.servicio.addSubcategoria(subcategoriaDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void editSubcategoriaTest() throws Exception
    {
        SubcategoriaDto subcategoriaDto = new SubcategoriaDto();
        subcategoriaDto.setDescripcion("Yogurts");
        subcategoriaDto.setEstatus("A");
        CategoriaDto categoriaDto=new CategoriaDto(5);
        subcategoriaDto.setCategoriaDto(categoriaDto);
        SubcategoriaDto resultado = this.servicio.editSubcategoria(2,subcategoriaDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void getSubcategoriaTest() throws Exception
    {
        SubcategoriaDto resultado = this.servicio.getSubcategoria(2);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void deleteSubcategoriaTest() throws Exception
    {
        SubcategoriaDto resultado = this.servicio.deleteSubcategoria(2);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }
}

