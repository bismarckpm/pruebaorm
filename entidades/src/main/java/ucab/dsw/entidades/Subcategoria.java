package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="subcategoria")
public class Subcategoria extends EntidadBase{

    @Column(name = "descripcion")
    private String _descripcion;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria _categoria;

    @OneToMany( mappedBy = "_subcategoria", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Solicitud> _solicitudes;

    public Subcategoria(long id) {
        super(id);
    }

    public Subcategoria() {
    }
}
