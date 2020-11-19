package ucab.dsw.servicio;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import ucab.dsw.accesodatos.DaoTipoPregunta;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.entidades.TipoPregunta;

/**
 *
 * @author Omar David
 */
public class PruebaTipoPregunta {
    @PUT
    @Path( "/addtipopregunta" )
    public TipoPreguntaDto addTipoPregunta( TipoPreguntaDto tipopreguntaDto )
    {
        TipoPreguntaDto resultado = new TipoPreguntaDto();
        try
        {
            DaoTipoPregunta dao = new DaoTipoPregunta();
            TipoPregunta tipoPregunta = new TipoPregunta();
            tipoPregunta.set_descripcion(tipopreguntaDto.getDescripcion());
            tipoPregunta.set_estatus(tipopreguntaDto.getEstatus());
            TipoPregunta resul = dao.insert(tipoPregunta);
            resultado.setId(resul.get_id());
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

}
