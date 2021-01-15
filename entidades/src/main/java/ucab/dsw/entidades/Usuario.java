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

    public String getNombre()
    {
        return _nombre;
    }

    public void setNombre( String _nombre )
    {
        this._nombre = _nombre;
    }

    public String getApellido()
    {
        return _apellido;
    }

    public void setApellido( String _apellido )
    {
        this._apellido = _apellido;
    }

    public String getCorreoElectronico()
    {
        return _correoelectronico;
    }

    public void setCorreoElectronico( String _correoelectronico )
    {
        this._correoelectronico = _correoelectronico;
    }

    public TipoUsuario getTipoUsuario()
    {
        return _tipousuario;
    }

    public void setTipoUsuario( TipoUsuario _tipousuario )
    {
        this._tipousuario = _tipousuario;
    }

    @Column( name = "apellido" )
    private String _apellido;

    public String getToken()
    {
        return _token;
    }

    public void setToken( String token )
    {
        _token = token;
    }

    @Column( name = "token" )
    private String _token;

    @Column( name = "correoelectronico" )
    private String _correoelectronico;

    @Override
    public String getEstatus()
    {
        return _estatus;
    }

    @Override
    public void setEstatus( String _estatus )
    {
        this._estatus = _estatus;
    }

    @Column( name = "estatus" )
    private String _estatus;

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
