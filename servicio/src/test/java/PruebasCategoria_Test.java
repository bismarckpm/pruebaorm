import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.entidades.categoria;

public class PruebasCategoria_Test {

    @Test
    public void addCategoriaTest() throws Exception
    {
        ucab.dsw.servicio.PruebasCategoria servicio = new ucab.dsw.servicio.PruebasCategoria();
        CategoriaDto categoriaDto = new CategoriaDto();
        categoriaDto.setDescripcion( "Muy alto" );
        categoriaDto.setEstatus( "A" );
        CategoriaDto resultado = servicio.addCategoria( categoriaDto );
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void deleateCategoriaTest() throws Exception
    {
        ucab.dsw.servicio.PruebasCategoria servicio = new ucab.dsw.servicio.PruebasCategoria();
        CategoriaDto categoriaDto = new CategoriaDto();
        categoriaDto.setDescripcion( "Muy alto" );
        categoriaDto.setEstatus( "A" );
        categoriaDto.setId(6);//Solo elimina aquellos datos que no tengan una subcategoria
        servicio.eliminarCategoria( categoriaDto );
    }

    @Test
    public void updateCategoriaTest() throws Exception
    {
        ucab.dsw.servicio.PruebasCategoria servicio = new ucab.dsw.servicio.PruebasCategoria();
        CategoriaDto categoriaDto = new CategoriaDto();
        categoriaDto.setDescripcion( "Amarillos" );
        categoriaDto.setId(1);
        servicio.actualizarCategoria( categoriaDto );
    }

    @Test
    public void leerCategoriaTest() throws Exception
    {
        ucab.dsw.servicio.PruebasCategoria servicio = new ucab.dsw.servicio.PruebasCategoria();
        CategoriaDto categoriaDto = new CategoriaDto();
        categoriaDto.setId(4);
        CategoriaDto resultado = servicio.leerCategoria( categoriaDto );
        System.out.println("Datos de la categoria:\n");
        System.out.println("Id="+resultado.getId()+"\n");
        System.out.println("Descripcion="+resultado.getDescripcion()+"\n");
        System.out.println("Estatus="+resultado.getEstatus()+"\n");
    }
}
