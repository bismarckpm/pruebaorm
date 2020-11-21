package ucab.dsw.servicio;


import ucab.dsw.accesodatos.DaoOpcion;
import ucab.dsw.dtos.OpcionDto;
import ucab.dsw.entidades.Opcion;
import ucab.dsw.entidades.Pregunta;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path( "/opcionCRUD" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class OpcionCRUD extends AplicacionBase {

    @PUT
    @Path( "/addpregunta" )
    public OpcionDto addOpcion(OpcionDto opcionDto )
    {
        OpcionDto resultado = new OpcionDto();
        try
        {
            DaoOpcion dao = new DaoOpcion();
            Opcion opcion = new Opcion();
            opcion.set_descripcion( opcionDto.getDescripcion() );
            opcion.set_estatus( opcionDto.getEstatus() );
            Pregunta pregunta = new Pregunta(opcionDto.getPreguntaDto().getId());
            opcion.set_pregunta( pregunta );
            Opcion resul = dao.insert( opcion );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }


    @GET
    @Path("/getOpcion")
    public List<Opcion> getOpcion() {

        List<Opcion> opciones = null;
        try {
            DaoOpcion dao = new DaoOpcion();
            opciones = dao.findAll(Opcion.class);
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        for (Opcion obj : opciones){
            System.out.println(obj.get_descripcion());
        }
        return opciones;
    }


    @PUT
    @Path("/updateOpcion/{id}")
    public OpcionDto updateOpcion(@PathParam("id") long id, OpcionDto opcionDto) {
        OpcionDto resultado = new OpcionDto();
        try {
            DaoOpcion dao = new DaoOpcion();
            Opcion opcion = dao.find(id, Opcion.class);
            opcion.set_descripcion( opcionDto.getDescripcion() );
            opcion.set_estatus( opcionDto.getEstatus() );
            Pregunta pregunta = new Pregunta(opcionDto.getPreguntaDto().getId());
            opcion.set_pregunta( pregunta );
            Opcion resul = dao.update(opcion);
            resultado.setId(resul.get_id());

        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }


    @DELETE
    @Path("/deleteOpcion/{id}")
    public OpcionDto deleteOpcion(@PathParam("id") long id){
        OpcionDto resultado = new OpcionDto();
        try
        {
            DaoOpcion dao = new DaoOpcion();
            Opcion opcion = dao.find(id, Opcion.class);
            if (opcion != null) {
                Opcion resul = dao.delete(opcion);
                resultado.setId(resul.get_id());
            }
        }
        catch (Exception ex){
            String problema = ex.getMessage();
        }
        return resultado;
    }
}
