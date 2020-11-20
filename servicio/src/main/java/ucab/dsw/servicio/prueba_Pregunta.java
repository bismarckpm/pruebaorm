package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoPregunta;
import ucab.dsw.dtos.PreguntaDto;
import ucab.dsw.entidades.Pregunta;
import ucab.dsw.entidades.SubCategoria;
import ucab.dsw.entidades.TipoPregunta;
import ucab.dsw.entidades.Usuario;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path( "/prueba" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class prueba_Pregunta extends AplicacionBase{
    @PUT
    @Path( "/addpregunta" )
    public PreguntaDto addPregunta(PreguntaDto PreguntaDto ) throws Exception {
        PreguntaDto resultado = new PreguntaDto();
        try {
            DaoPregunta dao = new DaoPregunta();
            Pregunta pregunta = new Pregunta();

            pregunta.set_pregunta(PreguntaDto.getPregunta());
            pregunta.set_fechacreacion(PreguntaDto.getFechacreacion());
            pregunta.set_estatus(PreguntaDto.getEstatus() );
            TipoPregunta idtipopregunta = new TipoPregunta(PreguntaDto.getIdTipoPregunta().getId());
            pregunta.set_idTipoPregunta(idtipopregunta);
            SubCategoria idsubcategoria = new SubCategoria(PreguntaDto.getIdSubCategoria().getId());
            pregunta.set_idSubCategoria(idsubcategoria);
            Usuario idusuario = new Usuario(PreguntaDto.getIdUsuario().getId());
            pregunta.set_idUsuario(idusuario);

            Pregunta resul = dao.insert( pregunta );
            resultado.setId( resul.get_id() );
        } catch ( Exception ex ) {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @PUT
    @Path( "/changepregunta" )
    public PreguntaDto changePregunta( PreguntaDto PreguntaDto ) throws Exception
    {
        PreguntaDto resultado = new PreguntaDto();
        try  {
            DaoPregunta dao = new DaoPregunta();
            Pregunta pregunta = new Pregunta(PreguntaDto.getId());

            pregunta.set_pregunta(PreguntaDto.getPregunta());
            pregunta.set_fechacreacion(PreguntaDto.getFechacreacion());
            pregunta.set_estatus(PreguntaDto.getEstatus() );
            TipoPregunta idtipopregunta = new TipoPregunta(PreguntaDto.getIdTipoPregunta().getId());
            pregunta.set_idTipoPregunta(idtipopregunta);
            SubCategoria idsubcategoria = new SubCategoria(PreguntaDto.getIdSubCategoria().getId());
            pregunta.set_idSubCategoria(idsubcategoria);
            Usuario idusuario = new Usuario(PreguntaDto.getIdUsuario().getId());
            pregunta.set_idUsuario(idusuario);

            Pregunta resul = dao.update( pregunta );
            resultado.setId( resul.get_id() );
        } catch ( Exception ex ) {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @PUT
    @Path( "/{id}" )
    public PreguntaDto deletePregunta( long id )
    {
        PreguntaDto resultado = new PreguntaDto();
        try {
            DaoPregunta dao = new  DaoPregunta();
            Pregunta delete = dao.find( id,Pregunta.class );
            Pregunta resul = dao.delete( delete);
            resultado.setId( resul.get_id() );
        } catch ( Exception ex ) {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @PUT
    @Path( "/{id}" )
    public PreguntaDto findPregunta(long id ) {
        PreguntaDto resultado = new PreguntaDto();
        try {
            DaoPregunta dao = new  DaoPregunta();
            Pregunta resul = dao.find( id,Pregunta.class );
            resultado.setId( resul.get_id() );
        } catch ( Exception ex ) {
            String problema = ex.getMessage();
        }
        return  resultado;
    }
}
