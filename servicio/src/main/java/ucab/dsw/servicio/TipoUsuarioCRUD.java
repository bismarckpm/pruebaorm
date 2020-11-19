package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoTipoUsuario;
import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.entidades.TipoUsuario;
import ucab.dsw.servicio.AplicacionBase;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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

}
