package ucab.dsw.servicio;


import ucab.dsw.accesodatos.DaoOpcion;
import ucab.dsw.dtos.OpcionDto;
import ucab.dsw.entidades.Opcion;
import ucab.dsw.entidades.Pregunta;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path( "/opciones" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class OpcionControlador extends AplicacionBase{

    @GET
    @Path( "/{id}" )
    // @PathParam("id") Long id
    public OpcionDto obtenerOpcion (long id){
        OpcionDto resultado = new OpcionDto();
        try{
            DaoOpcion dao = new DaoOpcion();
            Opcion encontrado = dao.find( id, Opcion.class);
            resultado.setDescricion( encontrado.get_descripcion());
            resultado.setEstatus( encontrado.get_estatus());
            resultado.setId(encontrado.get_id());
        }catch (Exception e){
            String problema = e.getMessage();
        }
        return resultado;
    }

    @POST
    @Path("/")
    public OpcionDto crearOpcion ( OpcionDto opcionDto){
        OpcionDto resultado = new OpcionDto();
        try{
            DaoOpcion dao = new DaoOpcion();
            Opcion opcion = new Opcion();
            opcion.set_descripcion( opcionDto.getDescricion());
            opcion.set_estatus( opcionDto.getEstatus());
            Pregunta pregunta = new Pregunta( opcionDto.getPregunta().getId());
            opcion.set_pregunta( pregunta);
            Opcion resul = dao.insert( opcion);
            resultado.setId( resul.get_id());
        }catch (Exception e){
            String problema = e.getMessage();
        }
        return resultado;
    }

    @PUT
    @Path("/")
    public OpcionDto modificarOpcion( OpcionDto opcionDto){
        OpcionDto resultado = new OpcionDto();
        try{
            DaoOpcion dao = new DaoOpcion();
            Opcion opcion = new Opcion( opcionDto.getId());
            opcion.set_descripcion( opcionDto.getDescricion());
            opcion.set_estatus( opcionDto.getEstatus());
            Pregunta pregunta = new Pregunta( opcionDto.getPregunta().getId());
            opcion.set_pregunta( pregunta);
            Opcion resul = dao.update( opcion);
            resultado.setId( resul.get_id());
        }catch (Exception e){
            String problema = e.getMessage();
        }
        return resultado;
    }

    @DELETE
    @Path( "/{id}" )
    //@PathParam("id") Long id
    public OpcionDto borrarOpcion( long id){
        OpcionDto resultado = new OpcionDto();
        try{
            DaoOpcion dao = new DaoOpcion();
            Opcion paraBorrar = dao.find( id, Opcion.class);
            Opcion resul = dao.delete( paraBorrar);
            resultado.setId(resul.get_id());
        }catch (Exception e){
            String problema = e.getMessage();
        }
        return resultado;
    }
}
