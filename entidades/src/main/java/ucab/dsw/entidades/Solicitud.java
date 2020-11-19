package ucab.dsw.entidades;


import javax.persistence.*;

@Entity
@Table( name = "solicitud" )
public class Solicitud extends EntidadBase{

    public Solicitud( long id )
    {
        super( id );
    }

    public Solicitud( )
    {

    }

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

    @Column( name = "fecha" )
    private String _fecha;

    public String get_fecha()
    {
        return _fecha;
    }

    public void set_fecha( String _fecha )
    {
        this._fecha = _fecha;
    }

    @Column( name = "estatus" )
    private String _estatus;

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

    public SubCategoria get_subCategoria()
    {
        return _subCategoria;
    }

    public void set_subCategoria( SubCategoria _subCategoria )
    {
        this._subCategoria = _subCategoria;
    }

    public Usuario get_usuario()
    {
        return _usuario;
    }

    public void set_usuario( Usuario _usuario )
    {
        this._usuario = _usuario;
    }

    @ManyToOne
    @JoinColumn( name = "idUsuario" )
    private Usuario _usuario;

    @ManyToOne
    @JoinColumn( name = "idSubCategoria" )
    private SubCategoria _subCategoria;

}
