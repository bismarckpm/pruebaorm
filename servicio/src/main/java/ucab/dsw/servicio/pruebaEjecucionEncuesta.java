package ucab.dsw.servicio;

import ucab.dsw.accesodatos.*;
import ucab.dsw.dtos.*;
import ucab.dsw.entidades.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class pruebaEjecucionEncuesta extends AplicacionBase{

    @PUT
    @Path( "/addejecucionencuesta" )
    public EjecucionEncuestaDto addEjecucionEncuesta(EjecucionEncuestaDto ejecucionEncuestaDto )
    {
        EjecucionEncuestaDto resultado = new EjecucionEncuestaDto();
        try
        {
            DaoEjecucionEncuesta dao = new DaoEjecucionEncuesta();
            EjecucionEncuesta ejecucionEncuesta = new EjecucionEncuesta();
            ejecucionEncuesta.set_encuesta(ejecucionEncuesta.get_encuesta());
         // ejecucionEncuesta.set_pregunta(ejecucionEncuesta.get_pregunta());
            ejecucionEncuesta.set_usuarioencuestado(ejecucionEncuesta.get_usuarioencuestado());
            ejecucionEncuesta.set_opcion(ejecucionEncuesta.get_opcion());
            ejecucionEncuesta.set_respuesta(ejecucionEncuesta.get_respuesta());
            ejecucionEncuesta.set_estatus(ejecucionEncuesta.get_estatus());
            EjecucionEncuesta resul = dao.insert( ejecucionEncuesta );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path ("/listejecucionencuesta")
    public List<EjecucionEncuesta> listEjecucionEncuesta( )
    {
        List<EjecucionEncuesta> ejecuciones= null;
        try
        {
            DaoEjecucionEncuesta dao = new DaoEjecucionEncuesta();
            ejecuciones = dao.findAll(EjecucionEncuesta.class);
            for (EjecucionEncuesta ejecucionEncuesta: ejecuciones) {
                System.out.println("Id:" + ejecucionEncuesta.get_id());
                System.out.println("Encuesta:"+ejecucionEncuesta.get_encuesta());
                //   System.out.println("Pregunta:"+ejecucionEncuesta.get_pregunta() );
                System.out.println("Usuario:"+ejecucionEncuesta.get_usuarioencuestado() );
                System.out.println("Opcion:"+ejecucionEncuesta.get_opcion() );
                System.out.println("Estatus:"+ejecucionEncuesta.get_estatus() );
            }
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return ejecuciones;
    }

    @PUT
    @Path( "/updateejecucionencuesta/{id}" )
    public EjecucionEncuestaDto updateEjecucionEncuesta( EjecucionEncuestaDto ejecucionEncuestaDto)
    {
        EjecucionEncuestaDto resultado = new EjecucionEncuestaDto();
        try
        {
            DaoEjecucionEncuesta dao = new DaoEjecucionEncuesta();
            EjecucionEncuesta ejecucionEncuesta = new EjecucionEncuesta(ejecucionEncuestaDto.getId());
            ejecucionEncuesta.set_encuesta(ejecucionEncuesta.get_encuesta());
            //ejecucionEncuesta.set_pregunta(ejecucionEncuesta.get_pregunta());
            ejecucionEncuesta.set_usuarioencuestado(ejecucionEncuesta.get_usuarioencuestado());
            ejecucionEncuesta.set_opcion(ejecucionEncuesta.get_opcion());
            ejecucionEncuesta.set_respuesta(ejecucionEncuesta.get_respuesta());
            ejecucionEncuesta.set_estatus(ejecucionEncuesta.get_estatus());
            EjecucionEncuesta resul = dao.update (ejecucionEncuesta );
            resultado.setId(resul.get_id());

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @DELETE
    @Path( "/deleteejecucionencuesta/{id}" )
    public EjecucionEncuestaDto deleteEjecucionEncuesta( EjecucionEncuestaDto ejecucionEncuestaDto) {
        EjecucionEncuestaDto resultado = new EjecucionEncuestaDto();
        try {
            DaoEjecucionEncuesta dao = new DaoEjecucionEncuesta();
            EjecucionEncuesta ejecucionEncuesta = dao.find(ejecucionEncuestaDto.getId(), EjecucionEncuesta.class);
            EjecucionEncuesta resul = dao.delete( ejecucionEncuesta);
            resultado.setId(resul.get_id());

        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }

}
