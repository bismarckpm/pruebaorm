package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoTipoPregunta;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.entidades.TipoPregunta;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path( "/prueba" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class prueba_TipoPregunta extends AplicacionBase{
    
    @PUT
    @Path( "/addtipopregunta" )
    public TipoPreguntaDto addTipoPregunta( TipoPreguntaDto TipoPreguntaDto ) throws Exception {
        TipoPreguntaDto resultado = new TipoPreguntaDto();
        try {
            DaoTipoPregunta dao = new DaoTipoPregunta();
            TipoPregunta tipopregunta = new TipoPregunta();
            tipopregunta.set_descripcion( TipoPreguntaDto.getDescripcion() );
            tipopregunta.set_estatus( TipoPreguntaDto.getEstatus() );
            TipoPregunta resul = dao.insert( tipopregunta );
            resultado.setId( resul.get_id() );
        } catch ( Exception ex ) {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @PUT
    @Path( "/changeTipoPregunta" )
    public TipoPreguntaDto changeTipoPregunta( TipoPreguntaDto TipoPreguntaDto ) throws Exception
    {
        TipoPreguntaDto resultado = new TipoPreguntaDto();
        try  {
            DaoTipoPregunta dao = new  DaoTipoPregunta();
            TipoPregunta tipopregunta = new TipoPregunta(TipoPreguntaDto.getId());
            tipopregunta.set_descripcion( TipoPreguntaDto.getDescripcion() );
            tipopregunta.set_estatus( TipoPreguntaDto.getEstatus() );
            TipoPregunta resul = dao.update( tipopregunta );
            resultado.setId( resul.get_id() );
        } catch ( Exception ex ) {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @PUT
    @Path( "/{id}" )
    public TipoPreguntaDto deleteTipoPregunta( long id )
    {
        TipoPreguntaDto resultado = new TipoPreguntaDto();
        try
        {
            DaoTipoPregunta dao = new  DaoTipoPregunta();
            TipoPregunta delete = dao.find( id,TipoPregunta.class );
            TipoPregunta resul = dao.delete( delete);
            resultado.setId( resul.get_id() );
        } catch ( Exception ex ) {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @PUT
    @Path( "/{id}" )
    public TipoPreguntaDto findTipoPregunta( long id ) {
        TipoPreguntaDto resultado = new TipoPreguntaDto();
        try {
            DaoTipoPregunta dao = new  DaoTipoPregunta();
            TipoPregunta resul = dao.find( id,TipoPregunta.class );
            resultado.setId( resul.get_id() );
        } catch ( Exception ex ) {
            String problema = ex.getMessage();
        }
        return  resultado;
    }
}
