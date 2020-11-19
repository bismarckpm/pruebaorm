package ucab.dsw.servicio;
import ucab.dsw.accesodatos.DaoCategoria;
import ucab.dsw.accesodatos.DaoTipoUsuario;
import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.dtos.categoriaDto;
import ucab.dsw.entidades.Categoria;
import ucab.dsw.entidades.TipoUsuario;
import ucab.dsw.entidades.Usuario;

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
public class prueba_TipoUsuario extends AplicacionBase
{
    @PUT
    @Path( "/addTipouser" )
    public TipoUsuarioDto addTipoUser( TipoUsuarioDto tipoUsuarioDto )
    {
        TipoUsuarioDto resultado = new TipoUsuarioDto();
        try
        {
            DaoTipoUsuario dao = new DaoTipoUsuario();
            TipoUsuario tipoUsuario = new TipoUsuario();
            tipoUsuario.set_descripcion(tipoUsuarioDto.getDescripcion());
            tipoUsuario.set_estatus( tipoUsuarioDto.getEstatus() );
            TipoUsuario resul = dao.insert( tipoUsuario );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @PUT
    @Path( "/changecategoria" )
    public TipoUsuarioDto changeTipoUser(TipoUsuarioDto tipoUsuarioDto ) throws Exception
    {
        TipoUsuarioDto resultado = new TipoUsuarioDto();
        try
        {
            DaoTipoUsuario dao = new DaoTipoUsuario();
            TipoUsuario tipoUsuario = new TipoUsuario(tipoUsuarioDto.getId());
            tipoUsuario.set_descripcion(tipoUsuarioDto.getDescripcion());
            tipoUsuario.set_estatus( tipoUsuarioDto.getEstatus() );
            TipoUsuario resul = dao.update( tipoUsuario );
            resultado.setId( resul.get_id() );

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @PUT
    @Path( "/{id}" )
    public TipoUsuarioDto deleteTipoUser( long id )
    {
        TipoUsuarioDto resultado = new TipoUsuarioDto();
        try
        {
            DaoTipoUsuario dao = new DaoTipoUsuario();
            TipoUsuario delete = dao.find( id,TipoUsuario.class );
            TipoUsuario resul = dao.delete( delete);
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }


    @PUT
    @Path( "/{id}" )
    public TipoUsuarioDto findTipoUser( long id )
    {
        TipoUsuarioDto resultado = new TipoUsuarioDto();
        try
        {
            DaoTipoUsuario dao = new DaoTipoUsuario();
            TipoUsuario resul = dao.find( id,TipoUsuario.class );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }


    @GET
    @Path( "/consulta" )
    public String consulta()
    {
        return "Epa";
    }
}