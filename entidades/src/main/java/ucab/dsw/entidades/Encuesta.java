package ucab.dsw.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table( name = "encuesta" )
public class Encuesta extends EntidadBase {
    @Column(name="fechacreacion")
    private Date fechacreacion;

    @ManyToOne
    @JoinColumn(name="idEstudio")
    private Estudio estudio;

    @ManyToOne
    @JoinColumn(name="idUsuario_Creador")
    private Usuario idUsuarioCreador;

    @ManyToOne
    @JoinColumn(name="idUsuario_Analista")
    private Usuario idUsuarioAnalista;

    public void setFechacreacion(Date FC){this.fechacreacion=FC;}
    public Date getFechacreacion(){return this.fechacreacion;}

    public void setIdEstudio(Estudio E){this.estudio=E;}
    public Estudio getidEstudio(){return this.estudio;}

    public void setidUsuarioCreador(Usuario UC){this.idUsuarioCreador=UC;}
    public Usuario getidUsuarioCreador(){return this.idUsuarioCreador;}

    public void setidUsuarioAnalista(Usuario UA){this.idUsuarioAnalista=UA;}
    public Usuario getidUsuarioAnalista(){return this.idUsuarioAnalista;}

    public Encuesta(long id){super(id);}
    public Encuesta(){}

}
