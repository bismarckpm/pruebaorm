package ucab.dsw.servicio;
import ucab.dsw.accesodatos.DaoTipoPregunta;
import ucab.dsw.accesodatos.DaoTipoUsuario;
import ucab.dsw.accesodatos.DaoUsuario;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.TipoPregunta;
import ucab.dsw.entidades.TipoUsuario;
import ucab.dsw.entidades.Usuario;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


@Path( "/tipousuario" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class tipousuarioORMWS extends AplicacionBase{
    @PUT
    @Path( "/addtipousuario" )
    public TipoUsuarioDto addTipoUsuario(TipoUsuarioDto tipoUsuarioDto )
    {
        TipoUsuarioDto resultado = new TipoUsuarioDto();

        try{
            DaoTipoUsuario dao= new DaoTipoUsuario();
            TipoUsuario tipoUsuario= new TipoUsuario();
            tipoUsuario.set_descripcion(tipoUsuarioDto.getDescripcion());
            tipoUsuario.set_estatus(tipoUsuarioDto.getEstatus());
            TipoUsuario resul= dao.insert(tipoUsuario);

            resultado.setId( resul.get_id() );

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;

    }


    @DELETE
    @Path( "/{id}"  )
    public TipoUsuarioDto deleteTipoUsuario(@PathParam("id") long  _id){
        TipoUsuarioDto resultado= new TipoUsuarioDto();


        try{
            DaoTipoUsuario dao= new DaoTipoUsuario();
            TipoUsuario tipoUsuario= new TipoUsuario();

            Class<TipoUsuario> type = TipoUsuario.class;
            tipoUsuario= dao.find(_id,type);
            tipoUsuario.set_estatus("I");
            TipoUsuario resul= dao.update(tipoUsuario);
            resultado.setId(resul.get_id());

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }


        return resultado;
    }


    @GET
    @Path("/edit/{id}")
    public TipoUsuarioDto consultarTipoUsuario(@PathParam("id") long  _id){

        TipoUsuarioDto resultado = new TipoUsuarioDto();

        try{
            DaoTipoUsuario dao= new DaoTipoUsuario();
            TipoUsuario tipoUsuario= new TipoUsuario();

            Class<TipoUsuario> type = TipoUsuario.class;
            tipoUsuario= dao.find(_id,type);
            resultado.setId(tipoUsuario.get_id());
            resultado.setEstatus(tipoUsuario.get_estatus());
            resultado.setDescripcion(tipoUsuario.get_descripcion());

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return resultado;
    }


    @PUT
    @Path( "/{id}" )
    public TipoUsuarioDto updateTipoUsuario(@PathParam("id") long  _id ,TipoUsuarioDto tipoUsuarioDto ){
        TipoUsuarioDto resultado= new TipoUsuarioDto();
        try{
            DaoTipoUsuario dao= new DaoTipoUsuario();
            TipoUsuario tipoUsuario= dao.find(_id, TipoUsuario.class);
            tipoUsuario.set_estatus(tipoUsuarioDto.getEstatus());
            tipoUsuario.set_descripcion(tipoUsuarioDto.getDescripcion());
            TipoUsuario resul= dao.update(tipoUsuario);
            resultado.setId(resul.get_id());
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return resultado;
    }


}
