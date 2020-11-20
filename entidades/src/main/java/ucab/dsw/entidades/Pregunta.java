package ucab.dsw.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Pregunta implements Serializable {
    public static final long serialVersionUID = 1L;

    private int id;
    private String pregunta;
    private Date fechacreacion;
    private String estatus;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "pregunta", nullable = false, length = 345)
    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    @Basic
    @Column(name = "fechacreacion", nullable = false)
    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    @Basic
    @Column(name = "estatus", nullable = false)
    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @JoinColumn(name = "idTipoPregunta", referencedColumnName = "id")
    @ManyToOne
    private Tipopregunta tipopregunta;

    @JoinColumn(name = "idSubcategoria", referencedColumnName = "id")
    @ManyToOne
    private Subcategoria subcategoria;

    @JoinColumn(name = "idUsuario", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuario;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pregunta pregunta1 = (Pregunta) o;
        return id == pregunta1.id &&
                Objects.equals(pregunta, pregunta1.pregunta) &&
                Objects.equals(fechacreacion, pregunta1.fechacreacion) &&
                Objects.equals(estatus, pregunta1.estatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pregunta, fechacreacion, estatus);
    }
}
