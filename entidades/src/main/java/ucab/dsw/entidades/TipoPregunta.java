package ucab.dsw.entidades;


import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "tipopregunta")
public class TipoPregunta extends EntidadBase{

    @OneToMany( mappedBy = "_tipoPregunta", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Pregunta> _preguntas;

    public TipoPregunta(long id) {
        super(id);
    }

    public TipoPregunta() {
    }
}
