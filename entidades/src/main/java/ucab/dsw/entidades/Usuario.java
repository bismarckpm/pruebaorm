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

    @OneToMany(mappedBy = "idusuario", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<solicitud> solicitud;

    public List<solicitud> get_solicitud()
    {
        return solicitud;
    }

    public void set_solicitud( List<solicitud> S )
    {
        this.solicitud = S;
    }


    @OneToMany(mappedBy = "idUsuarioCreador", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Encuesta> Usuario_Creador;

    public List<Encuesta> get_Usuario_Creador(){return this.Usuario_Creador;}

    public void set_Usuario_Creador( List<Encuesta> UC )
    {
        this.Usuario_Creador = UC;
    }

    @OneToMany(mappedBy = "idUsuarioAnalista", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Encuesta> UsuarioAnalista;

    public List<Encuesta> get_Usuario_Analista(){return this.UsuarioAnalista;}

    public void set_Usuario_Analista( List<Encuesta> UA )
    {
        this.UsuarioAnalista = UA;
    }

    @ManyToOne
    @JoinColumn( name = "idTipoUsuario" )
    private TipoUsuario _tipousuario;

    public Usuario( long id )
    {
        super( id );
    }

    public Usuario()
    {

    }
}
