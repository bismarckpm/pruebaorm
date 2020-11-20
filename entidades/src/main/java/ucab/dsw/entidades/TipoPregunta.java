package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.List;

@Entity

@Table(name = "tipopregunta")
public class TipoPregunta extends EntidadBase{

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estatus")
    private String estatus;

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    @OneToMany( mappedBy = "_tipopregunta", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Pregunta>  preguntas;

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoPregunta( long id )
    {
        super( id );
    }

    public TipoPregunta() {
    }
}
