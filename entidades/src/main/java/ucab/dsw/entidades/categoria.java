package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categoria")
public class categoria extends EntidadBase{

@Column(name = "descripcion")
    private String descripcion;

public String getDescripcion(){
    return this.descripcion;
}

public void setDescripcion(String D)
    {
        this.descripcion=D;
    }

    @OneToMany(mappedBy = "idcategoria", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<subCategoria> SUBCATEGORIA;

    public List<subCategoria> get_subCategoria()
    {
        return SUBCATEGORIA;
    }

    public void set_subCategoria( List<subCategoria> SC )
    {
        this.SUBCATEGORIA = SC;
    }

public categoria( long id )
    {

        super( id );
    }

public categoria(){

}

}
