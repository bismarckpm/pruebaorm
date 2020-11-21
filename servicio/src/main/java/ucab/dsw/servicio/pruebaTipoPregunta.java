package ucab.dsw.servicio;
import ucab.dsw.accesodatos.DaoTipoPregunta;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.entidades.TipoPregunta;


import javax.ws.rs.*;
import java.util.List;

public class pruebaTipoPregunta {

    @PUT
    @Path( "/addTipoPregunta" )
    public TipoPreguntaDto addTipoPregunta(TipoPreguntaDto tipoPreguntaDto )
    {
        TipoPreguntaDto resultado = new TipoPreguntaDto();
        try
        {
            DaoTipoPregunta dao = new DaoTipoPregunta();
            TipoPregunta tipoPregunta = new TipoPregunta();
            tipoPregunta.set_descripcion( tipoPreguntaDto.getDescripcion() );
            tipoPregunta.set_estatus( tipoPreguntaDto.getEstatus() );
            TipoPregunta resultadoDos = dao.insert( tipoPregunta );
            resultado.setId( resultadoDos.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path("/getTipoPregunta")
    public List<TipoPregunta> getTipoPregunta() {

        List<TipoPregunta> tipoPregunta = null;
        try {
            DaoTipoPregunta dao = new DaoTipoPregunta();
            tipoPregunta = dao.findAll(TipoPregunta.class);
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return tipoPregunta;
    }

    @PUT
    @Path("/updateTipoPregunta/{id}")
    public TipoPreguntaDto updateTipoPregunta(@PathParam("id") long id, TipoPreguntaDto tipoPreguntaDto) {
        TipoPreguntaDto resultado = new TipoPreguntaDto();
        try {
            DaoTipoPregunta dao = new DaoTipoPregunta();
            TipoPregunta tipoPregunta = dao.find(id, TipoPregunta.class);

            if (tipoPregunta != null) {
                tipoPregunta.set_descripcion(tipoPreguntaDto.getDescripcion());
                TipoPregunta resultadoDos = dao.update(tipoPregunta);
                resultado.setId(resultadoDos.get_id());
            }

        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }

    @DELETE
    @Path("/deleteTipoPregunta/{id}")
    public TipoPreguntaDto deleteTipoPregunta(@PathParam("id") long id)
    {
        TipoPreguntaDto resultado = new TipoPreguntaDto();
        try
        {
            DaoTipoPregunta dao = new DaoTipoPregunta();
            TipoPregunta tipoPregunta = dao.find(id, TipoPregunta.class);

            if(tipoPregunta != null)
            {
                TipoPregunta resultadoDos = dao.delete(tipoPregunta);
                resultado.setId(resultadoDos.get_id());
            }
        }
        catch (Exception ex){
            String problema = ex.getMessage();
        }
        return resultado;
    }
}