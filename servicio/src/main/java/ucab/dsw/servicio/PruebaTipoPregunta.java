package ucab.dsw.servicio;
import ucab.dsw.accesodatos.*;
import ucab.dsw.dtos.*;
import ucab.dsw.entidades.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path( "/PruebaTipoPregunta" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class PruebaTipoPregunta extends AplicacionBase{

    @PUT
    @Path( "/addtipopregunta" )
    public SolicitudDto addTipoPregunta( DtoTipoPregunta Dtotipopregunta )
    {
        DtoTipoPregunta resultado = new DtoTipoPregunta();
        try
        {
            DaoTipoPregunta dao = new DaoTipoPregunta();
            Tipopregunta tipopregunta = new Tipopregunta();
            Tipopregunta.setTipoPregunta(Dtotipopregunta.getTipoPregunta());
            tipopregunta(Dtotipopregunta.getFecha());
            tipopregunta.set_estatus(solicitudDto.getEstatus());

            tipopregunta.set_usuario(usuario);


            Tipopregunta resul = dao.insert(tipopregunta);
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return resultado;
    }
    @DELETE
    @Path( "/eliminarcategoria" )
    public void eliminarTipopregunta(DtoTipoPregunta tipopreguntaDto )
    {
        DtoTipoPregunta resultado = new DtoTipoPregunta();
        try
        {
            DaoTipoPregunta dao = new DaoTipoPregunta();
            Tipopregunta tpregunta = new Tipopregunta(tipopreguntaDto.getId());
            tpregunta.setDescripcion(tipopreguntaDto.getTipoPregunta());
            tpregunta.set_estatus(tipopreguntaDto.getEstatus());
            categoria resul = dao.delete( Tipopregunta );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
    }
}
