package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoSubcategoria;
import ucab.dsw.dtos.SubcategoriaDto;
import ucab.dsw.entidades.Categoria;
import ucab.dsw.entidades.Subcategoria;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path( "/subcategoria" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class pruebaSubcategoriaORMWS extends AplicacionBase {

    @POST
    @Path( "/add" )
    public SubcategoriaDto addSubcategoria(SubcategoriaDto SubcategoriaDto)
    {
        SubcategoriaDto resultado = new SubcategoriaDto();
        try
        {
            DaoSubcategoria dao = new DaoSubcategoria();
            Subcategoria subcategoria = new Subcategoria();
            subcategoria.set_descripcion(SubcategoriaDto.getDescripcion());
            subcategoria.set_estatus( SubcategoriaDto.getEstatus() );
            Categoria categoria=new Categoria(SubcategoriaDto.getCategoriaDto().getId());
            subcategoria.set_categoria(categoria);
            Subcategoria resul = dao.insert( subcategoria );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @DELETE
    @Path( "/delete/{id}" )
    public SubcategoriaDto deleteSubcategoria(@PathParam("id") long  _id)
    {
        SubcategoriaDto resultado = new SubcategoriaDto();
        try
        {
            DaoSubcategoria dao = new DaoSubcategoria();
            Subcategoria subcategoria = dao.find(_id,Subcategoria.class);
            Subcategoria resul = dao.delete(subcategoria);
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }


    @PUT
    @Path( "/edit/{id}" )
    public SubcategoriaDto editSubcategoria(@PathParam("id") long _id, SubcategoriaDto SubcategoriaDto)
    {
        SubcategoriaDto resultado = new SubcategoriaDto();
        try
        {
            DaoSubcategoria dao = new DaoSubcategoria();
            Subcategoria subcategoria = dao.find(_id,Subcategoria.class);
            subcategoria.set_descripcion(SubcategoriaDto.getDescripcion());
            subcategoria.set_estatus( SubcategoriaDto.getEstatus() );
            Categoria categoria=new Categoria(SubcategoriaDto.getCategoriaDto().getId());
            subcategoria.set_categoria(categoria);
            Subcategoria resul = dao.update(subcategoria);
            resultado.setId( resul.get_id() );

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path( "/{id}" )
    public SubcategoriaDto getSubcategoria(@PathParam("id") long  _id)
    {
        SubcategoriaDto resultado = new SubcategoriaDto();
        try
        {
            DaoSubcategoria dao = new DaoSubcategoria();
            Subcategoria subcategoria = dao.find(_id,Subcategoria.class);
            resultado.setId( subcategoria.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }


}
