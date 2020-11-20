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
import java.sql.Date;

@Entity
@Table( name = "ejecucionencuesta" )
public class EjecucionEncuesta extends EntidadBase{

    @Column( name = "respuesta" )
    private String _respuesta;

    @Column( name = "estatus" )
    private String _estatus;

    @ManyToOne
    @JoinColumn( name = "idEncuesta" )
    private Encuesta _encuesta;

    @ManyToOne
    @JoinColumn( name = "idPregunta" )
    private Pregunta _pregunta;

    @ManyToOne
    @JoinColumn( name = "idUsuario_Encuestado" )
    private Usuario _usuario;

    @ManyToOne
    @JoinColumn( name = "idOpcion" )
    private Opcion _opcion;

    public String get_respuesta() {
        return _respuesta;
    }

    public Opcion get_opcion() {
        return _opcion;
    }

    public void set_opcion(Opcion _opcion) {
        this._opcion = _opcion;
    }

    public Usuario get_usuario() {
        return _usuario;
    }

    public void set_usuario(Usuario _usuario) {
        this._usuario = _usuario;
    }

    public Pregunta get_pregunta() {
        return _pregunta;
    }

    public void set_pregunta(Pregunta _pregunta) {
        this._pregunta = _pregunta;
    }

    @Override
    public String get_estatus() {
        return _estatus;
    }

    public Encuesta get_encuesta() {
        return _encuesta;
    }

    public void set_encuesta(Encuesta _encuesta) {
        this._encuesta = _encuesta;
    }

    @Override
    public void set_estatus(String _estatus) {
        this._estatus = _estatus;
    }

    public void set_respuesta(String _respuesta) {
        this._respuesta = _respuesta;
    }

    public EjecucionEncuesta(long id )
    {
        super( id );
    }

    public EjecucionEncuesta()
    {

    }
}