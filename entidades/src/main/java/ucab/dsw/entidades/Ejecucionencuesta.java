package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ejecucionencuesta")
public class Ejecucionencuesta extends EntidadBase {

    @Column(name = "respuesta", nullable = false)
    private String _respuesta;

    @ManyToOne
    @JoinColumn(name = "idEncuesta")
    private Encuesta encuesta;
    @ManyToOne
    @JoinColumn(name = "idPregunta")
    private Pregunta pregunta;
    @ManyToOne
    @JoinColumn(name = "idOpcion")
    private Opcion opcion;
    @ManyToOne
    @JoinColumn(name = "idUsuario_Encuestado ")
    private Usuario usuarioEncuest;

    public String get_respuesta() {
        return _respuesta;
    }
    public void set_respuesta(String _descripcion) {
        this._respuesta = _respuesta;
    }

    public Encuesta getIdencuesta(){return this.encuesta;}
    public void setIdencuesta(Encuesta U){this.encuesta=U;}

    public Pregunta getIdpregunta(){return this.pregunta;}
    public void setIdpregunta(Pregunta U){this.pregunta=U;}

    public Opcion getIdopcion(){return this.opcion;}
    public void setIdopcion(Opcion U){this.opcion=U;}

    public Usuario getIdencuestado(){return this.usuarioEncuest;}
    public void setIdencuestado(Usuario UE){this.usuarioEncuest=UE;}

    public Ejecucionencuesta(long id) {super(id);}
    public Ejecucionencuesta() {}
}


