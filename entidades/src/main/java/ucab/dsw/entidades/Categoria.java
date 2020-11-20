package ucab.dsw.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table( name = "categoria" )

public class Categoria extends EntidadBase
{


    @Column( name = "descripcion", nullable = false )
    private String _descripcion;

    public String get_descripcion()
    {
        return _descripcion;
    }

    public void set_descripcion( String _descripcion ) { this._descripcion = _descripcion; }


    public List<SubCategoria> get_subcategoria()
    {
        return _subcategoria;
    }

    public void set_subcategoria( List<SubCategoria> _subcategoria )
    {
        this._subcategoria = _subcategoria;
    }

    @OneToMany( mappedBy = "_Categoria", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<SubCategoria> _subcategoria;

    public Categoria ( long id )
    {
        super( id );
    }

    public Categoria ( )
    {

    }
}

