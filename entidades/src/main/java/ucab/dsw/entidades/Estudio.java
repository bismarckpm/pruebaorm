package ucab.dsw.entidades;


import javax.persistence.*;
import java.util.Date;
import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table( name = "estudio" )
public class Estudio extends EntidadBase{

    @ManyToOne
    @JoinColumn( name = "idUsuario" )
    private Usuario _usuario;

    @ManyToOne
    @JoinColumn( name = "idSolicitud" )
    private Solicitud _solicitud;

    @Column( name = "fechaCreacion" )
    private Date _fechaCreacion;

    @Column( name = "estatus" )
    private String _estatus;

    public Estudio( long id )
    {
        super( id );
    }

    public Estudio()
    {

    }

    public Date get_fechaCreacion()
    {
        return _fechaCreacion;
    }

    public void set_fechaCreacion( Date _fechaCreacion )
    {
        this._fechaCreacion = _fechaCreacion;
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

    public Usuario get_usuario()
    {
        return _usuario;
    }

    public void set_usuario( Usuario _usuario )
    {
        this._usuario = _usuario;
    }

    public Solicitud get_solicitud()
    {
        return _solicitud;
    }

    public void set_solicitud( Solicitud _solicitud )
    {
        this._solicitud = _solicitud;
    }

}