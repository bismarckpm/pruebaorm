package ucab.dsw.entidades;

import javax.persistence.*;

@Entity
@Table( name = "subCategoria" )
public class SubCategoria extends EntidadBase{

    @Column( name = "descripcion" )
    private String _descripcion;

    public String get_descripcion()
    {
        return _descripcion;
    }

    public void set_descripcion( String _descripcion )
    {
        this._descripcion = _descripcion;
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



    public Categoria get_categoria()
    {
        return _categoria;
    }

    public void set_categoria( Categoria _categoria )
    {
        this._categoria = _categoria;
    }

    @ManyToOne
    @JoinColumn( name = "idCategoria" )
    private Categoria _categoria;

    public SubCategoria( long id )
    {
        super( id );
    }

    public SubCategoria( )
    {

    }


}
