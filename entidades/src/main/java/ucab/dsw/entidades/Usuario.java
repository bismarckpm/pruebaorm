package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "usuario" )
public class Usuario extends EntidadBase
{
    @Column( name = "nombre" )
    private String _nombre;

    @Column( name = "apellido" )
    private String _apellido;
  
    @Column( name = "correoelectronico" )
    private String _correoelectronico;

    @Column( name = "estatus" )
    private String _estatus;

    @ManyToOne
    @JoinColumn( name = "idTipoUsuario" )
    private TipoUsuario _tipousuario;

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

    @OneToMany( mappedBy = "_idUsuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    private List<Solicitud> _Solicitudes = new ArrayList<>();

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

    public Usuario( long id )
    {
        super( id );
    }

    public Usuario()
    {

    }
}
