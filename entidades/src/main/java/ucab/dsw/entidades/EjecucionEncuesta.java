package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ejecucionencuesta")
public class EjecucionEncuesta extends EntidadBase{

    @Column(name ="respuesta")
    private String _respuesta;

    public String get_respuesta() {
        return _respuesta;
    }

    public void set_respuesta(String _respuesta) {
        this._respuesta = _respuesta;
    }

    @Column(name ="estatus")
    private String _estatus;

    public String get_estatus() {
        return _estatus;
    }

    public void set_estatus(String _estatus) {
        this._estatus = _estatus;
    }

    @ManyToOne
    @JoinColumn(name = "idEncuesta")
    private Encuesta _encuesta;

    @ManyToOne
    @JoinColumn(name = "idPregunta")
    private Pregunta _pregunta;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario _usuario;

    @ManyToOne
    @JoinColumn(name = "idOpcion")
    private Opcion _opcion;
}
