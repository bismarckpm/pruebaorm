package ucab.dsw.entidades;

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
@Table( name = "usuario" )
public class Usuario extends EntidadBase
{
    @Column( name = "nombre" )
    private String _nombre;

    public String get_nombre()
    {
        return _nombre;
    }

    public void set_nombre( String _nombre )
    {
        this._nombre = _nombre;
    }

    public String get_apellido()
    {
        return _apellido;
    }

    public void set_apellido( String _apellido )
    {
        this._apellido = _apellido;
    }

    public String get_correoelectronico()
    {
        return _correoelectronico;
    }

    public void set_correoelectronico( String _correoelectronico )
    {
        this._correoelectronico = _correoelectronico;
    }

    public TipoUsuario get_tipousuario()
    {
        return _tipousuario;
    }

    public void set_tipousuario( TipoUsuario _tipousuario )
    {
        this._tipousuario = _tipousuario;
    }

    @Column( name = "apellido" )
    private String _apellido;

    @Column( name = "correoelectronico" )
    private String _correoelectronico;

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

    @Column( name = "estatus" )
    private String _estatus;

    @ManyToOne
    @JoinColumn( name = "idTipoUsuario" )
    private TipoUsuario _tipousuario;

    @OneToMany( mappedBy = "_usuario", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Estudio> _estudios;

    @OneToMany( mappedBy = "_usuarioSolicitud", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Solicitud> _solicitudes;

    @OneToMany( mappedBy = "_usuarioCreador", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Encuesta> _encuestasCreador;

    @OneToMany( mappedBy = "_usuarioAnalista", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Encuesta> _encuestasAnalista;

    @OneToMany( mappedBy = "_usuario", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<EjecucionEncuesta> _ejecuciones;

    @OneToMany( mappedBy = "_usuario", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Pregunta> _preguntas;

    public Usuario( long id )
    {
        super( id );
    }

    public Usuario()
    {

    }
}
