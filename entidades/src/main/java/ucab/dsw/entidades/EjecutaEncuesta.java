package ucab.dsw.entidades;

import javax.persistence.*;

@Entity
@Table( name = "ejecucionencuesta" )
public class EjecutaEncuesta extends EntidadBase{

    @Column(name = "respuesta")
    private String _respuesta;

    @Column(name = "estatus")
    private String _estatus;

    @ManyToOne
    @JoinColumn(name = "idEncuesta")
    private Encuesta idEncuesta;

    @ManyToOne
    @JoinColumn( name = "idPregunta")
    private Pregunta idPregunta;

    @ManyToOne
    @JoinColumn(name = "idUsuario_Encuestado")
    private Usuario idUsuario_Encuestado;

    @ManyToOne
    @JoinColumn(name = "idOpcion" )
    private Opcion idOpcion;

    public String get_respuesta() {
        return _respuesta;
    }

    public void set_respuesta(String _respuesta) {
        this._respuesta = _respuesta;
    }

    @Override
    public String get_estatus() {
        return _estatus;
    }

    @Override
    public void set_estatus(String _estatus) {
        this._estatus = _estatus;
    }

    public Encuesta getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(Encuesta idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public Pregunta getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Pregunta idPregunta) {
        this.idPregunta = idPregunta;
    }

    public Usuario getIdUsuario_Encuestado() {
        return idUsuario_Encuestado;
    }

    public void setIdUsuario_Encuestado(Usuario idUsuario_Encuestado) {
        this.idUsuario_Encuestado = idUsuario_Encuestado;
    }

    public Opcion getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(Opcion idOpcion) {
        this.idOpcion = idOpcion;
    }
}
