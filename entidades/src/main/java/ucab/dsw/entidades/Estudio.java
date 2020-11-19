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
@Table( name = "estudio" )
public class Estudio extends EntidadBase{

    @Column(name = "fechacreacion")
    private Date fechaCreacion;

    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Usuario idusuario;

    @ManyToOne
    @JoinColumn(name="idSolicitud")
    private solicitud idsolicitud;

    @OneToMany(mappedBy = "estudio", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Encuesta> idestudio;

    public List<Encuesta> get_idestudio(){return this.idestudio;}
    public void set_idestudio( List<Encuesta> E ){this.idestudio = E;}

    public Date getFechaCreacion(){return this.fechaCreacion;}
    public void setFechaCreacion(Date FC){this.fechaCreacion=FC;}

    public Usuario getIdusuario(){return this.idusuario;}
    public void setIdusuario(Usuario U){this.idusuario=U;}

    public solicitud getIdsolicitud(){return this.idsolicitud;}
    public void setIdsolicitud(solicitud SO){this.idsolicitud=SO;}

    public Estudio(long id){super(id);}
    public Estudio(){}


}
