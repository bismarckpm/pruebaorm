package ucab.dsw.entidades;

import ucab.dsw.entidades.ComposedKeys.SolicitudId;
import ucab.dsw.entidades.ComposedKeys.SubCategoriaId;
import ucab.dsw.entidades.enums.EstadoEnum;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class SubCategoria extends EntidadBase {
    /*@Id
    @Column( name = "idSubCategoria", length=11)
    private long _idSubCategoria;

    @Id
    @Column( name = "idCategoria", length=11)
    private long _idCategoria;*/


    /*@EmbeddedId
    private SubCategoriaId _id;*/
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria id_categoria;

    public Categoria getId_categoria(){
        return this.id_categoria;
    }

    public void setId_categoria(Categoria id_categoria) {
        this.id_categoria = id_categoria;
    }

    @Column(name="descripcion",length = 45)
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
    public String get_estatus() {
        return _estatus;
    }

    @Override
    public void set_estatus(String _estatus) {
        this._estatus = _estatus;
    }

    public SubCategoria(long id) throws Exception{ super(id);}

    public SubCategoria(){}
}
