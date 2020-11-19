package ucab.dsw.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
    private List<Estudio> _estudios = new ArrayList<>();

    @OneToMany( mappedBy = "_usuario", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Pregunta> _preguntas;

    public List<Estudio> get_estudios() {
        return _estudios;
    }

    public void set_estudios(List<Estudio> _estudios) {
        this._estudios = _estudios;
    }

    public List<Pregunta> get_preguntas() {
        return _preguntas;
    }

    public void set_preguntas(List<Pregunta> _preguntas) {
        this._preguntas = _preguntas;
    }

    public Usuario(long id )
    {
        super( id );
    }

    public Usuario()
    {

    }
}
