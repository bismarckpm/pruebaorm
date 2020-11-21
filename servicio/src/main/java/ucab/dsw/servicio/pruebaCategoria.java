package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoCategoria;
import ucab.dsw.accesodatos.DaoSubCategoria;
import ucab.dsw.accesodatos.DaoUsuario;
import ucab.dsw.accesodatos.DaoOpcion;
import ucab.dsw.accesodatos.DaoSolicitud;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.dtos.SubCategoriaDto;
import ucab.dsw.dtos.OpcionDto;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.entidades.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class pruebaCategoria extends AplicacionBase{

    @PUT
    @Path( "/addcategoria" )
    public CategoriaDto addCategoria(CategoriaDto categoriaDto )
    {
        CategoriaDto resultado = new CategoriaDto();
        try
        {
            DaoCategoria dao = new DaoCategoria();
            Categoria categoria = new Categoria();
            categoria.set_descripcion( categoriaDto.getDescripcion());
            categoria.set_estatus (categoriaDto.getEstatus());
            Categoria resul = dao.insert( categoria );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path ("/listcategoria")
    public List<Categoria> listCategoria( )
    {
        List<Categoria> categorias= null;
        try
        {
            DaoCategoria dao = new DaoCategoria();
            categorias = dao.findAll(Categoria.class);
            for (Categoria categoria: categorias) {
                System.out.println("Id:" + categoria.get_id());
                System.out.println("Descipcion:"+categoria.get_descripcion());
                System.out.println("Estatus:"+categoria.get_estatus() );
            }
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  categorias;
    }

    @PUT
    @Path( "/updatecategoria/{id}" )
    public CategoriaDto updateCategoria( CategoriaDto categoriaDto)
    {
        CategoriaDto resultado = new CategoriaDto();
        try
        {
            DaoCategoria dao = new DaoCategoria();
            Categoria categoria = new Categoria(categoriaDto.getId());
            categoria.set_descripcion( categoriaDto.getDescripcion());
            categoria.set_estatus (categoriaDto.getEstatus());
            Categoria resul = dao.update (categoria );
            resultado.setId(resul.get_id());

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @DELETE
    @Path( "/deletecategoria/{id}" )
    public CategoriaDto deleteCategoria( CategoriaDto categoriaDto) {
        CategoriaDto resultado = new CategoriaDto();
        try {
            DaoCategoria dao = new DaoCategoria();
            Categoria categoria = dao.find(categoriaDto.getId(), Categoria.class);
            Categoria resul = dao.delete(categoria);
            resultado.setId(resul.get_id());

        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }

}
