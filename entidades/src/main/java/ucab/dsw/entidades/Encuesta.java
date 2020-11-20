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

    @Column( name = "fechaCreacion" )
    private Date _fechaCreacion;

    @Column( name = "estatus" )
    private String _estatus;

    @ManyToOne
    @JoinColumn( name = "idUsuario_Creador" )
    private Usuario _usuariocreador;

    @ManyToOne
    @JoinColumn( name = "idUsuario_Analista" )
    private Usuario _usuarioanalista;

    @ManyToOne
    @JoinColumn( name = "idEstudio" )
    private Estudio _estudio ;

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

    public void set_fechaCreacion( Date _descripcion )
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

    public Usuario get_usuariocreador()
    {
        return _usuariocreador;
    }

    public void set_usuariocreador( Usuario _usuariocreador )
    {
        this._usuariocreador = _usuariocreador;
    }

    public Usuario get_usuarioanalista()
    {
        return _usuarioanalista;
    }

    public void set_usuarioanalista( Usuario _usuarioanalista )
    {
        this._usuarioanalista = _usuarioanalista;
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
