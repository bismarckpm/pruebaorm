package ucab.dsw.entidades;

import javax.persistence.*;

@Entity
@Table(name = "ejecucionencuesta")
public class EjecucionEncuesta extends EntidadBase{
    @Column(name = "respuesta")
    private String respuesta;

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    @ManyToOne
    @JoinColumn(name = "idEncuesta")
    private Encuesta _encuesta;

    @ManyToOne
    @JoinColumn(name = "idPregunta")
    private Pregunta _pregunta;

    @ManyToOne
    @JoinColumn(name = "idUsuario_Encuestado")
    private Usuario _usuarioEncuestado;

    @ManyToOne
    @JoinColumn(name = "idOpcion", nullable = true)
    private Opcion _opcion;

    public Encuesta get_encuesta() {
        return _encuesta;
    }

    public void set_encuesta(Encuesta _encuesta) {
        this._encuesta = _encuesta;
    }

    public Pregunta get_pregunta() {
        return _pregunta;
    }

    public void set_pregunta(Pregunta _pregunta) {
        this._pregunta = _pregunta;
    }

    public Usuario get_usuarioEncuestado() {
        return _usuarioEncuestado;
    }

    public void set_usuarioEncuestado(Usuario _usuarioEncuestado) {
        this._usuarioEncuestado = _usuarioEncuestado;
    }

    public Opcion get_opcion() {
        return _opcion;
    }

    public void set_opcion(Opcion _opcion) {
        this._opcion = _opcion;
    }

    public EjecucionEncuesta(long id) {
        super(id);
    }

    public EjecucionEncuesta() {
    }
}
