package ucab.dsw.entidades;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table( name = "encuesta" )
public class Encuesta extends EntidadBase{

    @Column(name = "fechacreacion")
    private Date _fechacreacion;

    @Column(name = "estatus")
    private String _estatus;

    @ManyToOne
    @JoinColumn( name = "idUsuario_Creador" )
    private Usuario _idUsuario_Creador;

    @ManyToOne
    @JoinColumn( name = "idUsuario_Analista" )
    private Usuario _idUsuario_Analista;

    @ManyToOne
    @JoinColumn( name = "idEstudio" )
    private Estudio _idEstudio;

    public Date get_fechacreacion() {
        return _fechacreacion;
    }

    public void set_fechacreacion(Date _fechacreacion) {
        this._fechacreacion = _fechacreacion;
    }

    public Usuario get_idUsuario_Creador() {
        return _idUsuario_Creador;
    }

    public void set_idUsuario_Creador(Usuario _idUsuario_Creador) {
        this._idUsuario_Creador = _idUsuario_Creador;
    }

    public Usuario get_idUsuario_Analista() {
        return _idUsuario_Analista;
    }

    public void set_idUsuario_Analista(Usuario _idUsuario_Analista) {
        this._idUsuario_Analista = _idUsuario_Analista;
    }

    public Estudio get_idEstudio() { return _idEstudio; }

    public void set_idEstudio(Estudio _idEstudio) {
        this._idEstudio = _idEstudio;
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
