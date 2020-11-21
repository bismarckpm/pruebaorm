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
@Table( name = "encuesta" )
public class Encuesta extends EntidadBase{

    @ManyToOne
    @JoinColumn( name = "idUsuario_Creador" )
    private Usuario _usuarioC;

    @ManyToOne
    @JoinColumn( name = "idUsuario_Analista" )
    private Usuario _usuarioA;

    @ManyToOne
    @JoinColumn( name = "idEstudio" )
    private Estudio _estudio;


    @Column( name = "fechacreacion" )
    private Date _fechaCreacion;

    @Column( name = "estatus" )
    private String _estatus;

    public Encuesta( long id )
    {
        super( id );
    }

    public Encuesta()
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

    public Usuario get_usuarioC()
    {
        return _usuarioC;
    }

    public void set_usuarioC( Usuario _usuariocreador )
    {
        this._usuarioC = _usuarioC;
    }

    public Usuario get_usuarioA()
    {
        return _usuarioA;
    }

    public void set_usuarioA( Usuario _usuarioanalista )
    {
        this._usuarioA= _usuarioA;
    }

    public Estudio get_estudio()
    {
        return _estudio;
    }

    public void set_estudio( Estudio _estudio )
    {
        this._estudio = _estudio;
    }


}