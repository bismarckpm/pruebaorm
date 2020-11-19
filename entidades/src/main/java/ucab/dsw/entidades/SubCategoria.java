package ucab.dsw.entidades;

import javax.persistence.*;

@Entity
@Table( name = "subcategoria" )
public class SubCategoria extends EntidadBase {


    @Column( name = "descripcion" )
    private String descripcion;

    @Column(  name = "estatus" ,columnDefinition = "CHECK (estatus IN ('I','A'))")
    private String estatus;

    @ManyToOne
    @JoinColumn( name = "idCategoria" )
    private Categoria _idCategoria;


    public Categoria get_idCategoria() { return _idCategoria; }

    public void set_idCategoria(Categoria _idCategoria) { this._idCategoria = _idCategoria; }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstatus() { return estatus;}

    public void setEstatus(String estatus) { this.estatus = estatus;}
}
