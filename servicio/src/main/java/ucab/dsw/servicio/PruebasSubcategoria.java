package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoCategoria;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.entidades.categoria;
import ucab.dsw.accesodatos.DaoSubCategoria;
import ucab.dsw.dtos.SubCategoriaDto;
import ucab.dsw.entidades.subCategoria;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path( "/prueba/Subcategoria" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class PruebasSubcategoria extends AplicacionBase{
    @PUT
    @Path( "/addsubcategoria" )
    public SubCategoriaDto addSubCategoria(SubCategoriaDto subcategoriaDto )
    {
        SubCategoriaDto resultado = new SubCategoriaDto();
        try
        {
            DaoSubCategoria dao = new DaoSubCategoria();
            subCategoria SUbCategoria = new subCategoria();
            SUbCategoria.set_descripcion(subcategoriaDto.getDescripcion());
            SUbCategoria.set_estatus(subcategoriaDto.getEstatus());
            categoria cate_subcate= new categoria(subcategoriaDto.getCategoriaDto().getId());
            SUbCategoria.set_idcategoria(cate_subcate);
            subCategoria resul = dao.insert( SUbCategoria );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @DELETE
    @Path( "/eliminarsubcategoria" )
    public void eliminarSubCategoria(SubCategoriaDto SUBcategoriaDto )
    {
        SubCategoriaDto resultado = new SubCategoriaDto();
        try
        {
            DaoSubCategoria dao = new DaoSubCategoria();
            subCategoria subCategoria = new subCategoria(SUBcategoriaDto.getId());
            categoria C=new categoria(dao.find(subCategoria.get_id(),subCategoria.class).get_id());
            subCategoria.set_descripcion(SUBcategoriaDto.getDescripcion());
            subCategoria.set_estatus(SUBcategoriaDto.getEstatus());
            subCategoria.set_idcategoria(C);
            subCategoria resul = dao.delete( subCategoria );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
    }

    @GET
    @Path( "/leercsubategoria" )
    public SubCategoriaDto leerSubCategoria(SubCategoriaDto subcategoriaDto ) {
        SubCategoriaDto resultado = new SubCategoriaDto();
        try {
            DaoSubCategoria dao = new DaoSubCategoria();
            subCategoria SUBCategoria = new subCategoria(subcategoriaDto.getId());
            subCategoria resul = dao.find(SUBCategoria.get_id(), subCategoria.class);
            resultado.setEstatus(resul.get_estatus());
            resultado.setDescripcion(resul.get_descripcion());
            resultado.setId(resul.get_id());
            CategoriaDto A = new CategoriaDto(resul.get_idcategoria().get_id());
            resultado.setCategoriaDto(A);
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }

/*
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

*/



}
