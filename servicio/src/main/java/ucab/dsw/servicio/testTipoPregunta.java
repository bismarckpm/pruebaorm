package ucab.dsw.servicio;

import jdk.nashorn.internal.objects.annotations.Getter;
import ucab.dsw.accesodatos.DaoTipoPregunta;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.entidades.TipoPregunta;

import javax.faces.push.Push;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path( "/tipopregunta" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class testTipoPregunta extends AplicacionBase {


    @PUT
    @Path( "/addtipopregunta" )
    public TipoPreguntaDto addTipoPregunta(TipoPreguntaDto tipoPreguntaDto)
    {
        TipoPreguntaDto resultado = new TipoPreguntaDto();
        try
        {
            DaoTipoPregunta dao = new DaoTipoPregunta();
            TipoPregunta tipoPregunta = new TipoPregunta();
            tipoPregunta.set_descripcion( tipoPreguntaDto.getDescripcion() );
            tipoPregunta.set_estatus( tipoPreguntaDto.getEstatus() );
            TipoPregunta resul = dao.insert( tipoPregunta );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @PUT
    @Path( "/changetipopregunta/{id}" )
    public TipoPreguntaDto changeTipoPregunta(TipoPreguntaDto tipoPreguntaDto ) throws Exception
    {
        TipoPreguntaDto resultado = new TipoPreguntaDto();
        try
        {
            DaoTipoPregunta dao = new DaoTipoPregunta();
            TipoPregunta tipoPregunta = new TipoPregunta(tipoPreguntaDto.getId());
            tipoPregunta.set_descripcion( tipoPreguntaDto.getDescripcion() );
            tipoPregunta.set_estatus( tipoPreguntaDto.getEstatus() );
            TipoPregunta resul = dao.update( tipoPregunta );
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
    public TipoPreguntaDto deleteTipoPregunta( long id )
    {
        TipoPreguntaDto resultado = new TipoPreguntaDto();

        try {
            DaoTipoPregunta dao = new DaoTipoPregunta();
            TipoPregunta findid = dao.find(id,TipoPregunta.class);
            TipoPregunta deleteid = dao.delete(findid);
            resultado.setId( deleteid.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path("/findtipopregunta/{id}")
    public TipoPreguntaDto findTipoPregunta (long id)
    {
        TipoPreguntaDto resultado = new TipoPreguntaDto();

        try {
            DaoTipoPregunta dao = new DaoTipoPregunta();
            TipoPregunta findid = dao.find(id,TipoPregunta.class);
            resultado.setId(findid.get_id());
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return resultado;
    }







}
