package ucab.dsw.servicio;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import ucab.dsw.accesodatos.DaoOpcion;
import ucab.dsw.dtos.OpcionDto;
import ucab.dsw.entidades.Opcion;

/**
 *
 * @author Omar David
 */
public class PruebaOpcion {
    @PUT
    @Path("/addopcion")
    public OpcionDto addOpcion (OpcionDto opcionDto){
        OpcionDto resultado = new OpcionDto();
        
        try {
            DaoOpcion dao = new DaoOpcion();
            Opcion opcion = new Opcion();
            opcion.setDescripcion(opcionDto.getDescripcion());
            opcion.set_estatus(opcionDto.getEstatus());
//            Pregunta pregunta = new Pregunta(opcionDto.getPreguntaDto().getId());
//            opcion.setIdPregunta(pregunta);
            Opcion resul = dao.insert(opcion);
            resultado.setId(resul.get_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }
    
}
