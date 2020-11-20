package ucab.dsw.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Encuesta implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fechacreacion", nullable = false)
    private Date fechacreacion;

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    @Basic
    @Column(name = "estatus", nullable = false)
    private String estatus;

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @JoinColumn(name = "idUsuario_Creador", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuarioCreador;

    public Usuario getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(Usuario usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    @JoinColumn(name = "idUsuario_Analista", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuarioAnalista;

    public Usuario getUsuarioAnalista() {
        return usuarioAnalista;
    }

    public void setUsuarioAnalista(Usuario usuarioAnalista) {
        this.usuarioAnalista = usuarioAnalista;
    }

    @JoinColumn(name = "idEstudio", referencedColumnName = "id")
    @ManyToOne
    private Estudio estudio;

    public Estudio getEstudio() {
        return estudio;
    }

    public void setEstudio(Estudio estudio) {
        this.estudio = estudio;
    }

    public Encuesta(){

    }

    public Encuesta(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Encuesta{" +
                "id=" + id +
                ", fechacreacion=" + fechacreacion +
                ", estatus='" + estatus + '\'' +
                '}';
    }
}
