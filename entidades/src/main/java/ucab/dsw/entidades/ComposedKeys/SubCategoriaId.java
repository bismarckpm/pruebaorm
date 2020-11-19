package ucab.dsw.entidades.ComposedKeys;

import ucab.dsw.entidades.SubCategoria;
import ucab.dsw.entidades.Usuario;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SubCategoriaId implements Serializable {
    @Column( name = "sc_id", length=11)
    private long _SubCategoria;

    /*@ManyToOne
    @JoinColumn(
    name = "c_id",
    referencedColumnName = "id",
    ,insertable = false, updatable = false)
    private Usuario _Categoria;*/

    public SubCategoriaId() {

    }
    public SubCategoriaId(long sc_id /*, Categoria c_id*/){
        this._SubCategoria=sc_id;
        //this._Categoria = c_id;
    }

    public long getSubCategoria(){
        return _SubCategoria;
    }

    /*public Categoria getCategoria(){
        return _Categoria;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubCategoriaId)) return false;
        SubCategoriaId that = (SubCategoriaId) o;
        return Objects.equals(getSubCategoria(), that.getSubCategoria());/*&&
                /Objects.equals(getCategoria(), that.getCategoria()) */
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSubCategoria()/*,getCategoria());*/);
    }
}
