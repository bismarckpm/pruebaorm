package ucab.dsw.servicio;


import ucab.dsw.accesodatos.DaoTipoUsuario;
import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.entidades.TipoUsuario;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path( "/tipousuario" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class TipoUsuarioControlador extends AplicacionBase {

    @GET
    @Path( "/{id}" )
    public TipoUsuarioDto obtenerTipoUsuario(long id )
    {
        TipoUsuarioDto resultado = new TipoUsuarioDto();
        try{
            DaoTipoUsuario dao = new DaoTipoUsuario();
            TipoUsuario resul = dao.find( id, TipoUsuario.class);
            resultado.setId( resul.get_id());
        }
        catch ( Exception ex ){
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @POST
    @Path( "/" )
    public TipoUsuarioDto crearTipoUsuario( TipoUsuarioDto tipoUsuarioDto )
    {
        TipoUsuarioDto resultado = new TipoUsuarioDto();
        try{
            DaoTipoUsuario dao = new DaoTipoUsuario();
            TipoUsuario tipoUsuario = new TipoUsuario();
            tipoUsuario.set_descripcion(tipoUsuarioDto.getDescripcion());
            tipoUsuario.set_estatus( tipoUsuarioDto.getEstatus());
            TipoUsuario resul = dao.insert( tipoUsuario);
            resultado.setId( resul.get_id());
        }
        catch (Exception ex){
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @PUT
    @Path( "/" )
    public TipoUsuarioDto modificarTipoUsuario(TipoUsuarioDto tipoUsuarioDto )
    {
        TipoUsuarioDto resultado = new TipoUsuarioDto();
        try{
            DaoTipoUsuario dao = new DaoTipoUsuario();
            TipoUsuario tipoUsuario = new TipoUsuario( tipoUsuarioDto.getId());
            tipoUsuario.set_descripcion( tipoUsuarioDto.getDescripcion());
            tipoUsuario.set_estatus( tipoUsuarioDto.getEstatus());
            TipoUsuario resul = dao.update( tipoUsuario);
            resultado.setId( resul.get_id());
        }
        catch (Exception ex){
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @DELETE
    @Path( "/{id}" )
    public TipoUsuarioDto borrarTipoUsuario( long id )
    {
        TipoUsuarioDto resultado = new TipoUsuarioDto();
        try{
            DaoTipoUsuario dao = new DaoTipoUsuario();
            TipoUsuario paraBorrar = dao.find( id,TipoUsuario.class);
            TipoUsuario resul = dao.delete( paraBorrar);
            resultado.setId( resul.get_id());
        }
        catch (Exception ex){
            String problema = ex.getMessage();
        }
        return  resultado;
    }
}
