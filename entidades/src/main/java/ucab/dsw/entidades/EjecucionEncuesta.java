package ucab.dsw.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table( name = "ejecucionencuesta" )
public class EjecucionEncuesta extends EntidadBase{
    
    public EjecucionEncuesta ( long id ){
        super( id );
    }

    public EjecucionEncuesta (){

    }
    
    @ManyToOne
    @Column( name = "idEncuesta" )
    private Encuesta _encuesta;
    
//    @ManyToOne
//    @JoinColumn( name = "idPregunta" )
//    private Pregunta _pregunta;
    
    @ManyToOne
    @JoinColumn( name = "idUsuario_Encuestado" )
    private Usuario _usuarioEncuestado;
    
    @ManyToOne
    @JoinColumn( name = "idOpcion" )
    private opcion _opcion;
    
    @Column( name = "respuesta" )
    private String _respuesta;

    public Encuesta getEncuesta() {
        return _encuesta;
    }

    public void setEncuesta(Encuesta _encuesta) {
        this._encuesta = _encuesta;
    }

//    public Pregunta getPregunta() {
//        return _pregunta;
//    }
//
//    public void setPregunta(Pregunta _pregunta) {
//        this._pregunta = _pregunta;
//    }

    public Usuario getUsuarioEncuestado() {
        return _usuarioEncuestado;
    }

    public void setUsuarioEncuestado(Usuario _usuarioEncuestado) {
        this._usuarioEncuestado = _usuarioEncuestado;
    }

    public opcion getOpcion() {
        return _opcion;
    }

    public void setOpcion(opcion _opcion) {
        this._opcion = _opcion;
    }

    public String getRespuesta() {
        return _respuesta;
    }

    public void setRespuesta(String _respuesta) {
        this._respuesta = _respuesta;
    }
    
}
