package ucab.dsw.entidades;

import ucab.dsw.entidades.ComposedKeys.SolicitudId;
import ucab.dsw.entidades.ComposedKeys.SubCategoriaId;
import ucab.dsw.entidades.enums.EstadoEnum;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class SubCategoria {
    /*@Id
    @Column( name = "idSubCategoria", length=11)
    private long _idSubCategoria;

    @Id
    @Column( name = "idCategoria", length=11)
    private long _idCategoria;*/
    @EmbeddedId
    private SubCategoriaId _id;

    @Column(name="descripcion",length = 45)
    private String _descripcion;

    @Column( name = "estatus" )
    @Enumerated(EnumType.ORDINAL)
    private EstadoEnum _estatus;

    public EstadoEnum get_estatus()
    {
        return _estatus;
    }

    public void set_estatus( EstadoEnum _estatus )
    {
        this._estatus = _estatus;
    }
}
