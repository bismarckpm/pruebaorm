package ucab.dsw.servicio;
import ucab.dsw.accesodatos.DaoOpcion;
import ucab.dsw.dtos.OpcionDto;
import ucab.dsw.entidades.TipoPregunta;
import ucab.dsw.entidades.Opcion;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.*;


@Path( "/opcion" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class OpcionS {
    
    @POST
    @Path( "/addopcion" )
    public OpcionDto addOpcion( OpcionDto opcionDto )
    {
        OpcionDto resultado = new OpcionDto();
        try
        {
            DaoOpcion dao = new DaoOpcion();
            Opcion opcion = new Opcion();
            opcion.set_descripcion( opcionDto.getdescripcion() );
            opcion.set_estatus( opcionDto.getEstatus() );
            /*TipoPregunta tipoPregunta = new TipoPregunta(opcionDto.gettipopreguntaDto().getId());
            opcion.set_tipopregunta( tipoPregunta );*/
            Opcion resul = dao.insert( opcion );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }
    
    
    @GET
    @Path("/getopcion/{id}")
    public OpcionDto getOpcion(@PathParam("id") long id, OpcionDto opcionDto){
        OpcionDto res = new OpcionDto();
        try{
            DaoOpcion dao = new DaoOpcion();
            Opcion opcion = dao.find(id, Opcion.class);
            res.setId(opcion.get_id());
        }catch (Exception ex){
            String problema = ex.getMessage();
        }
        return res;
    }
    
    @PUT
    @Path("/updateopcion/{id}")
    public OpcionDto updateOpcion(@PathParam("id") long id, OpcionDto opcionDto){
        OpcionDto res = new OpcionDto();
        try{
            DaoOpcion dao = new DaoOpcion();
            Opcion opcion = dao.find(id, Opcion.class);
            opcion.set_descripcion( opcionDto.getdescripcion() );
            opcion.set_estatus( opcionDto.getEstatus() );
            Opcion r = dao.update(opcion);
            /*TipoPregunta tipoPregunta = new TipoPregunta(opcionDto.gettipopreguntaDto().getId());
            opcion.set_tipopregunta( tipoPregunta );*/
            res.setId(r.get_id());
        }catch (Exception ex){ 
            String problema = ex.getMessage();
        }
        return res;
    }
    
    
    @DELETE
    @Path("/deleteopcion/{id}")
    public OpcionDto deleteOpcion (@PathParam("id") long id, OpcionDto opcionDto){
        OpcionDto res = new OpcionDto();
        try{
            DaoOpcion dao = new DaoOpcion();
            Opcion opcion = dao.find(id, Opcion.class);
            Opcion r = dao.delete(opcion);
            res.setId(r.get_id());
        }catch (Exception ex){ 
            String problema = ex.getMessage();
        }
        return res;
    }
}
