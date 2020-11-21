import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.accesodatos.DaoSubCategoria;
import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.dtos.SubCategoriaDto;
import ucab.dsw.dtos.OpcionDto;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.entidades.*;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import java.util.List;


public class pruebaCategoria_Test {

    @Test
    public void addCategoriaTest() throws Exception{

        ucab.dsw.servicio.pruebaCategoria servicio = new ucab.dsw.servicio.pruebaCategoria();
        CategoriaDto categoriaDto = new CategoriaDto( );
        categoriaDto.setDescripcion( "Deportivo" );
        categoriaDto.setEstatus( "A" );
        CategoriaDto resultado = servicio.addCategoria( categoriaDto );
        Assert.assertNotEquals( resultado.getId(), 0 );

    }

    @Test
    public void listCategoriaTest() throws Exception{

        ucab.dsw.servicio.pruebaCategoria servicio = new ucab.dsw.servicio.pruebaCategoria();
        List<Categoria> categoria = servicio.listCategoria();
        Assert.assertNotEquals( "Categorias listadas", categoria.isEmpty() );

    }

    @Test
    public void updateCategoriaTest() throws Exception{

        ucab.dsw.servicio.pruebaCategoria servicio = new ucab.dsw.servicio.pruebaCategoria();
        CategoriaDto categoriaDto = new CategoriaDto(1);
        categoriaDto.setDescripcion( "Electrodomestico" );
        categoriaDto.setEstatus( "I" );
        CategoriaDto resultado = servicio.updateCategoria (categoriaDto);
        Assert.assertNotEquals( resultado.getId(), 0);

    }

    @Test
    public void deleteCategoriaTest() throws Exception{

        ucab.dsw.servicio.pruebaCategoria servicio = new ucab.dsw.servicio.pruebaCategoria();
        CategoriaDto categoriaDto = new CategoriaDto(1);
        CategoriaDto resultado = servicio.deleteCategoria(categoriaDto);
        Assert.assertNotEquals( resultado.getId(), 0 );

    }
}
