package ucab.dsw.entidades;

import ucab.dsw.entidades.ComposedKeys.SolicitudId;
import ucab.dsw.entidades.enums.EstadoEnum;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@Entity
@Table(name="Solicitud")
public class Solicitud{
    /*@Id
    @Column( name = "idSolicitud", length=11)
    private long _idSolicitud;

    @Id
    @Column( name = "idUsuario", length=11)
    private long _idUsuario;

    @Id
    @Column( name = "idSubCategoria", length=11)
    private long _idSubCategoria;*/
    @EmbeddedId
    private SolicitudId _id;

    @Column( name = "creado_el",length = 45)
    private String _creado;

    @Column( name = "modificado_el",length = 45 )
    private String _modificado;

    @Column( name = "estatus" )
    @Enumerated(EnumType.ORDINAL)
    private EstadoEnum _estatus;

    public SolicitudId getSolicitudId(){
        return _id;
    }
    public void set_id(SolicitudId id){
        this._id=id;
    }

    public String getCreado(){
        return _creado;
    }
    public void set_creado(String creado){
        this._creado=creado;
    }

    public String getModificado(){
        return _modificado;
    }
    public void set_modificado(String modificado){
        this._modificado=modificado;
    }

    public EstadoEnum get_estatus()
    {
        return _estatus;
    }

    public void set_estatus( EstadoEnum _estatus )
    {
        this._estatus = _estatus;
    }
}
