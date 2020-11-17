package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="estudio")
public class Encuesta extends EntidadBase {

    @Column(name = "fechacreacion")
    private Date _fechacreacion;

    @ManyToOne
    @JoinColumn(name = "idUsuario_Creador")
    private Usuario _usuarioCreador;

    @ManyToOne
    @JoinColumn(name = "idUsuario_Analista")
    private Usuario _usuarioAnalista;

    @ManyToOne
    @JoinColumn(name = "idEstudio")
    private Estudio _estudio;

    public Encuesta(long id) {
        super(id);
    }

    public Encuesta() {
    }
}
