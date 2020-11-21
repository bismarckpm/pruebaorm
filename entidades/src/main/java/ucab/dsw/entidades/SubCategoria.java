package ucab.dsw.entidades;


import ucab.dsw.entidades.enums.EstadoEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "subcategoria" )
public class SubCategoria extends EntidadBase {
    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria _idCategoria;

    public Categoria getId_categoria(){
        return this._idCategoria;
    }

    public void setId_categoria(Categoria id_categoria) {
        this._idCategoria = id_categoria;
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

    @OneToMany( mappedBy = "_idSubCategoria", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    private List<Solicitud> _Solicitudes = new ArrayList<>();

    public SubCategoria(long id) throws Exception{ super(id);}

    public SubCategoria(){}
}
