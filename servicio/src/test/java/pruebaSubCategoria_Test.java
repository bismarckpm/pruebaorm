import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.dtos.SubCategoriaDto;
import ucab.dsw.entidades.Categoria;
import ucab.dsw.entidades.Usuario;


public class pruebaSubCategoria_Test
{
    //SubCategoria
    @Test
    public void addSubCategoriaTest() throws Exception{

        ucab.dsw.servicio.pruebaSubCategoria servicio = new ucab.dsw.servicio.pruebaSubCategoria();
        SubCategoriaDto subcategoriaDto = new SubCategoriaDto();
        subcategoriaDto.setDescripcion( "Balon" );
        subcategoriaDto.setEstatus( "A" );
        CategoriaDto categoria = new CategoriaDto( 1);
        subcategoriaDto.setCategoriaDto( categoria );
        SubCategoriaDto resultado = servicio.addSubCategoria( subcategoriaDto );
        Assert.assertNotEquals( resultado.getId(), 1 );

    }

    @Test
    public void updateSubCategoriaTest() throws Exception{

        ucab.dsw.servicio.pruebaSubCategoria servicio = new ucab.dsw.servicio.pruebaSubCategoria();
        SubCategoriaDto subcategoriaDto = new SubCategoriaDto(1);
        subcategoriaDto.setDescripcion( "Nevera" );
        subcategoriaDto.setEstatus( "A" );
        CategoriaDto categoria = new CategoriaDto( 1);
        subcategoriaDto.setCategoriaDto( categoria );
        SubCategoriaDto resultado = servicio.updateSubCategoria (subcategoriaDto);
        Assert.assertNotEquals( resultado.getId(), 1);

    }

    @Test
    public void deleteSubCategoriaTest() throws Exception{

        ucab.dsw.servicio.pruebaSubCategoria servicio = new ucab.dsw.servicio.pruebaSubCategoria();
        SubCategoriaDto subcategoriaDto = new SubCategoriaDto(1);
        SubCategoriaDto resultado = servicio.deleteSubCategoria(subcategoriaDto);
        Assert.assertNotEquals( resultado.getId(), 1 );

    }

}