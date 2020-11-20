package ucab.dsw.servicio;
import ucab.dsw.accesodatos.DaoPregunta;
import ucab.dsw.accesodatos.DaoTipoUsuario;
import ucab.dsw.dtos.*;
import ucab.dsw.entidades.TipoPregunta;
import ucab.dsw.entidades.TipoUsuario;
import ucab.dsw.entidades.Usuario;
import ucab.dsw.entidades.Opcion;
import ucab.dsw.entidades.Pregunta;
import ucab.dsw.entidades.Subcategoria;


import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path( "/Pregunta" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class preguntasORMWS extends AplicacionBase{

    @PUT
    @Path( "/addPregunta" )
    public PreguntaDto addPregunta( PreguntaDto preguntaDto )
    {
        PreguntaDto resultado= new PreguntaDto();
        try
        {
            DaoPregunta dao= new DaoPregunta();
            Pregunta pregunta= new Pregunta();

            pregunta.set_estatus(preguntaDto.getEstatus());
            pregunta.set_pregunta(preguntaDto.getPregunta());
            pregunta.set_fecha(preguntaDto.getFechacreacion());

            TipoPregunta tipoPregunta= new TipoPregunta(preguntaDto.getTipoPreguntaDto().getId());
            Subcategoria subcategoria= new Subcategoria(preguntaDto.getSubCategoriaDto().getId());
            Usuario usuario= new Usuario(preguntaDto.getUsuarioDto().getId());

            pregunta.set_subcategoria(subcategoria);
            pregunta.set_tipopregunta(tipoPregunta);
            pregunta.set_usuario(usuario);


            Pregunta resul= dao.insert(pregunta);

            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }


    @DELETE
    @Path( "/{id}"  )
    public PreguntaDto deletePregunta(@PathParam("id") long  _id){
        PreguntaDto resultado= new PreguntaDto();
        try{
            DaoPregunta dao= new DaoPregunta();

            Pregunta pregunta= new Pregunta();
            Class<Pregunta> type = Pregunta.class;


            pregunta= dao.find(_id,type);
            pregunta.set_estatus("I");

            Pregunta resul= dao.update(pregunta);
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
    public PreguntaDto consultarPregunta(@PathParam("id") long  _id){

        PreguntaDto resultado= new PreguntaDto();


        try{

            DaoPregunta dao= new DaoPregunta();
            Pregunta pregunta= new Pregunta();


            Class<Pregunta> type = Pregunta.class;
            pregunta= dao.find(_id,type);

            resultado.setId(pregunta.get_id());
            resultado.setEstatus(pregunta.get_estatus());
            resultado.setFechacreacion(pregunta.get_fecha());
            resultado.setPregunta(pregunta.get_pregunta());

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return resultado;
    }


    @PUT
    @Path("/edit/{id}")
    public PreguntaDto updatePregunta(@PathParam("id") long  _id, PreguntaDto preguntaDto){

        PreguntaDto resultado= new PreguntaDto();
        try{
            DaoPregunta dao= new DaoPregunta();
            Pregunta pregunta= new Pregunta();

            Class<Pregunta> type = Pregunta.class;
            pregunta= dao.find(_id,type);

            pregunta.set_pregunta(preguntaDto.getPregunta());
            pregunta.set_fecha(preguntaDto.getFechacreacion());
            pregunta.set_estatus(preguntaDto.getEstatus());

            Pregunta resul= dao.update(pregunta);



            resultado.setId(resul.get_id());


        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return resultado;
    }

}
