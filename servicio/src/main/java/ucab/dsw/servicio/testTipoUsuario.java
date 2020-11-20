package ucab.dsw.servicio;


import ucab.dsw.accesodatos.DaoOpcion;
import ucab.dsw.accesodatos.DaoTipoUsuario;
import ucab.dsw.dtos.OpcionDto;
import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.entidades.Opcion;
import ucab.dsw.entidades.Pregunta;
import ucab.dsw.entidades.TipoUsuario;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path( "/tipousuario" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class testTipoUsuario extends AplicacionBase{

    @PUT
    @Path( "/addtipousuario" )
    public TipoUsuarioDto addTipoUsuario(TipoUsuarioDto tipoUsuarioDto)
    {
        TipoUsuarioDto resultado = new TipoUsuarioDto();
        try
        {
            DaoTipoUsuario dao = new DaoTipoUsuario();
            TipoUsuario tipousuario = new TipoUsuario();
            tipousuario.set_descripcion( tipoUsuarioDto.getDescripcion() );
            tipousuario.set_estatus( tipoUsuarioDto.getEstatus() );
            TipoUsuario resul = dao.insert( tipousuario );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @PUT
    @Path( "/changetipousuario{id}" )
    public TipoUsuarioDto modifyTipoUsuario(TipoUsuarioDto tipoUsuarioDto ) throws Exception
    {
        TipoUsuarioDto resultado = new TipoUsuarioDto();
        try
        {
            DaoTipoUsuario dao = new DaoTipoUsuario();
            TipoUsuario tipousuario = new TipoUsuario(tipoUsuarioDto.getId());
            tipousuario.set_descripcion( tipoUsuarioDto.getDescripcion() );
            tipousuario.set_estatus( tipoUsuarioDto.getEstatus() );
            TipoUsuario resul = dao.update( tipousuario );
            resultado.setId( resul.get_id() );

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @DELETE
    @Path("/{id}")
    public TipoUsuarioDto deleteTipoUsuario(long id )
    {
        TipoUsuarioDto resultado = new TipoUsuarioDto();

        try {
            DaoTipoUsuario dao = new DaoTipoUsuario();
            TipoUsuario findid = dao.find(id,TipoUsuario.class);
            TipoUsuario deleteid = dao.delete(findid);
            resultado.setId( deleteid.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path("/Consultartipousuario/{id}")
    public TipoUsuarioDto consultarTiposUsuario (long id)
    {
        TipoUsuarioDto resultado = new TipoUsuarioDto();

        try {
            DaoTipoUsuario dao = new DaoTipoUsuario();
            TipoUsuario findid = dao.find(id,TipoUsuario.class);
            resultado.setId(findid.get_id());
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return resultado;
    }
}
