package ucab.dsw.servicio;

import interfaces.CategoriaDao;
import ucab.dsw.entidades.Categoria;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Stateless
@Path("/categorias")
public class CategoriaServiceRS {
    @Inject
    private CategoriaDao categoriaDao;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Categoria> listarCategorias(){
        List<Categoria> categorias = categoriaDao.findAll();
        System.out.println("Categorías encontradas: "+categorias);
        return categorias;
    }
}
