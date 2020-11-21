package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoTipoPregunta;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.entidades.TipoPregunta;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path( "/tipo-pregunta" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class TipoPreguntaORMWS {

    @POST
    @Path( "/add" )
    public TipoPreguntaDto add(TipoPreguntaDto tipoPreguntaDto ) {

        TipoPreguntaDto resultado = new TipoPreguntaDto();
        try{

            DaoTipoPregunta dao = new DaoTipoPregunta();
            TipoPregunta tipoPregunta = new TipoPregunta();

            tipoPregunta.setDescripcion(tipoPreguntaDto.getDescripcion());
            tipoPregunta.setEstatus(tipoPreguntaDto.getEstatus());

            TipoPregunta result = dao.insert(tipoPregunta);

            resultado.setId(result.get_id());

            return resultado;

        }catch (Exception ex){

            String problema = ex.getMessage();

        }

        return resultado;
    }

    @DELETE
    @Path( "/delete" )
    public TipoPreguntaDto delete( long id ) {

        TipoPreguntaDto resultado = new TipoPreguntaDto();

        try{
            DaoTipoPregunta dao = new DaoTipoPregunta();
            TipoPregunta tipoPregunta = dao.find(id, TipoPregunta.class);

            dao.delete(tipoPregunta);

            TipoPregunta firstTipoPegunta = dao.find(id, TipoPregunta.class);

            resultado.setId(firstTipoPegunta.get_id());

            return resultado;


        }catch (Exception ex){
            String problema = ex.getMessage();
        }

        return resultado;
    }

    @GET
    @Path( "/first-one/{id}" )
    public TipoPreguntaDto getFirstOne(long id ) {

        TipoPreguntaDto tipoPreguntaDto = new TipoPreguntaDto();

        try{
            DaoTipoPregunta dao = new DaoTipoPregunta();

            TipoPregunta firstOneTipoPregunta = dao.find( id, TipoPregunta.class );
            tipoPreguntaDto.setId(firstOneTipoPregunta.get_id());

            return tipoPreguntaDto;

        }catch (Exception ex ){

            String problema = ex.getMessage();

        }

        return tipoPreguntaDto;
    }

    /*
    @PUT
    @Path( "/update" )
    public TipoPreguntaDto update( TipoPreguntaDto tipoPreguntaDto ) {
        try {
            DaoTipoPregunta dao = new DaoTipoPregunta();

            TipoPregunta tipoPregunta = dao.find(tipoPreguntaDto.getId(), TipoPregunta.class);

            tipoPregunta.setStatus(tipoPreguntaDto.getStatus());
            tipoPregunta.setDescripcion(tipoPreguntaDto.getDescripcion());

            TipoPregunta resultado = dao.update(tipoPregunta);

            tipoPreguntaDto.setId(resultado.getId());

            return tipoPreguntaDto;

        }catch (Exception ex){
            String problema = ex.getMessage();
        }

        return tipoPreguntaDto;
    }

*/


}
