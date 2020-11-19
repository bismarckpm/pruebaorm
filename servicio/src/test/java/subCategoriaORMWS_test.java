import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.accesodatos.DaoSubCategoria;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.dtos.SubCategoriaDto;
import ucab.dsw.entidades.Categoria;

public class subCategoriaORMWS_test {
    @Test
    public void addSubCategoria() throws Exception {

        ucab.dsw.servicio.SubCategoriaORMWS servicio = new ucab.dsw.servicio.SubCategoriaORMWS();

        SubCategoriaDto subCategoriaDto = new SubCategoriaDto();
        subCategoriaDto.setDescripcion( "PruebaA" );
        subCategoriaDto.setEstatus( "A" );

        CategoriaDto categoriaDto = new CategoriaDto(1);

        subCategoriaDto.setCategoriaDto(categoriaDto);
        SubCategoriaDto resultado = servicio.add( subCategoriaDto );
        Assert.assertNotEquals( resultado.getId(), 0  );

    }
}
