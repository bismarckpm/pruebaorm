package ucab.dsw.entidades;


import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "solicitud" )
public class Solicitud extends EntidadBase{

    @OneToMany( mappedBy = "_solicitud", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Estudio> _estudios;

    public Solicitud(long id) {
        super(id);
    }

    public Solicitud() {
    }
}
