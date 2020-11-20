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
        SubCategoriaDto SBCDto = new SubCategoriaDto();
        SBCDto.setId(1);
        servicio.eliminarSubCategoria( SBCDto );
    }

    @Test
    public void updateSubCategoriaTest() throws Exception
    {
        ucab.dsw.servicio.PruebasSubcategoria servicio = new ucab.dsw.servicio.PruebasSubcategoria();
        SubCategoriaDto SUBC = new SubCategoriaDto();
        SUBC.setDescripcion( "Rojos" );
        SUBC.setEstatus( "A" );
        SUBC.setId(1);
        servicio.actualizarSubCategoria( SUBC );
    }

    @Test
    public void leerSubCategoriaTest() throws Exception
    {
        ucab.dsw.servicio.PruebasSubcategoria servicio = new ucab.dsw.servicio.PruebasSubcategoria();
        SubCategoriaDto SUBC = new SubCategoriaDto();
        SUBC.setId(1);
        SubCategoriaDto resultado = servicio.leerCategoria( SUBC );
        System.out.println("Datos de la subcategoria:\n");
        System.out.println("Id="+resultado.getId()+"\n");
        System.out.println("Descripcion="+resultado.getDescripcion()+"\n");
        System.out.println("Estatus="+resultado.getEstatus()+"\n");
        System.out.println("Categoria="+resultado.getCategoriaDto()+"\n");
    }

}
