package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoSubCategoria;
import ucab.dsw.accesodatos.DaoTipoPregunta;
import ucab.dsw.dtos.SubCategoriaDto;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.entidades.Categoria;
import ucab.dsw.entidades.SubCategoria;
import ucab.dsw.entidades.TipoPregunta;

import javax.ws.rs.*;

public class TipoPreguntaWS {


    @POST
    @Path( "/enviarsubcategoria/{id}" )
    public SubCategoriaDto add(SubCategoriaDto subCategoriaDto ){
        SubCategoriaDto resultado = new SubCategoriaDto();
        try{
            DaoSubCategoria dao = new DaoSubCategoria();



        }
        catch ( Exception ex ){
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path( "/gettipopregunta/{id}" )
    public TipoPreguntaDto gettipopregunta(@PathParam("id") long  _id , TipoPreguntaDto tipoPreguntaDto){
        TipoPreguntaDto resultado = new TipoPreguntaDto();
        try{
            DaoTipoPregunta dao = new DaoTipoPregunta();
            TipoPregunta tipoPregunta = dao.find(_id, TipoPregunta.class);
            resultado.setId(tipoPregunta.get_id());
        }
        catch ( Exception ex ){
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @PUT
    @Path( "/addstipopregunta" )
    public TipoPreguntaDto addstipopregunta( TipoPreguntaDto tipoPreguntaDto ){
        TipoPreguntaDto resultado = new TipoPreguntaDto();
        try{
            DaoTipoPregunta dao = new DaoTipoPregunta();
            TipoPregunta tipoPregunta = new TipoPregunta();
            tipoPregunta.set_descripcion(tipoPreguntaDto.getDescripcion());
            tipoPregunta.set_estatus(tipoPreguntaDto.getEstatus());
            TipoPregunta resul = dao.insert( tipoPregunta);
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex ){
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @DELETE
    @Path( "/deletetipopregunta/{id}" )
    public TipoPreguntaDto deletetipopregunta(@PathParam("id") long  _id , TipoPreguntaDto tipoPreguntaDto){
        TipoPreguntaDto resultado = new TipoPreguntaDto();
        try{
            DaoTipoPregunta dao = new DaoTipoPregunta();
            TipoPregunta tipoPregunta= dao.find(_id, TipoPregunta.class);
            TipoPregunta tp = dao.delete(tipoPregunta);
            resultado.setId(tp.get_id());
        }
        catch ( Exception ex ){
            String problema = ex.getMessage();
        }
        return  resultado;
    }
}
