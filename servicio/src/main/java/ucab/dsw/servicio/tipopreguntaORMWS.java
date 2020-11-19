package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoTipoPregunta;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.TipoPregunta;
import ucab.dsw.entidades.Pregunta;
import ucab.dsw.entidades.Usuario;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path( "/tipopregunta" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class tipopreguntaORMWS extends AplicacionBase{
    @PUT
    @Path( "/addPregunta" )
    public TipoPreguntaDto addTipoPregunta(TipoPreguntaDto tipoPreguntaDto )
    {
        TipoPreguntaDto resultado = new TipoPreguntaDto();
        try{
            DaoTipoPregunta dao= new DaoTipoPregunta();
            TipoPregunta tipoPregunta= new TipoPregunta();
            tipoPregunta.set_descripcion(tipoPreguntaDto.getDescripcion());
            tipoPregunta.set_estatus(tipoPreguntaDto.getEstatus());
            TipoPregunta resul= dao.insert(tipoPregunta);

            resultado.setId( resul.get_id() );

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;

    }

    @DELETE
    @Path( "/deletePregunta" )
    public TipoPreguntaDto deleteTipoPregunta(long _id ){
        TipoPreguntaDto resultado = new TipoPreguntaDto();
        try{
            DaoTipoPregunta dao= new DaoTipoPregunta();
            TipoPregunta tipoPregunta= new TipoPregunta();
            Class<TipoPregunta> type = TipoPregunta.class;
            tipoPregunta= dao.find(_id,type);
            tipoPregunta.set_estatus("I");
            TipoPregunta resul= dao.update(tipoPregunta);
            resultado.setId(resul.get_id());

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }


        return resultado;
    }

    @GET
    @Path("/id")
    public TipoPreguntaDto consultarTipoPregunta(long _id ){
        TipoPreguntaDto resultado = new TipoPreguntaDto();
        try{
            DaoTipoPregunta dao= new DaoTipoPregunta();
            TipoPregunta tipoPregunta= new TipoPregunta();
            Class<TipoPregunta> type = TipoPregunta.class;
            tipoPregunta= dao.find(_id,type);

            resultado.setId(tipoPregunta.get_id());
            resultado.setEstatus(tipoPregunta.get_estatus());
            resultado.setDescripcion(tipoPregunta.get_descripcion());

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }


        return resultado;
    }

    @PUT
    @Path( "/updatePregunta" )
    public TipoPreguntaDto updateTipoPregunta(TipoPreguntaDto tipoPreguntaDto ){
        TipoPreguntaDto resultado = new TipoPreguntaDto();
        try{

            DaoTipoPregunta dao= new DaoTipoPregunta();
            TipoPregunta tipoPregunta= new TipoPregunta();
            tipoPregunta.set_estatus(tipoPreguntaDto.getEstatus());
            tipoPregunta.set_descripcion(tipoPreguntaDto.getDescripcion());
            tipoPregunta.set_id(tipoPreguntaDto.getId());

            TipoPregunta resul= dao.update(tipoPregunta);
            resultado.setId(resul.get_id());

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }

        return resultado;
    }
}
