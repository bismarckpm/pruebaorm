package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoTipoPregunta;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.entidades.TipoPregunta;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


public class TipoPreguntaORMWS {
/*
    @POST
    @Path( "/add" )
    public TipoPreguntaDto add(TipoPreguntaDto tipoPreguntaDto ) {

        TipoPreguntaDto resultado = new TipoPreguntaDto();
        try{

            DaoTipoPregunta dao = new DaoTipoPregunta();
            TipoPregunta tipoPregunta = new TipoPregunta();

            tipoPregunta.setDescripcion(tipoPreguntaDto.getDescripcion());
            tipoPregunta.setStatus(tipoPreguntaDto.getStatus());

            TipoPregunta result = dao.insert(tipoPregunta);

            resultado.setId(result.get_id());

            return resultado;




            DaoUsuario dao = new DaoUsuario();
            Usuario usuario = new Usuario();

            usuario.set_nombre( usuarioDto.getNombre() );
            usuario.set_apellido( usuarioDto.getApellido() );
            usuario.set_estatus( usuarioDto.getEstatus() );
            usuario.set_correoelectronico( usuarioDto.getCorreoelectronico() );

            TipoUsuario tipoUsuario = new TipoUsuario(usuarioDto.getTipoUsuarioDto().getId());

            usuario.set_tipousuario( tipoUsuario );
            Usuario resul = dao.insert( usuario );

            resultado.setId( resul.get_id() );

        }catch (Exception ex){

            String problema = ex.getMessage();

        }

        return resultado;
    }
    /*
    @DELETE
    @Path( "/delete" )
    public TipoPreguntaDto delete( Long id ) {

        TipoPreguntaDto resultado = new TipoPreguntaDto();

        try{
            DaoTipoPregunta dao = new DaoTipoPregunta();
            TipoPregunta tipoPregunta = dao.find(id, TipoPregunta.class);

            dao.delete(tipoPregunta);

            TipoPregunta firstTipoPegunta = dao.find(id, TipoPregunta.class);

            resultado.setId(firstTipoPegunta.getId());

            return resultado;


        }catch (Exception ex){
            String problema = ex.getMessage();
        }

        return resultado;
    }

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


    @GET
    @Path( "/first-one/{id}" )
    public TipoPreguntaDto getFirstOne(long id ) {

        TipoPreguntaDto tipoPreguntaDto = new TipoPreguntaDto();

        try{
            DaoTipoPregunta dao = new DaoTipoPregunta();

            TipoPregunta firstOneTipoPregunta = dao.find( id, TipoPregunta.class );
            tipoPreguntaDto.setId(firstOneTipoPregunta.getId());

            return tipoPreguntaDto;

        }catch (Exception ex ){

            String problema = ex.getMessage();

        }

        return tipoPreguntaDto;
    }
*/
}
