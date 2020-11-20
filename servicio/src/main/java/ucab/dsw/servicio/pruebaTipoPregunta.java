package ucab.dsw.servicio;
import ucab.dsw.accesodatos.DaoTipoPregunta;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.entidades.TipoPregunta;


import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

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
            tipoPregunta.setDescripcion("¿Cantidad de televisores en su hogar?");
            tipoPregunta.setEstatus("A");
            TipoPregunta resul = dao.insert( tipoPregunta );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @PUT
    @Path( "/updateTipoPregunta/{id}" )
    public TipoPreguntaDto updateTipoPregunta( TipoPreguntaDto tipoPreguntaDto)
    {
        TipoPreguntaDto resultado = new TipoPreguntaDto();
        try
        {
            DaoTipoPregunta dao = new DaoTipoPregunta();
            TipoPregunta tipoPregunta = new TipoPregunta(tipoPreguntaDto.getId());
            tipoPregunta.setDescripcion(tipoPreguntaDto.getDescripcion());
            tipoPregunta.setEstatus( tipoPreguntaDto.getEstatus() );
            TipoPregunta resul = dao.update ( tipoPregunta );
            resultado.setId(resul.get_id());

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @DELETE
    @Path( "/deleteTipoPregunta/{id}" )
    public TipoPreguntaDto deletePregunta( TipoPreguntaDto tipoPreguntaDto) {
        TipoPreguntaDto resultado = new TipoPreguntaDto();
        try {
            DaoTipoPregunta dao = new DaoTipoPregunta();
            TipoPregunta tipoPregunta = dao.find(tipoPreguntaDto.getId(), TipoPregunta.class);
            TipoPregunta resul = dao.delete(tipoPregunta);
            resultado.setId(resul.get_id());

        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }

}
