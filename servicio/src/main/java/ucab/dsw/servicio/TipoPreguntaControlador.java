package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoTipoPregunta;
import ucab.dsw.accesodatos.DaoUsuario;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.TipoPregunta;
import ucab.dsw.entidades.TipoUsuario;
import ucab.dsw.entidades.Usuario;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path( "/tipo-pregunta" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class TipoPreguntaControlador extends AplicacionBase {

    @POST
    @Path( "/new" )
    public TipoPreguntaDto addTipoPregunta(TipoPreguntaDto tipoPreguntaDto ){
        TipoPreguntaDto resultado = new TipoPreguntaDto();
        String err = new String();
        try
        {
            DaoTipoPregunta dao = new DaoTipoPregunta();
            TipoPregunta tipoPregunta = new TipoPregunta();
            tipoPregunta.set_estatus(tipoPreguntaDto.get_estatus());
            tipoPregunta.set_descripcion(tipoPreguntaDto.get_descripcion());
            TipoPregunta result = dao.insert( tipoPregunta );
            resultado.setId(result.get_id());
        }
        catch ( Exception ex )
        {
            err = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path( "ext/:tp_id" )
    public TipoPreguntaDto obtenerTipoPregunta(long tp_id){
        TipoPreguntaDto resultado = new TipoPreguntaDto();
        String err = new String();
        try{
            DaoTipoPregunta dao = new DaoTipoPregunta();
            TipoPregunta encontrado = dao.find( tp_id,TipoPregunta.class);
            resultado.setId(encontrado.get_id());
            resultado.setDescripcion( encontrado.get_descripcion());
        }catch (Exception e){
            err = e.getMessage();
        }

        return resultado;
    }

    @PUT
    @Path( "/update/:tp_id" )
    public TipoPreguntaDto updateTipoPregunta(TipoPreguntaDto tipoPreguntaDto){
        TipoPreguntaDto resultado = new TipoPreguntaDto();
        try{
            DaoTipoPregunta dao = new DaoTipoPregunta();
            TipoPregunta updPreg = new TipoPregunta( tipoPreguntaDto.getId());
            updPreg.set_descripcion(  tipoPreguntaDto.get_descripcion());
            updPreg.set_estatus(  tipoPreguntaDto.get_estatus());
            TipoPregunta resul = dao.update(updPreg);
            resultado.setId( resul.get_id());
        }catch (Exception e){
            String problema = e.getMessage();
        }
        return resultado;
    }
    @DELETE
    @Path( "/delete/:tp_id" )
    public TipoPreguntaDto deleteTipoPregunta(long id){
        TipoPreguntaDto resultado = new TipoPreguntaDto();
        try{
            DaoTipoPregunta dao = new DaoTipoPregunta();
            TipoPregunta paraBorrar = dao.find( id, TipoPregunta.class);
            TipoPregunta resul = dao.delete( paraBorrar);
            resultado.setId(resul.get_id());
        }catch (Exception e){
            String problema = e.getMessage();
        }
        return resultado;
    }
}
