package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "subcategoria" )
public class SubCategoria extends EntidadBase{

    public String get_descripcion() { return _descripcion; }

    public void set_descripcion( String _descripcion ) { this._descripcion = _descripcion; }

    @Column( name = "descripcion")
    private String _descripcion;

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
/*
    public List<Pregunta> get_preguntas()
    {
        return _preguntas;
    }

    public void set_preguntas( List<Pregunta> _preguntas )
    {
        this._preguntas = _preguntas;
    }

    @OneToMany( mappedBy = "_subcategoria", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Pregunta> _preguntas;
*/
    public SubCategoria(long id )
    {
        super( id );
    }

    public SubCategoria( )
    {

    }

}
