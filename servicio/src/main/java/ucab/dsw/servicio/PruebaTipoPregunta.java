package ucab.dsw.servicio;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ucab.dsw.accesodatos.DaoTipoPregunta;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.entidades.TipoPregunta;

/**
 *
 * @author Omar David
 */
@Path( "/prueba" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
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

    @PUT
    @Path( "/changetipopregunta" )
    public TipoPreguntaDto changeTipoPregunta( TipoPreguntaDto tipoPreguntaDto ) throws Exception
    {
        TipoPreguntaDto resultado = new TipoPreguntaDto();
        try
        {
            DaoTipoPregunta dao = new DaoTipoPregunta();
            TipoPregunta tipoPregunta = new TipoPregunta(tipoPreguntaDto.getId());
            tipoPregunta.set_descripcion(tipoPreguntaDto.getDescripcion());
            tipoPreguntaDto.setEstatus(tipoPreguntaDto.getEstatus());
            TipoPregunta resul = dao.update(tipoPregunta);
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @PUT
    @Path( "/deletetipopregunta" )
    public TipoPreguntaDto deleteTipoPregunta( long id )
    {
        TipoPreguntaDto resultado = new TipoPreguntaDto();
        try
        {
            DaoTipoPregunta dao = new DaoTipoPregunta();
            TipoPregunta delete = dao.find( id, TipoPregunta.class );
            TipoPregunta resul = dao.delete( delete );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }


    @PUT
    @Path( "/showtipopregunta" )
    public TipoPreguntaDto showTipoPregunta( long id )
    {
        TipoPreguntaDto resultado = new TipoPreguntaDto();
        try {
            DaoTipoPregunta dao = new DaoTipoPregunta();
            TipoPregunta resul = dao.find( id, TipoPregunta.class );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }
}
