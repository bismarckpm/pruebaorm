package ucab.dsw.entidades;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "subcategoria")
public class subCategoria extends EntidadBase{

    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "idsubcategoria", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<solicitud> solicitud;

    public List<solicitud> get_solicitud()
    {
        return solicitud;
    }

    public void set_solicitud( List<solicitud> S )
    {
        this.solicitud = S;
    }

    @ManyToOne
    @JoinColumn( name = "idCategoria" )
    private categoria idcategoria;

    public String get_descripcion(){
        return this.descripcion;
    }

    public void set_descripcion(String D){
        this.descripcion=D;
    }

    public categoria get_idcategoria() {
        return this.idcategoria;
    }

    public void set_idcategoria(categoria C) {
        this.idcategoria=C;
    }



    public subCategoria(long id){
    super(id);
    }

    public subCategoria(){

    }
}
