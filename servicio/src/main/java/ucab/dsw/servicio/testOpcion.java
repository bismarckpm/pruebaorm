package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoOpcion;
import ucab.dsw.dtos.OpcionDto;
import ucab.dsw.entidades.Opcion;
import ucab.dsw.entidades.Pregunta;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path( "/opcion" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class testOpcion extends AplicacionBase{

    @PUT
    @Path( "/addopcion" )
    public OpcionDto addOpcion(OpcionDto opcionDto)
    {
        OpcionDto resultado = new OpcionDto();
        try
        {
            DaoOpcion dao = new DaoOpcion();
            Opcion opcion = new Opcion();
            opcion.set_descripcion( opcionDto.getDescripcion() );
            opcion.set_estatus( opcionDto.getEstatus() );
            Pregunta pregunta = new Pregunta(opcionDto.getPreguntaDto().getId());
            opcion.set_pregunta(pregunta);
            Opcion resul = dao.insert( opcion );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @PUT
    @Path( "/changeopcion/{id}" )
    public OpcionDto modifyOpcion(OpcionDto opcionDto ) throws Exception
    {
        OpcionDto resultado = new OpcionDto();
        try
        {
            DaoOpcion dao = new DaoOpcion();
            Opcion opcion = new Opcion(opcionDto.getId());
            opcion.set_descripcion( opcionDto.getDescripcion() );
            opcion.set_estatus( opcionDto.getEstatus() );
            Pregunta pregunta = new Pregunta(opcionDto.getPreguntaDto().getId());
            opcion.set_pregunta(pregunta);
            Opcion resul = dao.update( opcion );
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
    public OpcionDto deleteOpcion(long id )
    {
        OpcionDto resultado = new OpcionDto();

        try {
            DaoOpcion dao = new DaoOpcion();
            Opcion findid = dao.find(id,Opcion.class);
            Opcion deleteid = dao.delete(findid);
            resultado.setId( deleteid.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path("/Consultaropcion/{id}")
    public OpcionDto consultarOpcion (long id)
    {
        OpcionDto resultado = new OpcionDto();

        try {
            DaoOpcion dao = new DaoOpcion();
            Opcion findid = dao.find(id,Opcion.class);
            resultado.setId(findid.get_id());
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return resultado;
    }

}
