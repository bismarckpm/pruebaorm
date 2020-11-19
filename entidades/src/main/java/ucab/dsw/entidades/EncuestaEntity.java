package ucab.dsw.entidades;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "encuesta", schema = "taller", catalog = "")
public class EncuestaEntity {
    private int id;
    private int idUsuarioCreador;
    private Integer idUsuarioAnalista;
    private int idEstudio;
    private Date fechacreacion;
    private String estatus;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "idUsuario_Creador")
    public int getIdUsuarioCreador() {
        return idUsuarioCreador;
    }

    public void setIdUsuarioCreador(int idUsuarioCreador) {
        this.idUsuarioCreador = idUsuarioCreador;
    }

    @Basic
    @Column(name = "idUsuario_Analista")
    public Integer getIdUsuarioAnalista() {
        return idUsuarioAnalista;
    }

    public void setIdUsuarioAnalista(Integer idUsuarioAnalista) {
        this.idUsuarioAnalista = idUsuarioAnalista;
    }

    @Basic
    @Column(name = "idEstudio")
    public int getIdEstudio() {
        return idEstudio;
    }

    public void setIdEstudio(int idEstudio) {
        this.idEstudio = idEstudio;
    }

    @Basic
    @Column(name = "fechacreacion")
    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    @Basic
    @Column(name = "estatus")
    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EncuestaEntity that = (EncuestaEntity) o;
        return id == that.id &&
                idUsuarioCreador == that.idUsuarioCreador &&
                idEstudio == that.idEstudio &&
                Objects.equals(idUsuarioAnalista, that.idUsuarioAnalista) &&
                Objects.equals(fechacreacion, that.fechacreacion) &&
                Objects.equals(estatus, that.estatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idUsuarioCreador, idUsuarioAnalista, idEstudio, fechacreacion, estatus);
    }
}
