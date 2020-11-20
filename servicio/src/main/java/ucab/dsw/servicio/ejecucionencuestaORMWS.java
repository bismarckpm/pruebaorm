package ucab.dsw.servicio;
import jdk.nashorn.internal.objects.annotations.Getter;
import ucab.dsw.accesodatos.*;
import ucab.dsw.dtos.*;
import ucab.dsw.entidades.TipoPregunta;
import ucab.dsw.entidades.TipoUsuario;
import ucab.dsw.entidades.Usuario;

import ucab.dsw.entidades.Opcion;
import ucab.dsw.entidades.Pregunta;
import ucab.dsw.entidades.EjecucionEncuesta;
import ucab.dsw.entidades.Encuesta;


import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


@Path( "/Opcion" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class ejecucionencuestaORMWS extends AplicacionBase{

    @PUT
    @Path( "/addejecucion" )
    public EjecucionencuestaDto addejecucion(EjecucionencuestaDto ejecucionencuestaDto)
    {
        EjecucionencuestaDto resultado =new EjecucionencuestaDto();

        try
        {
            DaoEjecucionEncuesta dao = new DaoEjecucionEncuesta();
            EjecucionEncuesta ejecucionEncuesta= new EjecucionEncuesta();
            ejecucionEncuesta.set_estatus(ejecucionencuestaDto.getEstatus());
            ejecucionEncuesta.set_respuesta(ejecucionencuestaDto.getRespuesta());
            Opcion opcion= new Opcion(ejecucionencuestaDto.getOpcionDto().getId());
            Encuesta encuesta= new Encuesta(ejecucionencuestaDto.getEncuestaDto().getId());
            Pregunta pregunta= new Pregunta(ejecucionencuestaDto.getPreguntaDto().getId());
            Usuario usuario= new Usuario(ejecucionencuestaDto.getUsuarioDto().getId());

            ejecucionEncuesta.set_opcion(opcion);
            ejecucionEncuesta.set_encuesta(encuesta);
            ejecucionEncuesta.set_pregunta(pregunta);
            ejecucionEncuesta.set_usuario(usuario);

            EjecucionEncuesta resul= dao.insert(ejecucionEncuesta);

            resultado.setId(resul.get_id());
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }



    @DELETE
    @Path( "/{id}"  )
    public EjecucionencuestaDto deleteejecucion(@PathParam("id") long  _id){
        EjecucionencuestaDto resultado= new EjecucionencuestaDto();

        try{
            DaoEjecucionEncuesta dao= new DaoEjecucionEncuesta();
            EjecucionEncuesta ejecucionEncuesta= new EjecucionEncuesta();
            Class<EjecucionEncuesta> type = EjecucionEncuesta.class;
            ejecucionEncuesta= dao.find(_id,type);

            ejecucionEncuesta.set_estatus("C");
            EjecucionEncuesta resul= dao.update(ejecucionEncuesta);
            resultado.setId(resul.get_id());

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }


        return resultado;
    }


    @GET
    @Path( "/{id}"  )
    public EjecucionencuestaDto consultarEjecucion(@PathParam("id") long  _id){
        EjecucionencuestaDto resultado= new EjecucionencuestaDto();

        try{
            DaoEjecucionEncuesta dao= new DaoEjecucionEncuesta();
            EjecucionEncuesta ejecucionEncuesta= new EjecucionEncuesta();
            Class<EjecucionEncuesta> type = EjecucionEncuesta.class;
            ejecucionEncuesta= dao.find(_id,type);

            resultado.setRespuesta(ejecucionEncuesta.get_respuesta());
            resultado.setEstatus(ejecucionEncuesta.get_respuesta());

            resultado.setId(ejecucionEncuesta.get_id());

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }


        return resultado;
    }


    @PUT
    @Path( "/update/{id}" )
    public EjecucionencuestaDto actualizarejecucion(@PathParam("id") long  _id, EjecucionencuestaDto ejecucionencuestaDto)
    {
        EjecucionencuestaDto resultado =new EjecucionencuestaDto();

        try
        {

            DaoEjecucionEncuesta dao= new DaoEjecucionEncuesta();
            EjecucionEncuesta ejecucionEncuesta= new EjecucionEncuesta();
            Class<EjecucionEncuesta> type = EjecucionEncuesta.class;
            ejecucionEncuesta= dao.find(_id,type);

            ejecucionEncuesta.set_respuesta(ejecucionencuestaDto.getRespuesta());
            ejecucionEncuesta.set_estatus(ejecucionencuestaDto.getEstatus());
            EjecucionEncuesta resul= dao.update(ejecucionEncuesta);
            resultado.setId(resul.get_id());
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }





}
