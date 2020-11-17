package ucab.dsw.entidades;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="estudio")
public class Estudio extends EntidadBase {

    @Column(name = "fechacreacion")
    private Date _fechacreacion;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario _usuarioEstudio;

    @ManyToOne
    @JoinColumn(name = "idSolicitud")
    private Solicitud _solicitud;

    @OneToMany( mappedBy = "_estudio", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Encuesta> _encuestas;

    public Estudio(long id) {
        super(id);
    }

    public Estudio() {
    }
}



