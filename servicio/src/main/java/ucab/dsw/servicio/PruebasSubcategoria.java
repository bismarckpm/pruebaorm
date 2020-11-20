package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoCategoria;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.dtos.SolicitudDto;
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
            subCategoria SUBC=new subCategoria(SUBcategoriaDto.getId());
            subCategoria SUBCEliminar=dao.find(SUBC.get_id(),subCategoria.class);
            SUBC.set_descripcion(SUBCEliminar.get_descripcion());
            SUBC.set_estatus("I");
            SUBC.set_idcategoria(SUBCEliminar.get_idcategoria());
            SUBC.set_solicitud(SUBCEliminar.get_solicitud());
            subCategoria resul = dao.update( SUBC );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
    }

    @POST
    @Path( "/actualizarsubcategoria" )
    public void actualizarSubCategoria(SubCategoriaDto SUBcategoriaDto )
    {
        SubCategoriaDto resultado = new SubCategoriaDto();
        try
        {
            DaoSubCategoria dao = new DaoSubCategoria();
            subCategoria SUBC = new subCategoria(SUBcategoriaDto.getId());
            subCategoria subcategoriaAactualizar= dao.find(SUBC.get_id(),subCategoria.class);
            if(SUBcategoriaDto.getDescripcion()!=null){
                SUBC.set_descripcion(SUBcategoriaDto.getDescripcion());
            }else {SUBC.set_descripcion(subcategoriaAactualizar.get_descripcion());}
            if(SUBcategoriaDto.getEstatus()!=null){
                SUBC.set_estatus(SUBcategoriaDto.getEstatus());
            }else {SUBC.set_estatus(subcategoriaAactualizar.get_estatus());}
            SUBC.set_idcategoria(subcategoriaAactualizar.get_idcategoria());
            SUBC.set_solicitud(subcategoriaAactualizar.get_solicitud());
            subCategoria resul = dao.update( SUBC );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
    }

    @GET
    @Path( "/leersubcategoria" )
    public SubCategoriaDto leerCategoria(SubCategoriaDto SUBcategoria )
    {
        SubCategoriaDto resultado = new SubCategoriaDto();
        try
        {
            DaoSubCategoria dao = new DaoSubCategoria();
            subCategoria SUBC = new subCategoria(SUBcategoria.getId());
            subCategoria resul= dao.find(SUBC.get_id(),subCategoria.class);
            CategoriaDto CDTO =new CategoriaDto(resul.get_idcategoria().get_id());
            CDTO.setDescripcion(resul.get_idcategoria().getDescripcion());
            CDTO.setEstatus(resul.get_idcategoria().get_estatus());
            resultado.setEstatus(resul.get_estatus());
            resultado.setDescripcion(resul.get_estatus());
            resultado.setCategoriaDto(CDTO);
            resultado.setId(resul.get_id());
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return resultado;
    }
}
