package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoTipoUsuario;
import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.entidades.TipoUsuario;

import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

public class pruebaTipoUsuario {
    @PUT
    @Path( "/addTipoUsuario" )
    public TipoUsuarioDto addTipoUsuario(TipoUsuarioDto tipoUsuarioDto )
    {
        TipoUsuarioDto resultado = new TipoUsuarioDto();
        try
        {
            DaoTipoUsuario dao = new DaoTipoUsuario();
            TipoUsuario tipoUsuario = new TipoUsuario();
            tipoUsuario.set_descripcion("Analista");
            tipoUsuario.set_estatus("A");
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
    @Path( "/updateTipoUsuario/{id}" )
    public TipoUsuarioDto updateTipoUsuario( TipoUsuarioDto tipoUsuarioDto)
    {
        TipoUsuarioDto resultado = new TipoUsuarioDto();
        try
        {
            DaoTipoUsuario dao = new DaoTipoUsuario();
            TipoUsuario tipoUsuario = new TipoUsuario(tipoUsuarioDto.getId());
            tipoUsuario.set_descripcion(tipoUsuarioDto.getDescripcion());
            tipoUsuario.set_estatus( tipoUsuarioDto.getEstatus() );
            TipoUsuario resul = dao.update ( tipoUsuario );
            resultado.setId(resul.get_id());

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @DELETE
    @Path( "/deleteTipoUsuario/{id}" )
    public TipoUsuarioDto deleteUsuario( TipoUsuarioDto tipoUsuarioDto) {
        TipoUsuarioDto resultado = new TipoUsuarioDto();
        try {
            DaoTipoUsuario dao = new DaoTipoUsuario();
            TipoUsuario tipoUsuario = dao.find(tipoUsuarioDto.getId(), TipoUsuario.class);
            TipoUsuario resul = dao.delete(tipoUsuario);
            resultado.setId(resul.get_id());

        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }

}
