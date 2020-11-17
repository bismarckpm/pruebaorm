package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="solicitud")
public class Solicitud extends EntidadBase {

    @Column(name = "nombre")
    private String _nombre;

    @Column(name = "fecha")
    private Date _fecha;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario _usuarioSolicitud;

    @ManyToOne
    @JoinColumn(name = "idSubCategoria")
    private Subcategoria _subcategoria;

    @OneToMany( mappedBy = "_solicitud", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Estudio> _estudios;

    public Solicitud(long id) {
        super(id);
    }

    public Solicitud() {
    }
}
