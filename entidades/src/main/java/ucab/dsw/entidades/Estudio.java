package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table( name = "estudio")
public class Estudio extends EntidadBase {

    @Column(name = "fechacreacion")
    private Date _fechacreacion;

    public Date get_fechacreacion() {return _fechacreacion;}
    public void set_fechacreacion(Date _fechacreacion) {
        this._fechacreacion = _fechacreacion;
    }

    @Column(name = "estatus")
    private String _estatus;

    @Override
    public String get_estatus() {
        return super.get_estatus();
    }
    @Override
    public void set_estatus(String _estatus) {
        super.set_estatus(_estatus);
    }


    //ManyToOne
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario _usuario;

    public Usuario get_usuario() {
        return _usuario;
    }
    public void set_usuario(Usuario _usuario) {
        this._usuario = _usuario;
    }

    @ManyToOne
    @JoinColumn(name = "idSolicitud")
    private Solicitud _solicitud;

    public Solicitud get_solicitud() {
        return _solicitud;
    }
    public void set_solicitud(Solicitud _solicitud) {
        this._solicitud = _solicitud;
    }


    @OneToMany( mappedBy = "_estudio", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Encuesta> _encuesta;

    public List<Encuesta> get_encuesta()
    {
        return _encuesta;
    }
    public void set_encuesta( List<Encuesta> _encuesta )
    {
        this._encuesta = _encuesta;
    }



    public  Estudio(long id) {
        super(id);
    }

    public Estudio() {

    }
}
