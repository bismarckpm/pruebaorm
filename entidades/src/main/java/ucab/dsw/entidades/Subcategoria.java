package ucab.dsw.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "subcategoria")
@NamedQueries({
        @NamedQuery(name = "Subcategoria.findAll", query = "SELECT s FROM Subcategoria s ORDER BY s.id")
})
public class Subcategoria implements Serializable {
    public static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "descripcion", nullable = false, length = 45)
    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    @Basic
    @Column(name = "estatus", nullable = false)
    private String estatus;


    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }


    @JoinColumn(name = "idCategoria", referencedColumnName = "id")
    @ManyToOne
    private Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Subcategoria() {
    }

    public Subcategoria(int id) {
        this.id = id;
    }
}
