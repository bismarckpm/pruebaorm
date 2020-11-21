package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "estudio" )
public class Estudio extends EntidadBase {

    @Temporal(TemporalType.TIMESTAMP)
    @Column( name = "fechacreacion")
    private Date _fechaCreacion;

    @ManyToOne
    @JoinColumn( name = "idSolicitud" )
    private Solicitud _solicitud;

    @ManyToOne
    @JoinColumn( name = "idUsuario" )
    private Usuario _usuario;

    @Column( name = "estatus" )
    private String _estatus;

    public Estudio(long id) {
        super(id);
    }

    public Estudio() {
    }

    public Date get_fechaCreacion() {
        return _fechaCreacion;
    }

    public void set_fechaCreacion(Date _fechaCreacion) {
        this._fechaCreacion = _fechaCreacion;
    }

    public Solicitud get_solicitud() {
        return _solicitud;
    }

    public void set_solicitud(Solicitud _solicitud) {
        this._solicitud = _solicitud;
    }

    public Usuario get_Usuario() {
        return _usuario;
    }

    public void set_Usuario(Usuario _Usuario) {
        this._usuario = _Usuario;
    }

    @Override
    public String get_estatus()
    {
        return _estatus;
    }

    @Override
    public void set_estatus( String _estatus )
    {
        this._estatus = _estatus;
    }

    }
