package ucab.dsw.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "solicitud" )
public class solicitud extends EntidadBase
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

    public String get_fecha()
    {
        return _fecha;
    }

    public void set_fecha( String _fecha )
    {
        this._fecha = _fecha;
    }


    public Usuario get_usuario()
    {
        return _usuario;
    }

    public void set_usuarioAn( Usuario _usuario )
    {
        this._usuario = _usuario;
    }

    public SubCategoria get_subcategoria()
    {
        return _subCategoria;
    }

    public void set_subcategoria( SubCategoria _subCategoria)
    {
        this._subCategoria = _subCategoria;
    }
    
    
    @Column( name = "fecha" )
    private String _fecha;


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
    @JoinColumn( name = "idUsuario" )
    private Usuario _usuario;

    @ManyToOne
    @JoinColumn( name = "idsubcategoria" )
    private SubCategoria _subCategoria;
    

    public solicitud( long id )
    {
        super( id );
    }

    public solicitud()
    {

    }
}
