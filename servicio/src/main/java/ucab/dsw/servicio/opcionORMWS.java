package ucab.dsw.servicio;
import ucab.dsw.accesodatos.DaoTipoPregunta;
import ucab.dsw.accesodatos.DaoUsuario;
import ucab.dsw.accesodatos.DaoOpcion;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.dtos.OpcionDto;
import ucab.dsw.entidades.TipoPregunta;
import ucab.dsw.entidades.TipoUsuario;
import ucab.dsw.entidades.Usuario;
import ucab.dsw.entidades.Opcion;
import ucab.dsw.entidades.Pregunta;


import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


@Path( "/Opcion" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class opcionORMWS extends AplicacionBase{

    @PUT
    @Path( "/addopcion" )
    public OpcionDto addopcion( OpcionDto opcionDto )
    {

        OpcionDto resultado= new OpcionDto();
        try
        {
            DaoOpcion dao = new DaoOpcion();
            Opcion opcion= new Opcion();
            opcion.set_descripcion(opcionDto.getDescripcion());
            opcion.set_estatus(opcionDto.getEstatus());
            Pregunta pregunta= new Pregunta(opcionDto.getPreguntaDto().getId());
            opcion.set_pregunta(pregunta);

            Opcion resul= dao.insert(opcion);

            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }


    @DELETE
    @Path( "/{id}" )
    public OpcionDto deleteOpcion(@PathParam("id") long  _id){
        OpcionDto resultado= new OpcionDto();

        try{
            DaoOpcion dao= new DaoOpcion();
            Opcion opcion= new Opcion();
            Class<Opcion> type = Opcion.class;
            opcion= dao.find(_id,type);
            opcion.set_estatus("I");
            Opcion resul= dao.update(opcion);
            resultado.setId(resul.get_id());

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }


        return resultado;
    }


    @GET
    @Path("/{id}")
    public OpcionDto consultarTipoPregunta(@PathParam("id") long  _id ){
        OpcionDto resultado= new OpcionDto();

        try{

            DaoOpcion dao= new DaoOpcion();

            Opcion opcion= new Opcion();
            Class<Opcion> type = Opcion.class;


            opcion= dao.find(_id,type);


            resultado.setId(opcion.get_id());
            resultado.setEstatus(opcion.get_estatus());
            resultado.setDescripcion(opcion.get_descripcion());

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }


        return resultado;
    }


    @PUT
    @Path( "/updatePregunta/{id}" )
    public OpcionDto updateOpcion(@PathParam("id") long  _id, OpcionDto opcionDto ){

        OpcionDto resultado= new OpcionDto();
        try{
            DaoOpcion dao = new DaoOpcion();
            Opcion opcion= dao.find(_id, Opcion.class);

            opcion.set_descripcion(opcionDto.getDescripcion());
            opcion.set_estatus(opcionDto.getEstatus());

            Pregunta pregunta= new Pregunta(opcionDto.getPreguntaDto().getId());
            opcion.set_pregunta(pregunta);
            Opcion resul= dao.update(opcion);
            resultado.setId(resul.get_id());

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }

        return resultado;
    }



}