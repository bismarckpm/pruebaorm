package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoTipoUsuario;
import ucab.dsw.accesodatos.DaoUsuario;
import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.TipoUsuario;
import ucab.dsw.entidades.Usuario;
import ucab.dsw.servicio.AplicacionBase;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path( "/tipousuario" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class TipoUsuarioCRUD extends AplicacionBase {

    @PUT
    @Path( "/addtipousuario" )
    public TipoUsuarioDto addTipoUsuario(TipoUsuarioDto tipousuarioDto )
    {
        TipoUsuarioDto resultado = new TipoUsuarioDto();
        try
        {
            DaoTipoUsuario dao = new DaoTipoUsuario();
            TipoUsuario tipousuario = new TipoUsuario();
            tipousuario.set_descripcion(tipousuarioDto.getDescripcion());
            tipousuario.set_estatus(tipousuarioDto.getEstatus());
            TipoUsuario resul = dao.insert( tipousuario );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path("/getTipousuario")
    public List<TipoUsuario> getTipoUsers() {

        List<TipoUsuario> tipousuarios = null;
        try {
            DaoTipoUsuario dao = new DaoTipoUsuario();
            tipousuarios = dao.findAll(TipoUsuario.class);
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        for (TipoUsuario obj : tipousuarios) {
            System.out.println(obj.get_descripcion());
        }
        return tipousuarios;
    }

    @PUT
    @Path("/updateTipousuario/{id}")
    public TipoUsuarioDto updateTipoUsuario(@PathParam("id") long id, TipoUsuarioDto tipoUsuarioDto) {
        TipoUsuarioDto resultado = new TipoUsuarioDto();
        try {
            DaoTipoUsuario dao = new DaoTipoUsuario();
            TipoUsuario tipousuario = dao.find(id, TipoUsuario.class);
            tipousuario.set_descripcion(tipoUsuarioDto.getDescripcion());
            tipousuario.set_estatus(tipoUsuarioDto.getEstatus());
            TipoUsuario resul = dao.update(tipousuario);
            resultado.setId(resul.get_id());
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }

    @DELETE
    @Path("/deleteTipousuario/{id}")
    public TipoUsuarioDto deleteTipoUsuario(@PathParam("id") long id)
    {
        TipoUsuarioDto resultado = new TipoUsuarioDto();
        try
        {
            DaoTipoUsuario dao = new DaoTipoUsuario();
            TipoUsuario tipousuario = dao.find(id, TipoUsuario.class);
            if(tipousuario != null) {
                TipoUsuario resul = dao.delete(tipousuario);
                resultado.setId(resul.get_id());
            }
        }
        catch (Exception er){
            String problema = er.getMessage();
        }
        return resultado;
    }

}
