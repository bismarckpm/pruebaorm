package ucab.dsw.servicio;
import ucab.dsw.accesodatos.DaoCategoria;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.dtos.SubCategoriaDto;
import ucab.dsw.entidades.*;

import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path( "/prueba/categoria" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )

public class PruebasCategoria extends AplicacionBase {
    @PUT
    @Path( "/addcategoria" )
    public CategoriaDto addCategoria(CategoriaDto categoriaDto )
    {
        CategoriaDto resultado = new CategoriaDto();
        try
        {
            DaoCategoria dao = new DaoCategoria();
            categoria Categoria = new categoria();
            Categoria.setDescripcion(categoriaDto.getDescripcion());
            Categoria.set_estatus(categoriaDto.getEstatus());
            categoria resul = dao.insert( Categoria );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @DELETE
    @Path( "/eliminarcategoria" )
    public void eliminarCategoria(CategoriaDto categoriaDto )
    {
        CategoriaDto resultado = new CategoriaDto();
        try
        {
            DaoCategoria dao = new DaoCategoria();
            categoria Categoria = new categoria(categoriaDto.getId());
            Categoria.setDescripcion(categoriaDto.getDescripcion());
            Categoria.set_estatus(categoriaDto.getEstatus());
            categoria resul = dao.delete( Categoria );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
    }



    @POST
    @Path( "/actualizarcategoria" )
    public void actualizarCategoria(CategoriaDto categoriaDto )
    {
        CategoriaDto resultado = new CategoriaDto();
        try
        {
            DaoCategoria dao = new DaoCategoria();
            categoria Categoria = new categoria(categoriaDto.getId());
            categoria categoriaAactualizar= dao.find(Categoria.get_id(),categoria.class);
            if(categoriaDto.getDescripcion()!=null){
                Categoria.setDescripcion(categoriaDto.getDescripcion());
            }else {Categoria.setDescripcion(categoriaAactualizar.getDescripcion());}
            if(categoriaDto.getEstatus()!=null){
                Categoria.set_estatus(categoriaDto.getEstatus());
            }else {Categoria.set_estatus(categoriaAactualizar.get_estatus());}
            categoria resul = dao.update( Categoria );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
    }

    @GET
    @Path( "/leercategoria" )
    public CategoriaDto leerCategoria(CategoriaDto categoriaDto )
    {
        CategoriaDto resultado = new CategoriaDto();
        try
        {
            DaoCategoria dao = new DaoCategoria();
            categoria Categoria = new categoria(categoriaDto.getId());
            categoria resul= dao.find(Categoria.get_id(),categoria.class);
            resultado.setEstatus(resul.get_estatus());
            resultado.setDescripcion(resul.getDescripcion());
            resultado.setId(resul.get_id());
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return resultado;
    }
}
