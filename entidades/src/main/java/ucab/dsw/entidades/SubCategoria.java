package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "subcategoria" )
public class SubCategoria extends EntidadBase{



    @Column( name = "descripcion", nullable = false )
    private String _descripcion;

    public String get_descripcion()
    {
        return _descripcion;
    }

    public void set_descripcion( String _descripcion ) { this._descripcion = _descripcion; }

    @ManyToOne
    @JoinColumn( name = "idCategoria" )
    private Categoria _Categoria;

    public Categoria get_Categoria()
    {
        return _Categoria;
    }

    public void set_Categoria( Categoria _Categoria )
    {
        this._Categoria = _Categoria;
    }


    public SubCategoria ( long id )
    {
        super( id );
    }

    public SubCategoria ( )
    {

    }
}
