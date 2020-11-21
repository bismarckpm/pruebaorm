package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoOpcion;
import ucab.dsw.dtos.DtoOpcion;
import ucab.dsw.entidades.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path( "/prueba" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class PruebaOpcion extends AplicacionBase{

    @PUT
    @Path( "/addopcion" )
    public DtoOpcion addOpcion(DtoOpcion Dtoopcion )
    {
        DtoOpcion resultado = new DtoOpcion();
        try
        {
            String descripcion
            DaoOpcion dao = new DaoOpcion();
            Opcion opcion = new Opcion();

            opcion(DtoOpcion.getestatus());
            opcion.set_estatus(opcion.get_estatus());
            Usuario usuario=new Usuario(solicitudDto.getIdusuario().getId());
            List<Estudio> estudio = null;
            opcion.set_estudio(estudio);
            subCategoria subcatego =new subCategoria(solicitudDto.getIdsubcategoria().getId());
            opcion.set_descripcion(Dtoopcion.getestatus());
            solicitud resul = dao.insert(tipopregunta);
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return resultado;
    }
}