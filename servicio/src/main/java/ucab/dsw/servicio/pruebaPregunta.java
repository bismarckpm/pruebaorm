package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoPregunta;
import ucab.dsw.dtos.PreguntaDto;
import ucab.dsw.entidades.Pregunta;
import ucab.dsw.entidades.TipoPregunta;


import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

public class pruebaPregunta {
    @PUT
    @Path( "/addPregunta" )
    public PreguntaDto addPregunta(PreguntaDto preguntaDto ) throws Exception {
        PreguntaDto resultado = new PreguntaDto();
        try
        {
            DaoPregunta dao = new DaoPregunta();
            Pregunta pregunta = new Pregunta();
            pregunta.setPregunta(preguntaDto.getPregunta());
            pregunta.setFechaCreacion(preguntaDto.getFechacreacion());
            pregunta.set_estatus(preguntaDto.getEstatus());
            TipoPregunta tipoPregunta = new TipoPregunta(preguntaDto.getTipoPreguntaDto().getId());
            pregunta.set_tipoPregunta(tipoPregunta);
            Pregunta resul = dao.insert( pregunta );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @PUT
    @Path( "/updatePregunta/{id}" )
    public PreguntaDto updatePregunta( PreguntaDto preguntaDto)
    {
        PreguntaDto resultado = new PreguntaDto();
        try
        {
            DaoPregunta dao = new DaoPregunta();
            Pregunta pregunta = new Pregunta(preguntaDto.getId());
            pregunta.setPregunta(preguntaDto.getPregunta());
            pregunta.setFechaCreacion(preguntaDto.getFechacreacion());
            pregunta.set_estatus(preguntaDto.getEstatus());
            TipoPregunta tipoPregunta = new TipoPregunta(preguntaDto.getTipoPreguntaDto().getId());
            pregunta.set_tipoPregunta(tipoPregunta);
            Pregunta resul = dao.update ( pregunta );
            resultado.setId(resul.get_id());

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @DELETE
    @Path( "/deletePregunta/{id}" )
    public PreguntaDto deletePregunta( PreguntaDto preguntaDto) {
        PreguntaDto resultado = new PreguntaDto();
        try {
            DaoPregunta daoPregunta = new DaoPregunta();
            Pregunta pregunta = daoPregunta.find(preguntaDto.getId(), Pregunta.class);
            Pregunta resul = daoPregunta.delete(pregunta);
            resultado.setId(resul.get_id());

        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }
}
