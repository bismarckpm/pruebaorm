package ucab.dsw.entidades;


import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "subcategoria")
public class SubCategoria extends EntidadBase{

    @OneToMany( mappedBy = "_subCategoria", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Pregunta> _preguntas;

    public SubCategoria(long id) {
        super(id);
    }

    public SubCategoria() {
    }
}
