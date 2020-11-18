package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoTipoPregunta;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.entidades.TipoPregunta;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path( "/PreguntaCRUD" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class TipoPreguntaCRUD extends AplicacionBase {

    @PUT
    @Path( "/addtipopregunta" )
    public TipoPreguntaDto addTipoPregunta(TipoPreguntaDto tipoPreguntaDto)
    {
        TipoPreguntaDto resultado = new TipoPreguntaDto();
        try
        {
            DaoTipoPregunta dao = new DaoTipoPregunta();
            TipoPregunta tipoPregunta = new TipoPregunta();
            tipoPregunta.set_descripcion( tipoPreguntaDto.getDescripcion() );
            tipoPregunta.set_estatus( tipoPreguntaDto.getEstatus() );
            TipoPregunta resul = dao.insert( tipoPregunta );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }
}
