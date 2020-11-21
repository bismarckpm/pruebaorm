package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "categoria" )
public class Categoria extends EntidadBase{

    @Column(name = "descripcion")
    private String _descripcion;

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

    public String get_descripcion()
    {
        return _descripcion;
    }

    public void set_descripcion( String _descripcion )
    {
        this._descripcion = _descripcion;
    }

    @OneToMany( mappedBy = "_idCategoria", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    private List<SubCategoria> _subCategorias = new ArrayList<>();

    public Categoria( long id )
    {
        super( id );
    }

    public Categoria()
    {

    }

}
