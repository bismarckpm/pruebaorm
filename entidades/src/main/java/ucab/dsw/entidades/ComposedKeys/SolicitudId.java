package ucab.dsw.entidades.ComposedKeys;

import ucab.dsw.entidades.SubCategoria;
import ucab.dsw.entidades.Usuario;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SolicitudId implements Serializable {

    @Column( name = "id", length=11)
    private long _Solicitud;

    @ManyToOne
    @JoinColumn(name = "id",insertable = false, updatable = false)
    private Usuario _Usuario;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "s_sc_id",
                    referencedColumnName = "sc_id",
                    insertable = false, updatable = false),
            @JoinColumn(name = "s_c_id",
                    referencedColumnName = "c_id",
                    insertable = false, updatable = false)
    })
    private SubCategoria _SubCategoria;

    public SolicitudId() {

    }
    public SolicitudId(long s_id,Usuario u_id,SubCategoria sc_id){
        this._Solicitud=s_id;
        this._Usuario=u_id;
        this._SubCategoria=sc_id;
    }

    public Usuario getUsuario(){
        return _Usuario;
    }

    public long getSolicitud(){
        return _Solicitud;
    }

    public SubCategoria getSubCategoria(){
        return _SubCategoria;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SolicitudId)) return false;
        SolicitudId that = (SolicitudId) o;
        return Objects.equals(getUsuario(), that.getUsuario()) &&
                Objects.equals(getSubCategoria(), that.getSubCategoria()) &&
                    Objects.equals(getSolicitud(), that.getSolicitud());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsuario(),getSubCategoria(),getSolicitud());
    }
}
