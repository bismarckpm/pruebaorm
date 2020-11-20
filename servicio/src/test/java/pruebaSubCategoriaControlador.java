import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.dtos.SubCategoriaDto;

public class pruebaSubCategoriaControlador {
    private long test_id =10;
    public void setTest_id(long tid){
        this.test_id= tid;
    }
    public long getTest_id(){
        return test_id;
    }
    @Test
    public void createSubCategoriaTest() throws Exception {
        ucab.dsw.servicio.SubCategoriaControlador servicio = new ucab.dsw.servicio.SubCategoriaControlador();
        SubCategoriaDto subCategoriaDto = new SubCategoriaDto();
        subCategoriaDto.setDescripcion("prueba");
        subCategoriaDto.setEstatus("A");
        CategoriaDto categoriaDto = new CategoriaDto(1);
        subCategoriaDto.setCatId(categoriaDto);
        SubCategoriaDto resultado = servicio.addSubCategoria(subCategoriaDto);
        this.setTest_id(resultado.getId());
        Assert.assertNotEquals(resultado.getId(), 0);
    }
    @Test
    public void bgetSubCategoriaTest() throws Exception
    {
        ucab.dsw.servicio.SubCategoriaControlador servicio = new ucab.dsw.servicio.SubCategoriaControlador();
        SubCategoriaDto resultado = servicio.obtenerSubCategoria(getTest_id());
        Assert.assertEquals( resultado.getId(),getTest_id());
    }
    @Test
    public void cupdateSubCategoriaTest() throws Exception
    {
        ucab.dsw.servicio.SubCategoriaControlador servicio = new ucab.dsw.servicio.SubCategoriaControlador();
        SubCategoriaDto subCategoriaDto = new SubCategoriaDto(getTest_id());
        subCategoriaDto.setEstatus("A");
        subCategoriaDto.setDescripcion("upd_desc_sc");
        CategoriaDto categoriaDto = new CategoriaDto(1);
        subCategoriaDto.setCatId(categoriaDto);
        SubCategoriaDto resultado = servicio.updateSubCategoria(subCategoriaDto);
        Assert.assertNotEquals( resultado.getId(), 0  );
    }
    @Test
    public void ddeleteSubCategoriaTest() throws Exception
    {
        ucab.dsw.servicio.SubCategoriaControlador servicio = new ucab.dsw.servicio.SubCategoriaControlador();
        SubCategoriaDto resultado = servicio.deleteSubCategoria(getTest_id() - 1);
        Assert.assertEquals( resultado.getId(), getTest_id() - 1);
    }
}
