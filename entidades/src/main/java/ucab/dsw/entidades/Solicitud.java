package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name= "solicitud")
public class Solicitud extends EntidadBase{

    public String get_nombre() { return _nombre; }

    public void set_nombre( String _nombre ) { this._nombre = _nombre; }

    @Column( name = "nombre")
    private String _nombre;

    public String get_fecha() { return _fecha; }

    public void set_fecha( String _fecha ) { this._fecha = _fecha; }

    @Column( name = "fecha")
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

    public SubCategoria get_subcategoria()
    {
        return _subcategoria;
    }

    public void set_subcategoria( SubCategoria _subcategoria )
    {
        this._subcategoria = _subcategoria;
    }

    @ManyToOne
    @JoinColumn( name = "idSubCategoria" )
    private SubCategoria _subcategoria;

    /*
    public List<Estudio> get_estudios()
    {
        return _estudios;
    }

    public void set_estudios( List<Estudio> _estudios )
    {
        this._estudios = _estudios;
    }

    @OneToMany( mappedBy = "_solicitud", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Estudio> _estudios;

     */

    public Solicitud(long id )
    {
        super( id );
    }

    public Solicitud( )
    {

    }
}
